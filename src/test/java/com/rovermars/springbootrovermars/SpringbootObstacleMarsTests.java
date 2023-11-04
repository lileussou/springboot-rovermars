package com.rovermars.springbootrovermars;

import com.rovermars.objects.Obstacle;
import com.rovermars.services.MapService;
import com.rovermars.services.RoverService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = MapService.class)
public class SpringbootObstacleMarsTests {
    @Test
    void Should_Create_An_Obstacle () {
        Obstacle expectedObstacle = new Obstacle(2,1);

        Obstacle obstacleTwoOne = MapService.createObstacle(2,1);
        Assert.assertEquals(expectedObstacle.Longitude, obstacleTwoOne.Longitude);
        Assert.assertEquals(expectedObstacle.Latitude, obstacleTwoOne.Latitude);
    }
}
