package org.example.search.info.DTO;

/**
 * В случае, если произошла ошибка парсинга, хочу передать это состояние вглубь для дальнейшей обработки
 */
public class ParseResult<T> {
    private final T resultData;
    private final Boolean isMissingData;

    public ParseResult(T resultData, Boolean isMissingData) {
        this.resultData = resultData;
        this.isMissingData = isMissingData;
    }

    public T getResultData() {
        return resultData;
    }

    public Boolean getMissingData() {
        return isMissingData;
    }
}
