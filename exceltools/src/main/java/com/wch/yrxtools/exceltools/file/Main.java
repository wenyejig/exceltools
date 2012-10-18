package com.wch.yrxtools.exceltools.file;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class Main {
	public static void main(String[] args) {
		String path = "H:\\成品资料\\成品分布图";
		File tagartDir = new File(path);
//		if (tagartDir.isDirectory()) {
			File[] tagartFile = tagartDir.listFiles();
//		}
			List< String> fileName=new ArrayList<String>();
			for (File file : tagartFile) {
				fileName.add(file.getName());
			}
			try {
				ExcelTools.writeExcel("E:\\成品分布图.xls", fileName,true);
			} catch (RowsExceededException e) {
 				e.printStackTrace();
			} catch (WriteException e) {
 				e.printStackTrace();
			}
	}
}
