package com.he.maven.module.excel;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileOutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by heyanjing on 2017/12/4 10:20.
 */
public class Excel2007 {
    private static final Logger log = LoggerFactory.getLogger(Excel2007.class);

    public static void main(String[] args) throws Exception {
        List<Bean> dataList = new ArrayList<>();
        dataList.add(new Bean("name1", 1, new Date()));
        dataList.add(new Bean("name2", 2, new Date()));
        dataList.add(new Bean("name3", 3, new Date()));
        List<Title> titleList = new ArrayList<>();
        //region Description
//        titleList.add(new Title("企业名称", "enterprisename"));
//        titleList.add(new Title("所属省市/区县", "areaname"));
//        titleList.add(new Title("资质等级", "aptitudegread"));
//        titleList.add(new Title("资质证书编号", "aptitudecode"));
//        titleList.add(new Title("注册资本", "enterprisemoney"));
//        titleList.add(new Title("注册登记类型", "enterprisetypeonename"));
//        titleList.add(new Title("法定代表人", "username"));
//        titleList.add(new Title("注册加密狗数", "encryptnum"));
//        titleList.add(new Title("营业执照注册号", "businessnumber"));
//        titleList.add(new Title("企业成立日期", "creattime"));
//        titleList.add(new Title("批准从事开发日期", "allowdeveloptime"));
//        titleList.add(new Title("执照到期时间", "businessendtime"));
//        titleList.add(new Title("办公地址", "enterpriseaddress"));
//        titleList.add(new Title("邮政编码", "postcode"));
//        titleList.add(new Title("联系电话", "enterprisephone"));
//        titleList.add(new Title("电子邮箱", "enterpriseemail"));
//        titleList.add(new Title("投资方数量", "holderinfosnum"));
//        titleList.add(new Title("在册员工数", "allperson"));
//        titleList.add(new Title("高级职称人数", "hightype"));
//        titleList.add(new Title("中级职称人数", "middletype"));
//        titleList.add(new Title("初级职称人数", "juniortype"));
        //endregion
        titleList.add(new Title("姓名", "id"));
        titleList.add(new Title("年龄", "age"));
        titleList.add(new Title("生日", "birthday"));

        XSSFWorkbook workbook = Excel2007.getXSSFWorkbook("你妹", dataList, titleList);
        workbook.write(new FileOutputStream("D:\\Temp/export.xlsx"));
    }

    /**
     * @param sheetname sheet名称
     * @param dataList  写入excel的数据
     * @param titleList 标题与标题对应的属性名称的对象集合
     * @return XSSFWorkbook
     */
    public static XSSFWorkbook getXSSFWorkbook(String sheetname, List<?> dataList, List<Title> titleList) {

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFCellStyle cellStyle = workbook.createCellStyle();
        XSSFSheet sheet = workbook.createSheet(sheetname);
        sheet.setDefaultColumnWidth(20);
        XSSFRow titleRow = sheet.createRow(0);
        for (int i = 0; i < titleList.size(); i++) {
            XSSFCell cell = titleRow.createCell(i);
            cell.setCellStyle(cellStyle);
            cell.setCellValue(titleList.get(i).getTitle());
        }
        for (int i = 0; i < dataList.size(); i++) {
            XSSFRow row = sheet.createRow(i + 1);
            Object data = dataList.get(i);
            Map<String, String> map = getFieldValueMap(data);
            for (int j = 0; j < titleList.size(); j++) {
                row.createCell(j).setCellValue(map.get(titleList.get(j).getProp()));
            }
        }
        return workbook;
    }

    /**
     * @param bean   实例对象
     * @param isDate 是否格式化成2017-09-12
     *               2017-09-12 12:12:12
     *               默认2017-09-12
     * @return 对象字段对应的值的map集合
     */
    public static Map<String, String> getFieldValueMap(Object bean, Boolean isDate) {
        Class<?> cls = bean.getClass();
        Map<String, String> valueMap = new HashMap<>();
        Method[] methods = cls.getDeclaredMethods();
        Field[] fields = cls.getDeclaredFields();
        for (Field field : fields) {
            try {
                String fieldType = field.getType().getSimpleName();
                String fieldGetName = Excel2007.parGetName(field.getName());
                Method fieldGetMet = null;
                for (Method met : methods) {
                    if (met.getName().equals(fieldGetName)) {
                        fieldGetMet = met;
                        break;
                    }
                }
                if (fieldGetMet != null) {
                    Object fieldVal = fieldGetMet.invoke(bean);
                    String result = null;
                    if ("Date".equals(fieldType)) {
                        DateFormat dateFormat = isDate ? DateFormat.getDateInstance() : DateFormat.getDateTimeInstance();
                        result = dateFormat.format(fieldVal);
                    } else {
                        if (null != fieldVal) {
                            result = String.valueOf(fieldVal);
                        } else {
                            result = "-";
                        }
                    }
                    valueMap.put(field.getName(), result);
                }
            } catch (Exception e) {
                log.info("{}", e);
            }
        }
        return valueMap;
    }

    public static Map<String, String> getFieldValueMap(Object bean) {
        return getFieldValueMap(bean, true);
    }

    public static String parGetName(String fieldName) {
        if (null == fieldName || "".equals(fieldName)) {
            return null;
        }
        int startIndex = 0;
        if (fieldName.charAt(0) == '_')
            startIndex = 1;
        return "get"
                + fieldName.substring(startIndex, startIndex + 1).toUpperCase()
                + fieldName.substring(startIndex + 1);
    }
}
