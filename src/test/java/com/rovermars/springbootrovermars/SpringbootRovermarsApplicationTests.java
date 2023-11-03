package com.rovermars.springbootrovermars;

import com.rovermars.models.Commands;

import com.rovermars.models.Directions;
import com.rovermars.objects.Rover;
import com.rovermars.services.RoverService;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.hamcrest.Matchers.samePropertyValuesAs;

@SpringBootTest(classes = RoverService.class)
class SpringbootRovermarsApplicationTests {

	@Test
	void Should_Make_Rover_Turn_Right_Facing_East () {
		Rover currentRover = new Rover(1, 1, Directions.Direction.NORTH);
		Rover expectedRover = new Rover(1, 1, Directions.Direction.EAST);
		ArrayList<Commands.Command> turnRight = new ArrayList<>();
		turnRight.add(Commands.Command.RIGHT);

		Rover facingEastRover = RoverService.changeRoverPosition(currentRover, turnRight);
		MatcherAssert.assertThat(expectedRover, samePropertyValuesAs(facingEastRover));
	}

}
