package org.example;

import java.util.HashMap;

public class Db implements iDb {

    private HashMap<String, HashMap<String, String>> data;

    public Db() {
        data = new HashMap<String, HashMap<String, String>>();
    }

    public void set(String namespace, String key, String val) {
        if (!data.containsKey(namespace)) {
            data.put(namespace, new HashMap<String, String>());
        }
        data.get(namespace).put(key, val);
    }

    public String get(String namespace, String key) {
        if (!data.containsKey(namespace) || !data.get(namespace).containsKey(key)) {
            return null;
        }
        return data.get(namespace).get(key);
    }

    public void delete(String namespace, String key) {
        if (!data.containsKey(namespace) || !data.get(namespace).containsKey(key)) {
            return;
        }
        data.get(namespace).remove(key);
    }
}
