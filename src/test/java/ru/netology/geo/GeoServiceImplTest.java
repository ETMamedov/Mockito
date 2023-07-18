package ru.netology.geo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.netology.entity.Country;
import ru.netology.entity.Location;

import java.util.stream.Stream;

public class GeoServiceImplTest {

    GeoServiceImpl geoService;

    @BeforeEach
    public void test(){
       geoService  = new GeoServiceImpl();
    }

    @ParameterizedTest
    @MethodSource("testParams")
    void byIpTest(Location expected, String ip){
        //act
        Location result = geoService.byIp(ip);
        //assert
        Assertions.assertEquals(expected, result);
    }
    public static Stream<Arguments>testParams(){
        return Stream.of(Arguments.of(new Location("New York", Country.USA, " 10th Avenue", 32), "96.44.183.149"));
    }



}
