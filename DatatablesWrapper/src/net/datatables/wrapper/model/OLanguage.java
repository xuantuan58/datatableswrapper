package net.datatables.wrapper.model;

/**
 * 
 * @author xuantuan.bui
 *
 */
public class OLanguage {
	/**
	 * Strings that are used for WAI-ARIA labels and controls only (these are
	 * not actually visible on the page, but will be read by screenreaders, and
	 * thus must be internationalised as well).
	 */
	public OAria oAria;

	/**
	 * 
	 */
	public OPaginate oPaginate;
	/**
	 * This string is shown in preference to sZeroRecords when the table is
	 * empty of data (regardless of filtering). Note that this is an optional
	 * parameter - if it is not given, the value of sZeroRecords will be used
	 * instead (either the default or given value).
	 * 
	 * <pre>
	 * Default: 	No data available in table
	 * Type: 	string
	 * 
	 * $(document).ready( function() {
	 *   $('#example').dataTable( {
	 *     "oLanguage": {
	 *       "sEmptyTable": "No data available in table"
	 *     }
	 *   } );
	 * } );
	 * </pre>
	 */
	public String sEmptyTable;
	/**
	 * This string gives information to the end user about the information that
	 * is current on display on the page. The START, END and TOTAL variables are
	 * all dynamically replaced as the table display updates, and can be freely
	 * moved or removed as the language requirements change.
	 * 
	 * <pre>
	 * Default: 	Showing _START_ to _END_ of _TOTAL_ entries
	 * Type: 	string
	 * 
	 * $(document).ready( function() {
	 *   $('#example').dataTable( {
	 *     "oLanguage": {
	 *       "sInfo": "Got a total of _TOTAL_ entries to show (_START_ to _END_)"
	 *     }
	 *   } );
	 * } );
	 * </pre>
	 */
	public String sInfo;
	/**
	 * Display information string for when the table is empty. Typically the
	 * format of this string should match sInfo.
	 * 
	 * <pre>
	 * Default: 	Showing 0 to 0 of 0 entries
	 * Type: 	string
	 * 
	 * $(document).ready( function() {
	 *   $('#example').dataTable( {
	 *     "oLanguage": {
	 *       "sInfoEmpty": "No entries to show"
	 *     }
	 *   } );
	 * } );
	 * </pre>
	 */
	public String sInfoEmpty;
	/**
	 * When a user filters the information in a table, this string is appended
	 * to the information (sInfo) to give an idea of how strong the filtering
	 * is. The variable MAX is dynamically updated.
	 * 
	 * <pre>
	 * Default: 	(filtered from _MAX_ total entries)
	 * Type: 	string
	 * 
	 * $(document).ready( function() {
	 *   $('#example').dataTable( {
	 *     "oLanguage": {
	 *       "sInfoFiltered": " - filtering from _MAX_ records"
	 *     }
	 *   } );
	 * } );
	 * </pre>
	 */
	public String sInfoFiltered;
	/**
	 * If can be useful to append extra information to the info string at times,
	 * and this variable does exactly that. This information will be appended to
	 * the sInfo (sInfoEmpty and sInfoFiltered in whatever combination they are
	 * being used) at all times.
	 * 
	 * <pre>
	 * Default: 	Empty string
	 * Type: 	string
	 * 
	 * $(document).ready( function() {
	 *   $('#example').dataTable( {
	 *     "oLanguage": {
	 *       "sInfoPostFix": "All records shown are derived from real information."
	 *     }
	 *   } );
	 * } );
	 * </pre>
	 */
	public String sInfoPostFix;
	/**
	 * DataTables has a build in number formatter (fnFormatNumber) which is used
	 * to format large numbers that are used in the table information. By
	 * default a comma is used, but this can be trivially changed to any
	 * character you wish with this parameter.
	 * 
	 * <pre>
	 * Default: 	,
	 * Type: 	string
	 * 
	 * $(document).ready( function() {
	 *   $('#example').dataTable( {
	 *     "oLanguage": {
	 *       "sInfoThousands": "'"
	 *     }
	 *   } );
	 * } );
	 * </pre>
	 */
	public String sInfoThousands;
	/**
	 * Detail the action that will be taken when the drop down menu for the
	 * pagination length option is changed. The 'MENU' variable is replaced with
	 * a default select list of 10, 25, 50 and 100, and can be replaced with a
	 * custom select box if required.
	 * 
	 * <pre>
	 * Default: 	Show _MENU_ entries
	 * Type: 	string
	 * 
	 * // Language change only
	 * $(document).ready( function() {
	 *   $('#example').dataTable( {
	 *     "oLanguage": {
	 *       "sLengthMenu": "Display _MENU_ records"
	 *     }
	 *   } );
	 * } );
	 *  
	 *  
	 * // Language and options change
	 * $(document).ready( function() {
	 *   $('#example').dataTable( {
	 *     "oLanguage": {
	 *       "sLengthMenu": 'Display <select>'+
	 *         '<option value="10">10</option>'+
	 *         '<option value="20">20</option>'+
	 *         '<option value="30">30</option>'+
	 *         '<option value="40">40</option>'+
	 *         '<option value="50">50</option>'+
	 *         '<option value="-1">All</option>'+
	 *         '</select> records'
	 *     }
	 *   } );
	 * } );
	 * </pre>
	 */
	public String sLengthMenu;
	/**
	 * When using Ajax sourced data and during the first draw when DataTables is
	 * gathering the data, this message is shown in an empty row in the table to
	 * indicate to the end user the the data is being loaded. Note that this
	 * parameter is not used when loading data by server-side processing, just
	 * Ajax sourced data with client-side processing.
	 * 
	 * <pre>
	 * Default: 	Loading...
	 * Type: 	string
	 * 
	 * $(document).ready( function() {
	 *   $('#example').dataTable( {
	 *     "oLanguage": {
	 *       "sLoadingRecords": "Please wait - loading..."
	 *     }
	 *   } );
	 * } );
	 * </pre>
	 */
	public String sLoadingRecords;
	/**
	 * Text which is displayed when the table is processing a user action
	 * (usually a sort command or similar).
	 * 
	 * <pre>
	 * Default: 	Processing...
	 * Type: 	string
	 * 
	 * $(document).ready( function() {
	 *   $('#example').dataTable( {
	 *     "oLanguage": {
	 *       "sProcessing": "DataTables is currently busy"
	 *     }
	 *   } );
	 * } );
	 * </pre>
	 */
	public String sProcessing;
	/**
	 * Details the actions that will be taken when the user types into the
	 * filtering input text box. The variable "INPUT", if used in the string, is
	 * replaced with the HTML text box for the filtering input allowing control
	 * over where it appears in the string. If "INPUT" is not given then the
	 * input box is appended to the string automatically.
	 * 
	 * <pre>
	 * Default: 	Search:
	 * Type: 	string
	 * 
	 * // Input text box will be appended at the end automatically
	 * $(document).ready( function() {
	 *   $('#example').dataTable( {
	 *     "oLanguage": {
	 *       "sSearch": "Filter records:"
	 *     }
	 *   } );
	 * } );
	 *  
	 *  
	 * // Specify where the filter should appear
	 * $(document).ready( function() {
	 *   $('#example').dataTable( {
	 *     "oLanguage": {
	 *       "sSearch": "Apply filter _INPUT_ to table"
	 *     }
	 *   } );
	 * } );
	 * </pre>
	 */
	public String sSearch;
	/**
	 * All of the language information can be stored in a file on the
	 * server-side, which DataTables will look up if this parameter is passed.
	 * It must store the URL of the language file, which is in a JSON format,
	 * and the object has the same properties as the oLanguage object in the
	 * initialiser object (i.e. the above parameters). Please refer to one of
	 * the example language files to see how this works in action.
	 * 
	 * <pre>
	 * Default: 	Empty string - i.e. disabled
	 * Type: 	string
	 * 
	 * $(document).ready( function() {
	 *   $('#example').dataTable( {
	 *     "oLanguage": {
	 *       "sUrl": "http://www.sprymedia.co.uk/dataTables/lang.txt"
	 *     }
	 *   } );
	 * } );
	 * </pre>
	 */
	public String sUrl;
	/**
	 * Text shown inside the table records when the is no information to be
	 * displayed after filtering. sEmptyTable is shown when there is simply no
	 * information in the table at all (regardless of filtering).
	 * 
	 * <pre>
	 * Default: 	No matching records found
	 * Type: 	string
	 * 
	 * $(document).ready( function() {
	 *   $('#example').dataTable( {
	 *     "oLanguage": {
	 *       "sZeroRecords": "No records to display"
	 *     }
	 *   } );
	 * } );
	 * </pre>
	 */
	public String sZeroRecords;
}
