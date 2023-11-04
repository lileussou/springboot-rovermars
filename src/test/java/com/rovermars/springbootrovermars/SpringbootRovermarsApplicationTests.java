package com.rovermars.springbootrovermars;

import com.rovermars.models.Commands;

import com.rovermars.models.Directions;
import com.rovermars.objects.Rover;
import com.rovermars.services.RoverService;
import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.hamcrest.Matchers.samePropertyValuesAs;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = RoverService.class)
class SpringbootRovermarsApplicationTests {

	@Test
	void Should_Make_Rover_Turn_Right_Facing_East () {
		Rover currentRover = new Rover(1, 1, Directions.Direction.NORTH);
		Rover expectedRover = new Rover(1, 1, Directions.Direction.EAST);
		ArrayList<Commands.Command> turnRight = new ArrayList<>();
		turnRight.add(Commands.Command.RIGHT);

		Rover facingEastRover = RoverService.changeRoverPosition(currentRover, turnRight);
		Assert.assertEquals(facingEastRover.Longitude, expectedRover.Longitude);
		Assert.assertEquals(facingEastRover.Latitude, expectedRover.Latitude);
		Assert.assertEquals(facingEastRover.Facing, expectedRover.Facing);
	}

	@Test
	void Should_Make_Rover_Turn_Left_Facing_West () {
		Rover currentRover = new Rover(1, 1, Directions.Direction.NORTH);
		Rover expectedRover = new Rover(1, 1, Directions.Direction.WEST);
		ArrayList<Commands.Command> turnLeft = new ArrayList<>();
		turnLeft.add(Commands.Command.LEFT);

		Rover facingWestRover = RoverService.changeRoverPosition(currentRover, turnLeft);
		Assert.assertEquals(facingWestRover.Longitude, expectedRover.Longitude);
		Assert.assertEquals(facingWestRover.Latitude, expectedRover.Latitude);
		Assert.assertEquals(facingWestRover.Facing, expectedRover.Facing);
	}

	@Test
	void Should_Make_Rover_Turn_Left_Twice_Facing_South () {
		Rover currentRover = new Rover(1, 1, Directions.Direction.NORTH);
		Rover expectedRover = new Rover(1, 1, Directions.Direction.SOUTH);
		ArrayList<Commands.Command> turnLeftTwice = new ArrayList<>();
		turnLeftTwice.add(Commands.Command.LEFT);
		turnLeftTwice.add(Commands.Command.LEFT);

		Rover facingSouthRover = RoverService.changeRoverPosition(currentRover, turnLeftTwice);
		Assert.assertEquals(facingSouthRover.Longitude, expectedRover.Longitude);
		Assert.assertEquals(facingSouthRover.Latitude, expectedRover.Latitude);
		Assert.assertEquals(facingSouthRover.Facing, expectedRover.Facing);
	}

}
