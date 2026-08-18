package recursion;

import java.util.ArrayList;
import java.util.List;

public class LetterCombination {
    public static void main(String[] args) {
        letters("","12");
        System.out.println(lettersReturn("","12"));
        System.out.println(lettersCoutn("","12"));
    }

    public static void letters(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }

        int digit = up.charAt(0) - '0'; // This will convert '2' into 2
        for(int i= (digit-1)*3 ; i < (digit*3); i++){
            char ch = (char) ('a' + i);
            letters(p+ch, up.substring(1));
        }
    }

    public static List<String> lettersReturn(String p, String up){
        if(up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        int digit = up.charAt(0) - '0';
        ArrayList<String> list = new ArrayList<>();
        for(int i= (digit-1)*3 ; i < (digit*3); i++){
            char ch = (char) ('a' + i);
            list.addAll(lettersReturn(p+ch, up.substring(1)));
        }
        return list;
    }

    public static int lettersCoutn(String p, String up){
        if(up.isEmpty()){
            return 1;
        }

        int digit = up.charAt(0) - '0';
        int count = 0;
        for(int i= (digit-1)*3 ; i < (digit*3); i++){
            char ch = (char) ('a' + i);
            count = count + lettersCoutn(p+ch, up.substring(1));
        }
        return count;
    }
}
