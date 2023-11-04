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
		Assert.assertEquals(expectedRover.Longitude, facingEastRover.Longitude);
		Assert.assertEquals(expectedRover.Latitude, facingEastRover.Latitude);
		Assert.assertEquals(expectedRover.Facing, facingEastRover.Facing);
	}

	@Test
	void Should_Make_Rover_Turn_Left_Facing_West () {
		Rover currentRover = new Rover(1, 1, Directions.Direction.NORTH);
		Rover expectedRover = new Rover(1, 1, Directions.Direction.WEST);
		ArrayList<Commands.Command> turnLeft = new ArrayList<>();
		turnLeft.add(Commands.Command.LEFT);

		Rover facingWestRover = RoverService.changeRoverPosition(currentRover, turnLeft);
		Assert.assertEquals(expectedRover.Longitude, facingWestRover.Longitude);
		Assert.assertEquals(expectedRover.Latitude, facingWestRover.Latitude);
		Assert.assertEquals(expectedRover.Facing, facingWestRover.Facing);
	}

	@Test
	void Should_Make_Rover_Turn_Left_Twice_Facing_South () {
		Rover currentRover = new Rover(1, 1, Directions.Direction.NORTH);
		Rover expectedRover = new Rover(1, 1, Directions.Direction.SOUTH);
		ArrayList<Commands.Command> turnLeftTwice = new ArrayList<>();
		turnLeftTwice.add(Commands.Command.LEFT);
		turnLeftTwice.add(Commands.Command.LEFT);

		Rover facingSouthRover = RoverService.changeRoverPosition(currentRover, turnLeftTwice);
		Assert.assertEquals(expectedRover.Longitude, facingSouthRover.Longitude);
		Assert.assertEquals(expectedRover.Latitude, facingSouthRover.Latitude);
		Assert.assertEquals(expectedRover.Facing, facingSouthRover.Facing);
	}

	@Test
	void Should_Make_Rover_Move_Forward_Facing_North () {
		Rover currentRover = new Rover(1, 1, Directions.Direction.NORTH);
		Rover expectedRover = new Rover(1, 2, Directions.Direction.NORTH);
		ArrayList<Commands.Command> moveForward = new ArrayList<>();
		moveForward.add(Commands.Command.UP);

		Rover facingNorthRover = RoverService.changeRoverPosition(currentRover, moveForward);
		Assert.assertEquals(expectedRover.Longitude, facingNorthRover.Longitude);
		Assert.assertEquals(expectedRover.Latitude, facingNorthRover.Latitude);
		Assert.assertEquals(expectedRover.Facing, facingNorthRover.Facing);
	}
}
