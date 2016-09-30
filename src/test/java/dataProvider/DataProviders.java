package dataProvider;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Created by user on 22.09.2016.
 */
public class DataProviders {
    @DataProvider(name = "contactInformationForLogin", parallel=false)
    public static Iterator<Object[]> remoteServiceDataProvider(Method m) throws ParseException, IOException {
        DataSource sourceAnnotation = m.getAnnotation(DataSource.class);
        final String xlsx = sourceAnnotation.xlsx();
        XSSFWorkbook myExcelBook = new XSSFWorkbook(new FileInputStream(xlsx));
        final XSSFSheet sheet = myExcelBook.getSheetAt(0);

        Collection<Object[]> dp = new ArrayList<Object[]>() {
            {
                Row row = sheet.getRow(1);
                Cell cell = row.getCell(0);
                cell.setCellType(1);
                int leighOfAnswer = Integer.valueOf(cell.getStringCellValue());
                int totalNoOfRows = sheet.getLastRowNum() + 1;
                for (int i= 1 ; i < totalNoOfRows; i++) {
                    row = sheet.getRow(i);
                    String[] objects = new String[leighOfAnswer];
                    for (int j = 0; j < leighOfAnswer; j++){
                        cell = row.getCell(j);
                        cell.setCellType(1);
                        objects[j] = cell.getStringCellValue();
                    }
                    add(objects);
                }
            }
        };
        return dp.iterator();
    }
}
