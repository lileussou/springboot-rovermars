package com.rovermars.services;

import com.rovermars.models.Commands;
import com.rovermars.models.Directions;
import com.rovermars.objects.Rover;

import java.util.ArrayList;

public class RoverService {
    public static Rover changeRoverPosition(Rover rover, ArrayList<Commands.Command> command) {

        return new Rover(1, 1, Directions.Direction.EAST);
    }
}
