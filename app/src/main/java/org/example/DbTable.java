package org.example;

import java.util.LinkedList;

public class DbTable {
    public String namespace;
    public LinkedList<DbEntry> entries;

    DbTable(String namespace) {
        this.namespace = namespace;
        this.entries = new LinkedList<DbEntry>();
    }

    public boolean hasEntry(String key) {
        for (DbEntry entry : this.entries) {
            if (entry.getKey().equals(key)) {
                return true;
            }
        }
        return false;
    }

    public DbEntry getEntry(String key) {
        for (DbEntry entry : this.entries) {
            if (entry.getKey().equals(key)) {
                return entry;
            }
        }
        return null;
    }

    public void addEntry(DbEntry entry) {
        entries.add(entry);
    }

    public void removeEntry(DbEntry entry) {
        entries.remove(entry);
    }

    @Override
    public String toString() {
        String entriesStr = "";

        for (DbEntry entry : this.entries) {
            entriesStr += entry.toString();
        }

        return String.format("[%s]", entriesStr);
    }
}
