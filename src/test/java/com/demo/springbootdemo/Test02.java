package com.demo.springbootdemo;

import com.demo.bean.Dept;
import com.demo.bean.User;
import com.demo.service.IDeptService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Test02 {
    @Autowired
    private IDeptService deptService;
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
        List<Dept> depts = deptService.getDepts("");
        System.out.println(depts.size());
        for(Dept dept:depts){
            System.out.println(dept.getName());
            List<User> users = dept.getUsers();
            for(User user:users){
                System.out.println(user.getUsername());
            }
        }
    }
}
