package org.example.search.info.DTO;

/**
 * В случае, если произошла ошибка парсинга, хочу передать это состояние вглубь для дальнейшей обработки.
 * Я видел мнение в интернете, что так делать не очень хорошо.
 * Но в данной ситуации я считаю это хорошим решением, прокидывать ошибку вглубь в падлу, словить и проверить if-ом намного легче,
 * удобнее и интуитивно понятнее.
 */
public class ParseResult<T> {

    private final T resultData; // результат парсинга
    private final Boolean isMissingData; // не удалось запарсить?

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
