package com.algorithm.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class JavaMmyHttpExample {
    // 连接超时（单位：毫秒）
    private static int connectTimeOut = 5000;
    // 读操作超时（单位：毫秒）
    private static int readTimeOut = 10000;

    /**
     * <pre>
     * HTTP POST请求
     * </pre>
     * 
     * @param reqUrl
     *            HTTP请求URL
     * @param parameters
     *            参数映射表
     * @return HTTP响应的字符串
     */
    public static String doPost(String reqUrl, Map<String, String> parameters, String charset) {
        HttpURLConnection url_con = null;
        String responseContent = null;
        try {
            StringBuffer params = new StringBuffer();
            for (Iterator iter = parameters.entrySet().iterator(); iter.hasNext();) {
                Entry element = (Entry) iter.next();
                params.append(element.getKey().toString());
                params.append("=");
                params.append(URLEncoder.encode(element.getValue().toString(), charset));
                params.append("&");
            }

            if (params.length() > 0) {
                params = params.deleteCharAt(params.length() - 1);
            }

            URL url = new URL(reqUrl);
            url_con = (HttpURLConnection) url.openConnection();
            url_con.setRequestMethod("POST");

            url_con.setConnectTimeout(JavaMmyHttpExample.connectTimeOut);// （单位：毫秒）jdk 1.5+换成这个,连接超时
            url_con.setReadTimeout(JavaMmyHttpExample.readTimeOut);// （单位：毫秒）jdk 1.5+换成这个,读操作超时
            // System.setProperty("sun.net.client.defaultConnectTimeout", String
            // .valueOf(JavaHttpInterfaceExample.connectTimeOut));// （单位：毫秒）jdk1.4换成这个,连接超时
            // System.setProperty("sun.net.client.defaultReadTimeout", String
            // .valueOf(JavaHttpInterfaceExample.readTimeOut)); // （单位：毫秒）jdk1.4换成这个,读操作超时

            url_con.setDoOutput(true);
            byte[] b = params.toString().getBytes();
            url_con.getOutputStream().write(b, 0, b.length);
            url_con.getOutputStream().flush();
            url_con.getOutputStream().close();

            InputStream in = url_con.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(in, charset));
            String tempLine = rd.readLine();
            StringBuffer tempStr = new StringBuffer();
            String crlf = System.getProperty("line.separator");
            while (tempLine != null) {
                tempStr.append(tempLine);
                tempStr.append(crlf);
                tempLine = rd.readLine();
            }
            responseContent = URLDecoder.decode(tempStr.toString(), charset);
            rd.close();
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (url_con != null) {
                url_con.disconnect();
            }
        }
        return responseContent;
    }

    /**
     * @return 连接超时(毫秒)
     */
    public static int getConnectTimeOut() {
        return JavaMmyHttpExample.connectTimeOut;
    }

    /**
     * @param 连接超时(毫秒)
     */
    public static void setConnectTimeOut(int connectTimeOut) {
        JavaMmyHttpExample.connectTimeOut = connectTimeOut;
    }

    /**
     * @return 读取数据超时(毫秒)
     */
    public static int getReadTimeOut() {
        return JavaMmyHttpExample.readTimeOut;
    }

    /**
     * @param 读取数据超时(毫秒)
     */
    public static void setReadTimeOut(int readTimeOut) {
        JavaMmyHttpExample.readTimeOut = readTimeOut;
    }

    /**
     * 生成签名工具类
     * 
     * @param paramMap
     * @param apiKey
     * @return
     */
    public static String createSign(Map<String, String> paramMap, String apiKey) {
        String sign = null;
        TreeMap<String, String> treeMap = new TreeMap<String, String>();
        treeMap.putAll(paramMap);
        Iterator<String> iter = treeMap.keySet().iterator();
        StringBuffer signSb = new StringBuffer();
        while (iter.hasNext()) {
            String key = iter.next();
            signSb.append(key + "=" + String.valueOf(treeMap.get(key)) + "&");
        }
        signSb.append("key=" + apiKey);
        sign = md5(signSb.toString());
        return sign;
    }


    /**
     * 对字符串md5加密
     *
     * @param str
     * @return
     */
    public static String md5(String str) {
        try {
            // 生成一个MD5加密计算摘要
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.reset();
            // 计算md5函数
            md.update(str.getBytes());
            byte encrypt[];
            encrypt = md.digest();
            StringBuilder sb = new StringBuilder();
            for (byte t : encrypt) {
                String s = Integer.toHexString(t & 0xFF);
                if (s.length() == 1) {
                    s = "0" + s;
                }
                sb.append(s);
            }
            return sb.toString();
            // digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
            // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
//            return new BigInteger(1, md.digest()).toString(16);
        } catch (Exception e) {
        }
        return null;
    }

    /**
     * 发送测试短信
     * 
     * @param mobile
     * @param content
     * @return
     */
    public static String sendTestSms() {
        String retStr = null;
        // 编码
        String charset = "UTF-8";
        // HTTP接口地址
        String apiUrl = "http://yxapi.miaomayun.com:8080/smsapi";
        String account = "wuhujj";
        String apiKey = "570e679c021e42eebdb0c345b13e987f";
        // 手机号码
        String mobile = "18729041176";
        // 内容
        String content = "【五湖金交】验证码：879565，验证码有效期10分钟。如非本人操作，请勿理会。";

        // 接口请求参数
        Map<String, String> map = new HashMap<String, String>();

        map.put("account", account);
        map.put("mobile", mobile);
        String sign = createSign(map, apiKey);
        int mobileCount = mobile.split(",").length;

        map.put("action", "send");
        map.put("version", "2");
        map.put("content", content);
        map.put("sign", sign);
        // 可选参数
        map.put("count", String.valueOf(mobileCount));
        // map.put("reqid", "116888");
        // map.put("sendtime", "2017-04-28 16:15:58");
        // map.put("product", "1");
        // map.put("extno", "");

        retStr = JavaMmyHttpExample.doPost(apiUrl, map, charset);
        System.out.println("测试发送短信返回信息:" + retStr);
        return retStr;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(",1263016864947580930,ok,成功".split(",").length);
    }


//    实际测试发送成功返回结果：",1263016864947580930,ok,成功"
//    文档上发送成功返回结果："284,895210012,ok, %E6%88%90%E5%8A%9F"
}