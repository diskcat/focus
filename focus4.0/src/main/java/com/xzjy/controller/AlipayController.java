package com.xzjy.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.xzjy.alipay.AlipayConfig;
import com.xzjy.mapper.ArrearageMapper;
import com.xzjy.pojo.Arrearage;
import com.xzjy.pojo.Record;
import com.xzjy.pojo.Users;
import org.apache.catalina.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.text.Format;
import java.util.Date;

import static org.apache.coyote.http11.Constants.a;
@Controller
public class AlipayController {

    @Autowired
    private ArrearageMapper arrearageMapper;

    private Record record;
    @RequestMapping("/alipayController")
    public String payment(HttpServletRequest request,Model model){
        record = new Record();
        String recordId = getOrderId();    //账单
        record.setRecordId(null);
        HttpSession session = request.getSession();
        Users users = (Users)session.getAttribute("user");
        record.setHouseId(users.getUId());
        double money = arrearageMapper.getMoney(users.getUId()); //金额
        record.setRecordMoney(money);
        record.setRecordDate(null);
        record.setRecordType("物业费");
        Date date = new Date();

        String result = null;
        try {
            AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);

            //设置请求参数
            AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
            alipayRequest.setReturnUrl(AlipayConfig.return_url);
            alipayRequest.setNotifyUrl(AlipayConfig.notify_url);

            //商户订单号，商户网站订单系统中唯一订单号，必填
            String out_trade_no = recordId;
            //付款金额，必填
            String total_amount = String.valueOf(money);
            //订单名称，必填
            String subject = "物业费";
            //商品描述，可空
            String body = "";

            alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
                    + "\"total_amount\":\""+ total_amount +"\","
                    + "\"subject\":\""+ subject +"\","
                    + "\"body\":\""+ body +"\","
                    + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

            //若想给BizContent增加其他可选请求参数，以增加自定义超时时间参数timeout_express来举例说明
            //alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
            //		+ "\"total_amount\":\""+ total_amount +"\","
            //		+ "\"subject\":\""+ subject +"\","
            //		+ "\"body\":\""+ body +"\","
            //		+ "\"timeout_express\":\"10m\","
            //		+ "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
            //请求参数可查阅【电脑网站支付的API文档-alipay.trade.page.pay-请求参数】章节

            //请求
            result = alipayClient.pageExecute(alipayRequest).getBody();

            //输出
            model.addAttribute("result",result);
            return "user/payment";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //生成订单号
    public String getOrderId(){
        long time = new Date().getTime();
        int random  = (int) time%10000 + 1000;
        int abs = Math.abs(random);
        String s1 = String.valueOf(time);
        String s2 = String.valueOf(abs);
        return s2+s1;
    }

    @RequestMapping("/paySuccess")
    public String paySuccess(HttpServletRequest request){
        try {
            HttpSession session = request.getSession();
            Users users = (Users)session.getAttribute("user");
            //将欠费表数据变为0,添加recod数据
            Arrearage arrearage = arrearageMapper.getArrearageByName(users.getUId());
            arrearage.setArrearageMoney(0);
            record.setOwnerTelphone(arrearage.getOwnerTelphone());
            arrearageMapper.update(arrearage);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/ownnerIndex";
    }
}
