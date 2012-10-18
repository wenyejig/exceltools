package com.wch.yrxtools.exceltools.file;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class Main2 {
	public static void main(String[] args) {

		String path = "H:\\已瘦身照片\\合格";
		File tagartDir = new File(path);
//		if (tagartDir.isDirectory()) {
			File[] tagartFile = tagartDir.listFiles();
//		}
			for (File file : tagartFile) {
				List< String> fileName=new ArrayList<String>();
				File[] files = file.listFiles();
				for (File file2 : files) {
					fileName.add(file2.getName());
				}try {
					ExcelTools.writeExcel("E:\\已瘦身照片-合格-"+file.getName()+".xls", fileName,false);
				} catch (RowsExceededException e) {
	 				e.printStackTrace();
				} catch (WriteException e) {
	 				e.printStackTrace();
				}
			}
			
	
	}
}
