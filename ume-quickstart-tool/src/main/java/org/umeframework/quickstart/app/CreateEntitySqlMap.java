package org.umeframework.quickstart.app;

import org.umeframework.dora.tool.gen.db.TableExcelGenerator;
 
/**
 * 读取并解析指定的输入目录下的所有数据库设计文档，生成如下的源码：<br>
 * <li> Java文件: Entity DTO (对应数据库各个表的JavaBean定义)
 * <li> XML文件: SQL Mapping (对应数据库各个的MyBatis映射文件)
 * <li> DDL: SQL脚本 (对应数据库各个的SQL DDL脚本)
 * 
 * @author Yue MA
 *
 */
public class CreateEntitySqlMap {
	/**
	 * 主函数.<br>
	 * 允许方法：Eclipse中右键点击该类，选择[Run As] - [Java Application]选项执行.<br>
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			String path = "input/design-table";
			
			TableExcelGenerator genMysql = new TableExcelGenerator();
            genMysql.setGenerateDefaultTableField(true);
			genMysql.execute(path);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
