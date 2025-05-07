package org.example.search.info.containers;

/**
 * Обертка над String Json
 */
public class Json {

    private final String value;

    public Json(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }

    public static Json valueOf(String json) {
        if (json == null) {
            throw new IllegalArgumentException("JSON string cannot be null");
        }
        return new Json(json);
    }
}
