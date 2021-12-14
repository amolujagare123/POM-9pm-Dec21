package util;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class DataProviderUtil {

    public static Object[][] getMyData(String fileName, String sheetName) throws IOException {
        // 1. read the file
        FileInputStream fis = new FileInputStream(fileName);

        // 2. convert the file object into workbook object
        XSSFWorkbook workbook = new XSSFWorkbook(fis);

        // 3. choose sheet from excel
        XSSFSheet sheet = workbook.getSheet(sheetName);

        // 4. count the active rows
        int rowCount = sheet.getPhysicalNumberOfRows();
        int colCount = sheet.getRow(0).getLastCellNum();

        Object[][] data = new Object[rowCount - 1][colCount];


        for (int i = 0; i < rowCount - 1; i++) {
            XSSFRow row = sheet.getRow(i + 1);

            for (int j = 0; j < colCount; j++) {

                if (row.getCell(j) == null)
                    data[i][j] = "";
                else
                    data[i][j] = row.getCell(j).toString();
            }


        }
        return data;
    }
}
