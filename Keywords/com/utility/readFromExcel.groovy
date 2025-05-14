package com.utility
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import com.kms.katalon.core.annotation.Keyword
import org.apache.poi.xssf.usermodel.XSSFSheet
import java.io.FileInputStream


public class readFromExcel {


	def file, workbook, sheet, rowCount,row,cellCount, cell,data

	@Keyword
	def getRowCount(String fileName, String sheetName) {
		file = new FileInputStream(fileName)
		workbook = new XSSFWorkbook(file)
		sheet = workbook.getSheet(sheetName)
		rowCount = sheet.getLastRowNum()
		workbook.close()
		file.close()
		return rowCount
	}

	@Keyword
	def getCellCount(String fileName, String sheetName, int rowCount) {
		file = new FileInputStream(fileName)
		workbook = new XSSFWorkbook(file)
		sheet = workbook.getSheet(sheetName)
		row = sheet.getRow(rowCount)
		cellCount = row.getLastCellNum()
		workbook.close()
		file.close()
		return cellCount
	}

	@Keyword
	def getCellDate(String fileName, String sheetName, int rowCount, int cellCount) {
		file = new FileInputStream(fileName)
		workbook = new XSSFWorkbook(file)
		sheet = workbook.getSheet(sheetName)
		row = sheet.getRow(rowCount)
		cell = row.getCell(cellCount)

		try {
			data = cell.toString()
		}
		catch (Exception e) {
			data = ' '
			workbook.close()
			file.close()
			return data
		}
	}
}