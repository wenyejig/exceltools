/**
 * @Title: MakeCodeFrame.java
 * @Package com.wch.codetools.cdxthis
 * @Description: TODO文(用一句话描述该文件做什么)
 * @author 文川豪
 * @date 2011-12-21 下午05:48:48
 * @最后修改人：文川豪
 * @最后修改时间：2011-12-21 下午05:48:48
 * @version V1.0
 * @copyright:成都信通网易医疗科技发展有限公司
 */
package com.wch.codetools.cdxthis;

import java.awt.BorderLayout;
import java.awt.FileDialog;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileDescriptor;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileSystemView;

/**
 * @ClassName: MakeCodeFrame
 * @Description: TODO文(这里用一句话描述这个类的作用)
 * @author 文川豪
 * @date 2011-12-21 下午05:48:48
 * @最后修改人：文川豪
 * @最后修改时间：2011-12-21 下午05:48:48
 * 
 * 
 */
public class ServiceFrame extends JFrame implements ActionListener {
	JButton button = new JButton("选择目录");

	/**
	 * @Title: 构造函数
	 * @Description: TODO文(描述构造函数实现的功能)
	 */
	public ServiceFrame() {
		this.setBounds(300, 333, 400, 100);
		button.setBounds(12, 28, 100, 26);
		this.setLayout(null);
		this.add(button);
		button.addActionListener(this);
	}

	public static void main(String[] args) {
		ServiceFrame codeFrame = new ServiceFrame();
		try {
			UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		codeFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		codeFrame.setVisible(true);
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
		JFileChooser chooser = new JFileChooser(curfile);
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

 		int i = chooser.showOpenDialog(this);
		if (i == 0) {
			File file = chooser.getSelectedFile();
			if (file == null) {
				this.dispose();
			} else {
				CdxtHisCode cdxtHisCode = new CdxtHisCode();
				try {
					cdxtHisCode.explorService(file);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
			this.dispose();
		}
	}
}
