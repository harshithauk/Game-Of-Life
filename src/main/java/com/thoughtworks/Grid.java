package com.thoughtworks;

import com.thoughtworks.exceptions.InvalidGridSizeException;

import java.util.ArrayList;

public class Grid {
    private final int row;
    private final int col;

    private final ArrayList<ArrayList<Cell>> cells;

    public Grid(int row, int col) throws InvalidGridSizeException {
        if (row < 0 || col < 0) {
            throw new InvalidGridSizeException();
        }
        this.row = row;
        this.col = col;
        cells = new ArrayList<>();
        createCells();
    }

    private void createCells() {
        for (int i = 0; i < row + 1; i++) {
            cells.add(new ArrayList<>());
            for (int j = 0; j < col + 1; j++) {
                cells.get(i).add(j, new Cell());
            }
        }
    }

    public boolean getCellStatus(int x, int y) {
        return cells.get(x).get(y).cellStatus();
    }
}
