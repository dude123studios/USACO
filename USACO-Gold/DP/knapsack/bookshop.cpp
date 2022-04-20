#include <bits/stdc++.h>
using namespace std;
int dp[100001][1001];
int h[1001], s[1001];
int main()
{
    int N, X;
    cin >> N >> X;
    for (int i = 1; i <= N; i++)
        cin >> h[i];
    for (int i = 1; i <= N; i++)
        cin >> s[i];
    for (int i = 1; i <= X; i++)
        for (int j = 1; j <= N; j++)
        {
            int prev = i - h[j];
            if (prev >= 0)
                dp[i][j] = max(dp[prev][j - 1] + s[j], dp[i][j]);
            dp[i][j] = max(dp[i][j - 1], dp[i][j]);
        }

    cout << dp[X][N] << endl;
}