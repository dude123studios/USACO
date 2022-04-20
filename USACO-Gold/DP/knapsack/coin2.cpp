#include <bits/stdc++.h>
using namespace std;
int N, X, dp[1000001], c[1000000];

int main()
{
    cin >> N >> X;
    for (int i = 0; i < N; i++)
        cin >> c[i];
    dp[0] = 1;
    for (int i = 0; i < N; i++)
        for (int j = 1; j <= X; j++)
            if (j - c[i] >= 0)
                dp[j] = (dp[j] + dp[j - c[i]]) % 1000000007;
    cout << dp[X] << endl;
}