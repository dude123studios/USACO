#include <bits/stdc++.h>
using namespace std;
int N, f[1001], s[1001];
int dp[1001][1001]; // max roads for up to i on one side and up to j on other
int main()
{
    freopen("nocross.in", "r", stdin);
    freopen("nocross.out", "w", stdout);
    cin >> N;
    for (int i = 1; i <= N; i++)
        cin >> f[i];
    for (int i = 1; i <= N; i++)
        cin >> s[i];

    for (int i = 1; i <= N; i++)
        for (int j = 1; j <= N; j++)
            dp[i][j] = max({dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1] + (abs(f[i] - s[j]) <= 4)});
    cout << dp[N][N] << endl;
}