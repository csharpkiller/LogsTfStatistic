package org.example.search.info.DTO;

/**
 * В частных случаях отслеживаем потерялась ли информация при парсинге, допустим битый Json
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
