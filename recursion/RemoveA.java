package recursion;

public class RemoveA {
    public static void main(String[] args) {
        removeChar("","baccdan");
        System.out.println(skipA("baccdasb"));
        System.out.println(skipApple("abcdappleef"));
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

    public static String skipA(String str){
        if(str.isEmpty()){
            return str;
        }
        char ch = str.charAt(0);
        if(ch == 'a'){
            return skipA(str.substring(1));
        }else {
            return ch + skipA(str.substring(1));
        }
    }

    public static String skipApple(String str){
        if(str.isEmpty()){
            return str;
        }
        char ch = str.charAt(0);
        if(str.startsWith("apple")){
            return skipApple(str.substring(5));
        }else{
            return ch + skipApple(str.substring(1));
        }
    }
}
