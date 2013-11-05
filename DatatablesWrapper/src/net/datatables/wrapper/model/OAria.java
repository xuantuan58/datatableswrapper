package net.datatables.wrapper.model;

/**
 * Strings that are used for WAI-ARIA labels and controls only (these are not
 * actually visible on the page, but will be read by screenreaders, and thus
 * must be internationalised as well).
 * 
 * @author xuantuan.bui
 * 
 */
public class OAria {
	/**
	 * ARIA label that is added to the table headers when the column may be
	 * sorted ascending by activing the column (click or return when focused).
	 * Note that the column header is prefixed to this string.
	 * 
	 * <pre>
	 * 
	 * $(document).ready(function() {
	 *   $('#example').dataTable( {
	 *     "oLanguage": {
	 *       "oAria": {
	 *         "sSortAscending": " - click/return to sort ascending"
	 *       }
	 *     }
	 *   } );
	 * } );
	 * </pre>
	 */
	public String sSortAscending;
	/**
	 * ARIA label that is added to the table headers when the column may be
	 * sorted descending by activing the column (click or return when focused).
	 * Note that the column header is prefixed to this string.
	 * 
	 * <pre>
	 * $(document).ready(function() {
	 *   $('#example').dataTable( {
	 *     "oLanguage": {
	 *       "oAria": {
	 *         "sSortDescending": " - click/return to sort descending"
	 *       }
	 *     }
	 *   } );
	 * } );
	 * </pre>
	 */
	public String sSortDescending;
}
