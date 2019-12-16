package com.boschchicagoconnectory.takehome.joan1stProblem.util;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Map;

public class JoinArrays {
    private Map jsonArray;
    private JSONArray jArr;

    public JoinArrays(Map jsonArray, JSONArray jArr){
        this.jsonArray = jsonArray;
        this.jArr = jArr;
    }

    public void join(){
        jArr.forEach(item -> {
            JSONObject jsonObj = (JSONObject) item;
            int key = jsonObj.getInt("ISBN");
            if(jsonArray.get(key) != null){
                JSONObject obj = (JSONObject)jsonArray.get(key);
                int qty = Integer.parseInt((jsonObj.opt("Qty.").toString()).trim());
                obj.put("Qty.", obj.getInt("Qty.") + qty);

            }else{
                jsonArray.put(key, item);
            }
        });
    }
}
