package com.rovermars.services;

import com.rovermars.objects.Map;
import com.rovermars.objects.Obstacle;
import com.rovermars.objects.Rover;

import java.util.ArrayList;

public class MapService {
    public static Map createMap(int longitude, int latitude) {
        if (longitude == 0 || latitude == 0) {
            throw new Error("Error: map cannot be build");
        }
        return new Map(longitude, latitude);
    }

    public static Obstacle createObstacle(int longitude, int latitude, Map map, Rover rover, ArrayList<Obstacle> obstacles) {
        if (longitude > map.Longitude
                || latitude > map.Latitude) {
            throw new Error("Error: obtacle cannot be build because coordinates are outside the map");
        }
        if (rover.Longitude == longitude
                && rover.Latitude == latitude) {
            throw new Error("Error: obtacle cannot be build because coordinates are on the current rover position");
        }
        if (obstacles.stream().anyMatch(obstacle -> obstacle.Longitude == longitude
                && obstacle.Latitude == latitude)) {
            throw new Error("Error: obtacle cannot be build because an obstacle is already at those coordinates");

        }
        return new Obstacle(longitude, latitude);
    }
}
