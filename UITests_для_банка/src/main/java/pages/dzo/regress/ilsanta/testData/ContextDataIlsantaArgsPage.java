package pages.dzo.regress.ilsanta.testData;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class ContextDataIlsantaArgsPage {

    private static final String ZIO_PLACE = "//*[@class='plantuml-schema']";

    public static Stream<Arguments> getPageSchemasData() {
        return Stream.of(
                Arguments.of("//*[text()[normalize-space(.)='Заказ']]", ZIO_PLACE,
                        "Схема не отображается"),
                Arguments.of("//*[text()[normalize-space(.)='Запись звонка']]", ZIO_PLACE,
                        "Схема не отображается"),
                Arguments.of("//*[text()[normalize-space(.)='Запись на услугу']]", ZIO_PLACE,
                        "Схема не отображается"),
                Arguments.of("//*[text()[normalize-space(.)='Информация о враче']]", ZIO_PLACE,
                        "Схема не отображается"),
                Arguments.of("//*[text()[normalize-space(.)='Информация о клинике']]", ZIO_PLACE,
                        "Схема не отображается"),
                Arguments.of("//*[text()[normalize-space(.)='Информация о юр.лице']]", ZIO_PLACE,
                        "Схема не отображается"),
                Arguments.of("//*[text()[normalize-space(.)='История посещений']]", ZIO_PLACE,
                        "Схема не отображается"),
                Arguments.of("//*[text()[normalize-space(.)='Контракты с контрагентами']]", ZIO_PLACE,
                        "Схема не отображается"),
                Arguments.of("//*[text()[normalize-space(.)='Логи']]", ZIO_PLACE,
                        "Схема не отображается"),
                Arguments.of("//*[text()[normalize-space(.)='Медицинские данные о наблюдении пациента']]", ZIO_PLACE,
                        "Схема не отображается"),
                Arguments.of("//*[text()[normalize-space(.)='Медицинские данные о приеме']]", ZIO_PLACE,
                        "Схема не отображается"),
                Arguments.of("//*[text()[normalize-space(.)='Мониторинг']]", ZIO_PLACE,
                        "Схема не отображается"),
                Arguments.of("//*[text()[normalize-space(.)='Номер телефона клиента']]", ZIO_PLACE,
                        "Схема не отображается"),
                Arguments.of("//*[text()[normalize-space(.)='Персональные данные клиента']]", ZIO_PLACE,
                        "Схема не отображается"),
                Arguments.of("//*[text()[normalize-space(.)='Расписание приема']]", ZIO_PLACE,
                        "Схема не отображается"),
                Arguments.of("//*[text()[normalize-space(.)='Сборки клиентских приложений']]", ZIO_PLACE,
                        "Схема не отображается"),
                Arguments.of("//*[text()[normalize-space(.)='События аудита']]", ZIO_PLACE,
                        "Схема не отображается"),
                Arguments.of("//*[text()[normalize-space(.)='Токен авторизации']]", ZIO_PLACE,
                        "Схема не отображается")
        );
    }
}
