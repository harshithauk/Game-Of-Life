package com.thoughtworks;

import com.thoughtworks.exceptions.InvalidGridSizeException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CellTest {
    @Test
    void checkIfInputCellsAreAlive() throws InvalidGridSizeException {
        int[][] input = {{0, 1}, {1, 1}, {2, 1}};
        Grid grid = new Grid(3, 3);
        grid.setCellStatus(input);
        assertTrue(grid.getCellStatus(1, 1));
    }

    @Test
    void checkIfLiveNeighbourCountOfMiddleCellIsTwo() throws InvalidGridSizeException {
        int[][] input = {{0, 1}, {1, 1}, {2, 1}};
        Grid grid = new Grid(5, 5);
        grid.setCellStatus(input);
        int liveCellCount = grid.liveCellCount(1, 1);
        assertEquals(2, liveCellCount);
    }
}
