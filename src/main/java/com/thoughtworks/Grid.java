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

    public void setCellStatus(int[][] input) {
        for (int[] ints : input) {
            int rowIndex = ints[0];
            int colIndex = ints[1];
            cells.get(rowIndex).get(colIndex).setStatus(true);
        }
    }

    public int liveCellCount(int x, int y) {
        int aliveCount = 0;
        int[] x_neighbours = {x, x, x + 1, x - 1, x + 1, x - 1, x - 1, x + 1};
        int[] y_neighbours = {y + 1, y - 1, y, y, y + 1, y - 1, y + 1, y - 1};

        for (int i = 0; i < 8; i++) {
            aliveCount += getNeighbourStatus(x_neighbours[i], y_neighbours[i]) ? 1 : 0;
        }

        return aliveCount;
    }

    private boolean getNeighbourStatus(int x, int y) {
        try {
            return cells.get(x).get(y).cellStatus();
        } catch (Exception e) {
            return false;
        }
    }
}
