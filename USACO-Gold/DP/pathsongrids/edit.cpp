#include <bits/stdc++.h>
using namespace std;
int N, M, dp[5001][5001];
string a, b;
int main()
{
    cin >> a >> b;
    N = a.size();
    M = b.size();
    for (int i = 0; i < N; i++)
        for (int j = 0; j < M; j++)
        {
            dp[i][j] = min(dp[i][j], 1 + dp[i - 1][j]);
            dp[i][j] = min(dp[i][j], 1 + dp[i][j - 1]);
            dp[i][j] = min(dp[i][j], 1 + dp[i + 1][j]);
            dp[i][j] = min(dp[i][j], 1 + dp[i][j + 1]);
            dp[i][j] = min(dp[i][j], 1 + dp[i - 1][j - 1]);
        }
}