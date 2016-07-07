package club.zhcs.matic.templates;

import java.io.IOException;

import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.core.resource.StringTemplateResourceLoader;
import org.nutz.lang.Files;

/**
 * @author Kerbores(kerbores@gmail.com)
 *
 * @project matic
 *
 * @file TemplatesLoader.java
 *
 * @description 模版加载器
 *
 * @time 2016年7月7日 上午1:07:50
 *
 */
public class TemplatesLoader {

	public static Template load(String path) throws IOException {
		StringTemplateResourceLoader resourceLoader = new StringTemplateResourceLoader();
		Configuration cfg = Configuration.defaultConfiguration();
		GroupTemplate gt = new GroupTemplate(resourceLoader, cfg);
		return gt.getTemplate(Files.read(path));
	}
}
