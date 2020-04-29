package com.yokall;

public class Board {
    private int[][] grid;

    public Board(int[][] grid) {
        this.grid = grid;
    }

    public void printGrid() {
        for (int y = 0; y < grid.length; y++) {
            if (y == 3 || y == 6) {
                System.out.println("-----------");
            }

            for (int x = 0; x < grid[y].length; x++) {
                if (x == 3 || x == 6) {
                    System.out.print('|');
                }

                System.out.print(grid[y][x]);
            }

            System.out.println();
        }
    }
}
