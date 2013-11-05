package net.datatables.wrapper.model;

/**
 * Pagination string used by DataTables for the two built-in pagination control
 * types ("two_button" and "full_numbers")
 * 
 * @author xuantuan.bui
 * 
 */
public class OPaginate {
	/**
	 * Text to use when using the 'full_numbers' type of pagination for the
	 * button to take the user to the first page.
	 * 
	 * <pre>
	 * $(document).ready(function() {
	 *   $('#example').dataTable( {
	 *     "oLanguage": {
	 *       "oPaginate": {
	 *         "sFirst": "First page"
	 *       }
	 *     }
	 *   } );
	 * } );
	 * </pre>
	 */
	public String sFirst;
	/**
	 * Text to use when using the 'full_numbers' type of pagination for the
	 * button to take the user to the last page.
	 * 
	 * <pre>
	 * $(document).ready(function() {
	 *   $('#example').dataTable( {
	 *     "oLanguage": {
	 *       "oPaginate": {
	 *         "sLast": "Last page"
	 *       }
	 *     }
	 *   } );
	 * } );
	 * </pre>
	 */
	public String sLast;
	/**
	 * Text to use when using the 'full_numbers' type of pagination for the
	 * button to take the user to the next page.
	 * 
	 * <pre>
	 * $(document).ready(function() {
	 *   $('#example').dataTable( {
	 *     "oLanguage": {
	 *       "oPaginate": {
	 *         "sNext": "Next page"
	 *       }
	 *     }
	 *   } );
	 * } );
	 * </pre>
	 */
	public String sNext;
	/**
	 * sPrevious :string
	 * 
	 * Text to use when using the 'full_numbers' type of pagination for the
	 * button to take the user to the previous page.
	 * 
	 * <pre>
	 *     $(document).ready(function() {
	 *       $('#example').dataTable( {
	 *         "oLanguage": {
	 *           "oPaginate": {
	 *             "sPrevious": "Previous page"
	 *           }
	 *         }
	 *       } );
	 *     } );
	 * </pre>
	 */
	public String sPrevious;
}
