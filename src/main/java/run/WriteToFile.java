package run;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by user on 22.09.2016.
 */
public class WriteToFile {
    public static void writeToTXT(String text) {
        try(FileWriter writer = new FileWriter("src/test/resources/mainPhoneNumbers.txt", true)) {
            writer.write(text);
            writer.append('\n');
            writer.flush();
            writer.close();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    public static void writeToXLSX(String email,String brand,String plan,String tier,String name,String surname, String numberOfUsers){
        String xlsx = "src/test/resources/contactInformationForUKLogin.xlsx";
        XSSFWorkbook myExcelBook = null;
        try {
            myExcelBook = new XSSFWorkbook(new FileInputStream(xlsx));
            final XSSFSheet sheet = myExcelBook.getSheetAt(0);
            Row row = sheet.getRow(1);
            Cell cell = row.getCell(0);
            cell.setCellValue(tier);
            cell.setCellType(1);

            cell = row.getCell(3);
            cell.setCellValue(name);
            cell.setCellType(1);

            cell = row.getCell(4);
            cell.setCellValue(surname);
            cell.setCellType(1);

            cell = row.getCell(7);
            cell.setCellValue(numberOfUsers);
            cell.setCellType(1);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                myExcelBook.write(new FileOutputStream(xlsx));
                myExcelBook.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
