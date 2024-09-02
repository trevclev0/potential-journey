package org.example;

public interface iDb {
    public void set(String namespace, String key, String val);

    public String get(String namespace, String key);

    public void delete(String namespace, String key);
}
