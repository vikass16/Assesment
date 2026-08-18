package recursion;

import java.util.ArrayList;
import java.util.List;

public class MazeProblem {
    public static void main(String[] args) {
        System.out.println(countWays(4,4));
        returnPaths("",3,3);
        System.out.println(paths("",3,3));
        System.out.println(diagonalPath("",3,3));
    }

    public static int countWays(int r, int c){
        if(r == 1 || c == 1){
            return 1;
        }
         int left = countWays(r,c-1);
         int right = countWays(r-1, c);

         return left + right;
    }

    public static void returnPaths(String p, int r, int c){
        if(r == 1 && c == 1){
            System.out.println(p);
            return;
        }

        if( r > 1 ){
            returnPaths(p+'D',r-1,c);
        }
        if(c > 1){
            returnPaths(p+'R',r,c-1);
        }
    }

    public static List<String> paths(String p, int r, int c){
        if(r == 1 && c == 1){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        ArrayList<String> list = new ArrayList<>();
        if( r > 1){
            list.addAll(paths(p+'D',r-1,c));
        }
        if (c > 1){
            list.addAll(paths(p+'R',r,c-1));
        }
        return list;
    }

    // Going via Diagonal is also allowed (If)
    public static List<String> diagonalPath(String p, int r, int c){
        if(r == 1 && c == 1){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        ArrayList<String> list = new ArrayList<>();
        if(r > 1){
            list.addAll(diagonalPath(p+'V',r-1,c));
        }
        if(c > 1){
            list.addAll(diagonalPath(p+'H',r,c-1));
        }

        // Only one New function call will be added over here to go via diagonally.
        if(r > 1 && c > 1){
            list.addAll(diagonalPath(p+'D',r-1,c-1));
        }
        return list;
    }
}
