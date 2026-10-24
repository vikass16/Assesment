package assesment;

public class ReverseSpecificWordInString {
    public static void main(String[] args) {
        String abc="My Name is Vipin";

        String[] word= abc.split(" ");

        word[1]=new StringBuilder(word[1]).reverse().toString();
        word[3]=new StringBuilder(word[3]).reverse().toString();

        System.out.println(String.join(" ",word));

    }
}
