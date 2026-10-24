package assesment;

import java.util.Arrays;

public class CharFreq {
    public static void main(String[] args) {
        String str = "vikaskumarfromsonebhadra";
        int[] freq = new int[26];
        for(char ch : str.toCharArray()){
            freq[ch - 'a']++;
        }

        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > 0) {
                char letter = (char) (i + 'a'); // 0 + 'a' becomes 'a', 1 + 'a' becomes 'b'
                System.out.println(letter + ": " + freq[i]);

            }

        }
    }
}
