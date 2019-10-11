package com.dev.ck;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class HttpTransfer {
    public static void main(String[] args) throws Exception {
        //테스트 파라미터
        String strUrl = "http://localhost:8080/postsend";
        //선언
        HttpURLConnection urlConnection = null;
        URL url = null;
        InputStream is = null;
        StringBuffer str = null;
        BufferedReader br = null;
        String buf = null;

        //파라미터 셋팅
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("user","chunkind");
        params.put("pwd","wnstjd");

        //파라미터 엔코딩
        StringBuilder postData = new StringBuilder();
        for(Map.Entry<String, Object> param : params.entrySet()){
            if(postData.length() != 0) postData.append("&");
            postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
            postData.append("=");
            postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
        }
        byte[] postDataBytes = postData.toString().getBytes("UTF-8");
        url = new URL(strUrl);
        urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.setDoInput(true);
        urlConnection.setDoOutput(true);
        urlConnection.setRequestMethod("POST");
        urlConnection.setUseCaches(false);
        urlConnection.setDefaultUseCaches(false);
        urlConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        urlConnection.setConnectTimeout(10000);

        urlConnection.getOutputStream().write(postDataBytes);

        is = urlConnection.getInputStream();
        str = new StringBuffer();
        br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
        while( (buf=br.readLine()) != null){
            str.append(buf + "\n");
        }
        br.close();

        System.out.println(str);

    }
}
