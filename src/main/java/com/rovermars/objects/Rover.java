package com.rovermars.objects;

import com.rovermars.models.Directions;

public class Rover {
    public int Longitude;
    public int Latitude;
    public Directions.Direction Facing;

    public Rover(int longitude, int latitude, Directions.Direction facing) {
        Longitude = longitude;
        Latitude = latitude;
        Facing = facing;
    }
}
