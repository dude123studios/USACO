#include <bits/stdc++.h>
using namespace std;
int N, K, s[10001];
int dp[10001];
int main()
{
    freopen("teamwork.in", "r", stdin);
    freopen("teamwork.out", "w", stdout);
    cin >> N >> K;
    for (int i = 1; i <= N; i++)
        cin >> s[i];
    for (int i = 1; i <= N; i++)
    {
        int maxval = 0;
        for (int j = i; j >= max(1, i - K + 1); j--)
        {
            maxval = max(maxval, s[j]);
            dp[i] = max(dp[i], dp[j - 1] + maxval * (i - j + 1));
        }
    }
    cout << dp[N] << endl;
}