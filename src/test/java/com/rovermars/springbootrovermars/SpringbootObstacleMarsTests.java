package com.rovermars.springbootrovermars;

import com.rovermars.models.Directions;
import com.rovermars.objects.Map;
import com.rovermars.objects.Obstacle;
import com.rovermars.objects.Rover;
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
        Rover rover = new Rover(2,2, Directions.Direction.NORTH);
        ArrayList<Obstacle> obstacles = new ArrayList<>();
        Obstacle expectedObstacle = new Obstacle(2,1);

        Obstacle obstacleTwoOne = MapService.createObstacle(2,1, map, rover, obstacles);
        Assert.assertEquals(expectedObstacle.Longitude, obstacleTwoOne.Longitude);
        Assert.assertEquals(expectedObstacle.Latitude, obstacleTwoOne.Latitude);
    }

    @Test
    void Should_Return_An_Error_If_Obstacle_Is_Outside_Map () throws Error{
        Map map = new Map(4, 4);
        Rover rover = new Rover(2,2, Directions.Direction.NORTH);
        ArrayList<Obstacle> obstacles = new ArrayList<>();
        Error expectedError = new Error("Error: obtacle cannot be build because coordinates are outside the map");
        Error actualError = null;

        try {
            Obstacle obstacleFourFive = MapService.createObstacle(4,5, map, rover, obstacles);
        } catch (Error error) {
            actualError = error;
        }
        Assert.assertEquals(expectedError.getMessage(), actualError.getMessage());
    }

    @Test
    void Should_Return_An_Error_If_Obstacle_Is_On_Current_Rover () throws Error{
        Map map = new Map(4, 4);
        Rover rover = new Rover(2,2, Directions.Direction.NORTH);
        ArrayList<Obstacle> obstacles = new ArrayList<>();
        Error expectedError = new Error("Error: obtacle cannot be build because coordinates are on the current rover position");
        Error actualError = null;

        try {
            Obstacle obstacleTwoTwo = MapService.createObstacle(2,2, map, rover, obstacles);
        } catch (Error error) {
            actualError = error;
        }
        Assert.assertEquals(expectedError.getMessage(), actualError.getMessage());
    }

    @Test
    void Should_Return_An_Error_If_Obstacle_Is_On_Current_Obstacle_List () throws Error{
        Map map = new Map(4, 4);
        Rover rover = new Rover(1,1, Directions.Direction.NORTH);
        ArrayList<Obstacle> obstacles = new ArrayList<>();
        obstacles.add(new Obstacle(2,3));
        obstacles.add(new Obstacle(3,4));

        Error expectedError = new Error("Error: obtacle cannot be build because an obstacle is already at those coordinates");
        Error actualError = null;

        try {
            Obstacle obstacleTwoThree = MapService.createObstacle(3,4, map, rover, obstacles);
        } catch (Error error) {
            actualError = error;
        }
        Assert.assertEquals(expectedError.getMessage(), actualError.getMessage());
    }
}
