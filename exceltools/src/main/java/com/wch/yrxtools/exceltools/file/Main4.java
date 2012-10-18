package com.wch.yrxtools.exceltools.file;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class Main4 {
	static List<String> fileNames = new ArrayList<String>();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		File file = new File("H:\\成品资料\\成都结构数据");
		refreshFileList(file);
		try {
			ExcelTools.writeExcel("E:\\成品资料-成都结构数据.xls", fileNames, true);
		} catch (RowsExceededException e) {
			e.printStackTrace();
		} catch (WriteException e) {
			e.printStackTrace();
		}

	}

	public static void refreshFileList(File dir) {
		File[] files = dir.listFiles();
		if (files == null)
			return;
		for (int i = 0; i < files.length; i++) {
			if (files[i].isDirectory()) {
				refreshFileList(files[i]);
			} else {
				String name = files[i].getName();
				if (name.indexOf(".xls")!=-1||name.indexOf(".xlsx")!=-1) {
					fileNames.add(name);
				}
			}
		}
	}
}
