#include <bits/stdc++.h>
using namespace std;
int N, dp[1001][1001], mod = 1e9 + 7;
int main()
{
    cin >> N;
    for (int i = 1; i <= N; i++)
    {
        string ln;
        cin >> ln;
        for (int j = 1; j <= N; j++)
            dp[i][j] = ln[j - 1] == '*' ? -1 : 0;
    }
    if (dp[1][1] == -1)
    {
        cout << 0 << endl;
        return 0;
    }
    dp[1][1] = 1;
    for (int i = 1; i <= N; i++)
        for (int j = 1; j <= N; j++)
            (dp[i][j] += (dp[i][j] == -1 ? 1 : dp[i - 1][j] + dp[i][j - 1])) %= mod;

    cout << dp[N][N] << endl;
}