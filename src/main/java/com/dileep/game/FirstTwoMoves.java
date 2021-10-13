package com.dileep.game;

import java.security.SecureRandom;
import java.util.List;

/**
 * 
 * @author 7504686
 *
 */
public class FirstTwoMoves {

    private final SecureRandom rng = new SecureRandom();

    public Board makeMove(Board input) {
        List<Cell> emptyCells = input.emptyCells();

        double numberToPlace = rng.nextDouble();

        int indexToPlace = rng.nextInt(emptyCells.size());
        Cell cellToPlace = emptyCells.get(indexToPlace);

        return input.placeTile(cellToPlace, numberToPlace >= 0.9 ? 4 : 2);
    }
}
