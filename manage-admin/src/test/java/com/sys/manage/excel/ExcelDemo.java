package com.sys.manage.excel;

import com.sys.manage.common.utils.ExportExcelUtil;
import com.sys.manage.common.utils.ImportExcelUtil;
import org.junit.Test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: ExcelDemo
 * @Description: excel测试类
 * @Author wangtiantian
 * @Date 2019/4/30
 */
public class ExcelDemo {

    /**
     * 导出Excel
     * @param request
     * @param response
     */
    @Test
    public void exportExcel(HttpServletRequest request, HttpServletResponse response){
        String title = "货运单据导出";
        String[] columnName = new String[]{"序号","num1","num2"};
        List<Object[]> dataList = new ArrayList<Object[]>();
        Object[] objs;
        for (int i = 0; i <2; i++) {
            objs = new Object[columnName.length];
            objs[0] = i;
            objs[1] = "1";
            objs[2] = "2";
            dataList.add(objs);
        }
        //实例化工具类
        ExportExcelUtil ex = new ExportExcelUtil(title, columnName, dataList,request,response);
        try {
            //导出excel
            ex.export();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 导入Excel
     */
    @Test
    public void importExcel(){
        try {
            // 对读取Excel表格标题测试
            InputStream is = new FileInputStream("d:\\test2.xls");
            ImportExcelUtil excelReader = new ImportExcelUtil();
            String[] title = excelReader.readExcelTitle(is);
            System.out.println("获得Excel表格的标题:");
            for (String s : title) {
                System.out.print(s + " ");
            }
            System.out.println();

            // 对读取Excel表格内容测试
            InputStream is2 = new FileInputStream("d:\\test2.xls");
            Map<Integer, String> map = excelReader.readExcelContent(is2);
            System.out.println("获得Excel表格的内容:");
            //这里由于xls合并了单元格需要对索引特殊处理
            for (int i = 2; i <= map.size()+1; i++) {
                System.out.println(map.get(i));
            }

        } catch (Exception e) {
            System.out.println("未找到指定路径的文件!");
            e.printStackTrace();
        }
    }


}
