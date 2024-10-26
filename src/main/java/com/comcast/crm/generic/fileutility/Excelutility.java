package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excelutility {
	public String getdatafromexcel(String sheetname ,int rownum, int celnum) throws Throwable {
		FileInputStream fis=new FileInputStream("./testscriptdata/Testscriptdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(sheetname).getRow(rownum).getCell(celnum).getStringCellValue();
		wb.close();
		return data;
	}
	
	public int getrowcount(String sheetname) throws Throwable {
		FileInputStream fis=new FileInputStream("./testscriptdata/Testscriptdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		int rowcount = wb.getSheet(sheetname).getLastRowNum();
		wb.close();
		return rowcount;
	}
	public void setdataintoexcel(String sheetname ,int rownum, int celnum,String data) throws Throwable {
		FileInputStream fis=new FileInputStream("./testscriptdata/Testscriptdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet(sheetname).getRow(rownum).createCell(celnum);
		FileOutputStream fos=new FileOutputStream("./testscriptdata/Testscriptdata.xlsx");
		wb.write(fos);
		wb.close();
	}

}
