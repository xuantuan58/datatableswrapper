package net.datatables.wrapper;

import java.io.IOException;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.datatables.wrapper.model.DataTable;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class DataTableWrapper {
	
	public static final String HANDLER_PARAM = "hdl";
	private DataTable<?> dataTable;
	private AjaxRequest ajaxTableReq;
	private AjaxResponse<?> ajaxTableRes;
	private Class<? extends IDataHandler> handler;
	private String urlLocation;
	public ObjectMapper objMapper = new ObjectMapper();

	public void setUrlLocation(String urlLocation){
		this.urlLocation = urlLocation;
	}
	
	public AjaxRequest getAjaxTableReq() {
		return ajaxTableReq;
	}

	public void setAjaxTableRes(AjaxResponse<?> ajaxTableRes) {
		this.ajaxTableRes = ajaxTableRes;
	}

	public DataTable<?> getDataTable() {
		return dataTable;
	}

	public void setDataTable(DataTable<?> dataTable) {
		this.dataTable = dataTable;
	}
	
	public void setDataHandler(Class<? extends IDataHandler> handler){
		this.handler = handler;
	}
	
	public void wrap(HttpServletRequest req, HttpServletResponse res) 
			throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		if(req == null || res == null){
			throw new IllegalArgumentException("Parmeters request and response must not be null.");
		}
		
		String handlerClazzName;
		
		if(handler != null){
			handlerClazzName = handler.getName();
		}
		else{
			handlerClazzName =  req.getParameter(HANDLER_PARAM);
		}
		
		//Initiate request (not a data request)
		if(dataTable != null && req.getParameter(HANDLER_PARAM) == null){
			
			//Specified data handler class.
			if(handler != null && dataTable.bServerSide != null && dataTable.bServerSide == true){
				String url = urlLocation != null? urlLocation: req.getRequestURL().toString();
				dataTable.sAjaxSource = url + (url.contains("?")? "&" : "?") + HANDLER_PARAM + "=" + handlerClazzName;
			}
			else if(handler != null && (dataTable.bServerSide == null || dataTable.bServerSide == false)){
				IDataHandler dataHandler = (IDataHandler) handler.newInstance();
				dataTable.aaData = dataHandler.getListData(ajaxTableReq, req);
			}
			
			
			writeJson(res.getOutputStream(), dataTable);
		}
		else{//Ajax Data request.
			
			this.ajaxTableReq = parseAjaxRequest(req);
			if(ajaxTableReq != null){
				@SuppressWarnings({ "rawtypes" })
				Class clazz = Class.forName(handlerClazzName);
				if(clazz != null){
					IDataHandler tableHandler = (IDataHandler) clazz.newInstance();
					ajaxTableRes = new AjaxResponse<>();
					ajaxTableRes.aaData = tableHandler.getListData(ajaxTableReq, req);
					ajaxTableRes.iTotalRecords = tableHandler.getITotalRecords();
					ajaxTableRes.iTotalDisplayRecords = tableHandler.getITotalDisplayRecords();
					ajaxTableRes.sEcho = ajaxTableReq.sEcho;
					writeJson(res.getOutputStream(), ajaxTableRes);
				}
			}
		}
	}
	

	public void writeJson(OutputStream out, Object obj){
		ObjectMapper objMapper = getObjectMapper();
		try {
			objMapper.writeValue(out, obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public String toString(){
		if(dataTable != null){
			try {
				if((dataTable.bServerSide == null || dataTable.bServerSide == false) && handler != null){
					IDataHandler dataHandler = (IDataHandler) handler.newInstance();
					dataTable.aaData = dataHandler.getListData(ajaxTableReq, null);
				}
				
				return getObjectMapper().writeValueAsString(dataTable);
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException();
			} 
		}
		else{
			return "{}";
		}
	}
	
	private ObjectMapper getObjectMapper(){
		DateFormat df = new SimpleDateFormat("MMM dd, yyyy HH:mm");
		objMapper.setDateFormat(df);
		objMapper.setSerializationInclusion(Include.NON_NULL);
		objMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
		return objMapper;
	}
	
	/**
	 * Utility method for parsing current request into AjaxRequest Object.
	 * @param request
	 */
	public AjaxRequest parseAjaxRequest(HttpServletRequest request) {
		AjaxRequest ajaxRequest = new AjaxRequest();
		if (request.getParameter("sEcho") != null
				&& request.getParameter("sEcho") != "") {
			ajaxRequest.sEcho = request.getParameter("sEcho");
			ajaxRequest.sSearchKeyword = request.getParameter("sSearch");
			ajaxRequest.bRegexKeyword = Boolean.parseBoolean(request.getParameter("bRegex"));
			ajaxRequest.sColumns = request.getParameter("sColumns");
			ajaxRequest.iDisplayStart = Integer.parseInt(request.getParameter("iDisplayStart"));
			ajaxRequest.iDisplayLength = Integer.parseInt(request.getParameter("iDisplayLength"));
			ajaxRequest.iColumns = Integer.parseInt(request.getParameter("iColumns"));
			ajaxRequest.sSearch = new String[ajaxRequest.iColumns];
			ajaxRequest.bSearchable = new boolean[ajaxRequest.iColumns];
			ajaxRequest.bSortable = new boolean[ajaxRequest.iColumns];
			ajaxRequest.bRegex = new boolean[ajaxRequest.iColumns];
			for (int i = 0; i < ajaxRequest.iColumns; i++) {
				ajaxRequest.sSearch[i] = request.getParameter("sSearch_" + i);
				ajaxRequest.bSearchable[i] = Boolean.parseBoolean(request.getParameter("bSearchable_" + i));
				ajaxRequest.bSortable[i] = Boolean.parseBoolean(request.getParameter("bSortable_" + i));
				ajaxRequest.bRegex[i] = Boolean.parseBoolean(request.getParameter("bRegex_" + i));
			}

			if (request.getParameter("iSortingCols") != null) {
				ajaxRequest.iSortingCols = Integer.parseInt(request.getParameter("iSortingCols"));
			}
			ajaxRequest.sSortDir = new String[ajaxRequest.iSortingCols];
			ajaxRequest.iSortCol = new int[ajaxRequest.iSortingCols];
			for (int i = 0; i < ajaxRequest.iSortingCols; i++) {
				ajaxRequest.sSortDir[i] = request.getParameter("sSortDir_" + i);
				ajaxRequest.iSortCol[i] = Integer.parseInt(request.getParameter("iSortCol_" + i));
			}
		}
		return ajaxRequest;
	}
	
}
