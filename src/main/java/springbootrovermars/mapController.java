package springbootrovermars;

import com.rovermars.objects.Map;
import com.rovermars.objects.Obstacle;
import com.rovermars.objects.Rover;
import com.rovermars.services.MapService;
import com.rovermars.services.RoverService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

public class mapController {
    @PostMapping("/mapMars/createMap")
    public Map createMap(int longitude, int latitude) {
        Map newMap = MapService.createMap(longitude, latitude);
        return newMap;
    }

    @PostMapping("/mapMars/createObstacle")
    public Obstacle createObstacle(int longitude, int latitude, Map map, Rover rover, ArrayList<Obstacle> obstacles) {
        Obstacle newObstacle = MapService.createObstacle(longitude, latitude, map, rover, obstacles);
        return newObstacle;
    }

    @PostMapping("/mapMars/deleteObstacle")
    public ArrayList<Obstacle> deleteObstacle(ArrayList<Obstacle> obstacles, Obstacle obstacle) {
        ArrayList<Obstacle> newObstaclesList = MapService.deleteObstacle(obstacles, obstacle);
        return newObstaclesList;
    }
}
