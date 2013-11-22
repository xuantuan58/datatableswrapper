package net.datatables.wrapper.model;

import java.util.List;

import net.datatables.wrapper.annotation.AnnotationParsing;

import com.fasterxml.jackson.annotation.JsonRawValue;

/**
 * Class represents a datatable object.
 * @author xuantuan.bui
 *
 * @param <T>
 */
public class DataTable<T> extends AnnotationParsing<T> {
	
	
	public DataTable(){}
	
	
	public DataTable(Class<T> t) {
		super(t);
	}

	// Options
	/**
	 * Replace a DataTable which matches the given selector and replace it with
	 * one which has the properties of the new initialisation object passed. If
	 * no table matches the selector, then the new DataTable will be constructed
	 * as per normal.
	 * 
	 * <pre>
	 * 		Default: 	false
	 * 		Type: 	boolean
	 * 		
	 * 		$(document).ready( function() {
	 * 		  $('#example').dataTable( {
	 * 		    "sScrollY": "200px",
	 * 		    "bPaginate": false
	 * 		  } );
	 * 		   
	 * 		  // Some time later....
	 * 		  $('#example').dataTable( {
	 * 		    "bFilter": false,
	 * 		    "bDestroy": true
	 * 		  } );
	 * 		} );
	 * </pre>
	 */
	public Boolean bDestroy;
	/**
	 * Retrieve the DataTables object for the given selector. Note that if the
	 * table has already been initialised, this parameter will cause DataTables
	 * to simply return the object that has already been set up - it will not
	 * take account of any changes you might have made to the initialisation
	 * object passed to DataTables (setting this parameter to true is an
	 * acknowledgement that you understand this). bDestroy can be used to
	 * reinitialise a table if you need.
	 * 
	 * <pre>
	 * Default: 	false
	 * Type: 	boolean
	 * $(document).ready( function() {
	 *   initTable();
	 *   tableActions();
	 * } );
	 *  
	 * function initTable ()
	 * {
	 *   return $('#example').dataTable( {
	 *     "sScrollY": "200px",
	 *     "bPaginate": false,
	 *     "bRetrieve": true
	 *   } );
	 * }
	 *  
	 * function tableActions ()
	 * {
	 *   var oTable = initTable();
	 *   // perform API operations with oTable
	 * }
	 * </pre>
	 */
	public Boolean bRetrieve;
	/**
	 * 
	 Hide details
	 * 
	 * Deprecated Indicate if DataTables should be allowed to set the padding /
	 * margin etc for the scrolling header elements or not. Typically you will
	 * want this.
	 * 
	 * Please note that this option has now been deprecated and will be removed
	 * in the next version of DataTables. Using CSS with `!important` can be
	 * used to achieve the same effect.
	 * 
	 * <pre>
	 * Default: 	true
	 * Type: 	boolean
	 * $(document).ready( function() {
	 *   $('#example').dataTable( {
	 *     "bScrollAutoCss": false,
	 *     "sScrollY": "200px"
	 *   } );
	 * } );
	 * </pre>
	 */
	public @Deprecated
	Boolean bScrollAutoCss;
	/**
	 * When vertical (y) scrolling is enabled, DataTables will force the height
	 * of the table's viewport to the given height at all times (useful for
	 * layout). However, this can look odd when filtering data down to a small
	 * data set, and the footer is left "floating" further down. This parameter
	 * (when enabled) will cause DataTables to collapse the table's viewport
	 * down when the result set will fit within the given Y height.
	 * 
	 * <pre>
	 * Default: 	false
	 * Type: 	boolean
	 * 
	 * $(document).ready( function() {
	 *   $('#example').dataTable( {
	 *     "sScrollY": "200",
	 *     "bScrollCollapse": true
	 *   } );
	 * } );
	 * </pre>
	 */
	public Boolean bScrollCollapse;
	/**
	 * bSortCellsTop Hide details
	 * 
	 * Allows control over whether DataTables should use the top (true) unique
	 * cell that is found for a single column, or the bottom (false - default).
	 * This is useful when using complex headers.
	 * 
	 * <pre>
	 * Default: 	false
	 * Type: 	boolean
	 * $(document).ready( function() {
	 *   $('#example').dataTable( {
	 *     "bSortCellsTop": true
	 *   } );
	 * } );
	 * </pre>
	 */
	public Boolean bSortCellsTop;
	/**
	 * Duration of the cookie which is used for storing session information.
	 * This value is given in seconds.
	 * 
	 * <pre>
	 * Default: 	7200 (2 hours)
	 * Type: 	int
	 * 
	 * $(document).ready( function() {
	 *   $('#example').dataTable( {
	 *     "iCookieDuration": 60*60*24; // 1 day
	 *   } );
	 * } )
	 * </pre>
	 */
	public Integer iCookieDuration;
	/**
	 * When enabled DataTables will not make a request to the server for the
	 * first page draw - rather it will use the data already on the page (no
	 * sorting etc will be applied to it), thus saving on an XHR at load time.
	 * iDeferLoading is used to indicate that deferred loading is required, but
	 * it is also used to tell DataTables how many records there are in the full
	 * table (allowing the information element and pagination to be displayed
	 * correctly). In the case where a filtering is applied to the table on
	 * initial load, this can be indicated by giving the parameter as an array,
	 * where the first element is the number of records available after
	 * filtering and the second element is the number of records without
	 * filtering (allowing the table information element to be shown correctly).
	 * 
	 * <pre>
	 * Default: 	null
	 * Type: 	int
	 * 
	 * // 57 records available in the table, no filtering applied
	 * $(document).ready( function() {
	 *   $('#example').dataTable( {
	 *     "bServerSide": true,
	 *     "sAjaxSource": "scripts/server_processing.php",
	 *     "iDeferLoading": 57
	 *   } );
	 * } );
	 *  
	 *  
	 * // 57 records after filtering, 100 without filtering (an initial filter applied)
	 * $(document).ready( function() {
	 *   $('#example').dataTable( {
	 *     "bServerSide": true,
	 *     "sAjaxSource": "scripts/server_processing.php",
	 *     "iDeferLoading": [ 57, 100 ],
	 *     "oSearch": {
	 *       "sSearch": "my_filter"
	 *     }
	 *   } );
	 * } );
	 * </pre>
	 */
	public Integer iDeferLoading;
	/**
	 * 
	 * Number of rows to display on a single page when using pagination. If
	 * feature enabled (bLengthChange) then the end user will be able to
	 * override this to a custom setting using a pop-up menu.
	 * 
	 * <pre>
	 * Default: 	10
	 * Type: 	int
	 * $(document).ready( function() {
	 *   $('#example').dataTable( {
	 *     "iDisplayLength": 50
	 *   } );
	 * } )
	 * </pre>
	 */
	public Integer iDisplayLength;
	/**
	 * Define the starting point for data display when using DataTables with
	 * pagination. Note that this parameter is the number of records, rather
	 * than the page number, so if you have 10 records per page and want to
	 * start on the third page, it should be "20".
	 * 
	 * <pre>
	 * Default: 	0
	 * Type: 	int
	 * 
	 * $(document).ready( function() {
	 *   $('#example').dataTable( {
	 *     "iDisplayStart": 20
	 *   } );
	 * } )
	 * </pre>
	 */
	public Integer iDisplayStart;
	/**
	 * The scroll gap is the amount of scrolling that is left to go before
	 * DataTables will load the next 'page' of data automatically. You typically
	 * want a gap which is big enough that the scrolling will be smooth for the
	 * user, while not so large that it will load more data than need.
	 * 
	 * <pre>
	 * Default: 	100
	 * Type: 	int
	 * $(document).ready( function() {
	 *   $('#example').dataTable( {
	 *     "bScrollInfinite": true,
	 *     "bScrollCollapse": true,
	 *     "sScrollY": "200px",
	 *     "iScrollLoadGap": 50
	 *   } );
	 * } );
	 * </pre>
	 */
	public Integer iScrollLoadGap;
	/**
	 * By default DataTables allows keyboard navigation of the table (sorting,
	 * paging, and filtering) by adding a tabindex attribute to the required
	 * elements. This allows you to tab through the controls and press the enter
	 * key to activate them. The tabindex is default 0, meaning that the tab
	 * follows the flow of the document. You can overrule this using this
	 * parameter if you wish. Use a value of -1 to disable built-in keyboard
	 * navigation.
	 * 
	 * <pre>
	 * Default: 	0
	 * Type: 	int
	 * $(document).ready( function() {
	 *   $('#example').dataTable( {
	 *     "iTabIndex": 1
	 *   } );
	 * } );
	 * </pre>
	 */
	public Integer iTabIndex;
	/**
	 * By default DataTables will look for the property 'aaData' when obtaining
	 * data from an Ajax source or for server-side processing - this parameter
	 * allows that property to be changed. You can use Javascript dotted object
	 * notation to get a data source for multiple levels of nesting.
	 * 
	 * <pre>
	 * Default: 	aaData
	 * Type: 	string
	 * 
	 * // Get data from { "data": [...] }
	 * $(document).ready( function() {
	 *   var oTable = $('#example').dataTable( {
	 *     "sAjaxSource": "sources/data.txt",
	 *     "sAjaxDataProp": "data"
	 *   } );
	 * } );
	 *  
	 *  
	 * // Get data from { "data": { "inner": [...] } }
	 * $(document).ready( function() {
	 *   var oTable = $('#example').dataTable( {
	 *     "sAjaxSource": "sources/data.txt",
	 *     "sAjaxDataProp": "data.inner"
	 *   } );
	 * } );
	 * </pre>
	 */
	public String sAjaxDataProp; // aaData
	/**
	 * You can instruct DataTables to load data from an external source using
	 * this parameter (use aData if you want to pass data in you already have).
	 * Simply provide a url a JSON object can be obtained from. This object must
	 * include the parameter 'aaData' which is the data source for the table.
	 * 
	 * <pre>
	 * Default: 	null
	 * Type: 	string
	 * 
	 * $(document).ready( function() {
	 *   $('#example').dataTable( {
	 *     "sAjaxSource": "http://www.sprymedia.co.uk/dataTables/json.php"
	 *   } );
	 * } )
	 * </pre>
	 */
	public String sAjaxSource;
	/**
	 * This parameter can be used to override the default prefix that DataTables
	 * assigns to a cookie when state saving is enabled.
	 * 
	 * <pre>
	 * Default: 	SpryMedia_DataTables_
	 * Type: 	string
	 * 
	 * $(document).ready( function() {
	 *   $('#example').dataTable( {
	 *     "sCookiePrefix": "my_datatable_",
	 *   } );
	 * } );
	 * </pre>
	 */
	public String sCookiePrefix;
/**
	 * This initialisation variable allows you to specify exactly where in the
	 * DOM you want DataTables to inject the various controls it adds to the
	 * page (for example you might want the pagination controls at the top of
	 * the table). DIV elements (with or without a custom class) can also be
	 * added to aid styling. The follow syntax is used:
	 * <pre>
	 * The following options are allowed:
        'l' - Length changing
        'f' - Filtering input
        't' - The table!
        'i' - Information
        'p' - Pagination
        'r' - pRocessing
    The following constants are allowed:
        'H' - jQueryUI theme "header" classes ('fg-toolbar ui-widget-header ui-corner-tl ui-corner-tr ui-helper-clearfix')
        'F' - jQueryUI theme "footer" classes ('fg-toolbar ui-widget-header ui-corner-bl ui-corner-br ui-helper-clearfix')
    The following syntax is expected:
        '<' and '>' - div elements
        '<"class" and '>' - div with a class
        '<"#id" and '>' - div with an ID
    Examples:
        '<"wrapper"flipt>'
        'ip>'
	 * Default: 	lfrtip (when bJQueryUI is false) or <"H"lfr>t<"F"ip> (when bJQueryUI is true)
	 * Type: 	string
	 * 
	 * $(document).ready( function() {
	 *   $('#example').dataTable( {
	 *     "sDom": '<"top"i>rt<"bottom"flp><"clear">'
	 *   } );
	 * } );
	 * </pre>
	 */
	public String sDom; // lfrtip (when bJQueryUI is false) or
						// <"H"lfr>t<"F"ip>(when bJQueryUI is true)
	/**
	 * DataTables features two different built-in pagination interaction methods
	 * ('twobutton' or 'fullnumbers') which present different page controls to
	 * the end user. Further methods can be added using the API (see below).
	 * 
	 * <pre>
	 * Default: 	two_button
	 * Type: 	string
	 * 
	 * $(document).ready( function() {
	 *   $('#example').dataTable( {
	 *     "sPaginationType": "full_numbers"
	 *   } );
	 * } )
	 * </pre>
	 */
	public String sPaginationType;
	/**
	 * This property can be used to force a DataTable to use more width than it
	 * might otherwise do when x-scrolling is enabled. For example if you have a
	 * table which requires to be well spaced, this parameter is useful for
	 * "over-sizing" the table, and thus forcing scrolling. This property can by
	 * any CSS unit, or a number (in which case it will be treated as a pixel
	 * measurement).
	 * 
	 * <pre>
	 * Default: 	blank string - i.e. disabled
	 * Type: 	string
	 * 
	 * $(document).ready( function() {
	 *   $('#example').dataTable( {
	 *     "sScrollX": "100%",
	 *     "sScrollXInner": "110%"
	 *   } );
	 * } );
	 * </pre>
	 */
	public String sScrollXInner;
	/**
	 * Set the HTTP method that is used to make the Ajax call for server-side
	 * processing or Ajax sourced data.
	 * 
	 * <pre>
	 * Default: 	GET
	 * Type: 	string
	 * 
	 * $(document).ready( function() {
	 *   $('#example').dataTable( {
	 *     "bServerSide": true,
	 *     "sAjaxSource": "scripts/post.php",
	 *     "sServerMethod": "POST"
	 *   } );
	 * } );
	 * </pre>
	 */
	public String sServerMethod; // GET POST
	// ---End option

