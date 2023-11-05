package com.rovermars.springbootrovermars;

import com.rovermars.objects.Map;
import com.rovermars.objects.Obstacle;
import com.rovermars.services.MapService;
import com.rovermars.services.RoverService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = MapService.class)
public class SpringbootObstacleMarsTests {
    @Test
    void Should_Create_An_Obstacle () {
        Map map = new Map(4, 4);
        Obstacle expectedObstacle = new Obstacle(2,1);

        Obstacle obstacleTwoOne = MapService.createObstacle(2,1, map);
        Assert.assertEquals(expectedObstacle.Longitude, obstacleTwoOne.Longitude);
        Assert.assertEquals(expectedObstacle.Latitude, obstacleTwoOne.Latitude);
    }

    @Test
    void Should_Return_An_Error_If_Obstacle_Is_Outside_Map () throws Error{
        Map map = new Map(4, 4);
        Error expectedError = new Error("Error: obtacle cannot be build because coordinates are outside the map");
        Error actualError = null;

        try {
            Obstacle obstacleFourFive = MapService.createObstacle(4,5, map);
        } catch (Error error) {
            actualError = error;
        }
        Assert.assertEquals(expectedError.getMessage(), actualError.getMessage());
    }
}
