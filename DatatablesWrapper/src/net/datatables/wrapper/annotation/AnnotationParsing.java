package net.datatables.wrapper.annotation;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import net.datatables.wrapper.model.FnCallBack;
/**
 * Class handles annotation for datatable.
 * @author xuantuan.bui
 *
 * @param <T>
 */
public class AnnotationParsing<T>{
	private Class<T> t;
	
	public AnnotationParsing(){}
	
	public AnnotationParsing(Class<T> t){
		this.t = t;
	}

	/**
	 * Parse Bean object and return columns
	 * @return
	 */
	@SuppressWarnings("deprecation")
	protected List<net.datatables.wrapper.model.AoColumn> parseAoColumns() {
		List<net.datatables.wrapper.model.AoColumn> columns = new ArrayList<>();
		
		List<Field> fields = new ArrayList<>();
		fields =  getAllFields(fields, t);		//get all declares fields include inherits fields.
		
		if (fields != null && !fields.isEmpty()) {
			for (Field field : fields) {
				// get the field name
				String fieldName = field.getName();
				if (fieldName != null) {
					// get all anotation of current field
					AoColumn anoColumn = field.getAnnotation(AoColumn.class);
					if (anoColumn != null) {
						net.datatables.wrapper.model.AoColumn aoColumn = new net.datatables.wrapper.model.AoColumn();

						aoColumn.aDataSort = toIntegerArr(anoColumn.aDataSort());
						aoColumn.asSorting = toIntegerArr(anoColumn.asSorting());
						aoColumn.bSearchable = toBoolean(anoColumn.bSearchable());
						aoColumn.bSortable = toBoolean(anoColumn.bSortable());
						aoColumn.bVisible = toBoolean(anoColumn.bVisible());
						aoColumn.bUseRendered = toBoolean(anoColumn.bUseRendered());
						
						String fnCreatedCell = toString(anoColumn.fnCreatedCell());
						if(fnCreatedCell != null){
							aoColumn.fnCreatedCell = new FnCallBack(fnCreatedCell);
						}
						
						aoColumn.fnRender = toString(anoColumn.fnRender());
						aoColumn.iDataSort = toInteger(anoColumn.iDataSort());
						// if mData is not annotated, set the name of field as default
						aoColumn.mData = getMData(anoColumn.mData(), fieldName);
						aoColumn.mRender = toString(anoColumn.mRender());
						aoColumn.sCellType = toString(anoColumn.sCellType());
						aoColumn.sClass = toString(anoColumn.sClass());
						aoColumn.sContentPadding = toString(anoColumn.sContentPadding());
						aoColumn.sDefaultContent = toString(anoColumn.sDefaultContent());
						aoColumn.sName = toString(anoColumn.sName());
						aoColumn.sSortDataType = toString(anoColumn.sSortDataType());
						aoColumn.sTitle = toString(anoColumn.sTitle());
						aoColumn.sType = toString(anoColumn.sType());
						aoColumn.sWidth = toString(anoColumn.sWidth());
						columns.add(aoColumn);
					}
				}
			}
		}

		return columns;
	}
	
	/**
	 * Get all declares fields of class, include all inherited fields.
	 * @param fields
	 * @param type
	 * @return
	 */
	private List<Field> getAllFields(List<Field> fields, Class<?> type) {
		if (type != null && fields != null) {
			if (type.getSuperclass() != null) {
				fields = getAllFields(fields, type.getSuperclass());
			}

			for (Field field : type.getDeclaredFields()) {
				int idx = getFieldIndex(fields, field);
				if ((idx != -1)) {
					fields.remove(idx);
					fields.add(idx, field);
				} else {
					fields.add(field);
				}
			}
		}

		return fields;
	}
	
	/**
	 * Check if the field name is already in the list.
	 * @param fields
	 * @param field
	 * @return -1 if list fields doesn't contain field.
	 */
	private int getFieldIndex(List<Field> fields, Field field){
		if(fields == null || fields.isEmpty() || field == null){
			return -1;
		}
		
		String fname = field.getName();
		for (int i = 0; i < fields.size(); i++) {
			if(fields.get(i).getName().equals(fname)){
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * Return null if boolean value is true
	 * @param input
	 * @return null if input value is false.
	 */
	private Boolean toBoolean(boolean input){
		if(input){
			return null;
		}
		else{
			return Boolean.valueOf(input);
		}
	}

	/**
	 * Convert int into Integer object. return null if the int value is 0
	 * @param in
	 * @return null if input value is 0
	 */
	private Integer[] toIntegerArr(int[] in) {

		if (in != null && in.length > 0) {
			Integer[] newArray = new Integer[in.length];
			int i = 0;
			for (int value : in) {
				newArray[i++] = Integer.valueOf(value);
			}
			return newArray;
		} else {
			return null;
		}

	}

	private Integer toInteger(int in) {
		if (in == 0) {
			return null;
		} else {
			return Integer.valueOf(in);
		}
	}

	private String toString(String in) {
		if (in != null && in.equals("")) {
			return null;
		} else {
			return in;
		}
	}

	private String getMData(String anotated, String fieldName) {
		if (anotated != null && anotated.equals("")) {
			return fieldName;
		} else {
			return anotated;
		}
	}
}
