package com.demo.springbootdemo;

import com.demo.mapper.TestMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Test02 {
    @Autowired
    private TestMapper mapper;
//
//          ----------神兽出没!----------
//            　　　┏┓　　　┏┓
//            　　┏┛┻━━━┛┻┓
//            　　┃　　　　　　　┃
//            　　┃　　　━　　　┃
//            　　┃　┳┛　┗┳　┃
//            　　┃　　　　　　　┃
//            　　┃　　　┻　　　┃
//            　　┃　　　　　　　┃
//            　　┗━┓　　　┏━┛
//            　　　　┃　　　┃神兽保佑
//            　　　　┃　　　┃代码无BUG！
//            　　　　┃　　　┗━━━┓
//            　　　　┃　　　　　　　┣┓
//            　　　　┃　　　　　　　┏┛
//            　　　　┗┓┓┏━┳┓┏┛
//            　　　　　┃┫┫　┃┫┫
//            　　　　　┗┻┛　┗┻┛
//            ━━━━━━神兽出没━━━━━━


//                    _ooOoo_
//                   o8888888o
//                   88" . "88
//                   (| -_- |)
//                   O\  =  /O
//                ____/`---'\____
//              .'  \\|     |//  `.
//            /  \\|||  :  |||//  \
//            /  _||||| -:- |||||-  \
//            |   | \\\  -  /// |   |
//            | \_|  ''\---/''  |   |
//            \  .-\__  `-`  ___/-. /
//          ___`. .'  /--.--\  `. . __
//       ."" '<  `.___\_<|>_/___.'  >'"".
//      | | :  ` - `.;`\ _ /`;.`/ - ` : | |
//      \  \ `-.   \_ __\ /__ _/   .-` /  /
// ======`-.____`-.___\_____/___.-`____.-'======
//                     `=---='
//^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
//             佛祖保佑       永无BUG
    @Test
    public void test02(){
        PageHelper.startPage(2, 20);
        List<HashMap<String, Object>> maps = mapper.selectAll();
        PageInfo pageInfo = new PageInfo(maps);
        String string = pageInfo.toString();
        System.out.println(string);
    }
}
