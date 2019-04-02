package util.readexcel;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import sun.awt.SunHints;
import util.NullObject;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.*;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package util.readexcel
 * @email wubin326@qq.com
 * @date 2018/12/19
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/12/19        wubin            0.0.1
 */
public class ExcelUtils {

    private static HashMap<String, Map<String, LinkedList<String>>> lazyMap = new HashMap<>();
    private static HashMap<String, Map<String, Map<String, LinkedList<String>>>> lazyMapAllDatas = new HashMap<>();

    public static Workbook parseExcel(String filename) {

        FileInputStream fileInputStream;

        Workbook workbook = null;
        try {
            fileInputStream = new FileInputStream(filename);
            if (judgeFileExt(filename, "xls")) {
                workbook = new HSSFWorkbook(fileInputStream);
            }
            if (judgeFileExt(filename, "xlsx")) {
                workbook = new XSSFWorkbook(fileInputStream);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (Objects.nonNull(workbook)) {
            return workbook;
        } else {
            return null;
        }
    }

    /**
     * 获取指定的sheet的所有列数据
     * 并按照列数据[columns]放入结果map中
     * 如果已经获取过则加入lazymap
     */
    public static Map<String, LinkedList<String>> getColumnsBySheet(Sheet sheet) {

        if (Objects.nonNull(lazyMap.get("columns"))) {
            return lazyMap.get("columns");
        }
        LinkedHashMap<String, LinkedList<String>> columnDataMap = new LinkedHashMap<>();
        //全部行的数量
        int rows = sheet.getPhysicalNumberOfRows();
        String columnString;
        //获取这个sheet页的第一行；
        Row topRow = sheet.getRow(0);

        //获取这一行所有单元格的数量，也就是一行的列数；
        int columns = topRow.getPhysicalNumberOfCells();
        /**
         * 每一行的数据存储list
         */
        LinkedList<String> rowDataList;
        Row tempRow;
        Cell tempCell;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                tempRow = sheet.getRow(i);
                if (Objects.nonNull(tempRow)){
                    tempCell = sheet.getRow(i).getCell(j);
                }else
                    tempCell = null;
                columnString = String.format("第%d列", j);
                /**
                 * 解析读取出来的workbook，将数据根据列存储在columnDataMap
                 */
                String cellValue = ExcelUtils.getCellValue(tempRow, tempCell);
                retrieveColumn(cellValue, columnDataMap, columnString);
            }
        }
        /**
         * 返回所有列的数据
         */
        lazyMap.put("columns", columnDataMap);
        return columnDataMap;
    }

    /**
     * 获取指定的sheet的所有行数据
     * 并按照行数据[rows]放入结果map中
     * 如果已经获取过则加入lazymap
     *
     * @param sheet
     * @return
     */
    public static Map<String, LinkedList<String>> getRowsBySheet(Sheet sheet) {

        if (Objects.nonNull(lazyMap.get("rows"))) {
            return lazyMap.get("rows");
        }
        LinkedHashMap<String, LinkedList<String>> rowDataMap = new LinkedHashMap<>();
        //全部行的数量
        int rows = sheet.getPhysicalNumberOfRows();
        //获取这个sheet页的第一行；
        Row topRow = sheet.getRow(0);

        //获取这一行所有单元格的数量，也就是一行的列数；
        int columns = topRow.getPhysicalNumberOfCells();
        /**
         * 每一行的数据存储list
         */
        LinkedList<String> rowDataList;
        Row tempRow;
        Cell tempCell;
        String rowString;
        for (int i = 0; i < rows; i++) {
            rowString = String.format("第%d行", i);
            rowDataList = new LinkedList<>();
            for (int j = 0; j < columns; j++) {
                /**
                 * 解析读取出来的workbook，将数据根据行存储在rowDataMap
                 */
                tempRow = sheet.getRow(i);
                if (Objects.nonNull(tempRow)){
                    tempCell = sheet.getRow(i).getCell(j);
                }else
                    tempCell = null;
                String cellValue = ExcelUtils.getCellValue(tempRow, tempCell);
                if (!cellValue.equals("NullObject")){
                    rowDataList.add(cellValue);
                }
            }
            /**
             * 记录每一行的数据
             */
            rowDataMap.put(rowString, rowDataList);
        }
        /**
         * 返回所有列的数据
         */
        lazyMap.put("rows", rowDataMap);
        return rowDataMap;
    }

