package CodeSamples.Algorithms;

public class DFSNumberOfIslands {

    public int numIslands(char[][] grid) {


        if(grid == null || grid.length == 0)
            return 0 ;


        int numberOfIslands = 0;

        for(int i=0; i < grid.length ; i++){

            for(int j=0; j< grid[0].length; j++){

                if(grid[i][j] == '1'){
                    numberOfIslands++;
                    findIsland(grid, i, j);

                }

            }


        }

        return numberOfIslands;


    }


    private void findIsland(char[][] grid, int row, int col){


        //base
        if(row<0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == '0')
            return ;


        grid[row][col] = '0';

        findIsland(grid, row+1, col);
        findIsland(grid, row, col+1);
        findIsland(grid, row-1, col);
        findIsland(grid, row, col-1);



    }
}
