package ${project.packageName}.module;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.nutz.dao.entity.Record;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.GET;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.POST;
import org.nutz.mvc.annotation.Param;

import ${project.packageName}.bean${table.className!};
import ${project.packageName}.service.${table.className!}Service;
import club.zhcs.titans.nutz.module.base.AbstractBaseModule;
import club.zhcs.titans.utils.db.Pager;
import club.zhcs.titans.utils.db.Result;

**
* 
* @author nutz-matic
*
* @email kerbores@zhcs.club
*
* @description ${table.comment!}
* 
*
*/
@At("${table.lowerClassName!}")
public class ${table.className!}Module extends AbstractBaseModule {

	@Inject
	private ${table.className!}Service ${table.lowerClassName!}Service;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.dgj.nutz.module.base.AbstractBaseModule#_getNameSpace()
	 */
	@Override
	public String _getNameSpace() {
		return "";
	}

	/**
	 * 角色列表
	 * 
	 * @param page
	 *            页码
	 * @return
	 */
	@At
	@Ok("beetl:pages/${table.lowerClassName!}/list.html")
	@RequiresRoles("admin")
	public Result list(@Param(value = "page", df = "1") int page) {
		page = _fixPage(page);
		Pager<${table.className!}> pager = ${table.lowerClassName!}Service.searchByPage(page);
		pager.setUrl(_base() + "/${table.lowerClassName!}/list");
		return Result.success().addData("pager", pager);
	}

	/**
	 * 搜索角色
	 * 
	 * @param page
	 *            页码
	 * @param key
	 *            关键词
	 * @return
	 */
	@At
	@Ok("beetl:pages/${table.lowerClassName!}/list.html")
	@RequiresRoles("admin")
	public Result search(@Param(value = "page", df = "1") int page, @Param("key") String key) {
		page = _fixPage(page);
		key = _fixSearchKey(key);
		Pager<${table.className!}> pager = ${table.lowerClassName!}Service.searchByKeyAndPage(key, page, "name", "description");
		pager.setUrl(_base() + "/${table.lowerClassName!}/search");
		pager.addParas("key", key);
		return Result.success().addData("pager", pager);
	}

	/**
	 * 添加角色页面
	 * 
	 * @return
	 */
	@At
	@GET
	@Ok("beetl:pages/${table.lowerClassName!}/add_edit.html")
	@RequiresRoles("admin")
	public Result add() {
		return Result.success();
	}

	/**
	 * 添加角色
	 * 
	 * @param role
	 *            待添加角色
	 * @return
	 */
	@At
	@POST
	@RequiresRoles("admin")
	public Result add(@Param("..") ${table.className!} ${table.lowerClassName!}) {
		${table.lowerClassName!} = ${table.lowerClassName!}Service.save(${table.lowerClassName!});
		return ${table.lowerClassName!} == null ? Result.fail("添加角色失败") : Result.success().addData("${table.lowerClassName!}", ${table.lowerClassName!});
	}

	/**
	 * 删除角色
	 * 
	 * @param id
	 *            角色id
	 * @return
	 */
	@At("/delete/*")
	@RequiresRoles("admin")
	public Result delete(int id) {
		return ${table.lowerClassName!}Service.delete(id) == 1 ? Result.success() : Result.fail("删除失败!");
	}

	/**
	 * 编辑页码页面
	 * 
	 * @param id
	 *            角色id
	 * @return
	 */
	@At("/edit/*")
	@Ok("beetl:pages/${table.lowerClassName!}/add_edit.html")
	@RequiresRoles("admin")
	public Result edit(int id) {
		${table.className!} ${table.lowerClassName!} = ${table.lowerClassName!}Service.fetch(id);
		return Result.success().addData("${table.lowerClassName!}", ${table.lowerClassName!});
	}

	/**
	 * 更新角色
	 * 
	 * @param role
	 *            待更新角色
	 * @return
	 */
	@At
	@POST
	@RequiresRoles("admin")
	public Result update(@Param("..") ${table.className!} ${table.lowerClassName!}) {
		return ${table.lowerClassName!}Service.updateIgnoreNull(${table.lowerClassName!}) == 1 ? Result.success() : Result.fail("更新失败!");
	}

}
