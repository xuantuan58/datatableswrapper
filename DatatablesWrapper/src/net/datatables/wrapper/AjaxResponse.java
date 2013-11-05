package net.datatables.wrapper;

import java.util.List;

/**
 * Class represents an Object response to the AjaxRequest request which sent by
 * client via ajax. (DataTable.bServerSide = true). reply to each request for
 * information that DataTables makes to the server
 * 
 * @author xuantuan.bui
 * 
 * @param <T>
 */
public class AjaxResponse<T> {
	/**
	 * Total records, before filtering (i.e. the total number of records in the
	 * database, without any filtering/limits)
	 */
	public int iTotalRecords;
	/**
	 * An unaltered copy of sEcho sent from the client side. This parameter will
	 * change with each draw (it is basically a draw count) - so it is important
	 * that this is implemented. Note that it strongly recommended for security
	 * reasons that you 'cast' this parameter to an integer in order to prevent
	 * Cross Site Scripting (XSS) attacks.
	 */
	public String sEcho;
	/**
	 * filtered result count. Total records, after filtering (i.e. the total number of records after
	 * filtering has been applied - not just the number of records being
	 * returned in this result set)
	 */
	public int iTotalDisplayRecords;

	/**
	 * The data in a 2D array. Note that you can change the name of this
	 * parameter with sAjaxDataProp.
	 */
	public List<T> aaData;
}
