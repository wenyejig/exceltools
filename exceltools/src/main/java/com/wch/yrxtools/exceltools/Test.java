package com.wch.yrxtools.exceltools;

import java.io.File;

public class Test {
public static void main(String[] args) {
	String url="D:\\Users\\wch\\Documents\\成都结构数据\\黄东东\\已交付（未整理）\\2012.4.9（未整理）\\海德花园.xls";
	String a=ExcelTools.readExcel(new File(url));
}
}
