package assesment;


import java.util.*;

public class Main {

    private static final long INF = (long) 1e15;

    public static long solve(int N, String z) {
        char[] status = new char[N + 1];
        for (int i = 1; i <= N; i++) {
            status[i] = z.charAt(i - 1);
        }
        long[][][] dp = new long[N + 2][N + 2][2];

        for (int len = 1; len <= N; len++) {
            for (int L = 1; L <= N - len + 1; L++) {
                int R = L + len - 1;

                for (int s = 0; s <= 1; s++) {
                    long minCost = INF;

                    for (int p = L; p <= R; p++) {
                        boolean isClosed = (status[p] == 'C');

                        if (s == 1) {
                            if (isClosed) continue;
                            long leftCost = (p > L) ? dp[L][p - 1][1] : 0;
                            long rightCost = (p < R) ? dp[p + 1][R][1] : 0;

                            if (leftCost < INF && rightCost < INF) {
                                minCost = Math.min(minCost, leftCost + rightCost + (R - L));
                            }
                        } else {

                            if (!isClosed) {
                                long costL1 = (p > L) ? dp[L][p - 1][0] : 0;
                                long costR1 = (p < R) ? dp[p + 1][R][1] : 0;
                                if (costL1 < INF && costR1 < INF) {
                                    minCost = Math.min(minCost, costL1 + costR1 + (R - L));
                                }
                                long costL2 = (p > L) ? dp[L][p - 1][1] : 0;
                                long costR2 = (p < R) ? dp[p + 1][R][0] : 0;
                                if (costL2 < INF && costR2 < INF) {
                                    minCost = Math.min(minCost, costL2 + costR2 + (R - L));
                                }
                            } else {

                                long leftCost = (p > L) ? dp[L][p - 1][1] : 0;
                                long rightCost = (p < R) ? dp[p + 1][R][1] : 0;

                                if (leftCost < INF && rightCost < INF) {
                                    minCost = Math.min(minCost, leftCost + rightCost + (R - L));
                                }
                            }
                        }
                    }

                    dp[L][R][s] = minCost;
                }
            }
        }

        long ans = dp[1][N][0];
        return (ans >= INF) ? -1 : ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;

        int N = sc.nextInt();
        String z = sc.next();

        long result = solve(N, z);
        System.out.println(result);

        sc.close();
    }
}