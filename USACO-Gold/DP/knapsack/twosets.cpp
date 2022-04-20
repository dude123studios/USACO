#include <bits/stdc++.h>
using namespace std;
int main()
{
    int N, mod = 1000000007;
    cin >> N;
    int total = N * (N + 1) / 2;
    if (total % 2 == 1)
    {
        cout << 0 << endl;
        return 0;
    }
    vector<vector<int>> dp(total + 1, vector<int>(N + 1, 0));
    fill(dp[0].begin(), dp[0].end(), 1);
    for (int i = 1; i <= total; i++)
        for (int j = 1; j <= N; j++)
        {
            if (i - j >= 0)
                dp[i][j] = (dp[i][j] + dp[i - j][j - 1]) % mod;
            dp[i][j] = (dp[i][j] + dp[i][j - 1]) % mod;
        }
    cout << dp[total / 2][N] / 2 << endl;
}