package com.utility

import org.apache.poi.xssf.usermodel.XSSFWorkbook

import com.kms.katalon.core.annotation.Keyword



public class writeInExcel {


	def file,workbook, fo,sheet,fi, row,cell

	@Keyword
	def setCellData(String filePath ,String sheetName, int rowNum,int cellNum,String data){
		FileInputStream fi = new FileInputStream(filePath)
		XSSFWorkbook workbook = new XSSFWorkbook(fi)
		sheet = workbook.getSheet(sheetName)
		row = sheet.createRow(rowNum)
		cell = row.createCell(cellNum)
		cell.setCellValue(data)
		fi.close()
		FileOutputStream fo = new FileOutputStream(filePath)
		workbook.write(fo)
		workbook.close()
		fo.close()
	}
}




