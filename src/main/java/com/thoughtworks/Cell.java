package com.thoughtworks;

public class Cell {
    private boolean status;
    private boolean statusInNextTick;


    public Cell() {
        this.status = false;
    }

    public Boolean cellStatus() {
        return status;
    }

    public void setStatus(boolean newStatus) {
        this.status = newStatus;
    }


    public void checkCellStatusInNextTick(int aliveNeighboursCount) {

        if (aliveNeighboursCount < 2 || aliveNeighboursCount > 3) {
            this.statusInNextTick = false;
        } else if (!status && aliveNeighboursCount == 3) {
            this.statusInNextTick = true;
        } else {
            this.statusInNextTick = this.status;
        }
    }

    public boolean cellStatusInNextTick() {
        return statusInNextTick;
    }
}
