package com.rovermars.services;

import com.rovermars.models.Commands;
import com.rovermars.models.Directions;
import com.rovermars.objects.Map;
import com.rovermars.objects.Rover;

import java.util.ArrayList;


public class RoverService {

    public static Rover createRover() {
        return new Rover(1, 1, Directions.Direction.NORTH);
    }
    public static Rover changeRoverPosition(Rover rover, ArrayList<Commands.Command> commands, Map map) {

        ArrayList<Directions.Direction> directions = Directions.Direction.getValue();

        for (Commands.Command command : commands) {
            if (command.equals(Commands.Command.LEFT)) {
                int currentPositionIndex = directions.indexOf(rover.Facing);
                int newPositionIndex = currentPositionIndex == 0 ? directions.toArray().length - 1 : currentPositionIndex - 1;
                Directions.Direction newFacing = directions.get(newPositionIndex);
                rover.setFacing(newFacing);
            }
            if (command.equals(Commands.Command.RIGHT)) {
                int currentPositionIndex = directions.indexOf(rover.Facing);
                int newPositionIndex = currentPositionIndex == 3 ? 0 : currentPositionIndex + 1;
                Directions.Direction newFacing = directions.get(newPositionIndex);
                rover.setFacing(newFacing);
            }
            if (command.equals(Commands.Command.FORWARD)) {
                switch (rover.Facing) {
                    case NORTH :
                        rover.setLatitude(rover.Latitude+1);
                        break;
                    case EAST :
                        rover.setLongitude(rover.Longitude+1);
                        break;
                    case SOUTH :
                        rover.setLatitude(rover.Latitude-1);
                        break;
                    case WEST :
                        rover.setLongitude(rover.Longitude-1);
                        break;
                }
            }
            if (command.equals(Commands.Command.BACKWARD)) {
                switch (rover.Facing) {
                    case NORTH:
                        rover.setLatitude(rover.Latitude - 1);
                        break;
                    case EAST:
                        rover.setLongitude(rover.Longitude - 1);
                        break;
                    case SOUTH:
                        rover.setLatitude(rover.Latitude + 1);
                        break;
                    case WEST:
                        rover.setLongitude(rover.Longitude + 1);
                        break;
                }
            }
            checkIfRoverMoveOutOfEdge(rover, map);
        }
        return rover;
    }

    public static Rover checkIfRoverMoveOutOfEdge(Rover rover, Map map) {
        if (rover.Longitude > map.Longitude) {
            rover.setLongitude(1);
        }
        if (rover.Longitude < 1) {
            rover.setLongitude(map.Longitude);
        }
        if (rover.Latitude > map.Latitude) {
            rover.setLatitude(1);
        }
        if (rover.Latitude < 1) {
            rover.setLatitude(map.Latitude);
        }
        return rover;
    }

    public static int angleBasedOnRoverDirection(Directions.Direction facing) {
        int roverAngle = 0;
        switch (facing) {
            case EAST :
                roverAngle = 90;
                break;
            case SOUTH :
                roverAngle = 180;
                break;
            case WEST :
                roverAngle = 270;
                break;
        }
        return roverAngle;
    }
}
