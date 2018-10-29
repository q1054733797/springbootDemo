package com.demo.springbootdemo;

import com.demo.mapper.TestMapper;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Test01 {
    @Autowired
    private TestMapper mapper;

    @Test
    public void downLoadFile() throws Exception {
        //导入
        List<HashMap<String, Object>> importMaps = read();
        for(HashMap<String, Object> map:importMaps){
            mapper.isertTestByHashMap(map);
        }

        //导出
        List<HashMap<String, Object>> exportMaps = mapper.selectAll();
        write(exportMaps);
    }

    public void write(List<HashMap<String, Object>> maps) throws Exception {
        File file = new File("F:/test.xls");
        if(!file.exists()){
            file.createNewFile();
        }
        //使用jxl写入数据需要createWorkbook
        WritableWorkbook workbook = Workbook.createWorkbook(file);
        //添加工作表
        WritableSheet sheet = workbook.createSheet("测试表", 0);
        //为第一行添加表头，我直接添加字段名，具体使用根据实际情况
        if(maps.size()>0){
            int i = 0;
            for(String key:maps.get(0).keySet()){
                sheet.addCell(new Label(i, 0, key));
                i++;
            }
        }
        String key = null;
        String value = null;
        for(int i=0;i<maps.size();i++){
            for(int j=0;j<sheet.getColumns();j++){
                key = sheet.getCell(j, 0).getContents();
                value = maps.get(i).get(key).toString();
                sheet.addCell(new Label(j, i+1, value));
            }
        }
        workbook.write();
        workbook.close();
    }

    public List<HashMap<String, Object>> read() throws IOException, BiffException {
        File file = new File("F:/test.xls");
        if(!file.exists()){
            file.createNewFile();
        }
        //读取文件要getWorkbook
        Workbook workbook = Workbook.getWorkbook(file);
        Sheet sheet = workbook.getSheet(0);
        List<HashMap<String,Object>> maps = new ArrayList();
        HashMap<String,Object> map = null;
        //第一行是表头，没有数据，所有默认从第二行开始读
        for(int i=1;i<sheet.getRows();i++){
            map = new HashMap<>();
            for(int j=0;j<sheet.getColumns();j++){
                //jxl中的cell操作第一个参数是列，第二个参数是行，由于我测试数据表头用的是字段名。所以直接封装，具体使用根据自己的表格放入参数即可
                map.put(sheet.getCell(j, 0).getContents(), sheet.getCell(j, i).getContents());
            }
            maps.add(map);
        }
        workbook.close();
        return maps;
    }
}
