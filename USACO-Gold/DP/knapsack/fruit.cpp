#include <bits/stdc++.h>
using namespace std;
bool dp[2][5000001];
int main()
{
    freopen("feast.in", "r", stdin);
    freopen("feast.out", "w", stdout);
    int T, A, B;
    cin >> T >> A >> B;
    int ans = 0;
    dp[0][0] = 1;
    dp[1][0] = 1;
    for (int i = 1; i <= T; i++)
    {
        for (int j = 0; j <= 1; j++)
        {
            if (i - A >= 0)
                dp[j][i] |= dp[j][i - A];
            if (i - B >= 0)
                dp[j][i] |= dp[j][i - B];
        }
        dp[1][i / 2] |= dp[0][i];
        if (dp[1][i] || dp[0][i])
            ans = i;
    }
    cout << ans << endl;
}