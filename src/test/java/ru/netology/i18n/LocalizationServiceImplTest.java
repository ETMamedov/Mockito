package ru.netology.i18n;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.netology.entity.Country;

import java.util.stream.Stream;

public class LocalizationServiceImplTest {

    LocalizationService localizationService;
    @BeforeEach
    public void test(){
        localizationService = new LocalizationServiceImpl();
    }

    @ParameterizedTest
    @MethodSource("testParams")
    void localeTest(String expected, Country country){
        //act
        String result = localizationService.locale(country);
        //assert
        Assertions.assertEquals(expected, result);
    }
    public static Stream<Arguments>testParams(){
        return Stream.of(Arguments.of("Welcome", Country.USA));
    }
}
