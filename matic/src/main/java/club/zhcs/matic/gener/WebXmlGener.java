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
 * @file WebXmlGener.java
 *
 * @description //TODO description
 *
 * @time 2016年7月7日 上午1:11:52
 *
 */
public class WebXmlGener implements Gener {

	/*
	 * (non-Javadoc)
	 * 
	 * @see club.zhcs.matic.gener.Gener#gen(club.zhcs.matic.meta.Project)
	 */
	@Override
	public List<File> gen(Project project) throws IOException {

		Template t = TemplatesLoader.load("templates/web.xml");
		t.binding("project", project);
		File webxml = Files.createFileIfNoExists(project.getOutput() + "/" + project.getName() + "/src/main/webapp/WEB-INF/web.xml");
		Files.write(webxml, t.render());
		return Lang.array2list(new File[] { webxml });
	}
}
