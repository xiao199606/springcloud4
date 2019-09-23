package com.jk.controller;

import com.jk.model.JianLi;
import com.jk.service.LmhServiceApi;

import com.jk.utils.ExportExcel;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("excel")
public class ExcelController {

    @Autowired
    private LmhServiceApi lmhServiceApi;

    //导出到excel
    @RequestMapping("exportExcel")
    public void exportExcel(HttpServletResponse response, HttpServletRequest request, Integer ids1) {
        //导出的excel的标题
        String title = "简历管理";

        String[] rowName = {"id", "名称", "性别", "出生日期", "民族", "婚姻状态", "政治面貌", "毕业学校", "所学专业", "最高学历", "工作经验", "现居住地", "籍贯", "求职岗位", "岗位类别", "工作地区", "月薪要求", "求职状态", "技术特长", "工作经历", "个人介绍", "手机号", "邮箱"};

        List<Object[]> dataList = new ArrayList<Object[]>();
        //查询的数据库的简历信息
        // Integer ids1 = (Integer) request.getSession().getAttribute("ids");
        List<JianLi> list = lmhServiceApi.queryJianL(ids1);
        for (JianLi book : list) {
            Object[] obj = new Object[rowName.length];
            obj[0] = book.getId();
            obj[1] = book.getName();

            if (book.getSex() == 1) {
                obj[2] = "男";
            } else {
                obj[2] = "女";
            }

            SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
            String format = sdf.format(book.getBirthday());
            obj[3] = format;
            obj[4] = book.getMinz();
            obj[5] = book.getHuny();
            obj[6] = book.getZhengzh();
            obj[7] = book.getXuex();
            obj[8] = book.getZhuany();
            obj[9] = book.getXuel();
            obj[10] = book.getGongzjy();
            obj[11] = book.getXianjd();
            obj[12] = book.getJig();
            obj[13] = book.getGangw();
            obj[14] = book.getGangwlb();
            obj[15] = book.getGongzdq();
            obj[16] = book.getYuexyq();
            obj[17] = book.getQiuzhzht();
            obj[18] = book.getJishtch();
            obj[19] = book.getGongzjl();
            obj[20] = book.getGerjs();
            obj[21] = book.getTel();
            obj[22] = book.getEmail();
            dataList.add(obj);
        }
        try {
            ExportExcel exportExcel = new ExportExcel(title, rowName, dataList, response);
            exportExcel.export();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //判断从Excel文件中解析出来数据的格式
    private static String getCellValue(Cell cell) {
        String value = null;
        //简单的查检列类型
        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_STRING://字符串
                value = cell.getRichStringCellValue().getString();
                break;
            case Cell.CELL_TYPE_NUMERIC://数字
                long dd = (long) cell.getNumericCellValue();
                value = dd + "";
                break;
            case Cell.CELL_TYPE_BLANK:
                value = "";
                break;
            case Cell.CELL_TYPE_FORMULA:
                value = String.valueOf(cell.getCellFormula());
                break;
            case Cell.CELL_TYPE_BOOLEAN://boolean型值
                value = String.valueOf(cell.getBooleanCellValue());
                break;
            case Cell.CELL_TYPE_ERROR:
                value = String.valueOf(cell.getErrorCellValue());
                break;
            default:
                break;
        }
        return value;
    }


    //判断从Excel文件中解析出来数据的格式
    private static String getCellValue(XSSFCell cell){
        String value = null;
        //简单的查检列类型
        switch(cell.getCellType())
        {
            case HSSFCell.CELL_TYPE_STRING://字符串
                value = cell.getRichStringCellValue().getString();
                break;
            case HSSFCell.CELL_TYPE_NUMERIC://数字
                long dd = (long)cell.getNumericCellValue();
                value = dd+"";
                break;
            case HSSFCell.CELL_TYPE_BLANK:
                value = "";
                break;
            case HSSFCell.CELL_TYPE_FORMULA:
                value = String.valueOf(cell.getCellFormula());
                break;
            case HSSFCell.CELL_TYPE_BOOLEAN://boolean型值
                value = String.valueOf(cell.getBooleanCellValue());
                break;
            case HSSFCell.CELL_TYPE_ERROR:
                value = String.valueOf(cell.getErrorCellValue());
                break;
            default:
                break;
        }
        return value;
    }
}