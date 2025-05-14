package com.utility

import org.apache.poi.xssf.usermodel.XSSFWorkbook

import com.kms.katalon.core.annotation.Keyword



public class writeInExcel {


	def file,workbook, fo,sheet,fi, row,cell

	@Keyword
	def setCellData(String filePath ,String sheetName, int rowNum,int cellNum,String data){

		file= new File(filePath)
		if(!file.exists())  // file is not exit create a new file
		{
			//creating a new file
			fo= new FileOutputStream(filePath)
			workbook = new XSSFWorkbook(fo)
			workbook.write(fo)
		}
		fi= new FileInputStream(file)
		workbook = new XSSFWorkbook(fi) //getting workbook

		if(workbook.getSheetIndex(sheetName)==-1)// if sheet not exits create new new sheet
			workbook.createSheet(sheetName)// create new sheet
		sheet =workbook.getSheet(sheetName) //get sheet


		if(sheet.getRow(rowNum)==null)// if row not exits for particular sheet
			sheet.createRow(rowNum) //create new row
		row=sheet.getRow(rowNum)// get row

		cell= row.createCell(cellNum) //for the particular row we need to create a cell
		cell.setCellValue(data)

		fo = new FileOutputStream(file) //to write all data in workbook opening file
		workbook.write(fo)
		workbook.close()
		fo.close()
		fi.close()
	}
}


//
//		def filePath = "C:\\Users\\Diksha Thakur\\Katalon Studio\\katalondemo\\myfirstKatalonProject\\Data Files\\excelWrite.xlsx"
//
//		// Create and write
//		workbook = new XSSFWorkbook()
//		workbook.createSheet(sheetName).createRow(rowNum).createCell(cellNum).setCellValue(data)
//
//		FileOutputStream fos = new FileOutputStream(filePath)
//		workbook.write(fos)create
//		fos.close()
//		workbook.close()
//	}
//}



