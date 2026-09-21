package Assessment12OrangeHRMData;

import java.io.File;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	public static Object[][] getData() throws IOException {

	    File file = new File("./src/test/resources/orangehrm_day12/demo2.xlsx");

	    Workbook wb = WorkbookFactory.create(file);

	    Sheet sh = wb.getSheet("Sheet1");

	    int rowCount = sh.getLastRowNum();

	    Object[][] obj = new Object[rowCount][5];

	    DataFormatter formatter = new DataFormatter();

	    for (int row = 1; row <= rowCount; row++) {

	        obj[row - 1][0] =
	                formatter.formatCellValue(
	                        sh.getRow(row).getCell(0));

	        obj[row - 1][1] =
	                formatter.formatCellValue(
	                        sh.getRow(row).getCell(1));

	        obj[row - 1][2] =
	                formatter.formatCellValue(
	                        sh.getRow(row).getCell(2));

	        obj[row - 1][3] =
	                formatter.formatCellValue(
	                        sh.getRow(row).getCell(3));

	        obj[row - 1][4] =
	                formatter.formatCellValue(
	                        sh.getRow(row).getCell(4));
	    }

	    wb.close();

	    return obj;
	}

}