	// Features
	/**
	 * Enable or disable automatic column width calculation. This can be
	 * disabled as an optimisation (it takes some time to calculate the widths)
	 * if the tables widths are passed in using aoColumns.
	 * 
	 * <pre>
	 * Default: 	true
	 * Type: 	boolean
	 * 
	 * $(document).ready( function () {
	 *   $('#example').dataTable( {
	 *     "bAutoWidth": false
	 *   } );
	 * } );
	 * </pre>
	 */
	public Boolean bAutoWidth;
	/**
	 * Deferred rendering can provide DataTables with a huge speed boost when
	 * you are using an Ajax or JS data source for the table. This option, when
	 * set to true, will cause DataTables to defer the creation of the table
	 * elements for each row until they are needed for a draw - saving a
	 * significant amount of time.
	 * 
	 * <pre>
	 * Default: 	false
	 * Type: 	boolean
	 * 
	 * $(document).ready( function() {
	 *   var oTable = $('#example').dataTable( {
	 *     "sAjaxSource": "sources/arrays.txt",
	 *     "bDeferRender": true
	 *   } );
	 * } );
	 * </pre>
	 */
	public Boolean bDeferRender;
	/**
	 * Enable or disable filtering of data. Filtering in DataTables is "smart"
	 * in that it allows the end user to input multiple words (space separated)
	 * and will match a row containing those words, even if not in the order
	 * that was specified (this allows matching across multiple columns). Note
	 * that if you wish to use filtering in DataTables this must remain 'true' -
	 * to remove the default filtering input box and retain filtering abilities,
	 * please use sDom).
	 * 
	 * <pre>
	 * Default: 	true
	 * Type: 	boolean
	 * 
	 * $(document).ready( function () {
	 *   $('#example').dataTable( {
	 *     "bFilter": false
	 *   } );
	 * } );
	 * </pre>
	 */
	public Boolean bFilter;
	/**
	 * Enable or disable the table information display. This shows information
	 * about the data that is currently visible on the page, including
	 * information about filtered data if that action is being performed.
	 * 
	 * <pre>
	 * Default: 	true
	 * Type: 	boolean
	 * 
	 * $(document).ready( function () {
	 *   $('#example').dataTable( {
	 *     "bInfo": false
	 *   } );
	 * } );
	 * </pre>
	 */
	public Boolean bInfo;
	/**
	 * Enable jQuery UI ThemeRoller support (required as ThemeRoller requires
	 * some slightly different and additional mark-up from what DataTables has
	 * traditionally used).
	 * 
	 * <pre>
	 * Default: 	false
	 * Type: 	boolean
	 * 	
	 * $(document).ready( function() {
	 *   $('#example').dataTable( {
	 *     "bJQueryUI": true
	 *   } );
	 * } );
	 * </pre>
	 */
	public Boolean bJQueryUI;
	/**
	 * Allows the end user to select the size of a formatted page from a select
	 * menu (sizes are 10, 25, 50 and 100). Requires pagination (bPaginate).
	 * 
	 * <pre>
	 * Default: 	true
	 * Type: 	boolean
	 * 
	 * $(document).ready( function () {
	 *   $('#example').dataTable( {
	 *     "bLengthChange": false
	 *   } );
	 * } );
	 * </pre>
	 */
	public Boolean bLengthChange;
	/**
	 * Enable or disable pagination.
	 * 
	 * <pre>
	 * Default: 	true
	 * Type: 	boolean
	 * 
	 * $(document).ready( function () {
	 *   $('#example').dataTable( {
	 *     "bPaginate": false
	 *   } );
	 * } );
	 * </pre>
	 */
	public Boolean bPaginate;
	/**
	 * Enable or disable the display of a 'processing' indicator when the table
	 * is being processed (e.g. a sort). This is particularly useful for tables
	 * with large amounts of data where it can take a noticeable amount of time
	 * to sort the entries.
	 * 
	 * <pre>
	 * Default: 	false
	 * Type: 	boolean
	 * 
	 * $(document).ready( function () {
	 *   $('#example').dataTable( {
	 *     "bProcessing": true
	 *   } );
	 * } );
	 * </pre>
	 */
	public Boolean bProcessing;
	/**
	 * Deprecated Enable infinite scrolling for DataTables (to be used in
	 * combination with sScrollY). Infinite scrolling means that DataTables will
	 * continually load data as a user scrolls through a table, which is very
	 * useful for large dataset. This cannot be used with pagination, which is
	 * automatically disabled.
	 * 
	 * Please note that this option has now been deprecated and will be removed
	 * in the next version of DataTables. Please use the Scroller extra instead.
	 * 
	 * <pre>
	 * Default: 	false
	 * Type: 	boolean
	 * 
	 * $(document).ready( function() {
	 *   $('#example').dataTable( {
	 *     "bScrollInfinite": true,
	 *     "bScrollCollapse": true,
	 *     "sScrollY": "200px"
	 *   } );
	 * } );
	 * </pre>
	 */
	public @Deprecated
	Boolean bScrollInfinite;
	/**
	 * Configure DataTables to use server-side processing. Note that the
	 * sAjaxSource parameter must also be given in order to give DataTables a
	 * source to obtain the required data for each draw.
	 * 
	 * <pre>
	 * Default: 	false
	 * Type: 	boolean
	 * 
	 * $(document).ready( function () {
	 *   $('#example').dataTable( {
	 *     "bServerSide": true,
	 *     "sAjaxSource": "xhr.php"
	 *   } );
	 * } );
	 * </pre>
	 */
	public Boolean bServerSide;
	/**
	 * Enable or disable sorting of columns. Sorting of individual columns can
	 * be disabled by the "bSortable" option for each column.
	 * 
	 * <pre>
	 * Default: 	true
	 * Type: 	boolean
	 * 
	 * $(document).ready( function () {
	 *   $('#example').dataTable( {
	 *     "bSort": false
	 *   } );
	 * } );
	 * </pre>
	 */
	public Boolean bSort;
	/**
	 * Enable or disable the addition of the classes 'sorting_1', 'sorting_2'
	 * and 'sorting_3' to the columns which are currently being sorted on. This
	 * is presented as a feature switch as it can increase processing time
	 * (while classes are removed and added) so for large data sets you might
	 * want to turn this off.
	 * 
	 * <pre>
	 * Default: 	true
	 * Type: 	boolean
	 * 
	 * $(document).ready( function () {
	 *   $('#example').dataTable( {
	 *     "bSortClasses": false
	 *   } );
	 * } );
	 * </pre>
	 */
	public Boolean bSortClasses;
	/**
	 * Enable or disable state saving. When enabled a cookie will be used to
	 * save table display information such as pagination information, display
	 * length, filtering and sorting. As such when the end user reloads the page
	 * the display will match what they had previously set up.
	 * 
	 * <pre>
	 * Default: 	false
	 * Type: 	boolean
	 * 
	 * $(document).ready( function () {
	 *   $('#example').dataTable( {
	 *     "bStateSave": true
	 *   } );
	 * } );
	 * </pre>
	 */
	public Boolean bStateSave;
	/**
	 * Enable horizontal scrolling. When a table is too wide to fit into a
	 * certain layout, or you have a large number of columns in the table, you
	 * can enable x-scrolling to show the table in a viewport, which can be
	 * scrolled. This property can be any CSS unit, or a number (in which case
	 * it will be treated as a pixel measurement).
	 * 
	 * <pre>
	 * Default: 	blank string - i.e. disabled
	 * Type: 	string
	 * 
	 * $(document).ready( function() {
	 *   $('#example').dataTable( {
	 *     "sScrollX": "100%",
	 *     "bScrollCollapse": true
	 *   } );
	 * } );
	 * </pre>
	 */
	public String sScrollX;
	/**
	 * Enable vertical scrolling. Vertical scrolling will constrain the
	 * DataTable to the given height, and enable scrolling for any data which
	 * overflows the current viewport. This can be used as an alternative to
	 * paging to display a lot of data in a small area (although paging and
	 * scrolling can both be enabled at the same time). This property can be any
	 * CSS unit, or a number (in which case it will be treated as a pixel
	 * measurement).
	 * 
	 * <pre>
	 * Default: 	blank string - i.e. disabled
	 * Type: 	string
	 * 
	 * $(document).ready( function() {
	 *   $('#example').dataTable( {
	 *     "sScrollY": "200px",
	 *     "bPaginate": false
	 *   } );
	 * } );
	 * </pre>
	 */
	public String sScrollY;
	// ---End Features

