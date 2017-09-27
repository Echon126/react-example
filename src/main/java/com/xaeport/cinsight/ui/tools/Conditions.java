package com.xaeport.cinsight.ui.tools;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 邮箱查询条件凭借
 * Created by zwj on 2017/6/1.
 */
@Component
public class Conditions {
    public List getList(String[] str, String[] strName) {
        List list = new ArrayList();
        Map map = null;
        for (int i = 0; i < str.length; i++) {
            map = new HashMap();
            map.put("relation", "and");
            map.put("keyword", strName[i]);
            if (strName[i].equals("content") || strName[i].equals("subject")) {
                map.put("expression", "like");
            } else {
                map.put("expression", "=");
            }
            map.put("result", str[i]);
            list.add(map);
        }
        return list;
    }
}
