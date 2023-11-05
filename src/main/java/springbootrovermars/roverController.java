package springbootrovermars;

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
    @PostMapping("/roverMars/createRover")
    public Rover createRover() {
        Rover newRover = RoverService.createRover();
        return newRover;
    }

    @PostMapping("/roverMars/changeRoverDirection")
    public Rover changeRoverDirection(Rover rover, ArrayList<Commands.Command> commands, Map map) {
        Rover newRoverPosition = RoverService.changeRoverPosition(rover, commands, map);
        return newRoverPosition;
    }

    @PostMapping("/roverMars/getAngle")
    public Integer getAngleBasedOnRoverFacing(Rover rover) {
        int newRoverAngle = RoverService.angleBasedOnRoverDirection(rover.Facing);
        return newRoverAngle;
    }
}
