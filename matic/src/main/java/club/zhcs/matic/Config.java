package club.zhcs.matic;

import org.nutz.ioc.impl.PropertiesProxy;

/**
 * 
 * @author 王贵源
 *
 * @email kerbores@kerbores.com
 *
 * @description 配置文件
 * 
 * @copyright copyright©2016 zhcs.club
 *
 * @createTime 2016年7月5日 下午3:14:54
 */
public class Config {

	private static PropertiesProxy project = new PropertiesProxy();
	private static PropertiesProxy templete = new PropertiesProxy();
	private static PropertiesProxy typeMapping = new PropertiesProxy();
	private static PropertiesProxy tableMapping = new PropertiesProxy();
	private static PropertiesProxy tableFieldMapping = new PropertiesProxy();
	private static PropertiesProxy other = new PropertiesProxy();

	static {
		project.setPaths("conf/project.properties");
		templete.setPaths("conf/templates.properties");
		typeMapping.setPaths("conf/type-mapping.properties");
		tableMapping.setPaths("conf/table-mapping.properties");
		tableFieldMapping.setPaths("conf/table-field-mapping.properties");
		other.setPaths("conf/other.properties");

		String output = project.get("output", "output/");
		if (!output.endsWith("/"))
			output += "/";
		project.put("output", output);

		project.put("projectRoot", output + project.get("projectName", "Test") + "/");
		project.put("srcFileRoot", project.get("projectRoot") + "src/" + project.get("packageName", "org.test.z").replace('.', '/') + "/");
	}

	/**
	 * @return the project
	 */
	public static PropertiesProxy getProject() {
		return project;
	}

	/**
	 * @return the templete
	 */
	public static PropertiesProxy getTemplete() {
		return templete;
	}

	/**
	 * @return the typeMapping
	 */
	public static PropertiesProxy getTypeMapping() {
		return typeMapping;
	}

	/**
	 * @return the tableMapping
	 */
	public static PropertiesProxy getTableMapping() {
		return tableMapping;
	}

	/**
	 * @return the tableFieldMapping
	 */
	public static PropertiesProxy getTableFieldMapping() {
		return tableFieldMapping;
	}

	/**
	 * @return the other
	 */
	public static PropertiesProxy getOther() {
		return other;
	}

}
