package com.rovermars.controller;

import com.rovermars.objects.Map;
import com.rovermars.objects.Obstacle;
import com.rovermars.objects.Rover;
import com.rovermars.services.MapService;
import com.rovermars.services.RoverService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

public class mapController {
    @PostMapping("/map_mars/create_map")
    public Map createMap(int longitude, int latitude) {
        Map newMap = MapService.createMap(longitude, latitude);
        return newMap;
    }

    @PostMapping("/map_mars/create_obstacle")
    public Obstacle createObstacle(int longitude, int latitude, Map map, Rover rover, ArrayList<Obstacle> obstacles) {
        Obstacle newObstacle = MapService.createObstacle(longitude, latitude, map, rover, obstacles);
        return newObstacle;
    }

    @PostMapping("/map_mars/delete_obstacle")
    public ArrayList<Obstacle> deleteObstacle(ArrayList<Obstacle> obstacles, Obstacle obstacle) {
        ArrayList<Obstacle> newObstaclesList = MapService.deleteObstacle(obstacles, obstacle);
        return newObstaclesList;
    }
}
