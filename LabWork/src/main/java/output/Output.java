package output;


import java.io.*;
import java.util.*;

import analyzer.Analyzer;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.charts.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xddf.usermodel.*;
import org.apache.poi.xddf.usermodel.chart.*;
import org.apache.poi.xddf.usermodel.chart.AxisCrosses;
import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.xssf.usermodel.charts.XSSFChartLegend;

public class Output {

    private static List<String> fillers = Analyzer.getNamesOfFillers();
    private List<String> subclasses = Analyzer.getNamesOfSubclasses();
    private static List<Integer> sizes = Analyzer.getSizes();
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
        XSSFWorkbook wb = new XSSFWorkbook();
        final int NUM_OF_ROWS = sizes.size();
        final int NUM_OF_COLUMNS = 9;

        System.out.println("NUM OF ROWS: "+NUM_OF_ROWS);
        System.out.println("SIZES:");
        for (Integer a:sizes
             ) {
            System.out.print(a+" ");
        }

        System.out.println("SUBCLASSES:");
        for (String s: subclasses
             ) {
            System.out.println(s);
        }

        System.out.println("FILLERS:");
        for (String s: fillers
        ) {
            System.out.println(s);
        }

        for (String fillerName:fillers
             ) {
            XSSFSheet sheet = wb.createSheet(fillerName);
            Row row = sheet.createRow(0);
            Cell size = row.createCell(0);
            size.setCellValue("Size");
            int k = 0;
            for (int i = 1; i <= 8; i++) {
                Cell sorter = row.createCell(i);
                sorter.setCellValue(subclasses.get(k++));
            }

            chooseSheet(sheet);



            XSSFDrawing drawing = sheet.createDrawingPatriarch();
            XSSFClientAnchor anchor = drawing.createAnchor(0, 0, 0, 0, 0, 5, 10, 15);

            XSSFChart chart = drawing.createChart(anchor);
            XDDFChartLegend legend = chart.getOrAddLegend();
            legend.setPosition(org.apache.poi.xddf.usermodel.chart.LegendPosition.TOP_RIGHT);

            // Use a category axis for the bottom axis.
            XDDFCategoryAxis bottomAxis = chart.createCategoryAxis(org.apache.poi.xddf.usermodel.chart.AxisPosition.BOTTOM);
            bottomAxis.setTitle("Number of elements"); // https://stackoverflow.com/questions/32010765
            XDDFValueAxis leftAxis = chart.createValueAxis(org.apache.poi.xddf.usermodel.chart.AxisPosition.LEFT);
            leftAxis.setTitle("Time of Sorting");
            leftAxis.setCrosses(AxisCrosses.AUTO_ZERO);

            XDDFDataSource<Double> xs = XDDFDataSourcesFactory.fromNumericCellRange(sheet, new CellRangeAddress(1, NUM_OF_ROWS, 0, 0));
            XDDFNumericalDataSource<Double> ys1 = XDDFDataSourcesFactory.fromNumericCellRange(sheet, new CellRangeAddress(1, NUM_OF_ROWS, 1, 1));
            XDDFNumericalDataSource<Double> ys2 = XDDFDataSourcesFactory.fromNumericCellRange(sheet, new CellRangeAddress(1, NUM_OF_ROWS, 2, 2));
            XDDFNumericalDataSource<Double> ys3 = XDDFDataSourcesFactory.fromNumericCellRange(sheet, new CellRangeAddress(1, NUM_OF_ROWS, 3, 3));
            XDDFNumericalDataSource<Double> ys4 = XDDFDataSourcesFactory.fromNumericCellRange(sheet, new CellRangeAddress(1, NUM_OF_ROWS, 4, 4));
            XDDFNumericalDataSource<Double> ys5 = XDDFDataSourcesFactory.fromNumericCellRange(sheet, new CellRangeAddress(1, NUM_OF_ROWS, 5, 5));
            XDDFNumericalDataSource<Double> ys6 = XDDFDataSourcesFactory.fromNumericCellRange(sheet, new CellRangeAddress(1, NUM_OF_ROWS, 6, 6));
            XDDFNumericalDataSource<Double> ys7 = XDDFDataSourcesFactory.fromNumericCellRange(sheet, new CellRangeAddress(1, NUM_OF_ROWS, 7, 7));
            XDDFNumericalDataSource<Double> ys8 = XDDFDataSourcesFactory.fromNumericCellRange(sheet, new CellRangeAddress(1, NUM_OF_ROWS, 8, 8));

            XDDFLineChartData data = (XDDFLineChartData) chart.createData(ChartTypes.LINE, bottomAxis, leftAxis);
            XDDFLineChartData.Series series1 = (XDDFLineChartData.Series) data.addSeries(xs, ys1);
            series1.setTitle(subclasses.get(0), null); // https://stackoverflow.com/questions/21855842
            series1.setSmooth(false); // https://stackoverflow.com/questions/29014848
           series1.setMarkerStyle(MarkerStyle.STAR); // https://stackoverflow.com/questions/39636138
            XDDFLineChartData.Series series2 = (XDDFLineChartData.Series) data.addSeries(xs, ys2);
            series2.setTitle(subclasses.get(1), null);
            series2.setSmooth(false);
            series2.setMarkerSize((short) 6);
            series2.setMarkerStyle(MarkerStyle.TRIANGLE); // https://stackoverflow.com/questions/39636138

            XDDFLineChartData.Series series3 = (XDDFLineChartData.Series) data.addSeries(xs, ys3);
            series3.setTitle(subclasses.get(2), null);

            XDDFLineChartData.Series series4 = (XDDFLineChartData.Series) data.addSeries(xs, ys4);
            series4.setTitle(subclasses.get(3), null);

            XDDFLineChartData.Series series5 = (XDDFLineChartData.Series) data.addSeries(xs, ys5);
            series5.setTitle(subclasses.get(4), null);

            XDDFLineChartData.Series series6 = (XDDFLineChartData.Series) data.addSeries(xs, ys6);
            series6.setTitle(subclasses.get(5), null);

            XDDFLineChartData.Series series7 = (XDDFLineChartData.Series) data.addSeries(xs, ys7);
            series7.setTitle(subclasses.get(6), null);
            chart.plot(data);

            XDDFLineChartData.Series series8 = (XDDFLineChartData.Series) data.addSeries(xs, ys8);
            series8.setTitle(subclasses.get(7), null);
            chart.plot(data);

            // if your series have missing values like https://stackoverflow.com/questions/29014848
            // chart.displayBlanksAs(DisplayBlanks.GAP);

            // https://stackoverflow.com/questions/24676460
            solidLineSeries(data, 0, PresetColor.CHARTREUSE);
           solidLineSeries(data, 1, PresetColor.TURQUOISE);








        }








