package net.datatables.wrapper.annotation;

import java.lang.annotation.*;

/**
 * Annotation class represents an AoColumn object.
 * @see net.datatables.wrapper.model.AoColumn
 * @author xuantuan.bui
 *
 */
@Documented
@Target(ElementType.FIELD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface AoColumn {
	int[] aDataSort() default {};
	int[] asSorting() default {};
	boolean bSearchable() default true;
	boolean bSortable() default true;
	boolean bVisible() default true;
	boolean bUseRendered() default true;
	String fnCreatedCell() default "";
	String fnRender() default "";
	int iDataSort() default 0;
	/**
	 * Map to the bean properties, by default it will set as the bean field name.
	 * @return
	 */
	String mData() default "";
	String mRender() default "";
	String sCellType() default "";
	String sClass() default "";
	String sContentPadding() default "";
	String sDefaultContent() default "";
	String sName() default "";
	String sSortDataType() default "";
	/**
	 * <Column name of the table present on client side>
	 * @return
	 */
	String sTitle();
	String sType() default "";
	String sWidth() default "";
}