	// Callbacks
	/**
	 * Customise the cookie and / or the parameters being stored when using
	 * DataTables with state saving enabled. This function is called whenever
	 * the cookie is modified, and it expects a fully formed cookie string to be
	 * returned. Note that the data object passed in is a Javascript object
	 * which must be converted to a string (JSON.stringify for example).
	 * 
	 * <pre>
	 * 
	 * <pre>
	 * Default: 	
	 * Type: 	function
	 * 
	 * $(document).ready( function () {
	 *   $('#example').dataTable( {
	 *     "fnCookieCallback": function (sName, oData, sExpires, sPath) {
	 *       // Customise oData or sName or whatever else here
	 *       return sName + "="+JSON.stringify(oData)+"; expires=" + sExpires +"; path=" + sPath;
	 *     }
	 *   } );
	 * } );
	 * </pre>
	 */
	public FnCallBack fnCookieCallback;
	/**
	 * This function is called when a TR element is created (and all TD child
	 * elements have been inserted), or registered if using a DOM source,
	 * allowing manipulation of the TR element (adding classes etc).
	 * 
	 * <pre>
	 * 
	 * <pre>
	 * Default: 	
	 * Type: 	function
	 * 
	 * $(document).ready( function() {
	 *   $('#example').dataTable( {
	 *     "fnCreatedRow": function( nRow, aData, iDataIndex ) {
	 *       // Bold the grade for all 'A' grade browsers
	 *       if ( aData[4] == "A" )
	 *       {
	 *         $('td:eq(4)', nRow).html( '<b>A</b>' );
	 *       }
	 *     }
	 *   } );
	 *  } );
	 * </pre>
	 */
	public FnCallBack fnCreatedRow;
	/**
	 * This function is called on every 'draw' event, and allows you to
	 * dynamically modify any aspect you want about the created DOM.
	 * 
	 * <pre>
	 * 
	 * <pre>
	 * Default: 	
	 * Type: 	function
	 * 
	 * $(document).ready( function() {
	 *   $('#example').dataTable( {
	 *     "fnDrawCallback": function( oSettings ) {
	 *       alert( 'DataTables has redrawn the table' );
	 *     }
	 *   } );
	 *  } );
	 * </pre>
	 */
	public FnCallBack fnDrawCallback;
	/**
	 * Identical to fnHeaderCallback() but for the table footer this function
	 * allows you to modify the table footer on every 'draw' even.
	 * 
	 * <pre>
	 * Default: 	
	 * Type: 	function
	 * 
	 * $(document).ready( function() {
	 *   $('#example').dataTable( {
	 *     "fnFooterCallback": function( nFoot, aData, iStart, iEnd, aiDisplay ) {
	 *       nFoot.getElementsByTagName('th')[0].innerHTML = "Starting index is "+iStart;
	 *     }
	 *   } );
	 * } )
	 * </pre>
	 */
	public FnCallBack fnFooterCallback;
	/**
	 * When rendering large numbers in the information element for the table
	 * (i.e. "Showing 1 to 10 of 57 entries") DataTables will render large
	 * numbers to have a comma separator for the 'thousands' units (e.g. 1
	 * million is rendered as "1,000,000") to help readability for the end user.
	 * This function will override the default method DataTables uses.
	 * 
	 * <pre>
	 * Default: 	
	 * Type: 	function
	 * 
	 * $(document).ready( function() {
	 *   $('#example').dataTable( {
	 *     "fnFormatNumber": function ( iIn ) {
	 *       if ( iIn < 1000 ) {
	 *         return iIn;
	 *       } else {
	 *         var
	 *           s=(iIn+""),
	 *           a=s.split(""), out="",
	 *           iLen=s.length;
	 *          
	 *         for ( var i=0 ; i<iLen ; i++ ) {
	 *           if ( i%3 === 0 && i !== 0 ) {
	 *             out = "'"+out;
	 *           }
	 *           out = a[iLen-i-1]+out;
	 *         }
	 *       }
	 *       return out;
	 *     };
	 *   } );
	 *  } );
	 * </pre>
	 */
	public FnCallBack fnFormatNumber;
	/**
	 * This function is called on every 'draw' event, and allows you to
	 * dynamically modify the header row. This can be used to calculate and
	 * display useful information about the table.
	 * 
	 * <pre>
	 * Default: 	
	 * Type: 	function
	 * 
	 * $(document).ready( function() {
	 *   $('#example').dataTable( {
	 *     "fnHeaderCallback": function( nHead, aData, iStart, iEnd, aiDisplay ) {
	 *       nHead.getElementsByTagName('th')[0].innerHTML = "Displaying "+(iEnd-iStart)+" records";
	 *     }
	 *   } );
	 * } )
	 * </pre>
	 */
	public FnCallBack fnHeaderCallback;
	/**
	 * The information element can be used to convey information about the
	 * current state of the table. Although the internationalisation options
	 * presented by DataTables are quite capable of dealing with most
	 * customisations, there may be times where you wish to customise the string
	 * further. This callback allows you to do exactly that.
	 * 
	 * <pre>
	 * Default: 	
	 * Type: 	function
	 * 
	 * $('#example').dataTable( {
	 *   "fnInfoCallback": function( oSettings, iStart, iEnd, iMax, iTotal, sPre ) {
	 *     return iStart +" to "+ iEnd;
	 *   }
	 *  } );
	 * </pre>
	 */
	public FnCallBack fnInfoCallback;
	/**
	 * Called when the table has been initialised. Normally DataTables will
	 * initialise sequentially and there will be no need for this function,
	 * however, this does not hold true when using external language information
	 * since that is obtained using an async XHR call.
	 * 
	 * <pre>
	 * Default: 	
	 * Type: 	function
	 * 
	 * $(document).ready( function() {
	 *   $('#example').dataTable( {
	 *     "fnInitComplete": function(oSettings, json) {
	 *       alert( 'DataTables has finished its initialisation.' );
	 *     }
	 *   } );
	 * } )
	 * </pre>
	 */
	public FnCallBack fnInitComplete;
	/**
	 * Called at the very start of each table draw and can be used to cancel the
	 * draw by returning false, any other return (including undefined) results
	 * in the full draw occurring).
	 * 
	 * <pre>
	 * Default: 	
	 * Type: 	function
	 * 
	 * $(document).ready( function() {
	 *   $('#example').dataTable( {
	 *     "fnPreDrawCallback": function( oSettings ) {
	 *       if ( $('#test').val() == 1 ) {
	 *         return false;
	 *       }
	 *     }
	 *   } );
	 *  } );
	 * </pre>
	 */
	public FnCallBack fnPreDrawCallback;
	/**
	 * This function allows you to 'post process' each row after it have been
	 * generated for each table draw, but before it is rendered on screen. This
	 * function might be used for setting the row class name etc.
	 * 
	 * <pre>
	 * Default: 	
	 * Type: 	function
	 * 
	 * $(document).ready( function() {
	 *   $('#example').dataTable( {
	 *     "fnRowCallback": function( nRow, aData, iDisplayIndex, iDisplayIndexFull ) {
	 *       // Bold the grade for all 'A' grade browsers
	 *       if ( aData[4] == "A" )
	 *       {
	 *         $('td:eq(4)', nRow).html( '<b>A</b>' );
	 *       }
	 *     }
	 *   } );
	 *  } );
	 * </pre>
	 */
	public FnCallBack fnRowCallback;
	/**
	 * This parameter allows you to override the default function which obtains
	 * the data from the server ($.getJSON) so something more suitable for your
	 * application. For example you could use POST data, or pull information
	 * from a Gears or AIR database.
	 * 
	 * <pre>
	 * Default: 	
	 * Type: 	function
	 * 
	 * // POST data to server
	 * $(document).ready( function() {
	 *   $('#example').dataTable( {
	 *     "bProcessing": true,
	 *     "bServerSide": true,
	 *     "sAjaxSource": "xhr.php",
	 *     "fnServerData": function ( sSource, aoData, fnCallback, oSettings ) {
	 *       oSettings.jqXHR = $.ajax( {
	 *         "dataType": 'json',
	 *         "type": "POST",
	 *         "url": sSource,
	 *         "data": aoData,
	 *         "success": fnCallback
	 *       } );
	 *     }
	 *   } );
	 *  } );
	 * </pre>
	 */
	public FnCallBack fnServerData;
	/**
	 * It is often useful to send extra data to the server when making an Ajax
	 * request - for example custom filtering information, and this callback
	 * function makes it trivial to send extra information to the server. The
	 * passed in parameter is the data set that has been constructed by
	 * DataTables, and you can add to this or modify it as you require.
	 * 
	 * <pre>
	 * Default: 	
	 * Type: 	function
	 * 
	 * $(document).ready( function() {
	 *   $('#example').dataTable( {
	 *     "bProcessing": true,
	 *     "bServerSide": true,
	 *     "sAjaxSource": "scripts/server_processing.php",
	 *     "fnServerParams": function ( aoData ) {
	 *       aoData.push( { "name": "more_data", "value": "my_value" } );
	 *     }
	 *   } );
	 *  } );
	 * </pre>
	 */
	public FnCallBack fnServerParams;
	/**
	 * Load the table state. With this function you can define from where, and
	 * how, the state of a table is loaded. By default DataTables will load from
	 * its state saving cookie, but you might wish to use local storage (HTML5)
	 * or a server-side database.
	 * 
	 * <pre>
	 * Default: 	
	 * Type: 	function
	 * 
	 * $(document).ready( function() {
	 *   $('#example').dataTable( {
	 *     "bStateSave": true,
	 *     "fnStateLoad": function (oSettings) {
	 *       var o;
	 *        
	 *       // Send an Ajax request to the server to get the data. Note that
	 *       // this is a synchronous request.
	 *       $.ajax( {
	 *         "url": "/state_load",
	 *         "async": false,
	 *         "dataType": "json",
	 *         "success": function (json) {
	 *           o = json;
	 *         }
	 *       } );
	 *        
	 *       return o;
	 *     }
	 *   } );
	 *  } );
	 * </pre>
	 */
	public FnCallBack fnStateLoad;
	/**
	 * Callback which allows modification of the saved state prior to loading
	 * that state. This callback is called when the table is loading state from
	 * the stored data, but prior to the settings object being modified by the
	 * saved state. Note that for plug-in authors, you should use the
	 * 'stateLoadParams' event to load parameters for a plug-in.
	 * 
	 * <pre>
	 * Default: 	
	 * Type: 	function
	 * 
	 * // Remove a saved filter, so filtering is never loaded
	 * $(document).ready( function() {
	 *   $('#example').dataTable( {
	 *     "bStateSave": true,
	 *     "fnStateLoadParams": function (oSettings, oData) {
	 *       oData.oSearch.sSearch = "";
	 *     }
	 *   } );
	 * } );
	 *  
	 *  
	 * // Disallow state loading by returning false
	 * $(document).ready( function() {
	 *   $('#example').dataTable( {
	 *     "bStateSave": true,
	 *     "fnStateLoadParams": function (oSettings, oData) {
	 *       return false;
	 *     }
	 *   } );
	 *  } );
	 * </pre>
	 */
	public FnCallBack fnStateLoadParams;
	/**
	 * Callback that is called when the state has been loaded from the state
	 * saving method and the DataTables settings object has been modified as a
	 * result of the loaded state.
	 * 
	 * <pre>
	 * Default: 	
	 * Type: 	function
	 * 
	 * // Show an alert with the filtering value that was saved
	 * $(document).ready( function() {
	 *   $('#example').dataTable( {
	 *     "bStateSave": true,
	 *     "fnStateLoaded": function (oSettings, oData) {
	 *       alert( 'Saved filter was: '+oData.oSearch.sSearch );
	 *     }
	 *   } );
	 *  } );
	 * </pre>
	 */
	public FnCallBack fnStateLoaded;
	/**
	 * Save the table state. This function allows you to define where and how
	 * the state information for the table is stored - by default it will use a
	 * cookie, but you might want to use local storage (HTML5) or a server-side
	 * database.
	 * 
	 * <pre>
	 * Default: 	
	 * Type: 	function
	 * 
	 * $(document).ready( function() {
	 *   $('#example').dataTable( {
	 *     "bStateSave": true,
	 *     "fnStateSave": function (oSettings, oData) {
	 *       // Send an Ajax request to the server with the state object
	 *       $.ajax( {
	 *         "url": "/state_save",
	 *         "data": oData,
	 *         "dataType": "json",
	 *         "method": "POST"
	 *         "success": function () {}
	 *       } );
	 *     }
	 *   } );
	 *  } );
	 * </pre>
	 */
	public FnCallBack fnStateSave;
	/**
	 * Callback which allows modification of the state to be saved. Called when
	 * the table has changed state a new state save is required. This method
	 * allows modification of the state saving object prior to actually doing
	 * the save, including addition or other state properties or modification.
	 * Note that for plug-in authors, you should use the 'stateSaveParams' event
	 * to save parameters for a plug-in.
	 * 
	 * <pre>
	 * Default: 	
	 * Type: 	function
	 * 
	 * // Remove a saved filter, so filtering is never saved
	 * $(document).ready( function() {
	 *   $('#example').dataTable( {
	 *     "bStateSave": true,
	 *     "fnStateSaveParams": function (oSettings, oData) {
	 *       oData.oSearch.sSearch = "";
	 *     }
	 *   } );
	 *  } );
	 * </pre>
	 */
	public FnCallBack fnStateSaveParams;
	// --End callbacks

