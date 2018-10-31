package com.demo.springbootdemo;

import com.demo.mapper.TestMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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

    private String name;

    @Test
    public void test02() throws InterruptedException, ClassNotFoundException {
        String className = "com.demo.springbootdemo.Test02";
        Class class1 = Class.forName(className);
    }
}