    /**
     * 获取指定的sheet的所有数据
     * 并按照行数据[rows]和列数据[columns]放入结果map中
     *
     * @param sheet
     * @return
     */
    public static Map<String, Map<String, LinkedList<String>>> getExcelDataBySheet(Sheet sheet) {
        /**
         * 如果已经调用过这个方法读取指定sheet所有的数据
         * 则直接返回lazymap中的数据
         */
        if (Objects.nonNull(lazyMapAllDatas.get("datas"))) {
            return lazyMapAllDatas.get("datas");
        }

        Map<String, Map<String, LinkedList<String>>> parsedData = new HashMap();
        /**
         * 所有的行数据以及
         * 所有的列数据
         */
        LinkedHashMap<String, LinkedList<String>> rowDataMap = new LinkedHashMap<>();
        LinkedHashMap<String, LinkedList<String>> columnDataMap = new LinkedHashMap<>();

        //全部行的数量
        int rows = sheet.getPhysicalNumberOfRows();

        //获取这个sheet页的第一行；
        Row topRow = sheet.getRow(0);

        //获取这一行所有单元格的数量，也就是一行的列数；
        int columns = topRow.getPhysicalNumberOfCells();

        String rowString;
        String columnString;
        /**
         * 每一行的数据存储list
         */
        LinkedList<String> rowDataList;
        /**
         * 迭代时储存临时的信息
         */
        Row tempRow;
        Cell tempCell;
        for (int i = 0; i < rows; i++) {
            rowString = String.format("第%d行", i);
            rowDataList = new LinkedList<>();
            for (int j = 0; j < columns; j++) {
                /**
                 * 解析读取出来的workbook，将数据根据行存储在rowDataMap
                 */
                tempRow = sheet.getRow(i);
                if (Objects.nonNull(tempRow)){
                    tempCell = sheet.getRow(i).getCell(j);
                }else
                    tempCell = null;
                columnString = String.format("第%d列", j);
                String cellValue = ExcelUtils.getCellValue(tempRow, tempCell);
                if (!cellValue.equals("NullObject")){
                    rowDataList.add(cellValue);
                }
                /**
                 * 解析读取出来的workbook，将数据根据列存储在columnDataMap
                 */
                retrieveColumn(cellValue, columnDataMap, columnString);
            }
            /**
             * 记录每一行的数据
             */
            rowDataMap.put(rowString, rowDataList);
        }
        parsedData.put("rows", rowDataMap);
        parsedData.put("columns", columnDataMap);
        lazyMap.put("rows", rowDataMap);
        lazyMap.put("columns", columnDataMap);
        lazyMapAllDatas.put("datas", parsedData);
        return parsedData;
    }

    /**
     * 获取所有的sheet页的数据放入list放回
     *
     * @param workbook
     * @return
     */
    public static List<Map<String, Map<String, LinkedList<String>>>> getAllExcelDataToList(Workbook workbook) {
        LinkedList<Map<String, Map<String, LinkedList<String>>>> sheets = new LinkedList<>();
        int numberOfSheets = workbook.getNumberOfSheets();
        for (int i = 0; i < numberOfSheets; i++) {
            sheets.add(getExcelDataBySheet(workbook.getSheetAt(i)));
        }
        return sheets;
    }

    /**
     * 获取所有的sheet页的数据按sheet名称放入map放回
     *
     * @param workbook
     * @return
     */
    public static Map<String,Map<String, Map<String, LinkedList<String>>>> getAllExcelDataToMap(Workbook workbook) {
        LinkedHashMap<String, Map<String, Map<String, LinkedList<String>>>> sheets = new LinkedHashMap<>();
        for (int i = 0; i < getAllExcelDataToList(workbook).size(); i++) {
            sheets.put(workbook.getSheetName(i), getExcelDataBySheet(workbook.getSheetAt(i)));
        }
        return sheets;
    }

