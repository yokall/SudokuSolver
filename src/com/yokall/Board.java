package com.yokall;

public class Board {
    private int[][] grid;

    public Board(int[][] grid) {
        this.grid = grid;
    }

    public void print() {
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

    public boolean solve(){
        GridPosition emptyPosition = getNextEmptyPosition();

        if (emptyPosition != null) {
            for (int i = 1; i < 10; i++) {
                if (moveIsValid(emptyPosition, i)) {
                    grid[emptyPosition.Y()][emptyPosition.X()] = i;

                    if (solve()) {
                        return true;
                    }
                    else {
                        grid[emptyPosition.Y()][emptyPosition.X()] = 0;
                    }
                }
            }

            return false;
        }
        else {
            return true;
        }
    }

    private GridPosition getNextEmptyPosition() {
        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[y].length; x++) {
                if (grid[y][x] == 0) {
                    return new GridPosition(x, y);
                }
            }
        }

        return null;
    }
    
    private boolean moveIsValid(GridPosition position, int number) {
        boolean valid = true;

        for (int x = 0; x < grid[position.Y()].length; x++) {
            if (x != position.X() && grid[position.Y()][x] == number) {
                valid = false;
            }
        }

        for (int y = 0; y < grid.length; y++) {
            if (y != position.Y() && grid[y][position.X()] == number) {
                valid = false;
            }
        }

        int subGridX = (position.X() / 3) * 3;
        int subGridY = (position.Y() / 3) * 3;

        for (int y = subGridY; y < subGridY + 3; y++) {
            for (int x = subGridX; x < subGridX + 3; x++) {
                if (x != position.X() && y != position.Y() && grid[y][x] == number) {
                    valid = false;
                }
            }
        }
        
        return valid;
    }
}
