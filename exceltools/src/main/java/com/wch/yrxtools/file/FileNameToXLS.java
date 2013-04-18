package com.wch.yrxtools.file;

import java.io.File;
import java.io.IOException;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/**
 * 遍历excel文件。取文件名，收集到一个excel中。
 * 
 * @author wch
 * 
 */
public class FileNameToXLS {
	private int i = 0;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String targetUrl = "I:\\3项信息（重要文件）\\楼盘信息";
		File file = new File(targetUrl);
		WritableWorkbook wwb = null;
		try {
			wwb = Workbook.createWorkbook(new File(targetUrl + "\\汇总.xls"));
			if (wwb != null) {
		 
				// Workbook的createSheet方法有两个参数，第一个是工作表的名称，第二个是工作表在工作薄中的位置
				WritableSheet ws = wwb.createSheet("sheet1", 0);
				FileNameToXLS toXLS = new FileNameToXLS();
				toXLS.isFile(file, ws);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
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

	public void isFile(File file, WritableSheet ws) {
		if (file.isDirectory()) {
			File[] files = file.listFiles();
			for (File file2 : files) {
				isFile(file2, ws);
			}
		} else {

			String filename = file.getName();
			if (filename.toLowerCase().indexOf("xls") < 0
					&& filename.toLowerCase().indexOf("xlsx") < 0) {
				System.out.println("不是excel文件：" + filename+"   $路径："+file.getAbsoluteFile());
			}
			try {
				Label label = new Label(0, i, filename.substring(0,filename.indexOf(".")));
				Label label1 = new Label(1, i, file.getAbsolutePath());
	 
				ws.addCell(label);
				ws.addCell(label1);
			 i++;
			} catch (Exception e) {
				System.out.println(filename + ":出錯!");
			}

		}

	}

	 
 

}
