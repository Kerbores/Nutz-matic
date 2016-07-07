package club.zhcs.matic.meta;

import java.util.List;

import club.zhcs.matic.db.DBLoader;
import club.zhcs.matic.db.DBProperties;

/**
 * 
 * @author 王贵源
 *
 * @email kerbores@kerbores.com
 *
 * @description 项目
 * 
 * @copyright copyright©2016 zhcs.club
 *
 * @createTime 2016年7月5日 下午2:31:51
 */
public class Project extends Meta {
	/**
	 * 项目的名字
	 */
	private String name;
	/**
	 * 顶层package名
	 */
	private String packageName;
	/**
	 * 输出路径名
	 */
	private String output;

	/**
	 * 组织
	 */
	private String group;

	/**
	 * 版本
	 */
	private String version;

	private DBProperties db;

	private List<Table> tables;

	/**
	 * @param name
	 * @param packageName
	 * @param output
	 * @param group
	 * @param version
	 * @param db
	 */
	public Project(String name, String packageName, String output, String group, String version, DBProperties db) {
		super();
		this.name = name;
		this.packageName = packageName;
		this.output = output;
		this.group = group;
		this.version = version;
		this.db = db;
		this.tables = DBLoader.tables(db);
	}

	public String getPackagePath() {
		String target = "";
		for (String s : packageName.split("\\.")) {
			target += s + "/";
		}
		return target;
	}

	/**
	 * @return the db
	 */
	public DBProperties getDb() {
		return db;
	}

	/**
	 * @param db
	 *            the db to set
	 */
	public void setDb(DBProperties db) {
		this.db = db;
	}

	/**
	 * @return the tables
	 */
	public List<Table> getTables() {
		return tables;
	}

	/**
	 * @param tables
	 *            the tables to set
	 */
	public void setTables(List<Table> tables) {
		this.tables = tables;
	}

	/**
	 * @return the group
	 */
	public String getGroup() {
		return group;
	}

	/**
	 * @param group
	 *            the group to set
	 */
	public void setGroup(String group) {
		this.group = group;
	}

	/**
	 * @return the version
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * @param version
	 *            the version to set
	 */
	public void setVersion(String version) {
		this.version = version;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the packageName
	 */
	public String getPackageName() {
		return packageName;
	}

	/**
	 * @param packageName
	 *            the packageName to set
	 */
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	/**
	 * @return the output
	 */
	public String getOutput() {
		return output;
	}

	/**
	 * @param output
	 *            the output to set
	 */
	public void setOutput(String output) {
		this.output = output;
	}

}
