package club.zhcs.matic.meta;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author 王贵源
 *
 * @email kerbores@kerbores.com
 *
 * @description 表描述
 * 
 * @copyright copyright©2016 zhcs.club
 *
 * @createTime 2016年7月5日 下午2:07:44
 */
public class Table extends Meta {

	private String tableName;
	private String className;

	private String fkCatalog; // FKTABLE_CAT
	private String fkSchema; // FKTABLE_SCHEM
	private String fkTableName; // FKTABLE_NAME
	private String fkColumnName; // FKCOLUMN_NAME
	private String pkColumnName; // PKCOLUMN_NAME
	private String fkName; // FK_NAME
	private short keySeq; // KEY_SEQ

	private String comment;
	private String catalog;

	private List<Field> fields = new ArrayList<Field>();

	public String getLowerClassName() {
		return className.toLowerCase();
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

	/**
	 * @return the catalog
	 */
	public String getCatalog() {
		return catalog;
	}

	/**
	 * @param catalog
	 *            the catalog to set
	 */
	public void setCatalog(String catalog) {
		this.catalog = catalog;
	}

	/**
	 * @return the tableName
	 */
	public String getTableName() {
		return tableName;
	}

	/**
	 * @param tableName
	 *            the tableName to set
	 */
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	/**
	 * @return the className
	 */
	public String getClassName() {
		return className;
	}

	/**
	 * @param className
	 *            the className to set
	 */
	public void setClassName(String className) {
		this.className = className;
	}

	/**
	 * @return the fkCatalog
	 */
	public String getFkCatalog() {
		return fkCatalog;
	}

	/**
	 * @param fkCatalog
	 *            the fkCatalog to set
	 */
	public void setFkCatalog(String fkCatalog) {
		this.fkCatalog = fkCatalog;
	}

	/**
	 * @return the fkSchema
	 */
	public String getFkSchema() {
		return fkSchema;
	}

	/**
	 * @param fkSchema
	 *            the fkSchema to set
	 */
	public void setFkSchema(String fkSchema) {
		this.fkSchema = fkSchema;
	}

	/**
	 * @return the fkTableName
	 */
	public String getFkTableName() {
		return fkTableName;
	}

	/**
	 * @param fkTableName
	 *            the fkTableName to set
	 */
	public void setFkTableName(String fkTableName) {
		this.fkTableName = fkTableName;
	}

	/**
	 * @return the fkColumnName
	 */
	public String getFkColumnName() {
		return fkColumnName;
	}

	/**
	 * @param fkColumnName
	 *            the fkColumnName to set
	 */
	public void setFkColumnName(String fkColumnName) {
		this.fkColumnName = fkColumnName;
	}

	/**
	 * @return the pkColumnName
	 */
	public String getPkColumnName() {
		return pkColumnName;
	}

	/**
	 * @param pkColumnName
	 *            the pkColumnName to set
	 */
	public void setPkColumnName(String pkColumnName) {
		this.pkColumnName = pkColumnName;
	}

	/**
	 * @return the fkName
	 */
	public String getFkName() {
		return fkName;
	}

	/**
	 * @param fkName
	 *            the fkName to set
	 */
	public void setFkName(String fkName) {
		this.fkName = fkName;
	}

	/**
	 * @return the keySeq
	 */
	public short getKeySeq() {
		return keySeq;
	}

	/**
	 * @param keySeq
	 *            the keySeq to set
	 */
	public void setKeySeq(short keySeq) {
		this.keySeq = keySeq;
	}

	/**
	 * @return the fields
	 */
	public List<Field> getFields() {
		return fields;
	}

	/**
	 * @param fields
	 *            the fields to set
	 */
	public void setFields(List<Field> fields) {
		this.fields = fields;
	}

}
