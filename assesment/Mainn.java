package assesment;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
public class Mainn {

    public static long solve(int N, int B, String s) {
        List<int[]> intervals = new ArrayList<>();

        for (int c = 0; c < N; c++) {
            int maxArm = 0;
            while (c - maxArm >= 0 && c + maxArm < N && s.charAt(c - maxArm) == s.charAt(c + maxArm)) {
                maxArm++;
            }
            maxArm--;

            for (int k = maxArm; k >= 0; k--) {
                intervals.add(new int[]{c - k, c + k, 2 * k + 1});
            }
        }

        for (int c = 0; c < N - 1; c++) {
            int maxArm = 0;
            while (c - maxArm >= 0 && c + 1 + maxArm < N && s.charAt(c - maxArm) == s.charAt(c + 1 + maxArm)) {
                maxArm++;
            }

            for (int k = maxArm; k >= 1; k--) {
                intervals.add(new int[]{c - k + 1, c + k, 2 * k});
            }
        }

        List<int[]>[] endAt = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            endAt[i] = new ArrayList<>();
        }
        for (int[] interval : intervals) {
            endAt[interval[1]].add(interval);
        }

        long[][] dp = new long[N + 1][B + 1];
        for (int i = 0; i <= N; i++) {
            Arrays.fill(dp[i], -1);
        }
        dp[0][0] = 0;

        for (int i = 1; i <= N; i++) {
            for (int k = 0; k <= B; k++) {
                dp[i][k] = dp[i - 1][k];
            }

            for (int[] interval : endAt[i - 1]) {
                int start = interval[0];
                int strength = interval[2];

                for (int k = 1; k <= B; k++) {
                    if (dp[start][k - 1] != -1) {
                        dp[i][k] = Math.max(dp[i][k], dp[start][k - 1] + strength);
                    }
                }
            }
        }

        return Math.max(0, dp[N][B]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int N = sc.nextInt();
            int B = sc.nextInt();
            String s = sc.next();
            System.out.println(solve(N, B, s));
        }
        sc.close();
    }
}

