package recursion;

public class RemoveA {
    public static void main(String[] args) {
        removeChar("","baccdan");
    }

    public static void removeChar(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }

        char ch = up.charAt(0);
        if(ch == 'a'){
            removeChar(p, up.substring(1));
        }else{
            removeChar(p+ch, up.substring(1));
        }
    }
}
