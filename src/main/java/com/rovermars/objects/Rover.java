package com.rovermars.objects;

import com.rovermars.models.Directions;

public class Rover {
    int Longitude;
    int Latitude; 
    Directions.Direction Facing;

    public Rover(int longitude, int latitude, Directions.Direction facing) {
        Longitude = longitude;
        Latitude = latitude;
        Facing = facing;
    }
}
