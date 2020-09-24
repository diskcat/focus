package com.xzjy;

import com.xzjy.mapper.*;
import com.xzjy.pojo.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.thymeleaf.util.StringUtils;

import javax.xml.crypto.Data;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

//@SpringBootTest
public class FocusApplicationTests {

    private Rates rates; //提升作用域
    @Autowired
    private ArrearageMapper arrearageMapper;  //为了更新数据

    @Autowired
    private RatesMapper ratesMapper; //为了得到单价

    @Autowired
    private HouseInformationMapper houseInformationMapper; //获得房屋的大小类型
    @Test
    public void test01() {
        Arrearage arrearage = arrearageMapper.getArrearageByName("s010");
        //根据房屋编号知道房屋的性质
        HouseInformation houseInformation = houseInformationMapper.getHouseInformationByName(arrearage.getHouseId());
        String houseType = houseInformation.getHouseType();
        System.out.println(houseType);
        double houseArea = houseInformation.getHouseArea();
        if (!"商铺".equals(houseType)){ //不是商铺计算价格
            //获取住宅物业费
             rates = ratesMapper.getMoneyByHouseType("住宅");
        }else{
            rates = ratesMapper.getMoneyByHouseType("商铺");
        }
        //计算天数
        Date now = new Date();
        String arrearageDate = arrearage.getArrearageDate();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date ago = null;
        try {
            ago = sdf.parse(arrearageDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);
        long nowMillis = calendar.getTimeInMillis();
        calendar.setTime(ago);
        long agoMillis = calendar.getTimeInMillis();
        Long betweenDate = (nowMillis - agoMillis)/(1000L*3600L*24L); //计算出来的天数
        Double dayPrice = rates.getRatesMoney(); //每平方米单价
        Double arrearageMoney = betweenDate*dayPrice*houseArea; //获取欠款信息
        Double money = arrearage.getArrearageMoney() + arrearageMoney; //欠款的总金额
        if(money!=0){
            arrearage.setState("欠费");
        }else{
            arrearage.setState("已交清");
        }
        //更新数据
        String nowTime = sdf.format(now);
        Arrearage newArrearage = new Arrearage(arrearage.getHouseId(),arrearage.getOwnerName(),
                                    arrearage.getOwnerTelphone(),arrearage.getState(),money,nowTime);
        arrearageMapper.update(newArrearage);
    }

    @Test
    public void test02(){
        int max=0;
        String maxString=null;
        String str = "I am a student and I like listening to music";
        String[] strs = str.split(" ");
        for (String s : strs) {
            if(s.length()>max){
                max = s.length();
                maxString = s;
            }
        }

        System.out.println(maxString);
    }

    @Test
   public void test03(){
        int[] a = {1,1,2};
        int[] b = {3,4,5};
        int[] c = merge(a,b);

   }
   public static boolean equals(int[] a,int[] b){
        if (a.length!=b.length)
            return false;
       for (int i = 0; i <a.length ; i++) {
           if (a[i]!=b[i]) return false;
       }
       return true;
   }

   public static boolean equalsIgnoreOrder(int[] a,int[] b){
       for (int i = 0; i <a.length ; i++) {
           for (int j = 0; j <b.length ; j++) {
               if (a[i]==b[j]){
                   return true;
               }
           }
       }
       return false;
   }

   public static int[] reverse(int[] a){
       for (int i = 0; i <a.length/2 ; i++) {
           int temp = a[i];
           a[i] = a[a.length-1-i];
           a[a.length-1-i] = temp;
       }
       return a;
   }

   public static int min(int[] a){
        int min = a[0];
       for (int i = 0; i <a.length ; i++) {
           if (a[i]<min){
               min = a[i];
           }
       }
       return min;
   }

   public static int[] merge(int[] a,int[] b){
       int[] c= new int[a.length+b.length];
       System.arraycopy(a, 0, c, 0, a.length);
       System.arraycopy(b, 0, c, a.length, b.length);
       return c;
   }

 /*  public static String getPassword(String str){
        if (str.length()<8){
            return ""
        }
   }*/
//第二题
    @Test
    public void testN2(){
        System.out.println(toBinaryString(8));
    }

 public static int reverse(int number){
     int rs = 0;
     while (number > 0) {
         rs *= 10;
         rs += number % 10;
         number /= 10;
     }
     return rs;
 }

    public boolean isPalindrome(int number){
        if (number==reverse(number)){
            return true;
        }
        return false;
    }

    public static String toBinaryString(int number){
        String str = "";
         while(number!=0){
             str = number%2+str;
             number = number/2;
         }
         return str;
    }

    public static boolean toBinaryStringAsPalindrome(int number){
        String str1 = toBinaryString(number);
        char[] chars = str1.toCharArray();
        String reverse = "";
        for (int i = chars.length - 1; i >= 0; i--) {
            reverse += chars[i];
        }
        if (reverse.equals(str1)) return true;
        return false;
    }
}
