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
    private Workbook wb = new HSSFWorkbook();
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
        Sheet sheet1 = wb.createSheet("Array");


        // This data needs to be written (Object[])
        int i = 0;
        Map<String, Object[]> data = new TreeMap<String, Object[]>();
        data.put("1", new Object[]{subclasses.get(i++), subclasses.get(i++), subclasses.get(i++), subclasses.get(i++), subclasses.get(i++), subclasses.get(i++), subclasses.get(i++), subclasses.get(i),});
        data.put("2", new Object[]{1, "Pankaj", "Kumar"});
        data.put("3", new Object[]{2, "Prakashni", "Yadav"});
        data.put("4", new Object[]{3, "Ayan", "Mondal"});
        data.put("5", new Object[]{4, "Virat", "kohli"});

        // Iterate over data and write to sheet
        Set<Integer> keyset = sortedArrayFiller.keySet();
        int rownum = 0;
        for (Integer key : keyset) {
            // this creates a new row in the sheet
            Row row = sheet1.createRow(rownum++);
            Object[] objArr = sortedArrayFiller.get(key);
            int cellnum = 0;
            for (Object obj : objArr) {
                // this line creates a cell in the next column of that row
                Cell cell = row.createCell(cellnum++);
                if (obj instanceof String)
                    cell.setCellValue((String) obj);
                else if (obj instanceof Long)
                    cell.setCellValue((Long) obj);
            }
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
            sortedArrayFiller.put(arraySize, new Object[]{times.get(i++), times.get(i++), times.get(i++), times.get(i++), times.get(i++), times.get(i++), times.get(i++), times.get(i)});
        } else if (filler.equals("createUnsortedArray")) {
            int i = 0;
            unsortedArrayFiller.put(arraySize, new Object[]{times.get(i++), times.get(i++), times.get(i++), times.get(i++), times.get(i++), times.get(i++), times.get(i++), times.get(i)});

        } else if (filler.equals("createReversSortedArray")) {
            int i = 0;
            reversSortedArrayFiller.put(arraySize, new Object[]{times.get(i++), times.get(i++), times.get(i++), times.get(i++), times.get(i++), times.get(i++), times.get(i++), times.get(i)});

        } else if (filler.equals("createSortedWithRandom")) {
            int i = 0;
            sortedWithRandomFiller.put(arraySize, new Object[]{times.get(i++), times.get(i++), times.get(i++), times.get(i++), times.get(i++), times.get(i++), times.get(i++), times.get(i)});

        }


    }

    public void fillTable(Set data) {

    }
}