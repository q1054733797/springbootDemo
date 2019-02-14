package com.demo.springbootdemo;

import com.demo.bean.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;

import java.io.InputStream;
import java.net.URI;
import java.util.*;

/**
 * @ClassName: Test04
 * @Author: zhanghongkai
 * @Date: Create in 2018/12/7 14:28
 * @Version: 1.0
 */
public class Test04 {
    public static void main(String[] args) throws Exception {
        String url = "http://127.0.0.1:8081/test02";
        Map<String,String> map = new HashMap<>();
        map.put("username", "admin");
        map.put("password", "123456");
        User user = new User();
        user.setUsername("admin");
        user.setPassword("123456");
        ObjectMapper mapper = new ObjectMapper();
        //String json = mapper.writeValueAsString(user);
        String json = "{\"username\":\"admin\",\"password\":\"123456\"}";
        System.out.println(json);
        //postByMap(url, map);
        postByJson(url, json);
    }

    public static void postByMap(String url, Map<String,String> map) throws Exception {
        HttpClient httpClient = new DefaultHttpClient();
        HttpPost request = new HttpPost();
        request.setURI(new URI(url));
        List<NameValuePair> mvps = new ArrayList<>();
        Set<String> keys = map.keySet();
        for (String key : keys) {
            mvps.add(new BasicNameValuePair(key,map.get(key)));
        }
        request.setEntity(new UrlEncodedFormEntity(mvps, HTTP.UTF_8));
        HttpResponse response = httpClient.execute(request);
        int code = response.getStatusLine().getStatusCode();
        if(code == 200){
            InputStream stream = response.getEntity().getContent();
            String content = IOUtils.toString(stream);
            System.out.println(content);
        }
    }

    public static void postByJson(String url,String json) throws Exception {
        HttpClient httpClient = new DefaultHttpClient();
        HttpPost request = new HttpPost();
        request.setURI(new URI(url));
        request.setHeader("Accept", "application/json");
        request.setHeader("Content-Type", "application/json");
        StringEntity stringEntity = new StringEntity(json,"UTF-8");
        request.setEntity(stringEntity);
        HttpResponse response = httpClient.execute(request);
        int code = response.getStatusLine().getStatusCode();
        if(code == 200){
            InputStream stream = response.getEntity().getContent();
            String content = IOUtils.toString(stream);
            System.out.println(content);
        }
    }
}
