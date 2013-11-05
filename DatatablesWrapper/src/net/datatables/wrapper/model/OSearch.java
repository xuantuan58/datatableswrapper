package net.datatables.wrapper.model;

/**
 * This parameter allows you to have define the global filtering state at
 * Initialization time. As an object the "sSearch" parameter must be defined,
 * but all other parameters are optional. When "bRegex" is true, the search
 * string will be treated as a regular expression, when false (default) it will
 * be treated as a straight string. When "bSmart" DataTables will use it's smart
 * filtering methods (to word match at any point in the data), when false this
 * will not be done.
 * 
 * <pre>
 * $(document).ready( function() {
 *   $('#example').dataTable( {
 *     "oSearch": {"sSearch": "Initial search"}
 *   } );
 * } )
 * </pre>
 * 
 * @author xuantuan.bui
 * 
 */
public class OSearch {
	/**
	 * Flag to indicate if the filtering should be case insensitive or not
	 */
	public Boolean bCaseInsensitive;
	/**
	 * Flag to indicate if the search term should be interpreted as a regular
	 * expression (true) or not (false) and therefore and special regex
	 * characters escaped.
	 */
	public Boolean bRegex;
	/**
	 * Flag to indicate if DataTables is to use its smart filtering or not.
	 */
	public Boolean bSmart;
	/**
	 * Applied search term
	 */
	public String sSearch;
}
