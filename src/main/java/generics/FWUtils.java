package generics;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class FWUtils {

    private static WebDriver driver;

    public FWUtils(WebDriver driver) {
    	if (driver == null) {
            throw new IllegalArgumentException("WebDriver cannot be null.");
        }
        this.driver = driver;
    }

    /**
     * Reads data from a specified cell in an Excel sheet.
     */
    public static String read_XL_Data(String filePath, String sheetName, int rowNum, int colNum) throws IOException {
        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = WorkbookFactory.create(fis)) {

            Sheet sheet = workbook.getSheet(sheetName);
            Row row = sheet.getRow(rowNum);
            if (row == null) {
                return "";
            }

            Cell cell = row.getCell(colNum);
            if (cell == null) {
                return "";
            }

            switch (cell.getCellType()) {
                case STRING:
                    return cell.getStringCellValue();
                case NUMERIC:
                    return DateUtil.isCellDateFormatted(cell) ? cell.getDateCellValue().toString() : String.valueOf(cell.getNumericCellValue());
                case BOOLEAN:
                    return String.valueOf(cell.getBooleanCellValue());
                case FORMULA:
                    return cell.getCellFormula();
                default:
                    return "";
            }
        }
    }

    /**
     * Counts the number of rows in a specified Excel sheet.
     */
    public static int read_XL_RowCount(String filePath, String sheetName) {
        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook wb = WorkbookFactory.create(fis)) {

            Sheet sheet = wb.getSheet(sheetName);
            return sheet.getLastRowNum();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * Writes data to a specified cell in an Excel sheet.
     */
    public static void set_XL_Data(String filePath, String sheetName, int row, int cell, int data) {
        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook wb = WorkbookFactory.create(fis);
             FileOutputStream fos = new FileOutputStream(filePath)) {

            Sheet sheet = wb.getSheet(sheetName);
            Row excelRow = sheet.getRow(row);
            if (excelRow == null) {
                excelRow = sheet.createRow(row);
            }
            Cell excelCell = excelRow.getCell(cell);
            if (excelCell == null) {
                excelCell = excelRow.createCell(cell);
            }
            excelCell.setCellValue(data);
            wb.write(fos);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Takes a screenshot and saves it to the specified path.
     * @param driver2 
     */
    public static void take_Screen_Shoot(WebDriver driver, String path) {
        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File src = ts.getScreenshotAs(OutputType.FILE);
            File dest = new File(path);
            FileUtils.copyFile(src, dest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Scrolls down the page.
     */
    public static void scrollDown() {
    	 if (driver == null) {
             throw new IllegalStateException("WebDriver is not initialized.");
         }
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    /**
     * Scrolls up to the top of the page.
     */
    public void scrollUp() {
    	
    	 if (driver == null) {
             throw new IllegalStateException("WebDriver is not initialized.");
         }
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(document.body.scrollHeight, 0)");
    }

    /**
     * Scrolls horizontally by 250 pixels.
     */
    public void scrollHorizontally() {
    	if (driver == null) {
            throw new IllegalStateException("WebDriver is not initialized.");
        }

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(250,0)");
    }

    /**
     * Scrolls horizontally to a specific element.
     */
    public void scrollHorizontallyToElement(String elementId) {
    	if (driver == null) {
            throw new IllegalStateException("WebDriver is not initialized.");
        }

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById(arguments[0]).scrollLeft += 250", elementId);
    }

    /**
     * Prints the current page URL.
     */
    public void printPageUrl() {
        System.out.println("Page URL is " + driver.getCurrentUrl());
    }

    /**
     * Checks if a file with a specific extension exists in the directory.
     */
    public static boolean isFileDownloadedExt(String dirPath, String ext) {
        File dir = new File(dirPath);
        File[] files = dir.listFiles();
        if (files == null) {
            return false;
        }
        for (File file : files) {
            if (file.getName().endsWith(ext)) {
                return true;
            }
        }
        return false;
    }
}
