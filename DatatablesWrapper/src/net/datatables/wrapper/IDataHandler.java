package net.datatables.wrapper;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

/**
 * Any class implemented this interface will be used for data response to ajax request made by datatabe.
 * set 
 * <pre>
 * table.bServerSide = true
 * 
 * //MyDataHandler is a class implemented this interface.
 * table.setDataHandlerClass(MyDataHandler.class); 
 * 
 * //let the datatable managed the request and response.
 * table.dispatch(request, response);	
 * 
 * </pre>
 * @author xuantuan.bui
 *
 * @param <T>
 */
public interface IDataHandler<T> {
	
	public List<T> getListData(AjaxRequest tableRequest, HttpServletRequest request);
	
	public int getITotalRecords();
	
	public int getITotalDisplayRecords();
	
}
