package com.Actitime.GenericLibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.formula.SheetNameFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.WorkbookDocument;
/**
 * This class is a generic class which is having non static methods to perform data driven testing.
 * @author MAYUR
 *
 */
public class FileLibrary {
	public String ReadDataFromPropertyFile(String key) throws IOException {
		FileInputStream fis=new FileInputStream("./testdata/commondata.property");
		Properties p=new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		return value;
	}
	public String ReadDataFromExcelFile(String sheetname, int row, int cell) throws EncryptedDocumentException, IOException {
		FileInputStream fis1=new FileInputStream("./testdata/actitimetestdata.xlsx");
		Workbook wb= WorkbookFactory.create(fis1);
		String value = wb.getSheet(sheetname).getRow(row).getCell(cell).getStringCellValue();
		
		return value;
	}

}
