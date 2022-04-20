#include <bits/stdc++.h>
using namespace std;
int N, dp[8][8];
int main()
{
    cin >> N;
    for (int i = N; i >= 1; i--)
        for (int j = 1; j <= N; j++)
        {
            string ln;
            cin >> ln;
            if (ln[0] == 'T')
                dp[i][j] = 10;
            else if (ln[0] == 'J')
                dp[i][j] = 11;
            else if (ln[0] == 'Q')
                dp[i][j] = 12;
            else if (ln[0] == 'K')
                dp[i][j] = 13;
            else if (ln[0] == 'A')
                dp[i][j] = 1;
            else
                dp[i][j] = ln[0] - '0';
        }
    for (int i = 1; i <= N; i++)
        for (int j = 1; j <= N; j++)
            dp[i][j] += max(dp[i - 1][j], dp[i][j - 1]);
    cout << dp[N][N] << endl;
}