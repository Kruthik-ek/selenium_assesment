package Assessment012OrangeHRMData;

import java.io.File;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

    public static String[] getData() throws IOException {

        File file = new File("./src/test/resources/Day12_assses_tc2/demo3.xlsx");

        Workbook wb = WorkbookFactory.create(file);

        Sheet sh = wb.getSheet("Sheet1");

        DataFormatter formatter = new DataFormatter();

        String firstName =
                formatter.formatCellValue(
                        sh.getRow(1).getCell(0));

        String lastName =
                formatter.formatCellValue(
                        sh.getRow(1).getCell(1));

        String employeeId =
                formatter.formatCellValue(
                        sh.getRow(1).getCell(2));

        wb.close();

        return new String[] {
                firstName,
                lastName,
                employeeId
        };
    }
}