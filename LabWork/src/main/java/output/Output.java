package output;


import java.io.*;
import java.util.*;

import analyzer.Analyzer;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class Output {

    private static List<String> fillers = Analyzer.getNamesOfFillers();
    private List<String> subclasses = Analyzer.getNamesOfSubclasses();
    private static Map<Integer, Object[]> sortedArrayFiller = new TreeMap<Integer, Object[]>();
    private static Map<Integer, Object[]> unsortedArrayFiller = new TreeMap<Integer, Object[]>();
    private static Map<Integer, Object[]> reversSortedArrayFiller = new TreeMap<Integer, Object[]>();
    private static Map<Integer, Object[]> sortedWithRandomFiller = new TreeMap<Integer, Object[]>();



    public void write()
            throws FileNotFoundException, IOException {

        // Creating Workbook instances


        // An output stream accepts output bytes and sends them to sink.
        // OutputStream fileOut = new FileOutputStream("Output.xls");

        // Creating Sheets using sheet object
        Workbook wb = new HSSFWorkbook();



        for (String fillerName:fillers
             ) {
            Sheet sheet = wb.createSheet(fillerName);
            Row row = sheet.createRow(0);
            Cell size = row.createCell(0);
            size.setCellValue("Size");
            int k = 0;
            for (int i = 1; i <= 8; i++) {
                Cell sorter = row.createCell(i);
                sorter.setCellValue(subclasses.get(k++));
            }

            chooseSheet(sheet);
        }








        try {
            // this Writes the workbook gfgcontribute
            FileOutputStream out = new FileOutputStream(new File("MyOutput.xls"));
            wb.write(out);
            out.close();
            System.out.println("gfgcontribute.xlsx written successfully on disk.");
        } catch (Exception e) {
            e.printStackTrace();
        }












/*
        Row row = sheet1.createRow(0);

        // Мы запишем имя и дату в два столбца
        // имя будет String, а дата рождения --- Date,
        // формата dd.mm.yyyy
        Cell name = row.createCell(0);
        name.setCellValue("John");

        System.out.println("Sheets Has been Created successfully");

        wb.write(fileOut);*/
    }

    public static void fillMap(int arraySize, String filler, ArrayList<Long> times) {
        if (filler.equals("createSortedArray")) {
            int i = 0;
            sortedArrayFiller.put(arraySize, new Object[]{arraySize, times.get(i++), times.get(i++), times.get(i++), times.get(i++), times.get(i++), times.get(i++), times.get(i++), times.get(i)});
        } else if (filler.equals("createUnsortedArray")) {
            int i = 0;
            unsortedArrayFiller.put(arraySize, new Object[]{arraySize,times.get(i++), times.get(i++), times.get(i++), times.get(i++), times.get(i++), times.get(i++), times.get(i++), times.get(i)});

        } else if (filler.equals("createReversSortedArray")) {
            int i = 0;
            reversSortedArrayFiller.put(arraySize, new Object[]{arraySize,times.get(i++), times.get(i++), times.get(i++), times.get(i++), times.get(i++), times.get(i++), times.get(i++), times.get(i)});

        } else if (filler.equals("createSortedWithRandom")) {
            int i = 0;
            sortedWithRandomFiller.put(arraySize, new Object[]{arraySize,times.get(i++), times.get(i++), times.get(i++), times.get(i++), times.get(i++), times.get(i++), times.get(i++), times.get(i)});

        }


    }

    public void fillTable(Sheet sheet, Map<Integer,Object[]> map) {
        // Iterate over data and write to sheet
        Set<Integer> keySet = map.keySet();
        int rownum = 1;
        for (Integer key : keySet) {
            // this creates a new row in the sheet
            Row row = sheet.createRow(rownum++);
            Object[] objArr = map.get(key);
            int cellnum = 0;
            for (Object obj : objArr) {
                // this line creates a cell in the next column of that row
                Cell cell = row.createCell(cellnum++);
                if (obj instanceof Integer)
                    cell.setCellValue((Integer) obj);
                else if (obj instanceof Long)
                    cell.setCellValue((Long) obj);
            }
        }
    }
    public void chooseSheet(Sheet sheet){

        switch (sheet.getSheetName()){
            case "createSortedArray":
                fillTable(sheet,sortedArrayFiller);
                break;

            case "createUnsortedArray":
                fillTable(sheet,unsortedArrayFiller);
                break;

            case "createReversSortedArray":
                fillTable(sheet,reversSortedArrayFiller);
                break;

            case "createSortedWithRandom":
                fillTable(sheet,sortedWithRandomFiller);
                break;

             default:
                 break;
        }



    }
}