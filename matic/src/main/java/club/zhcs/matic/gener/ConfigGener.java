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
 * @file ConfigGener.java
 *
 * @description //TODO description
 *
 * @time 2016年7月7日 上午1:29:08
 *
 */
public class ConfigGener implements Gener {

	/*
	 * (non-Javadoc)
	 * 
	 * @see club.zhcs.matic.gener.Gener#gen(club.zhcs.matic.meta.Project)
	 */
	@Override
	public List<File> gen(Project project) throws IOException {

		Template t = TemplatesLoader.load("templates/src/main/resources/conf/config.properties");
		t.binding("db", project.getDb());
		File config = Files.createFileIfNoExists(project.getOutput() + "/" + project.getName() + "/src/main/resources/conf/config.properties");
		Files.write(config, t.render());
		return Lang.array2list(new File[] { config });
	}
}
