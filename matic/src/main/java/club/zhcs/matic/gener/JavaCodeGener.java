package club.zhcs.matic.gener;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.beetl.core.Template;
import org.nutz.lang.Files;

import club.zhcs.matic.meta.Project;
import club.zhcs.matic.meta.Table;
import club.zhcs.matic.templates.TemplatesLoader;

/**
 * @author Kerbores(kerbores@gmail.com)
 *
 * @project matic
 *
 * @file JavaCodeGener.java
 *
 * @description //TODO description
 *
 * @time 2016年7月7日 上午1:47:47
 *
 */
public class JavaCodeGener implements Gener {

	/*
	 * (non-Javadoc)
	 * 
	 * @see club.zhcs.matic.gener.Gener#gen(club.zhcs.matic.meta.Project)
	 */
	@Override
	public List<File> gen(Project project) throws IOException {

		List<File> files = new ArrayList<File>();
		for (Table table : project.getTables()) {
			// domain
			Template t = TemplatesLoader.load("templates/src/main/java/club/zhcs/thunder/bean/Table.java");
			t.binding("project", project);
			t.binding("table", table);
			File domain = Files.createFileIfNoExists(project.getOutput() + "/" + project.getName() + "/src/main/java/" + project.getPackagePath() + "bean/" + table.getClassName()
					+ ".java");
			Files.write(domain, t.render());
			files.add(domain);

			// service
			t = TemplatesLoader.load("templates/src/main/java/club/zhcs/thunder/service/Service.java");
			t.binding("project", project);
			t.binding("table", table);
			File service = Files.createFileIfNoExists(project.getOutput() + "/" + project.getName() + "/src/main/java/" + project.getPackagePath() + "service/"
					+ table.getClassName()
					+ "Service.java");
			Files.write(service, t.render());
			files.add(service);

			// module
			t = TemplatesLoader.load("templates/src/main/java/club/zhcs/thunder/module/Module.java");
			t.binding("project", project);
			t.binding("table", table);
			File module = Files.createFileIfNoExists(project.getOutput() + "/" + project.getName() + "/src/main/java/" + project.getPackagePath() + "module/"
					+ table.getClassName()
					+ "Module.java");
			Files.write(module, t.render());
			files.add(module);
		}

		return files;
	}
}
