package com.rovermars.services;

import com.rovermars.objects.Map;

public class MapService {
    public static Map createMap(int longitude, int latitude) {
        return new Map(1, 1);
    }
}
