package com.demo.springbootdemo;

import cn.hutool.core.util.EscapeUtil;
import cn.hutool.core.util.HexUtil;
import org.assertj.core.util.DateUtil;
import org.junit.Test;

import java.awt.*;
import java.util.Date;

/**
 * @ClassName: HutoolTest
 * @Author: zhanghongkai
 * @Date: Create in 2019/1/22 14:17
 * @Version: 1.0
 */
public class HutoolTest {
    @Test
    public void test01(){
        String dateStr = "2019-01-22 11:18:30";
        Date date = DateUtil.parse(dateStr);
        Date date1 = new Date();
        System.out.println(date);
        System.out.println(date1);
    }

    @Test
    public void test02(){
        String str1 = "12";
        String str2 = "0x12";
        System.out.println(HexUtil.isHexNumber(str1));
        System.out.println(HexUtil.isHexNumber(str2));
        String str3 = "hello world,oh shit mother fucker";
        String str4 = HexUtil.encodeHexStr(str3);
        System.out.println(str4);
        String str5 = HexUtil.decodeHexStr(str4);
        System.out.println(str5);
        Color color1 = Color.RED;
        String color2 = HexUtil.encodeColor(color1);
        System.out.println(color2);
        Color color3 = HexUtil.decodeColor(color2);
        System.out.println(color3.toString());
    }

    @Test
    public void test03(){
        String str1 = "<script>nmsl</script>";
        String str2 = EscapeUtil.escapeHtml4(str1);
        String str3 = EscapeUtil.unescapeHtml4(str2);
        System.out.println(str2);
        System.out.println(str3);
    }
}
