package com.rovermars.services;

import com.rovermars.objects.Map;
import com.rovermars.objects.Obstacle;

public class MapService {
    public static Map createMap(int longitude, int latitude) {
        if (longitude == 0 || latitude == 0) {
            throw new Error("Error: map cannot be build");
        }
        return new Map(longitude, latitude);
    }

    public static Obstacle createObstacle(int longitude, int latitude, Map map) {
        if (longitude > map.Longitude
                || latitude > map.Latitude) {
            throw new Error("Error: obtacle cannot be build because coordinates are outside the map");
        }
        return new Obstacle(2, 1);
    }
}
