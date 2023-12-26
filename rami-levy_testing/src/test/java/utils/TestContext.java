package utils;

import test.enums.Enums;

import java.util.HashMap;

public class TestContext {

    private HashMap<String, Object> context = new HashMap<>();

    public void put(Enums key, Object obj){
        context.put(key.toString(),obj);
    }

    public <T> T get(Enums key){
        Object o = context.get(key.toString());
        if(o==null){
            return null;
        }else{
            return (T)o;
        }
    }

    public void clear() {
        context=new HashMap<>();
    }
}