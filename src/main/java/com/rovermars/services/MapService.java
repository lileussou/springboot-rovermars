package com.rovermars.services;

import com.rovermars.objects.Map;

public class MapService {
    public static Map createMap(int longitude, int latitude) {
        if(longitude == 0 || latitude == 0) {
            throw new Error("Error: map cannot be build");
        }
        return new Map(longitude, latitude);
    }
}
