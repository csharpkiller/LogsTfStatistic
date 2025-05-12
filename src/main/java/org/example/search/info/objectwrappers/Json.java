package org.example.search.info.objectwrappers;

/**
 * Обертка над String Json
 */
public class Json {

    /**
     * Json в String
     */
    private final String value;

    public Json(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
