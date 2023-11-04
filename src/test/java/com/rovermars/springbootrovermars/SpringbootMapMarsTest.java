package com.rovermars.springbootrovermars;

import com.rovermars.models.Commands;
import com.rovermars.models.Directions;
import com.rovermars.objects.Map;
import com.rovermars.objects.Rover;
import com.rovermars.services.MapService;
import com.rovermars.services.RoverService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest(classes = MapService.class)
public class SpringbootMapMarsTest {
    @Test
    void Should_Create_1_x_1_map () {
        Map expectedMap = new Map(1, 1);

        Map actualMap = MapService.createMap(1, 1);
        Assert.assertEquals(expectedMap.Longitude, actualMap.Longitude);
        Assert.assertEquals(expectedMap.Latitude, actualMap.Latitude);
    }
}
