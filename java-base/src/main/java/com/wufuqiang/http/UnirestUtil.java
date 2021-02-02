package com.wufuqiang.http;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;
import kong.unirest.GetRequest;
import kong.unirest.HttpRequestWithBody;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Builder
@Slf4j
public class UnirestUtil {

    //url的前缀
    private String urlPrefix;
    //
    private String responseBody;
    //连接超时时间
    private int connectionTimeout = 60000;

    //socket超时时间
    private int socketTimeout = 60000;

    //请求头，默认请求头
    private Map<String,String> header;

    //Content-Type: application/json
    // 请求头
    private static Map<String,String> headerJson;
    //Content-Type: application/x-www-form-urlencoded
    //请求头
    private static Map<String,String> headerForm;


    static {
        headerJson = new HashMap<String, String>() {{
            put("Content-Type", "application/json");
        }};
        headerForm = new HashMap<String, String>() {{
            put("Content-Type", "application/x-www-form-urlencoded");
        }};
    }

    /**
     * get请求
     * @param url 接口
     * @param params 参数
     * @param headers 请求头信息
     * @return
     */
    public UnirestUtil get(String url,Map<String,String> params,Map<String,String> headers){
        url = addPrefix(url);
        GetRequest getRequest = Unirest.get(url);
        if(params != null){
            for(String paramKey:params.keySet()){
                getRequest.queryString(paramKey,params.get(paramKey));
            }
        }
        if(headers != null){
            for(String headerKey:headers.keySet()){
                getRequest.header(headerKey,headers.get(headerKey));
            }
        }
        getRequest.header("Accept","application/json");
        HttpResponse<String> response = getRequest.asString();
        this.responseBody = response.getBody();
        return this;
    }

    /**
     * post请求
     * @param url
     * @param data
     * @param headers
     * @return
     */
    public UnirestUtil post(String url ,Map<String,String> data,Map<String,String> headers){
        url = addPrefix(url);
        HttpRequestWithBody httpRequestWithBody = Unirest.post(url)
                .connectTimeout(this.connectionTimeout)
                .socketTimeout(this.socketTimeout)
                .header("Content-Type", "application/json")
                .header("Accept", "application/json");
        if (headers != null) {
            for (String s : headers.keySet()) {
                httpRequestWithBody.header(s, headers.get(s));
            }
        }
        if (data != null) {
            for (String s : data.keySet()) {
                httpRequestWithBody.field(s, data.get(s));
            }
        }
        responseBody = httpRequestWithBody.asString().getBody();
        return this;
    }

    /**
     *
     * @param url
     * @param query
     * @param body
     * @return
     */
    public UnirestUtil body(String url, Map<String, String> query, String body) {
        url = addPrefix(url);
        HttpRequestWithBody httpRequestWithBody = Unirest.post(url);
        httpRequestWithBody.header("Content-Type", "application/json");
        httpRequestWithBody.header("Accept", "application/json");
        if (query != null) {
            for (String s : query.keySet()) {
                httpRequestWithBody.queryString(s, query.get(s));
            }
        }
        responseBody = httpRequestWithBody.body(body).asString().getBody();
        return this;
    }

    public UnirestUtil body(String url,Object obj){
        url = addPrefix(url);
        HttpRequestWithBody httpRequestWithBody = Unirest.post(url);
        httpRequestWithBody.header("Content-Type", "application/json");
        httpRequestWithBody.header("Accept", "application/json");
        responseBody = httpRequestWithBody.body(obj).asString().getBody();
        return this;
    }

    public UnirestUtil body(String url, Map<String, String> query, Map<String, String> body) {
        url = addPrefix(url);
        HttpRequestWithBody httpRequestWithBody = Unirest.post(url);
        httpRequestWithBody.header("Content-Type", "application/json");
        httpRequestWithBody.header("Accept", "application/json");
        if (query != null && query.size() > 0) {
            for (String s : query.keySet()) {
                httpRequestWithBody.queryString(s, query.get(s));
            }
        }
        responseBody = httpRequestWithBody.body(body).asString().getBody();
        return this;
    }

    public UnirestUtil delete(String url, Map<String, String> body) {
        url = addPrefix(url);
        if (body !=null) {
            responseBody = Unirest.delete(url).body(body).asString().getBody();
        } else {
            responseBody = Unirest.delete(url).asString().getBody();
        }
        return this;
    }

    /**
     * 为url添加前缀
     * @param url
     * @return
     */
    private String addPrefix(String url){
        if(urlPrefix != null){
            url = urlPrefix+url;
        }
        return url;
    }

    /**
     * 将返回信息转成JSON
     * @return
     */
    public JSONObject asJson(){
        JSONObject result = JSONObject.parseObject(this.responseBody,new TypeReference<JSONObject>(){
        }, Feature.OrderedField);
        return result;
    }


}
