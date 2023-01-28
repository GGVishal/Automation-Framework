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

public class Practice_XLSUtilities {
	
	FileInputStream fi;
	XSSFWorkbook wb;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cell;
	int rowCount;
	int cellCount;
	
	public XSSFSheet openSheet(String Xfile, String XSheet) throws IOException {
		fi= new FileInputStream(Xfile);
		wb = new XSSFWorkbook(fi);
		return sheet = wb.getSheet(XSheet);
		
	}
	
	public int getRowCout(String Xfile, String XSheet) throws IOException {
		
		return rowCount = openSheet(Xfile, XSheet).getLastRowNum();
		
	}
	
	public int getCellCount(String Xfile, String XSheet,  int RowNum) throws IOException{
		
		return cellCount = openSheet(Xfile, XSheet).getRow(RowNum).getLastCellNum();
	
	}
	
	public String getCellData(String Xfile, String XSheet,  int RowNum , int CellNum) throws IOException {
		
		cell = openSheet(Xfile, XSheet).getRow(RowNum).getCell(CellNum);
		DataFormatter DF = new DataFormatter();
		return DF.formatCellValue(cell);
		
	}
	
}
