package recursion;

import java.util.ArrayList;


public class SubString {
    public static void main(String[] args) {
        substr("","abc");
        System.out.println(subseqReturn("","abc"));
    }

    public static void substr(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }

        char ch = up.charAt(0);

        substr(p+ch, up.substring(1));
        substr(p, up.substring(1));
    }

    public static ArrayList<String> subseqReturn(String p, String up){
        if(up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        char ch = up.charAt(0);

        ArrayList<String > left = subseqReturn(p+ch, up.substring(1));
        ArrayList<String> right = subseqReturn(p, up.substring(1));
        left.addAll(right);
        return left;
    }
}
