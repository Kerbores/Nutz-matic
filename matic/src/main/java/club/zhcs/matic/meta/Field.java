package club.zhcs.matic.meta;

import org.nutz.lang.Strings;

/**
 * 
 * @author 王贵源
 *
 * @email kerbores@kerbores.com
 *
 * @description 表字段
 * 
 * @copyright copyright©2016 zhcs.club
 *
 * @createTime 2016年7月5日 下午2:28:51
 */
public class Field extends Meta {

	public String dbFieldName;
	public String fieldName;
	public String dbFieldType;
	public String classTypeName;
	public boolean isPrimaryKey;
	public boolean unique;
	public boolean notNull;
	public boolean unsign;
	// 注释
	public String comment;

	/**
	 * @return the dbFieldName
	 */
	public String getDbFieldName() {
		return dbFieldName;
	}

	public String getFieldName1() {
		return Strings.upperFirst(fieldName);
	}

	/**
	 * @param dbFieldName
	 *            the dbFieldName to set
	 */
	public void setDbFieldName(String dbFieldName) {
		this.dbFieldName = dbFieldName;
	}

	/**
	 * @return the fieldName
	 */
	public String getFieldName() {
		return fieldName;
	}

	/**
	 * @param fieldName
	 *            the fieldName to set
	 */
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	/**
	 * @return the dbFieldType
	 */
	public String getDbFieldType() {
		return dbFieldType;
	}

	/**
	 * @param dbFieldType
	 *            the dbFieldType to set
	 */
	public void setDbFieldType(String dbFieldType) {
		this.dbFieldType = dbFieldType;
	}

	/**
	 * @return the classTypeName
	 */
	public String getClassTypeName() {
		return classTypeName;
	}

	/**
	 * @param classTypeName
	 *            the classTypeName to set
	 */
	public void setClassTypeName(String classTypeName) {
		this.classTypeName = classTypeName;
	}

	/**
	 * @return the isPrimaryKey
	 */
	public boolean isPrimaryKey() {
		return isPrimaryKey;
	}

	/**
	 * @param isPrimaryKey
	 *            the isPrimaryKey to set
	 */
	public void setPrimaryKey(boolean isPrimaryKey) {
		this.isPrimaryKey = isPrimaryKey;
	}

	/**
	 * @return the unique
	 */
	public boolean isUnique() {
		return unique;
	}

	/**
	 * @param unique
	 *            the unique to set
	 */
	public void setUnique(boolean unique) {
		this.unique = unique;
	}

	/**
	 * @return the notNull
	 */
	public boolean isNotNull() {
		return notNull;
	}

	/**
	 * @param notNull
	 *            the notNull to set
	 */
	public void setNotNull(boolean notNull) {
		this.notNull = notNull;
	}

	/**
	 * @return the unsign
	 */
	public boolean isUnsign() {
		return unsign;
	}

	/**
	 * @param unsign
	 *            the unsign to set
	 */
	public void setUnsign(boolean unsign) {
		this.unsign = unsign;
	}

	/**
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * @param comment
	 *            the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

}
