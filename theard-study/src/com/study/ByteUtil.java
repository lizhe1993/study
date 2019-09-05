package com.study;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 二进制  处理类
 *
 * @author Administrator
 */
public class ByteUtil {

    /**
     * 二进制  和 16进制字符串的转换
     *
     * @param bytes
     * @return
     */
    public static String bytesToHexString(byte[] bytes) {
        StringBuilder stringBuilder = new StringBuilder("");
        if (bytes == null || bytes.length <= 0) {
            return null;
        }
        for (int i = 0; i < bytes.length; i++) {
            int v = bytes[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();
    }

    /**
     * 16进制字符串的转换成二进制
     *
     * @param hexString
     * @return
     */
    public static byte[] hexStringToBytes(String hexString) {
        if (hexString == null || hexString.equals("")) {
            return null;
        }
        int length = hexString.length() / 2;
        char[] hexChars = hexString.toCharArray();
        byte[] d = new byte[length];
        for (int i = 0; i < length; i++) {
            int pos = i * 2;
            d[i] = (byte) (charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1]) & 0xff);
        }
        return d;
    }

    private static byte charToByte(char c) {
        return (byte) "0123456789abcdef".indexOf(c);
    }

    public static void main(String[] args) throws Exception {
        String a = "大众化，是你的本质";
            String str = ByteUtil.bytesToHexString(a.getBytes("UTF-8"));
        System.out.println(str);
        byte[] t = ByteUtil.hexStringToBytes(str);
        System.out.println(new String(t, "UTF-8"));

        Map<String,Object> jsonResponse = new HashMap();
        jsonResponse.put("resultData",null);
        List<HashMap> resultData = (List<HashMap>)jsonResponse.get("resultData");
        System.out.println((resultData !=null && !resultData.isEmpty()));
    }


}
