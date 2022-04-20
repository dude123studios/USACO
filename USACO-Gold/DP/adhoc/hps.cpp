#include <bits/stdc++.h>
using namespace std;
#define MAXN 100000
int N, K;
int w[MAXN + 1], dp[MAXN + 1][21][3]; // max games won after i games with j switches and ending on move k
int main()
{
    freopen("hps.in", "r", stdin);
    freopen("hps.out", "w", stdout);
    cin >> N >> K;
    map<char, int> mp;
    mp['R'] = 0;
    mp['P'] = 1;
    mp['S'] = 2;
    for (int i = 1; i <= N; i++)
    {
        char c;
        cin >> c;
        w[i] = mp[c];
    }
    for (int i = 1; i <= N; i++)
        for (int j = 0; j <= K; j++)
            for (int k = 0; k < 3; k++)
            {
                dp[i][j][k] = dp[i - 1][j][k] + (w[i] == k);
                if (!j)
                    continue;
                for (int other = 0; other < 3; other++)
                    if (other != k)
                        dp[i][j][k] = max(dp[i][j][k], dp[i - 1][j - 1][other] + (w[i] == other));
            }
    int ans = 0;
    for (int i = 0; i <= K; i++)
        for (int j = 0; j < 3; j++)
            ans = max(ans, dp[N][i][j]);
    cout << ans << endl;
}