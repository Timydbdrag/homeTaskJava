package homeTask.thirteen;

import org.apache.commons.lang3.builder.ToStringStyle;

public class ApiConstant {
    /**
     * ToStringStyle по умолчанию, используемый методами toString.
     * Переопределяем чтобы изменить выходной формат переопределенных методов toString.
     * - Пример ToStringStyle.JSON_STYLE
     */
    public static ToStringStyle TO_STRING_BUILDER_STYLE = ToStringStyle.SHORT_PREFIX_STYLE;

    public static final String BASE_URL = "https://ru.wikipedia.org";
}
