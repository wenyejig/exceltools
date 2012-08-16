/**
 * @Title: CdxtHisCode.java
 * @Package com.wch.codetools
 * @Description:根据模板生成实体类的service层的常用方法
 * @author 文川豪
 * @date 2011-12-21 下午02:44:14
 * @最后修改人：文川豪
 * @最后修改时间：2011-12-21 下午02:44:14
 * @version V1.0
 * @copyright:成都信通网易医疗科技发展有限公司
 */
package com.wch.codetools.cdxthis;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.URL;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;

/**
 * @ClassName: CdxtHisCode
 * @Description: TODO文(这里用一句话描述这个类的作用)
 * @author 文川豪
 * @date 2011-12-21 下午02:44:14
 * @最后修改人：文川豪
 * @最后修改时间：2011-12-21 下午02:44:14
 * 
 * 
 */
public class CdxtHisCode {

	private Configuration cfg;
	private URL url = CdxtHisCode.class.getClassLoader().getResource(
			"freemarker/template");

	public Configuration getCfg() {
		return cfg;
	}

	public void init() throws Exception {
		cfg = new Configuration();
		cfg.setDirectoryForTemplateLoading(new File(url.toURI()));
	}

	public void explor(File _file) throws Exception {
		String dir = _file.getAbsolutePath();
		String path = _file.getPath();
		dir = dir.replaceAll("entity", "dao");
		String pack = path.substring(path.lastIndexOf("\\") + 1);
		init();
		File[] files = _file.listFiles();
		for (File curFile : files) {
			String filename = curFile.getName();
			Map root = new HashMap();
			String entityName = filename
					.substring(0, filename.lastIndexOf("."));
			if (entityName.length() < 2)
				continue;
			root.put("entityName", entityName);
			root.put("date", new Timestamp(System.currentTimeMillis()));
			root.put("packageName", pack);

			Template dao = getCfg().getTemplate("Dao.ftl");
			File a = new File(dir + "/api/");
			a.mkdir();
			File b = new File(dir + "/imp/");
			b.mkdir();
			Writer daoOut = new OutputStreamWriter(new FileOutputStream(dir
					+ "/api/" + root.get("entityName") + "Dao.java"), "UTF-8");
			dao.process(root, daoOut);
			System.out.println(entityName + "Dao Successfull.......");
			Template daoimp = getCfg().getTemplate("DaoImp.ftl");
			Writer daoimpOut = new OutputStreamWriter(new FileOutputStream(dir
					+ "/imp/" + root.get("entityName") + "DaoImp.java"),
					"UTF-8");
			daoimp.process(root, daoimpOut);
			System.out.println(entityName + "DaoImp Successfull.......");
		}

	}

	/**
	 * @Title: explorService
	 * @Description: TODO文(这里用一句话描述这个方法的作用)
	 * @最后修改人：文川豪
	 * @最后修改时间：2011-12-22 上午09:01:39
	 * @param _file
	 *            对方法的参数进行描述
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public void explorService(File _file) throws Exception {
		String dir = _file.getAbsolutePath(); 
		String pack = dir.substring(dir.lastIndexOf("\\") + 1);
		dir = dir.replaceAll("entity", "service");
		init();
		File[] files = _file.listFiles();
		for (File curFile : files) {
			String filename = curFile.getName();
			Map root = new HashMap();
			String entityName = filename
					.substring(0, filename.lastIndexOf("."));
			if (entityName.length() < 2)
				continue;
			root.put("entityName", entityName);
			root.put("date", new Timestamp(System.currentTimeMillis()));
			root.put("packageName", pack);

			Template dao = getCfg().getTemplate("Service.ftl");
			Writer daoOut = new OutputStreamWriter(new FileOutputStream(dir
					+ "/api/" + root.get("entityName") + "Service.java"),
					"UTF-8");
			dao.process(root, daoOut);
			System.out.println(entityName + "Service Successfull.......");

			Template daoimp = getCfg().getTemplate("ServiceImp.ftl");
			Writer daoimpOut = new OutputStreamWriter(new FileOutputStream(dir
					+ "/imp/" + root.get("entityName") + "ServiceImp.java"),
					"UTF-8");
			daoimp.process(root, daoimpOut);
			System.out.println(entityName + "ServiceImp Successfull.......");
		}

	}

}
