package com.rovermars.controller;

import com.rovermars.models.Commands;
import com.rovermars.models.Directions;
import com.rovermars.objects.Map;
import com.rovermars.objects.Rover;
import com.rovermars.services.RoverService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class roverController {
    @PostMapping("/rover_mars/create_rover")
    public Rover createRover() {
        return RoverService.createRover();
    }

    @PostMapping("/rover_mars/change_rover_direction")
    public Rover changeRoverDirection(Rover rover, ArrayList<Commands.Command> commands, Map map) {
        Rover newRoverPosition = RoverService.changeRoverPosition(rover, commands, map);
        return newRoverPosition;
    }

    @PostMapping("/rover_mars/get_angle")
    public Integer getAngleBasedOnRoverFacing(Rover rover) {
        int newRoverAngle = RoverService.angleBasedOnRoverDirection(rover.Facing);
        return newRoverAngle;
    }
}
