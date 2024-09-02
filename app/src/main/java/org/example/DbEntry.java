package org.example;

import java.util.HashMap;
import java.util.Map;

public class DbEntry {
    HashMap<String, String> mappings;

    DbEntry() {
        this.mappings = new HashMap<String, String>();
    }

    public void addMapping(String key, String value) {
        this.mappings.put(key, value);
    }

    public void removeMapping(String key) {
        this.mappings.remove(key);
    }

    public String getMappingVal(String key) {
        return this.mappings.get(key);
    }

    public boolean hasKey(String key) {
        return this.mappings.containsKey(key);
    }

    @Override
    public String toString() {
        String entryStringBuildeString = "";
        for (Map.Entry<String, String> mapping : this.mappings.entrySet()) {
            entryStringBuildeString += String.format("%s:%s", mapping.getKey(), mapping.getValue());
        }

        return String.format("{%s}", entryStringBuildeString);
    }
}
