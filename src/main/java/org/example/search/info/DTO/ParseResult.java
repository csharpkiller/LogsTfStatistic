package org.example.search.info.DTO;

/**
 * В случае, если произошла ошибка парсинга, хочу передать это состояние вглубь для дальнейшей обработки.
 * Я видел мнение в интернете, что так делать не очень хорошо.
 * Но в данной ситуации я считаю это хорошим решением, прокидывать ошибку вглубь в падлу, словить и проверить if-ом намного легче,
 * удобнее и интуитивно понятнее.
 */
public class ParseResult<T> {

    /**
     * Результат парсинга
     */
    private final T resultData;

    /**
     * Не удалось запарсить?
     */
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