    /**
     * 解析数据，将没一列的数据存储到columnDataMap中
     *
     * @param columnDataMap
     * @param columnString
     */
    private static void retrieveColumn(String cellValue,
                                       LinkedHashMap<String, LinkedList<String>> columnDataMap, String columnString) {

        LinkedList<String> columnDataList;
        if (Objects.nonNull(columnDataMap.get(columnString))) {
            /**
             * 如果每一列都已经有list作为存储数据
             * 直接获取map中的list，将后续同一列的数据
             * 添加进去即可
             */
            if (!cellValue.equals("NullObject")){
                columnDataMap.get(columnString).add(cellValue);
            }
        } else {
            /**
             * 首次获取列的数据时
             * 如果map中没一列还没有list
             * 则在没一列的开始都要新建一个list来存储不同列的数据
             */
            columnDataList = new LinkedList<>();

            if (!cellValue.equals("NullObject")){
                columnDataList.add(cellValue);
            }
            columnDataMap.put(columnString, columnDataList);
        }
    }

    /**
     * 判断文件的后缀，决定走哪个解析类
     *
     * @param filename
     * @param ext
     * @return
     */
    private static boolean judgeFileExt(String filename, String ext) {
        String fileExt = filename.substring(filename.lastIndexOf(".") + 1);
        if (ext.equals(fileExt)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 获取单元格的数据
     * 作为字符串返回
     * 若为空则返回 blank
     *
     * @param cell
     * @return
     */
    public static String getCellValue(Cell cell) {
        String value;
        if (Objects.nonNull(cell)) {

            switch (cell.getCellType()) {
                case HSSFCell.CELL_TYPE_NUMERIC:
                    value = String.valueOf(cell.getNumericCellValue());
                    break;
                case HSSFCell.CELL_TYPE_BOOLEAN:
                    value = String.valueOf(cell.getBooleanCellValue());
                    break;
                case HSSFCell.CELL_TYPE_STRING:
                    value = cell.getRichStringCellValue().getString();
                    break;
                default:
                    return new NullObject().toString();
            }
            return value;
        } else {
            return new NullObject().toString();
        }
    }

    /**
     * 获取指定行的指定单元格的数据
     *
     * @param row
     * @param cell
     * @return
     */
    public static String getCellValue(Row row, Cell cell) {
        String value;
        if (Objects.nonNull(row)) {
            value = getCellValue(cell);
        } else {
            value = new NullObject().toString();
        }
        return value;
    }

    public static String normalReadFile(String filename) {
        FileInputStream fileInputStream;
        FileChannel fileChannel;
        ByteBuffer byteBuffer;
        CharBuffer charBuffer;
        char[] chars;
        StringBuffer stringBuffer = new StringBuffer();
        try {
            fileInputStream = new FileInputStream(filename);
            byteBuffer = ByteBuffer.allocate(ExcelConst.BYTE_SIZE);
            charBuffer = CharBuffer.allocate(ExcelConst.BYTE_SIZE);
            fileChannel = fileInputStream.getChannel();
            fileChannel.read(byteBuffer);
            Charset charset = Charset.forName("utf-8");
            CharsetDecoder charsetDecoder = charset.newDecoder();
            charsetDecoder.decode(byteBuffer, charBuffer, true);
            chars = new char[charBuffer.length()];
            charBuffer.flip();
            while (charBuffer.hasRemaining()) {
                charBuffer.get(chars);
                String s = new String(chars);
                stringBuffer.append(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuffer.toString();
    }

    class ExcelConst {
        public static final int BYTE_SIZE = 1024 * 2;
        public static final String FILENAME = "/Users/wufan/Library/Containers/com.tencent.Foxmail/Data/Library/Foxmail/Profiles/wubin5@asiainfo.com/Mail/2/26/4766755657561218138.attachment/融合CRM下线新批次对应规则.xlsx";
    }
}
