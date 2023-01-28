/*
 * package com.Ecommerce.Utilities;
 * 
 * import java.io.FileInputStream; import java.io.FileNotFoundException; import
 * java.io.IOException; import java.util.Formattable;
 * 
 * import org.apache.poi.ss.usermodel.DataFormat; import
 * org.apache.poi.ss.usermodel.DataFormatter; import
 * org.apache.poi.xssf.usermodel.XSSFCell; import
 * org.apache.poi.xssf.usermodel.XSSFRow; import
 * org.apache.poi.xssf.usermodel.XSSFSheet; import
 * org.apache.poi.xssf.usermodel.XSSFWorkbook;
 * 
 * public class XLSUtilities {
 * 
 * public static FileInputStream fi; public static XSSFWorkbook wb; public
 * static XSSFSheet XS; public static XSSFRow row; public static XSSFCell cell;
 * 
 * public int getRowCount(String XFile, String XSheet) throws IOException { fi =
 * new FileInputStream(XFile); wb = new XSSFWorkbook(fi); XS
 * =wb.getSheet(XSheet); int lastRowNum= XS.getLastRowNum();
 * 
 * return lastRowNum; }
 * 
 * public int getCellCount(String XFile, String XSheet, int rowNum) throws
 * IOException { fi = new FileInputStream(XFile); wb = new XSSFWorkbook(fi); XS
 * =wb.getSheet(XSheet);
 * 
 * int lastCellCount =row.getLastCellNum(); return lastCellCount; }
 * 
 * public String getCellData(String XFile, String XSheet, int rowNum, int
 * cellnNum) throws IOException { fi = new FileInputStream(XFile); wb = new
 * XSSFWorkbook(fi); XS =wb.getSheet(XSheet); row = XS.getRow(rowNum); cell =
 * row.getCell(cellnNum);
 * 
 * // Used Formatter for to Convert cell data value to string DataFormatter
 * formatter = new DataFormatter(); String dataValue =
 * formatter.formatCellValue(cell);
 * 
 * return dataValue; }
 * 
 * 
 * }
 */

package com.Ecommerce.Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Formattable;

import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLSUtilities {
	
	public static XSSFSheet openSheet(String Xfile, String XSheet) throws IOException {
		FileInputStream fi= new FileInputStream(Xfile);
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		
		XSSFSheet sheet = wb.getSheet(XSheet);
		return sheet;
	}
	
	
	public static int getRowCout(String Xfile, String XSheet) throws IOException {
		
		int rowCount = openSheet(Xfile, XSheet).getLastRowNum();
		return rowCount;
	}
	
	public static int getCellCount(String Xfile, String XSheet,  int RowNum) throws IOException{
		
		int cellCount = openSheet(Xfile, XSheet).getRow(RowNum).getLastCellNum();
		return cellCount;
	}
	
	public static String getCellData(String Xfile, String XSheet,  int RowNum , int CellNum) throws IOException {
		
		XSSFCell cell = openSheet(Xfile, XSheet).getRow(RowNum).getCell(CellNum);
		DataFormatter DF = new DataFormatter();
		return DF.formatCellValue(cell);
		
	}
	
}



