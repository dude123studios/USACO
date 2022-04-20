#include <bits/stdc++.h>
using namespace std;
int N, H;
int dp[1 << 20];
int s[20], w[20], h[20];
int main()
{
    cin >> N >> H;
    for (int i = 0; i < N; i++)
        cin >> h[i] >> w[i] >> s[i];

    for (int m = 0; m < (1 << N); m++)
    {
        dp[m] = -1;
        for (int i = 0; i < N; i++)
            if (m & (1 << i) && dp[m ^ (1 << i)] >= w[i])
                dp[m] = max(dp[m], min(dp[m ^ (1 << i)] - w[i], s[i]));
    }
    int ans = 0;
    for (int m = 0; m < (1 << N); m++)
    {
        int height = 0;
        for (int i = 0; i < N; i++)
            if (m & (1 << i))
                height += h[i];
        if (height >= H)
            ans = max(ans, dp[m]);
    }
    cout << ans << endl;
}