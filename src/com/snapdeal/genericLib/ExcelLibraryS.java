package com.snapdeal.genericLib;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelLibraryS {
	String path = IConstant.filePath;
	public String readData(String sheetName, int rowNum, int colNum)
			throws IOException, InvalidFormatException {
		String path = IConstant.filePath;
		File file = new File(path);
		Workbook wb = new XSSFWorkbook(file);
		Sheet sh = wb.getSheet(sheetName);
		Row row = sh.getRow(rowNum);

		String data = row.getCell(colNum).getStringCellValue();
		return data;
	}

	public void writeData(String sheetName, int rowNum, int colNum, String data)
			throws InvalidFormatException, IOException {
		FileInputStream fis = new FileInputStream(path);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row row = sh.getRow(rowNum);
		Cell cell = row.createCell(colNum);
		cell.setCellType(cell.CELL_TYPE_STRING);
		FileOutputStream fos = new FileOutputStream(path);
		cell.setCellValue(data);
		wb.write(fos);
		wb.close();

	}
}