	// Objects
	/**
	 * This parameter allows you to define the global filtering state at
	 * initialisation time. As an object the "sSearch" parameter must be
	 * defined, but all other parameters are optional. When "bRegex" is true,
	 * the search string will be treated as a regular expression, when false
	 * (default) it will be treated as a straight string. When "bSmart"
	 * DataTables will use it's smart filtering methods (to word match at any
	 * point in the data), when false this will not be done.
	 * 
	 * <pre>
	 * Default: 	
	 * Type: 	
	 * $(document).ready( function() {
	 *   $('#example').dataTable( {
	 *     "oSearch": {"sSearch": "Initial search"}
	 *   } );
	 * } )
	 * 
	 * <pre>
	 */
	public OSearch oSearch;
	/**
	 * The language information presented by DataTables can be completely
	 * altered for internationalisation (or localisation) using the properties
	 * of the oLanguage object. Note that all strings in the following may
	 * contain HTML tags (i.e. you can include images etc. if you so wish in
	 * them).
	 */
	public OLanguage oLanguage;
	/**
	 * aoColumnDefs: This array allows you to target a specific column, multiple
	 * columns, or all columns, using the aTargets property of each object in
	 * the array (please note that aoColumnDefs was introduced in DataTables
	 * 1.7). This allows great flexibility when creating tables, as the
	 * aoColumnDefs arrays can be of any length, targeting the columns you
	 * specifically want. The aTargets property is an array to target one of
	 * many columns and each element in it can be:
	 * 
	 * <pre>
	 *     a string - class name will be matched on the TH for the column
	 *     0 or a positive integer - column index counting from the left
	 *     a negative integer - column index counting from the right
	 *     the string "_all" - all columns (i.e. assign a default)
	 * </pre>
	 */
	public List<AoColumnDefs> aoColumnDefs;
	/**
	 * aoColumns: If specified, then the length of this array must be equal to
	 * the number of columns in the original HTML table. Use 'null' where you
	 * wish to use only the default values and automatically detected options.
	 */
	private List<AoColumn> aoColumns;
	/**
	 * The data in a 2D array. Note that you can change the name of this
	 * parameter with sAjaxDataProp.
	 */
	public List<T> aaData;
	
	public String[][] aaSorting; 
	
	public List<AoColumn> getAoColumns() {
		return aoColumns == null? super.parseAoColumns(): aoColumns;
	}
	
	/**
	 * Difference from AoColumnDefs, entire column must be declared in the list of AoColumns
	 * How many columns is defined, that columns will be shown on client side, except set bVisible = false. 
	 * @param aoColumns
	 */
	public void setAoColumns(List<AoColumn> aoColumns) {
		this.aoColumns = aoColumns;
	}

}
