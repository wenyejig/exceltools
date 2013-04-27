package com.wch.yrxtools.file;

import java.io.File;
import java.io.IOException;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class DirNameToXLS {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String targetUrl = "H:\\中原要上传\\第二批";
		File file = new File(targetUrl);
		WritableWorkbook wwb = null;
		try {
			wwb = Workbook.createWorkbook(new File(targetUrl + "\\汇总.xls"));
			WritableSheet ws = wwb.createSheet("sheet1", 0);

			File[] dirs = file.listFiles();
			 int j=0;
			for (int i=0;i<dirs.length;i++) {
				if (dirs[i].isDirectory()) {
					String filename = dirs[i].getName();
					if(!filename.equals("1")){
						Label label = new Label(0, j++, filename);
						ws.addCell(label);
					}
			
				} 
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// 从内存中写入文件中
				wwb.write();
				// 关闭资源，释放内存
				wwb.close();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (WriteException e) {
				e.printStackTrace();
			}
		}
	}

}
