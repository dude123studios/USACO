#include <bits/stdc++.h>
using namespace std;
bool dp[101][101][5001];
int N, X, t[101], mod = 1000000007;
int main()
{
    cin >> N >> X;
    for (int i = 1; i <= N; i++)
        cin >> t[i];
    sort(t + 1, t + N + 1);
    dp[0][0][0] = 1;
    for (int i = 1; i <= N; i++)
        for (int j = 1; j <= N; j++)
            for (int k = 1; k <= 5000; k++)
            {
                if (k + t[i] <= 5000)
                    dp[i][j][k] = dp[i][j][k] + dp[i - 1][j - 1][k + t[i]] % mod;
                dp[i][j][k] = (dp[i][j][k] + dp[i - 1][j][k] + k * dp[i - 1][j - 1][k]) % mod;
                if (k - t[i] >= 0)
                    dp[i][j][k] = (dp[i][j][k] + k * dp[i - 1][j + 1][k - t[i]]) % mod;
            }
    cout << dp[N][0][X] << endl;
}