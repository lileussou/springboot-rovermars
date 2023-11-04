package com.rovermars.models;

import java.util.ArrayList;

public class Directions {

    public enum Direction {
        NORTH,
        EAST,
        SOUTH,
        WEST;

        public static ArrayList<Direction> getValue() {
            ArrayList<Direction> DirectionsList = new ArrayList<>();
            DirectionsList.add(Direction.NORTH);
            DirectionsList.add(Direction.EAST);
            DirectionsList.add(Direction.SOUTH);
            DirectionsList.add(Direction.WEST);
            return DirectionsList;
        }
    }
}
