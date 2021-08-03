package com.wuqq.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wuqq.entity.Partner;
import com.wuqq.entity.TestEntity;
import com.wuqq.request.Shits;
import com.wuqq.response.Order;
import com.wuqq.response.RealResponse;
import com.wuqq.response.Root;
import com.wuqq.response.TestResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


/**
 * @author: wuqq
 * @date: 2021/7/31 5:05 PM
 * @version: 1.0
 */

public class HttpUtils {

    public static void main(String[] args) {
        Partner partner = new Partner();
        TestEntity testEntity = new TestEntity();

        List<String> skpCodes = Lists.newArrayList("skp1111","skp2222","skp3333");
        List<Partner> partnerList =Lists.newArrayList();

        partner.setPartnerId(1234);
        partner.setSkpCodes(skpCodes);
        partnerList.add(partner);
        testEntity.setTaskId(111);
        testEntity.setPartnerList(partnerList);

        sendPost(testEntity);


    }

    public static void sendPost(TestEntity testEntity){
        CloseableHttpClient closeableHttpClient =null;
        CloseableHttpResponse closeableHttpResponse =null;
        String url = "http://127.0.0.1:8066/httppost";

        try {
            closeableHttpClient = HttpClients.createDefault();
            HttpPost httpPost = new HttpPost(url);
            httpPost.setHeader("Content-Type", "application/json");
            List<String> skpcodes =Lists.newArrayList("XSGZDA00052255","XSGZDA00051481","XSGZDA00045908");
//            Shits shits = new Shits();
//            shits.setShits(skpcodes);
//            String teststring =JSONObject.toJSONString(shits);
//            httpPost.setEntity(new StringEntity(teststring));
            Root root = new Root();
            List<Order> orders =new ArrayList<>();
            Order order1 = new Order("1111","222",skpcodes);
            Order order2 = new Order("2222","333",skpcodes);

            orders.add(order1);
            orders.add(order2);
            root.setOrders(orders);
            String teststring =JSONObject.toJSONString(root);
            httpPost.setEntity(new StringEntity(teststring));
            closeableHttpResponse = closeableHttpClient.execute(httpPost);

            int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();

            String json = EntityUtils.toString(closeableHttpResponse.getEntity());
            RealResponse testResponse =JSONObject.parseObject(json, RealResponse.class);
            System.out.println(json);

            System.out.println(statusCode);


        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
