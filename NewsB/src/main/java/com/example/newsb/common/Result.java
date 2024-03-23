package com.example.newsb.common;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Result {
    private String code;
    private String msg;
    private Map<String,Object> data =new HashMap<>();
    public static Result ok(){
        Result r= new Result();
        r.setCode("200");
        r.setMsg("成功");
        return r;
    }
    public static Result fail(){
        Result r= new Result();
        r.setCode("900");
        r.setMsg("失败");
        return r;
    }
    public static Result error(String code,String msg){
        Result r= new Result();
        r.setCode(code);
        r.setMsg(msg);
        return r;
    }

    public   Result data(String key,Object value){
        this.data.put(key,value);
        return this;
    }
    public   Result appenddata(String key1,Object value1,String key2,Object value2){
        this.data.put(key1,value1);
        this.data.put(key2,value2);
        return this;
    }

}
