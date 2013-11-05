package net.datatables.wrapper;

import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.datatables.wrapper.DataTableWrapper;
import net.datatables.wrapper.datahandle.MySpecAccDataHandler;
import net.datatables.wrapper.datahandle.UserAccDataHandler;
import net.datatables.wrapper.example.model.MySpecializedAcc;
import net.datatables.wrapper.example.model.UserAccount;
import net.datatables.wrapper.model.AoColumn;
import net.datatables.wrapper.model.DataTable;

import org.junit.Before;
import org.junit.Test;

public class DataTableWrapperTest {
	 HttpServletRequest request;
	 HttpServletResponse response;
	 ServletOutputStream mockOutput;
	 
	@Before
	public void setUp() throws Exception {
		 request = mock(HttpServletRequest.class);       
	     response = mock(HttpServletResponse.class);
	     
	     mockOutput = new ServletOutputStream() {
			@Override
			public void write(int b) throws IOException {
				System.out.print((char) b);
			}
		};
		
		when(response.getOutputStream()).thenReturn(mockOutput);
	}

	@Test
	public void testGetAjaxTableReq() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetDataTable() {
		PrintWriter writer = new PrintWriter(System.out);
		writer.write("test tset tset");
	}

	@Test
	public void testProceedMySpecUserAcct() throws Exception {	
	     
	     when(response.getOutputStream()).thenReturn(mockOutput);
	     when(request.getRequestURL()).thenReturn(new StringBuffer("http://localhost:8080/DataTableTest/AccountTable"));

	     
	     
	     DataTableWrapper tblWrapper = new DataTableWrapper();
	     DataTable<MySpecializedAcc> accTbl = new DataTable<>(MySpecializedAcc.class);

	     //accTbl.bServerSide = true;
	     tblWrapper.setDataTable(accTbl);
	     tblWrapper.setDataHandler(MySpecAccDataHandler.class);
	     
	     tblWrapper.wrap(request, response);
	     
	     
	}
	
	@Test
	public void testCreateTableUserAccount() throws Exception {	
		
		when(response.getOutputStream()).thenReturn(mockOutput);
		
		DataTableWrapper tblWrapper = new DataTableWrapper();
		DataTable<UserAccount> accTbl = new DataTable<>(UserAccount.class);
		
		//accTbl.bServerSide = true;
		tblWrapper.setDataTable(accTbl);
		tblWrapper.setDataHandler(UserAccDataHandler.class);
		
		tblWrapper.wrap(request, response);
		
		
	}

	@Test
	public void testWriteJson() {
		fail("Not yet implemented");
	}

	@Test
	public void testParseAjaxRequest() {
		fail("Not yet implemented");
	}
	
	@Test
	public void tetToString(){
		
		DataTable<UserAccount> accTbl = new DataTable<>(UserAccount.class);
		accTbl.bServerSide = true;
		accTbl.sAjaxSource = "/datasource";
		
		DataTableWrapper tblWrapper = new DataTableWrapper();
		
		tblWrapper.setDataTable(accTbl);
		tblWrapper.setDataHandler(UserAccDataHandler.class);
		
		String jsonStr = tblWrapper.toString();
		
		System.out.println(jsonStr);
	}
	
	@Test
	public void testBasicCreation() throws IOException{
		//Instantiate the wrapper to use utilities method
		DataTableWrapper wrapper = new DataTableWrapper();
		
		//create a new datatable object
		DataTable<UserAccount> tbl = new DataTable<UserAccount>();
		
		//set columns for the table
		tbl.setAoColumns(getAaColumns());
		
		//set datas for the table
		tbl.aaData = getAaData();
		
		//to use utility method toString(), assign setDataTable method by this table.
		//wrapper.setDataTable(tbl);
		//String tableJson = wrapper.toString();	
		//System.out.println(tableJson);
		
		//Write datatable object into Out
		wrapper.writeJson(response.getOutputStream(), tbl);
		
	}

	private List<UserAccount> getAaData() {
		List<UserAccount> listAcc = new ArrayList<>();
		listAcc.add(new UserAccount(1, "aTuanBui", new Date(), "cv"));
		listAcc.add(new UserAccount(2, "TauanBui", new Date(), "xcv"));
		listAcc.add(new UserAccount(3, "TuaanBui", new Date(), "xcv"));
		listAcc.add(new UserAccount(4, "TuaanBui", new Date(), "ds"));
		listAcc.add(new UserAccount(5, "TuanaBui", new Date(), "gd"));
		return listAcc;
	}

	private List<AoColumn> getAaColumns() {
		List<AoColumn> columns = new ArrayList<>();
		columns.add(new AoColumn("ID", "userId"));
		columns.add(new AoColumn("Username", "username"));
		columns.add(new AoColumn("Create Date", "createDate"));
		
		return columns;
	}
	

}
