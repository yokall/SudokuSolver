package com.yokall;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class BoardTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    private int[][] grid = {
            {5, 3, 0, 0, 7, 0, 0, 0, 0},
            {6, 0, 0, 1, 9, 5, 0, 0, 0},
            {0, 9, 8, 0, 0, 0, 0, 6, 0},
            {8, 0, 0, 0, 6, 0, 0, 0, 3},
            {4, 0, 0, 8, 0, 3, 0, 0, 1},
            {7, 0, 0, 0, 2, 0, 0, 0, 6},
            {0, 6, 0, 0, 0, 0, 2, 8, 0},
            {0, 0, 0, 4, 1, 9, 0, 0, 5},
            {0, 0, 0, 0, 8, 0, 0, 7, 9}};

    private Board board;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));

        board = new Board(grid);
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    public void print() {
        board.print();

        String expectedOutput = "530|070|000\r\n" +
                "600|195|000\r\n" +
                "098|000|060\r\n" +
                "-----------\r\n" +
                "800|060|003\r\n" +
                "400|803|001\r\n" +
                "700|020|006\r\n" +
                "-----------\r\n" +
                "060|000|280\r\n" +
                "000|419|005\r\n" +
                "000|080|079\r\n";

        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void solve() {
        board.solve();

        board.print();

        String expectedOutput = "534|678|912\r\n" +
                "672|195|348\r\n" +
                "198|342|567\r\n" +
                "-----------\r\n" +
                "859|761|423\r\n" +
                "426|853|791\r\n" +
                "713|924|856\r\n" +
                "-----------\r\n" +
                "961|537|284\r\n" +
                "287|419|635\r\n" +
                "345|286|179\r\n";

        assertEquals(expectedOutput, outContent.toString());
    }
}