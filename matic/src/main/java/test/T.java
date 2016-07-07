package test;

import java.io.IOException;

import org.nutz.dao.DB;

import club.zhcs.matic.db.DBProperties;
import club.zhcs.matic.gener.ConfigGener;
import club.zhcs.matic.gener.JavaCodeGener;
import club.zhcs.matic.gener.MavenProjectGener;
import club.zhcs.matic.gener.WebXmlGener;
import club.zhcs.matic.meta.Project;

/**
 * @author Kerbores(kerbores@gmail.com)
 *
 * @project matic
 *
 * @file T.java
 *
 * @description //TODO description
 *
 * @time 2016年7月7日 上午1:02:50
 *
 */
public class T {
	public static void main(String[] args) throws IOException {
		DBProperties db = new DBProperties();
		db.setType(DB.MYSQL);
		db.setDbAddress("127.0.0.1");
		db.setPort(3306);
		db.setSchame("tdb");
		db.setUser("root");
		db.setPassword("123456");

		Project p = new Project("tdb", "club.zhcs.tdb", "C:/gen/tdb", "club.zhcs", "1.0", db);

		MavenProjectGener mavenProjectGener = new MavenProjectGener();
		System.err.println(mavenProjectGener.gen(p));

		WebXmlGener webXmlGener = new WebXmlGener();
		System.err.println(webXmlGener.gen(p));

		ConfigGener configGener = new ConfigGener();
		System.err.println(configGener.gen(p));

		JavaCodeGener javaCodeGener = new JavaCodeGener();
		System.err.println(javaCodeGener.gen(p));

	}
}
