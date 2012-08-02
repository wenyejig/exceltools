package com.wch.yrxtools.exceltools;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

import jxl.Sheet;
 

public class DaoFrame extends JFrame implements ActionListener {
	JButton button = new JButton("选择目录");
    private static ArrayList<File> filelist = new ArrayList<File>();
    private  ArrayList<String> names = new ArrayList<String>();
    private  ArrayList<String> addresss = new ArrayList<String>();
    private  ArrayList<String> cr = new ArrayList<String>();
    private  ArrayList<String> quyu = new ArrayList<String>();


	/**
	 * @Title: 构造函数
	 * @Description: TODO文(描述构造函数实现的功能)
	 */
	public DaoFrame() {
		this.setBounds(300, 333, 400, 100);
		button.setBounds(12, 28, 100, 26);
		this.setLayout(null);
		this.add(button);
		button.addActionListener(this);
	}

	

	/**
	 * @Title: actionPerformed
	 * @Description: TODO文(这里用一句话描述这个方法的作用)
	 * @最后修改人：文川豪
	 * @最后修改时间：2011-12-21 下午06:01:05
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 * @param e
	 *            对方法的参数进行描述
	 */
	public void actionPerformed(ActionEvent e) {
		File curfile = new File(
				"E:\\myeclipse\\workspace\\cdxtHisService\\src\\com\\cdxt\\entity");
		JFileChooser chooser = new JFileChooser();
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int i = chooser.showOpenDialog(this);
 		if (i == 0) {
			File file = chooser.getSelectedFile();
			refreshFileList(file);
			readFile();
			writeFile();
			System.out.println("错误的文件");
			for (String iterable_element : ExcelTools.errFile) {
				System.out.println("start "+iterable_element);
			}
 		}
		this.dispose();
	}
	private void writeFile() {
		String a="c:\\a.xls";
		ExcelTools.writeExcel2(a, names, addresss,cr,quyu);
	}



	private void readFile() {
		for (File file : filelist) {
			String []temp=ExcelTools.readExcel2(file);
			if(temp!=null){
			names.add(temp[0]);
			addresss.add(temp[1]);
			cr.add(temp[2]);
			quyu.add(temp[3]);
			}
			System.out.println(temp[0]+"&^&"+temp[1]);
 		}
		System.out.println("读取完成");
	}

	public static void refreshFileList(File  dir) { 
        File[] files = dir.listFiles(); 
        if (files == null) 
            return; 
        for (int i = 0; i < files.length; i++) { 
            if (files[i].isDirectory()) { 
                refreshFileList(files[i]); 
            } else { 
                String strFileName = files[i].getAbsolutePath().toLowerCase();
             //   System.out.println("---"+strFileName);
                filelist.add(files[i]);                    
            } 
        } 
    }
}
