package club.zhcs.matic.db;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.sql.DataSource;

import org.nutz.dao.DB;
import org.nutz.dao.Dao;
import org.nutz.dao.impl.NutDao;
import org.nutz.dao.impl.SimpleDataSource;
import org.nutz.lang.ContinueLoop;
import org.nutz.lang.Each;
import org.nutz.lang.ExitLoop;
import org.nutz.lang.Lang;
import org.nutz.lang.LoopException;
import org.nutz.lang.Strings;
import org.nutz.log.Log;
import org.nutz.log.Logs;

import club.zhcs.matic.Config;
import club.zhcs.matic.meta.Field;
import club.zhcs.matic.meta.Table;

/**
 * 
 * @author 王贵源
 *
 * @email kerbores@kerbores.com
 *
 * @description 数据库加载器
 * 
 * @copyright copyright©2016 zhcs.club
 *
 * @createTime 2016年7月5日 下午1:30:30
 */
public class DBLoader {

	private static final Log log = Logs.get();

	/**
	 * 获取dao对象
	 * 
	 * @param db
	 * @return
	 */
	public static Dao dao(DBProperties db) {
		return new NutDao(dataSource(db));
	}

	public static Connection connection(DBProperties db) throws SQLException {
		return dataSource(db).getConnection();
	}

	/**
	 * 获取数据源
	 * 
	 * @param db
	 * @return
	 */
	public static DataSource dataSource(DBProperties db) {
		SimpleDataSource dataSource = new SimpleDataSource();
		dataSource.setJdbcUrl(db.getJDBCUrl());
		dataSource.setUsername(db.getUser());
		dataSource.setPassword(db.getPassword());
		return dataSource;
	}

	/**
	 * 获取表名列表
	 * 
	 * @param db
	 * @return
	 */
	public static List<Table> tables(DBProperties db) {
		Connection connection = null;
		List<Table> tables = new ArrayList<Table>();
		try {
			connection = connection(db);
			final DatabaseMetaData metaData = connection.getMetaData();
			ResultSet tableResultset = metaData.getTables(null, null, null, new String[] { "TABLE" });
			while (tableResultset.next()) {
				Table table = new Table();
				tables.add(table);
				// 对表信息进行处理
				table.setTableName(tableResultset.getString("TABLE_NAME"));

				table.setClassName(Config.getTableMapping().get(table.getTableName()));// 如果有设置表名和类名映射
				if (table.getClassName() == null) {
					table.setClassName(toName(table.getTableName(), false));
				}
				table.setComment(tableResultset.getString("REMARKS"));
			}

			// 处理表的字段们
			Lang.each(tables, new Each<Table>() {

				@Override
				public void invoke(int index, Table table, int length) throws ExitLoop, ContinueLoop, LoopException {
					try {
						Set<String> pks = new HashSet<String>();
						ResultSet pkResultSet;
						pkResultSet = metaData.getPrimaryKeys(null, null, table.getTableName());
						while (pkResultSet.next()) {
							pks.add(pkResultSet.getString("COLUMN_NAME"));
						}
						ResultSet columnResultset = metaData.getColumns(null, null, table.getTableName(), null);
						while (columnResultset.next()) {
							Field zField = new Field();
							zField.dbFieldName = columnResultset.getString("COLUMN_NAME");
							zField.notNull = "NO".equals(columnResultset.getString("IS_NULLABLE"));
							zField.dbFieldType = columnResultset.getString("TYPE_NAME");
							zField.fieldName = Config.getTableFieldMapping().get(table.getTableName() + "." + zField.dbFieldName);
							if (zField.fieldName == null)
								zField.fieldName = Config.getTableFieldMapping().get("*." + zField.dbFieldName);
							if (zField.fieldName == null)
								zField.fieldName = Strings.lowerFirst(toName(zField.dbFieldName, true));
							if (pks.contains(zField.dbFieldName))
								zField.isPrimaryKey = true;

							// 推断字段的Java类型
							zField.classTypeName = Config.getTypeMapping().get(zField.dbFieldType);
							if (zField.classTypeName == null) {
								log.warnf("Unkown type_name %s.%s, skip!", table.getTableName(), zField.dbFieldName);
								continue;
							}

							zField.comment = columnResultset.getString("REMARKS");
							if (zField.comment == null)
								zField.comment = "";

							table.getFields().add(zField);
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			});

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (log.isInfoEnabled())
			log.infof("Load %d tables", tables.size());
		if (log.isDebugEnabled())
			log.debug("Tables:\n" + tables);
		return tables;
	}

	/**
	 * 蛇形转换驼峰
	 * 
	 * @param srcName
	 * @return
	 */
	public static final String toName(String srcName, boolean isColumn) {
		if (Strings.isBlank(srcName))
			return "";
		boolean found = false;
		srcName = srcName.toLowerCase();
		if (!isColumn) {
			for (String prefix : Config.getOther().get("table_prefix").split(",")) {
				if (srcName.startsWith(prefix))
					srcName = srcName.substring(prefix.length());
			}
		} else {
			for (String prefix : Config.getOther().get("column_prefix").split(",")) {
				if (srcName.startsWith(prefix)) {
					found = true;
					srcName = srcName.substring(prefix.length());
				}
			}
		}
		if (!found && isColumn) {
			srcName = srcName.substring(srcName.indexOf("_") + 1);
		}
		String[] names = srcName.split("_");
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < names.length; i++) {
			sb.append(Strings.upperFirst(names[i]));
		}
		return sb.toString();
	}

	public static void main(String[] args) throws IOException {
		DBProperties db = new DBProperties();
		db.setType(DB.MYSQL);
		db.setDbAddress("127.0.0.1");
		db.setPort(3306);
		db.setSchame("tdb");
		db.setUser("root");
		db.setPassword("123456");
		tables(db);
	}

}
