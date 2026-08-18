package recursion;

import java.util.ArrayList;

public class Permutation {
    public static void main(String[] args) {

        perm("","abc");

        System.out.println(permStr("","abc"));
    }

    public static void perm(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }

        char ch = up.charAt(0);

        for(int i=0; i<=p.length(); i++){
            String left = p.substring(0,i);
            String right = p.substring(i);

            perm(left + ch + right, up.substring(1));
        }
    }

    public static ArrayList<String> permStr(String p, String up){
        if(up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        char ch = up.charAt(0);
        ArrayList<String> ans = new ArrayList<>();
        for(int i=0; i<= p.length(); i++){
            String left = p.substring(0,i);
            String right = p.substring(i);
            ans.addAll(permStr(left +ch + right, up.substring(1)));
        }
        return ans;
    }
}
