package org.example.search.info.objectwrappers;

/**
 * Обертка над String Json
 */
public class Json {

    private final String value; // Json String

    public Json(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
