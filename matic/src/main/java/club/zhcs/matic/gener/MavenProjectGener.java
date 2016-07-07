package club.zhcs.matic.gener;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.beetl.core.Template;
import org.nutz.lang.Files;
import org.nutz.lang.Lang;

import club.zhcs.matic.meta.Project;
import club.zhcs.matic.templates.TemplatesLoader;

/**
 * @author Kerbores(kerbores@gmail.com)
 *
 * @project matic
 *
 * @file MavenProjectGener.java
 *
 * @description maven项目生成器
 *
 * @time 2016年7月7日 上午12:45:31
 *
 */
public class MavenProjectGener implements Gener {

	/*
	 * (non-Javadoc)
	 * 
	 * @see club.zhcs.matic.gener.Gener#gen(club.zhcs.matic.meta.Project)
	 */
	@Override
	public List<File> gen(Project project) throws IOException {
		Template t = TemplatesLoader.load("templates/pom.xml");
		t.binding("project", project);
		File pom = Files.createFileIfNoExists(project.getOutput() + "/pom.xml");
		Files.write(pom, t.render());
		return Lang.array2list(new File[] { pom });
	}
}
