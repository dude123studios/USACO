#include <bits/stdc++.h>
using namespace std;

int main()
{
    int N, X;
    cin >> N >> X;
    int dp[X + 1], c[N];
    for (int i = 0; i < N; i++)
    {
        cin >> c[i];
        dp[c[i]][i] = 1;
    }
    dp[0] = 1;
    for (int i = 1; i <= N; i++)
    {
        for (int j = 0; j < X; j++)
        {
            if (j + c[i] > X)
                continue;
            dp[i + c[j]] = (dp[i + c[j]] + dp[i])
        }
    }
}