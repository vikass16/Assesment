package recursion;

import java.util.ArrayList;
import java.util.List;

public class DiceCombination {
    public static void main(String[] args) {
        dice("",4);
        System.out.println(diceReturn("",4));
        System.out.println(diceCount("",4));
    }

    public static void dice(String p, int target){
        if(target == 0){
            System.out.println(p);
            return;
        }

        for (int i=1; i<=6 && i <= target; i++){
            dice(p+i, target-i);
        }
    }

    public static List<String> diceReturn(String p, int target){
        if(target == 0){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        ArrayList<String> list = new ArrayList<>();
        for(int i = 1; i <= 6 && i <= target ; i++){
            list.addAll(diceReturn(p+i, target-i));
        }
        return list;
    }

    public static int diceCount(String p, int target){
        if(target == 0){
           return 1;
        }

        int count = 0;
        for(int i = 1; i <= 6 && i <= target ; i++){
            count += diceCount(p+i, target-i);
        }
        return count;
    }
}
