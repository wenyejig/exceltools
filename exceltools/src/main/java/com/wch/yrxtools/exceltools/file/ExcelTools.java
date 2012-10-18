package com.wch.yrxtools.exceltools.file;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jxl.Cell;
import jxl.HeaderFooter;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableImage;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

/**
 * @ClassName: ExcelTools
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author 001
 * @date 2012-8-2 下午1:25:28
 * @最后修改人：001
 * @最后修改时间：2012-8-2 下午1:25:28
 * 
 * 
 */
public class ExcelTools {

	static List<String> errFile = new ArrayList<String>();

	/**
	 * 读取Excel文件的内容
	 * 
	 * @param file
	 *            待读取的文件
	 * @return
	 */
	public static String readExcel(File file) {
		StringBuffer sb = new StringBuffer();

		Workbook wb = null;
		try {
			// 构造Workbook（工作薄）对象
			wb = Workbook.getWorkbook(file);
		} catch (BiffException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (wb == null)
			return null;

		// 获得了Workbook对象之后，就可以通过它得到Sheet（工作表）对象了
		Sheet[] sheet = wb.getSheets();

		if (sheet != null && sheet.length > 0) {
			// 对每个工作表进行循环
			for (int i = 0; i < sheet.length; i++) {
				// 得到当前工作表的行数
				int rowNum = sheet[i].getRows();
				for (int j = 0; j < rowNum; j++) {
					// 得到当前行的所有单元格
					Cell[] cells = sheet[i].getRow(j);
					if (cells != null && cells.length > 0) {
						// 对每个单元格进行循环
						for (int k = 0; k < cells.length; k++) {
							// 读取当前单元格的值
							String cellValue = cells[k].getContents();
							System.out.println("j:" + j + "   k:" + k
									+ "  val:" + cellValue);
							sb.append(cellValue + "\t");
						}
					}
					sb.append("\r\n");
				}
				sb.append("\r\n");
			}
		}
		// 最后关闭资源，释放内存
		wb.close();
		return sb.toString();
	}

	/**
	 * 读取Excel文件的内容
	 * 
	 * @param file
	 *            待读取的文件
	 * @return
	 */
	public static String[] readExcel2(File file) {
		String[] temp = new String[4];
		Workbook wb = null;
		try {
			// 构造Workbook（工作薄）对象
			wb = Workbook.getWorkbook(file);
			if (wb == null) {
				errFile.add(file.getAbsolutePath());
				return null;
			}
			// 获得了Workbook对象之后，就可以通过它得到Sheet（工作表）对象了
			// Sheet[] sheet = wb.getSheets();
			System.out.println(file.getAbsolutePath());

			Sheet a = wb.getSheet(0);
			if (a != null) {
				// 得到当前行的所有单元格
				temp[1] = a.getCell(2, 3).getContents();
				temp[0] = a.getCell(2, 1).getContents();
				temp[2] = a.getCell(2, 5).getContents();
				temp[3] = a.getCell(2, 7).getContents();
			}
		} catch (Throwable e) {
			errFile.add(file.getAbsolutePath());
		}

		// 最后关闭资源，释放内存
		if (wb != null) {
			wb.close();
		}
		return temp;
	}

	/**
	 * 生成一个Excel文件
	 * 
	 * @param fileName
	 *            要生成的Excel文件名
	 */
	public static void writeExcel(String fileName) {
		WritableWorkbook wwb = null;
		try {
			// 首先要使用Workbook类的工厂方法创建一个可写入的工作薄(Workbook)对象
			wwb = Workbook.createWorkbook(new File(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (wwb != null) {
			// 创建一个可写入的工作表
			// Workbook的createSheet方法有两个参数，第一个是工作表的名称，第二个是工作表在工作薄中的位置
			WritableSheet ws = wwb.createSheet("sheet1", 0);

			// 下面开始添加单元格
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 5; j++) {
					// 这里需要注意的是，在Excel中，第一个参数表示列，第二个表示行
					Label labelC = new Label(j, i, "这是第" + (i + 1) + "行，第"
							+ (j + 1) + "列");
					try {
						// 将生成的单元格添加到工作表中
						ws.addCell(labelC);
					} catch (RowsExceededException e) {
						e.printStackTrace();
					} catch (WriteException e) {
						e.printStackTrace();
					}

				}
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
	}

	/**
	 * 生成一个Excel文件
	 * 
	 * @param fileName
	 *            要生成的Excel文件名
	 * @throws WriteException
	 * @throws RowsExceededException
	 */
	public static void writeExcel(String fileName, List<String> filename,boolean isfile)
			throws RowsExceededException, WriteException {
		WritableWorkbook wwb = null;
		try {
			// 首先要使用Workbook类的工厂方法创建一个可写入的工作薄(Workbook)对象
			wwb = Workbook.createWorkbook(new File(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (wwb != null) {
			// 创建一个可写入的工作表
			// Workbook的createSheet方法有两个参数，第一个是工作表的名称，第二个是工作表在工作薄中的位置
			WritableSheet ws = wwb.createSheet("sheet1", 0);
			int i = 0;
			for (String string : filename) {
				if (isfile) {
					string = string.substring(0, string.lastIndexOf("."));
				}
				Label label = new Label(0, i, string);
				i++;
				ws.addCell(label);
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
	}

	/**
	 * 生成一个Excel文件
	 * 
	 * @param fileName
	 *            要生成的Excel文件名
	 * @param quyu
	 * @param cr
	 */
	public static void writeExcel2(String fileName, List<String> listname,
			List<String> listAddr, ArrayList<String> cr, ArrayList<String> quyu) {
		WritableWorkbook wwb = null;
		try {
			// 首先要使用Workbook类的工厂方法创建一个可写入的工作薄(Workbook)对象
			wwb = Workbook.createWorkbook(new File(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (wwb != null) {
			// 创建一个可写入的工作表
			// Workbook的createSheet方法有两个参数，第一个是工作表的名称，第二个是工作表在工作薄中的位置
			WritableSheet ws = wwb.createSheet("sheet1", 0);
			for (int i = 0; i < listname.size(); i++) {
				Label labelC = new Label(1, i, listname.get(i));
				Label labelC2 = new Label(2, i, listAddr.get(i));
				Label labelC3 = new Label(3, i, cr.get(i));
				Label labelC4 = new Label(4, i, quyu.get(i));
				try {
					// 将生成的单元格添加到工作表中
					ws.addCell(labelC);
					ws.addCell(labelC2);
					ws.addCell(labelC3);
					ws.addCell(labelC4);
				} catch (RowsExceededException e) {
					e.printStackTrace();
				} catch (WriteException e) {
					e.printStackTrace();
				}
			}
			// 下面开始添加单元格
			// for (int i = 0; i < 10; i++) {
			// for (int j = 0; j < 5; j++) {
			// // 这里需要注意的是，在Excel中，第一个参数表示列，第二个表示行
			// Label labelC = new Label(j, i, "这是第" + (i + 1) + "行，第"
			// + (j + 1) + "列");
			// try {
			// // 将生成的单元格添加到工作表中
			// ws.addCell(labelC);
			// } catch (RowsExceededException e) {
			// e.printStackTrace();
			// } catch (WriteException e) {
			// e.printStackTrace();
			// }
			//
			// }
			// }

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

	/**
	 * 搜索某一个文件中是否包含某个关键字
	 * 
	 * @param file
	 *            待搜索的文件
	 * @param keyWord
	 *            要搜索的关键字
	 * @return
	 */
	public static boolean searchKeyWord(File file, String keyWord) {
		boolean res = false;

		Workbook wb = null;
		try {
			// 构造Workbook（工作薄）对象
			wb = Workbook.getWorkbook(file);
		} catch (BiffException e) {
			return res;
		} catch (IOException e) {
			return res;
		}

		if (wb == null)
			return res;

		// 获得了Workbook对象之后，就可以通过它得到Sheet（工作表）对象了
		Sheet[] sheet = wb.getSheets();

		boolean breakSheet = false;

		if (sheet != null && sheet.length > 0) {
			// 对每个工作表进行循环
			for (int i = 0; i < sheet.length; i++) {
				if (breakSheet)
					break;

				// 得到当前工作表的行数
				int rowNum = sheet[i].getRows();

				boolean breakRow = false;

				for (int j = 0; j < rowNum; j++) {
					if (breakRow)
						break;
					// 得到当前行的所有单元格
					Cell[] cells = sheet[i].getRow(j);
					if (cells != null && cells.length > 0) {
						boolean breakCell = false;
						// 对每个单元格进行循环
						for (int k = 0; k < cells.length; k++) {
							if (breakCell)
								break;
							// 读取当前单元格的值
							String cellValue = cells[k].getContents();
							if (cellValue == null)
								continue;
							if (cellValue.contains(keyWord)) {
								res = true;
								breakCell = true;
								breakRow = true;
								breakSheet = true;
							}
						}
					}
				}
			}
		}
		// 最后关闭资源，释放内存
		wb.close();

		return res;
	}

	/**
	 * 往Excel中插入图片
	 * 
	 * @param dataSheet
	 *            待插入的工作表
	 * @param col
	 *            图片从该列开始
	 * @param row
	 *            图片从该行开始
	 * @param width
	 *            图片所占的列数
	 * @param height
	 *            图片所占的行数
	 * @param imgFile
	 *            要插入的图片文件
	 */
	public static void insertImg(WritableSheet dataSheet, int col, int row,
			int width, int height, File imgFile) {
		WritableImage img = new WritableImage(col, row, width, height, imgFile);
		dataSheet.addImage(img);
	}

	/**
	 * 向Excel中加入页眉页脚
	 * 
	 * @param dataSheet
	 *            待加入页眉的工作表
	 * @param left
	 * @param center
	 * @param right
	 */
	public static void setHeader(WritableSheet dataSheet, String left,
			String center, String right) {
		HeaderFooter hf = new HeaderFooter();
		hf.getLeft().append(left);
		hf.getCentre().append(center);
		hf.getRight().append(right);
		// 加入页眉
		dataSheet.getSettings().setHeader(hf);
		// 加入页脚
		// dataSheet.getSettings().setFooter(hf);
	}
}
