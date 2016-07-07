package ${project.packageName}.bean;

import java.util.Date;

import org.nutz.dao.entity.annotation.ColDefine;
import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Comment;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Name;
import org.nutz.dao.entity.annotation.Table;

import club.zhcs.matic.db.DBProperties;
import club.zhcs.titans.utils.db.po.Entity;

/**
 * 
 * @author nutz-matic
 *
 * @email kerbores@zhcs.club
 *
 * @description ${table.comment!}
 * 
 *
 */
@Table("${table.tableName}")
@Comment("${table.comment!}")
public class ${table.className!} extends Entity {

	
	<% for(field in table.fields){ %>
		<% if(field.isPrimaryKey! && (field.classTypeName! == 'int'|| field.classTypeName! == 'long')){ %>
			@Id
		<% }else if(field.isPrimaryKey){ %>
			@Name
		<% } %>
		@Column("${field.dbFieldName!}")
		@Comment("${field.comment!}")
		private ${field.classTypeName!} ${field.fieldName!} ;
		
		public ${field.classTypeName!} get${field.fieldName1!}() {
			return ${field.fieldName!};
		}
		
		public void set${field.fieldName1!}(${field.classTypeName!} ${field.fieldName!}) {
			this.${field.fieldName!} = ${field.fieldName!};
		}
		
	<% } %>
}