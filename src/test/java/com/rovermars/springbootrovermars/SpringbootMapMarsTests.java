package com.rovermars.springbootrovermars;

import com.rovermars.objects.Map;
import com.rovermars.services.MapService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = MapService.class)
public class SpringbootMapMarsTests {
    @Test
    void Should_Create_1_x_1_map () {
        Map expectedMap = new Map(1, 1);

        Map actualMap = MapService.createMap(1, 1);
        Assert.assertEquals(expectedMap.Longitude, actualMap.Longitude);
        Assert.assertEquals(expectedMap.Latitude, actualMap.Latitude);
    }

    @Test
    void Should_Create_5_x_5_map () {
        Map expectedMap = new Map(5, 5);

        Map actualMap = MapService.createMap(5, 5);
        Assert.assertEquals(expectedMap.Longitude, actualMap.Longitude);
        Assert.assertEquals(expectedMap.Latitude, actualMap.Latitude);
    }

    @Test
    void Should_Create_0_x_0_map () throws Error {
        Error expectedError = new Error("Error: map cannot be build");
        Error actualError = null;

        try {
            Map actualMap = MapService.createMap(0, 0);
        } catch (Error error) {
            actualError = error;
        }
        Assert.assertEquals(expectedError.getMessage(), actualError.getMessage());
    }
}
