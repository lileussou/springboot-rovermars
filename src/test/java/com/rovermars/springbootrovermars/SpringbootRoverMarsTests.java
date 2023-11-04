package com.rovermars.springbootrovermars;

import com.rovermars.models.Commands;

import com.rovermars.models.Directions;
import com.rovermars.objects.Map;
import com.rovermars.objects.Rover;
import com.rovermars.services.RoverService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = RoverService.class)
class SpringbootRoverMarsTests {

	@Test
	void Should_Make_Rover_Turn_Right_Facing_East () {
		Map map = new Map(5,5);
		Rover currentRover = new Rover(1, 1, Directions.Direction.NORTH);
		Rover expectedRover = new Rover(1, 1, Directions.Direction.EAST);
		ArrayList<Commands.Command> turnRight = new ArrayList<>();
		turnRight.add(Commands.Command.RIGHT);

		Rover facingEastRover = RoverService.changeRoverPosition(currentRover, turnRight, map);
		Assert.assertEquals(expectedRover.Longitude, facingEastRover.Longitude);
		Assert.assertEquals(expectedRover.Latitude, facingEastRover.Latitude);
		Assert.assertEquals(expectedRover.Facing, facingEastRover.Facing);
	}

	@Test
	void Should_Make_Rover_Turn_Left_Facing_West () {
		Map map = new Map(5,5);
		Rover currentRover = new Rover(1, 1, Directions.Direction.NORTH);
		Rover expectedRover = new Rover(1, 1, Directions.Direction.WEST);
		ArrayList<Commands.Command> turnLeft = new ArrayList<>();
		turnLeft.add(Commands.Command.LEFT);

		Rover facingWestRover = RoverService.changeRoverPosition(currentRover, turnLeft, map);
		Assert.assertEquals(expectedRover.Longitude, facingWestRover.Longitude);
		Assert.assertEquals(expectedRover.Latitude, facingWestRover.Latitude);
		Assert.assertEquals(expectedRover.Facing, facingWestRover.Facing);
	}

	@Test
	void Should_Make_Rover_Turn_Left_Twice_Facing_South () {
		Map map = new Map(5,5);
		Rover currentRover = new Rover(1, 1, Directions.Direction.NORTH);
		Rover expectedRover = new Rover(1, 1, Directions.Direction.SOUTH);
		ArrayList<Commands.Command> turnLeftTwice = new ArrayList<>();
		turnLeftTwice.add(Commands.Command.LEFT);
		turnLeftTwice.add(Commands.Command.LEFT);

		Rover facingSouthRover = RoverService.changeRoverPosition(currentRover, turnLeftTwice, map);
		Assert.assertEquals(expectedRover.Longitude, facingSouthRover.Longitude);
		Assert.assertEquals(expectedRover.Latitude, facingSouthRover.Latitude);
		Assert.assertEquals(expectedRover.Facing, facingSouthRover.Facing);
	}

	@Test
	void Should_Make_Rover_Move_Forward_Facing_North () {
		Map map = new Map(5,5);
		Rover currentRover = new Rover(1, 1, Directions.Direction.NORTH);
		Rover expectedRover = new Rover(1, 2, Directions.Direction.NORTH);
		ArrayList<Commands.Command> moveForward = new ArrayList<>();
		moveForward.add(Commands.Command.FORWARD);

		Rover facingNorthRover = RoverService.changeRoverPosition(currentRover, moveForward, map);
		Assert.assertEquals(expectedRover.Longitude, facingNorthRover.Longitude);
		Assert.assertEquals(expectedRover.Latitude, facingNorthRover.Latitude);
		Assert.assertEquals(expectedRover.Facing, facingNorthRover.Facing);
	}

	@Test
	void Should_Make_Rover_Move_Backward_Facing_North () {
		Map map = new Map(5,5);
		Rover currentRover = new Rover(1, 2, Directions.Direction.NORTH);
		Rover expectedRover = new Rover(1, 1, Directions.Direction.NORTH);
		ArrayList<Commands.Command> moveBackward = new ArrayList<>();
		moveBackward.add(Commands.Command.BACKWARD);

		Rover facingNorthRover = RoverService.changeRoverPosition(currentRover, moveBackward, map);
		Assert.assertEquals(expectedRover.Longitude, facingNorthRover.Longitude);
		Assert.assertEquals(expectedRover.Latitude, facingNorthRover.Latitude);
		Assert.assertEquals(expectedRover.Facing, facingNorthRover.Facing);
	}
	@Test
	void Should_Make_Rover_Move_Forward_Right_Forward_Forward_Left_BackWard_Facing_North () {
		Map map = new Map(5,5);
		Rover currentRover = new Rover(1, 1, Directions.Direction.NORTH);
		Rover expectedRover = new Rover(3, 1, Directions.Direction.NORTH);
		ArrayList<Commands.Command> moves = new ArrayList<>();
		moves.add(Commands.Command.FORWARD);
		moves.add(Commands.Command.RIGHT);
		moves.add(Commands.Command.FORWARD);
		moves.add(Commands.Command.FORWARD);
		moves.add(Commands.Command.LEFT);
		moves.add(Commands.Command.BACKWARD);

		Rover facingNorthRover = RoverService.changeRoverPosition(currentRover, moves, map);
		Assert.assertEquals(expectedRover.Longitude, facingNorthRover.Longitude);
		Assert.assertEquals(expectedRover.Latitude, facingNorthRover.Latitude);
		Assert.assertEquals(expectedRover.Facing, facingNorthRover.Facing);
	}

	@Test
	void Should_Make_Rover_Move_Forward_Facing_North_To_Border() {
		Map map = new Map(5,5);
		Rover currentRover = new Rover(1, 5, Directions.Direction.NORTH);
		Rover expectedRover = new Rover(1, 1, Directions.Direction.NORTH);
		ArrayList<Commands.Command> moveForward = new ArrayList<>();
		moveForward.add(Commands.Command.FORWARD);

		Rover facingNorthRover = RoverService.changeRoverPosition(currentRover, moveForward, map);
		Assert.assertEquals(expectedRover.Longitude, facingNorthRover.Longitude);
		Assert.assertEquals(expectedRover.Latitude, facingNorthRover.Latitude);
		Assert.assertEquals(expectedRover.Facing, facingNorthRover.Facing);
	}

	@Test
	void Should_Make_Rover_Move_Backward_Facing_East_To_Border() {
		Map map = new Map(5,5);
		Rover currentRover = new Rover(1, 1, Directions.Direction.EAST);
		Rover expectedRover = new Rover(5, 1, Directions.Direction.EAST);
		ArrayList<Commands.Command> moveBackward = new ArrayList<>();
		moveBackward.add(Commands.Command.BACKWARD);

		Rover facingEastRover = RoverService.changeRoverPosition(currentRover, moveBackward, map);
		Assert.assertEquals(expectedRover.Longitude, facingEastRover.Longitude);
		Assert.assertEquals(expectedRover.Latitude, facingEastRover.Latitude);
		Assert.assertEquals(expectedRover.Facing, facingEastRover.Facing);
	}

	@Test
	void Should_Set_Rover_Depend_On_Rover_Facing_East() {
		int expectedAngle = 90;
		Rover currentRover = new Rover(1, 1, Directions.Direction.EAST);

		int getRoverAngle = RoverService.angleBasedOnRoverDirection(currentRover.Facing);
		Assert.assertEquals(expectedAngle, getRoverAngle);
	}
}
