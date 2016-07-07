package club.zhcs.matic.gener;

import java.io.File;
import java.io.IOException;
import java.util.List;

import club.zhcs.matic.meta.Project;

/**
 * @author Kerbores(kerbores@gmail.com)
 *
 * @project matic
 *
 * @file Gener.java
 *
 * @description //TODO description
 *
 * @time 2016年7月7日 上午12:45:48
 *
 */
public interface Gener {

	List<File> gen(Project project) throws IOException;
}
