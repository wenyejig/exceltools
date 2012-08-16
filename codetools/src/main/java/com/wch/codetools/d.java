package com.wch.codetools;

import java.awt.AWTException;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;

import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;

 

public class d {


	SystemTray tray = SystemTray.getSystemTray();

	public TrayIcon ti;

	 
	
	public d() {
		 PopupMenu menu;
		JMenu submenu;
		 MenuItem menuItem;
		JRadioButtonMenuItem rbMenuItem;
		JCheckBoxMenuItem cbMenuItem;
//		Plastic3DLookAndFeel lf = new com.jgoodies.looks.plastic.Plastic3DLookAndFeel();
//		Plastic3DLookAndFeel.set3DEnabled(true);
//		Plastic3DLookAndFeel.setCurrentTheme(new com.jgoodies.looks.plastic.theme.SkyBluer() {
//			public ColorUIResource getWindowTitleBackground() {
//				return new ColorUIResource(Color.CYAN);//super.getWindowTitleBackground();
//			}
//		});
//		try {
//			UIManager.setLookAndFeel(lf);
//		} catch (UnsupportedLookAndFeelException e) {
//			e.printStackTrace();
//		}
//		if (Integer.parseInt(System.getProperty("java.version").substring(2, 3)) >= 5)
//			System.setProperty("javax.swing.adjustPopupLocationToFit", "true");
		menu = new PopupMenu("A Menu");
//		menuItem = new JMenuItem("打开LIS检验窗口", KeyEvent.VK_L);
//		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));
//		menuItem.getAccessibleContext().setAccessibleDescription("This doesn't really do anything");
//		menuItem.addActionListener(this);
//		menu.add(menuItem);
//		ImageIcon icon = new ImageIcon(LISTray.class.getResource("/images/keylock.gif"));
//		menuItem = new JMenuItem("锁定", icon);
//		menuItem.setMnemonic(KeyEvent.VK_B);
//		menuItem.addActionListener(this);
//		menu.add(menuItem);
//		menuItem = new JMenuItem("登录",icon);
//		menuItem.setMnemonic(KeyEvent.VK_D);
//		menuItem.addActionListener(this);
//		menu.add(menuItem);
//		menu.addSeparator();
//		ButtonGroup group = new ButtonGroup();
//		rbMenuItem = new JRadioButtonMenuItem("文件交换方式");
//		rbMenuItem.setSelected(true);
//		rbMenuItem.setMnemonic(KeyEvent.VK_R);
//		group.add(rbMenuItem);
//		rbMenuItem.addActionListener(this);
//		menu.add(rbMenuItem);
//		rbMenuItem = new JRadioButtonMenuItem("缓冲区方式");
//		rbMenuItem.setMnemonic(KeyEvent.VK_O);
//		group.add(rbMenuItem);
//		rbMenuItem.addActionListener(this);
//		menu.add(rbMenuItem);
//		menu.addSeparator();
//		cbMenuItem = new JCheckBoxMenuItem("备份系统");
//		cbMenuItem.setMnemonic(KeyEvent.VK_C);
//		cbMenuItem.addItemListener(this);
//		menu.add(cbMenuItem);
//		cbMenuItem = new JCheckBoxMenuItem("不备份数据");
//		cbMenuItem.setMnemonic(KeyEvent.VK_H);
//		cbMenuItem.addItemListener(this);
//		menu.add(cbMenuItem);
//		menu.addSeparator();
//		submenu = new JMenu("配置");
//		submenu.setMnemonic(KeyEvent.VK_S);
//		menuItem = new JMenuItem("检验项目配置");
//		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, ActionEvent.CTRL_MASK));
//		menuItem.addActionListener(new ActionListener(){
//			public void actionPerformed(ActionEvent e) {
//				appgui.getMainframe().setVisible(true);
//			}
//		});
//		submenu.add(menuItem);
//		menuItem = new JMenuItem("Another item");
//		menuItem.addActionListener(this);
//		submenu.add(menuItem);
//		menu.add(submenu);
//		menu.addSeparator();
		menuItem = new  MenuItem("完全退出系统");
//		menuItem.addActionListener(this);
		menu.add(menuItem);
		ImageIcon i = new ImageIcon(d.class.getResource("/images/t_complete.gif"));
		ti = new TrayIcon(i.getImage(), "成都信通实验检验系统(JAVA版1.0)", menu);
//		ti.setIconAutoSize(true);
		ti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				appgui.getMainframe().setVisible(true);//frame.setVisible(!frame.isVisible());
			}
		});
		try {
			tray.add (ti);
		} catch (AWTException e1) {
			// TODO文 Auto-generated catch block
			e1.printStackTrace();
		}
	}

	// Returns just the class name -- no package info.
	protected String getClassName(Object o) {
		String classString = o.getClass().getName();
		int dotIndex = classString.lastIndexOf(".");
		return classString.substring(dotIndex + 1);
	}

	public void actionPerformed(ActionEvent e) {
		JMenuItem source = (JMenuItem) (e.getSource());
		String s = source.getText();
		if (s.equalsIgnoreCase("完全退出系统")) {
			System.out.println("Quit menu item selected!");
			exit_sys();
			System.exit(0);
		} else {
			s = "Action event detected." + "\n" + "    Event source: " + source
					+ " (an instance of " + getClassName(source) + ")";
		}
	}

	public void exit_sys(){
 		tray.remove (ti);
 	}
	
	public void itemStateChanged(ItemEvent e) {
		
	}

	public static void main(String[] args) {
		new d();
	}

	 


}