        try {
            // this Writes the workbook gfgcontribute
            FileOutputStream out = new FileOutputStream(new File("MyOutput.xls"));
            wb.write(out);
            out.close();
            System.out.println("MyOutput.xls written successfully on disk.");
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
    private static void solidLineSeries(XDDFChartData data, int index, PresetColor color) {
        XDDFSolidFillProperties fill = new XDDFSolidFillProperties(XDDFColor.from(color));
        XDDFLineProperties line = new XDDFLineProperties();
        line.setFillProperties(fill);
        XDDFChartData.Series series = data.getSeries().get(index);
        XDDFShapeProperties properties = series.getShapeProperties();
        if (properties == null) {
            properties = new XDDFShapeProperties();
        }
        properties.setLineProperties(line);
        series.setShapeProperties(properties);
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
    public void chooseSheet(XSSFSheet sheet){

        switch (sheet.getSheetName()){
            case "SortedArray":
                fillTable(sheet,sortedArrayFiller);
                break;

            case "UnsortedArray":
                fillTable(sheet,unsortedArrayFiller);
                break;

            case "ReversSortedArray":
                fillTable(sheet,reversSortedArrayFiller);
                break;

            case "SortedWithRandom":
                fillTable(sheet,sortedWithRandomFiller);
                break;

             default:
                 break;
        }



    }

}