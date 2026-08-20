package recursion;

import java.util.Arrays;

public class MazeBacktracking {
    public static void main(String[] args) {
        boolean[][] board = {
                {true,true,true},
                {true,true,true},
                {true,true,true}
        };

        int[][] path = new int[board.length][board[0].length];

        allPossiblePaths("",board,0,0);
        printAllPossiblePaths("",board,0,0,path,1);
    }

    public static void allPossiblePaths(String p, boolean[][] maze, int r, int c){
        if(r == maze.length-1 && c == maze[r].length-1){
            System.out.println(p);
            return;
        }

        if(!maze[r][c]){
            return;
        }

        // I am considering this block in my path
        maze[r][c] = false;

        if(r < maze.length-1){
            allPossiblePaths(p+'D',maze,r+1,c);
        }
        if(c < maze[0].length-1){
            allPossiblePaths(p+'R',maze,r, c+1);
        }
        if(r > 0){
            allPossiblePaths(p+'U',maze, r-1,c);
        }
        if(c > 0){
            allPossiblePaths(p+'L',maze,r, c-1);
        }

        // This line is where the function will be over
        // So before the function gets removed, also remove that changes were made by that function

        maze[r][c] = true;
    }

    public static void printAllPossiblePaths(String p, boolean[][] maze, int r, int c,int[][] path, int step){
        if(r == maze.length-1 && c == maze[r].length-1){
            for(int[] arr : path){
                path[r][c] = step;
                System.out.println(Arrays.toString(arr));
            }
            System.out.println(p);
            System.out.println();
            return;
        }

        if(!maze[r][c]){
            return;
        }

        // I am considering this block in my path
        maze[r][c] = false;
        path[r][c] = step;

        if(r < maze.length-1){
            printAllPossiblePaths(p+'D',maze,r+1,c, path, step+1);
        }
        if(c < maze[0].length-1){
            printAllPossiblePaths(p+'R',maze,r, c+1, path, step+1);
        }
        if(r > 0){
            printAllPossiblePaths(p+'U',maze, r-1,c, path, step+1);
        }
        if(c > 0){
            printAllPossiblePaths(p+'L',maze,r, c-1, path, step+1);
        }

        // This line is where the function will be over
        // So before the function gets removed, also remove that changes were made by that function

        maze[r][c] = true;
        path[r][c] = 0;
    }
}
