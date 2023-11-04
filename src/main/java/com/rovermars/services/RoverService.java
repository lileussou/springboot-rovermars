package com.rovermars.services;

import com.rovermars.models.Commands;
import com.rovermars.models.Directions;
import com.rovermars.objects.Rover;

import java.util.ArrayList;


public class RoverService {
    public static Rover changeRoverPosition(Rover rover, ArrayList<Commands.Command> commands) {

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
            if (command.equals(Commands.Command.UP)) {
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
            if (command.equals(Commands.Command.DOWN)) {
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
        }
        return rover;
    }
}
