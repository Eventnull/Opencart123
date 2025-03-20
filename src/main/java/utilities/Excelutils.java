package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

public class Excelutils {
    
    private String path; // Path to the Excel file

    public Excelutils(String path) {
        this.path = path; // Constructor to initialize the path
    }

    public int getRowCount(String xlsheet) throws IOException {
        FileInputStream fi = new FileInputStream(path);
        XSSFWorkbook wb = new XSSFWorkbook(fi);
        XSSFSheet ws = wb.getSheet(xlsheet);

        int rowcount = ws.getLastRowNum();
        wb.close();
        fi.close();
        return rowcount;
    }

    public int getCellCount(String xlsheet, int rownum) throws IOException {
        FileInputStream fi = new FileInputStream(path);
        XSSFWorkbook wb = new XSSFWorkbook(fi);
        XSSFSheet ws = wb.getSheet(xlsheet);
        XSSFRow row = ws.getRow(rownum);

        int cellcount = row.getLastCellNum();
        wb.close();
        fi.close();
        return cellcount;
    }

    public String getCellData(String xlsheet, int rownum, int colnum) throws IOException {
        FileInputStream fi = new FileInputStream(path);
        XSSFWorkbook wb = new XSSFWorkbook(fi);
        XSSFSheet ws = wb.getSheet(xlsheet);
        XSSFRow row = ws.getRow(rownum);
        XSSFCell cell = row.getCell(colnum);

        String data;
        try {
            DataFormatter formatter = new DataFormatter();
            data = formatter.formatCellValue(cell);
        } catch (Exception e) {
            data = "";
        }

        wb.close();
        fi.close();
        return data;
    }

    public void setCellData(String xlsheet, int rownum, int colnum, String data) throws IOException {
        FileInputStream fi = new FileInputStream(path);
        XSSFWorkbook wb = new XSSFWorkbook(fi);
        XSSFSheet ws = wb.getSheet(xlsheet);
        XSSFRow row = ws.getRow(rownum);
        if (row == null) {
            row = ws.createRow(rownum);
        }

        XSSFCell cell = row.createCell(colnum);
        cell.setCellValue(data);

        FileOutputStream fo = new FileOutputStream(path);
        wb.write(fo);
        wb.close();
        fi.close();
        fo.close();
    }

    public void setCellDataWithColor(String xlsheet, int rownum, int colnum, String data, String color) throws IOException {
        FileInputStream fi = new FileInputStream(path);
        XSSFWorkbook wb = new XSSFWorkbook(fi);
        XSSFSheet ws = wb.getSheet(xlsheet);
        XSSFRow row = ws.getRow(rownum);
        if (row == null) {
            row = ws.createRow(rownum);
        }

        XSSFCell cell = row.getCell(colnum);
        if (cell == null) {
            cell = row.createCell(colnum);
        }

        cell.setCellValue(data);

        CellStyle style = wb.createCellStyle();
        if (color.equalsIgnoreCase("green")) {
            style.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
        } else if (color.equalsIgnoreCase("red")) {
            style.setFillForegroundColor(IndexedColors.RED.getIndex());
        } else {
            style.setFillForegroundColor(IndexedColors.WHITE.getIndex());
        }
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cell.setCellStyle(style);

        FileOutputStream fo = new FileOutputStream(path);
        wb.write(fo);
        wb.close();
        fi.close();
        fo.close();
    }
}
