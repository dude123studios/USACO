#include <bits/stdc++.h>
using namespace std;
int N, M, mod = 1e9 + 7;
int dp[100001][101], x[100001];
int main()
{
    cin >> N >> M;
    for (int i = 1; i <= N; i++)
        cin >> x[i];
    if (x[1] != 0)
        dp[1][x[1]] = 1;
    else
        fill(dp[1] + 1, dp[1] + N + 1, 1);
    for (int i = 2; i <= N; i++)
        for (int j = 1; j <= M; j++)
            if (x[i] == 0 || j == x[i])
            {
                dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
                if (j + 1 <= M)
                    dp[i][j] += dp[i - 1][j + 1];
            }
    int ans = 0;
    for (int i = 1; i <= M; i++)
        (ans += dp[N][i]) %= mod;
    cout << ans << endl;
}