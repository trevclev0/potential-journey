package org.example;

import java.util.HashMap;
import java.util.Map;

public class Db implements iDb {

    private HashMap<String, DbTable> data;

    public Db() {
        data = new HashMap<String, DbTable>();
    }

    public void set(String namespace, String key, String val) {
        DbTable table;
        DbEntry entry;

        if (!data.containsKey(namespace)) {
            table = new DbTable(namespace);
            data.put(namespace, table);
        } else {
            table = data.get(namespace);
        }

        if (!table.hasEntry(key)) {
            entry = new DbEntry(key, val);
            table.addEntry(entry);
        } else {
            entry = table.getEntry(key);
        }

        entry.setValue(val);
    }

    public String get(String namespace, String key) {
        if (!data.containsKey(namespace) || !data.get(namespace).hasEntry(key)) {
            return null;
        }
        return data.get(namespace).getEntry(key).getValue();
    }

    public void delete(String namespace, String key) {
        DbTable table;
        DbEntry entry;
        if (!data.containsKey(namespace)) {
            return;
        }
        table = data.get(namespace);

        if (!table.hasEntry(key)) {
            return;
        }
        entry = table.getEntry(key);

        table.removeEntry(entry);
    }

    public String getAll(String namespace) {
        if (!data.containsKey(namespace)) {
            return "";
        }
        return "";
    }

    public String getAll(String namespace, String prefix) {
        if (!data.containsKey(namespace)) {
            return "";
        }
        return "";
    }

    @Override
    public String toString() {
        String dataStr = "";
        for (Map.Entry<String, DbTable> table : data.entrySet()) {
            dataStr += table.toString();
        }

        return String.format("The current db table: %s", dataStr);
    }
}
