#include <bits/stdc++.h>
using namespace std;

int main()
{
    int N, X;
    cin >> N >> X;
    int dp[X + 1], c[N];
    fill(dp, dp + X + 1, 0);
    for (int i = 0; i < N; i++)
    {
        cin >> c[i];
        if (c[i] <= X)
            dp[c[i]]++;
    }
    for (int i = 1; i <= X; i++)
        for (int j = 0; j < N; j++)
            if (i + c[j] <= X)
                dp[i + c[j]] = (dp[i] + dp[i + c[j]]) % 1000000007;
    cout << dp[X] << endl;
}