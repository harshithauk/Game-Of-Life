package com.thoughtworks;

import com.thoughtworks.exceptions.InvalidGridSizeException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GridTest {

    @Test
    void checkIfAllCellsOfGridAreInDeadState() throws InvalidGridSizeException {
        Grid grid = new Grid(5, 5);
        assertEquals(new Cell().cellStatus(), grid.getCellStatus(1, 1));
    }

    @Test
    void shouldNotCreateGridWhenRowOrColValueIsLessThanZero() {
        assertThrows(InvalidGridSizeException.class, () -> new Grid(-1, 0));
    }


}
