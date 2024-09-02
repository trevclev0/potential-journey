package org.example;

public class DbEntry {
    private String key;
    private String value;

    DbEntry(String key, String value) {
        this.setKey(key);
        this.setValue(value);
    }

    public String getKey() {
        return this.key;
    }

    public String getValue() {
        return this.value;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }

        return this.key == ((DbEntry) obj).key;
    }

    @Override
    public String toString() {
        return String.format("%s: %s", key, value);
    }
}
