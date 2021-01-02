package com.xzjy.alipay;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */
@Configuration
@Component
public class AlipayConfig {
    //新增注释
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2021000116685924";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCevbszfY6AvELl+ZAx/F/TRp2tbxgfZN/xEh9InkmL/v8iC14ohfPwTLnqfJGEmw4SCEo4UafddpmYeOIJ2/JKyHcIMg6i53CM1wkSBzZAIUSYOGkQIkgFsX/4UpobadG1GNgJ7cj6xHIvbOe67f+F0QVMz5bLK9LYpdV/iRF6d21d7ftzsNozsM8QmbFSev3ynb2w7e5FGU8BT37bCM6s8IFSs/r+fsJY+XrWu5qj6vwuIsST7i2uYmuJkpFinogP7JmS2CBc5cZlYvziv+vJrvjXcJtP607Abj5F1Ne2PAk/+EFw9hcLWgJc+IgjCGbUAnfMxobdPVk2hRzX046rAgMBAAECggEAbKaekEK7HAA/pdsoSB5elGS8He5xS2OnKADoarL00h6qEGpJe2EcM3jAs++pRmM+wTbtXhj91caMoOD0jhz+fRMy7egdPoE89xlj+vP2vPRIWAwcVU+xjjwMxDH9iw/l2pdzn3Ai5Qk6wp0/CyJFiBkmEInxw4RuX506QX3W+cPZb3oYHrLIioujOAhIMfyG7BPwXPKohQ7Vmw9He8I6cijbPc6yeq07UhzqADRPn3Z1Qb78oUjPVAAHtJhoORBApk5uEtXkySnwHBJK1j8p3wO0aV10JMRHri2HsksDgNIcZ3snD+DD+FTCf0QqdyYubLzHZAhNLAwS7qLO9LXJmQKBgQDdO5dCHviUOzgBpiQZxE8ui3aaqcAgKKXxFasQ+hHibvC6l5Jk9bkR9mrHUDUnxONE3MdlIAzZlKEdbi/9LINBWa1RQH1eykIl0Dv8Mj7o8YAC3qDvxSFFCXIueFdr+OZzudNQp09mu7lkmrOsxKggTJdBT5AfL9JHlYG7I71OfwKBgQC3sAqJl8Wu93AZvN8i7NFpUtqRoX203WiplEBUouno3ft/23wTNE0lLthAtIcZrWsjx1TF/T10GdmeY8uPilKIhDOsGJmAV1hCPWBDBOZAyCNA14u1Oz4GZAPC333VOqshj0FXYfj8INk1RNA5VrarvleQFbNEj2LvvJF12h1B1QKBgFChvXld7F+qTblcImA5ylo+flXUdK/D4OdDbHvdiNMseBSp1bNyU6eWVkialSUPf33DsfDLg6Nxpl8hn9/4b0ZMNv0cMhVwRjed857xeThRfMSO+70n7f5JeRIyzjoOF4AqRDhrImdhGCrwr3fSnSxYffBR3UdgmJV6ijP4zLBlAoGATnkYp1t9ipgO/g/gS+1cMWDCG4EgUQpd0kSRjxbiUyeycBb2VMX9RytSG6KELQYXRXu8zbC4dkcs3yvHJRV02PmRka4YtemavQG3hCotq/NUjDkJaG1cvCIyMSiFe3jK71ViFtC2LBBkewtg4X4YIBr7EYUTxvBy1fR7OBvsb9kCgYEAxQZ59NMBXbfuyAULjkbDaNveO2RtGoXowfdQDeN/6o0JjYgsacnYFiTj9aAzcKxgDmRPZV+VMSY8rXwv0c7O0v/ssTfrIzs4vJXXULpEnHK9zYAKkJlF9QKatRwvLkZ9X/74mY2nLXjZiqyugGRqBBiRdmwxKqi4pzgfs9oi6V8=";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAnr27M32OgLxC5fmQMfxf00adrW8YH2Tf8RIfSJ5Ji/7/IgteKIXz8Ey56nyRhJsOEghKOFGn3XaZmHjiCdvySsh3CDIOoudwjNcJEgc2QCFEmDhpECJIBbF/+FKaG2nRtRjYCe3I+sRyL2znuu3/hdEFTM+WyyvS2KXVf4kRendtXe37c7DaM7DPEJmxUnr98p29sO3uRRlPAU9+2wjOrPCBUrP6/n7CWPl61ruao+r8LiLEk+4trmJriZKRYp6ID+yZktggXOXGZWL84r/rya7413CbT+tOwG4+RdTXtjwJP/hBcPYXC1oCXPiIIwhm1AJ3zMaG3T1ZNoUc19OOqwIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://工程公网访问地址/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://www.baidu.com";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "d:\\desktop";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

