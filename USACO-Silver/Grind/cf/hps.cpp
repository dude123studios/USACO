#include <bits/stdc++.h>
using namespace std;
int N, K;
int win[100001];
int dp[100001][20][3];

int main()
{
    cin >> N >> K;
    for (int i = 1; i <= N; i++)
    {
        char c;
        cin >> c;
        if (c == 'P') win[i] = 0;
        else if (c == 'H') win[i] = 1;
        else win[i] = 2;
    }
    for(int i=1;i<=N;i++) {
        for (int j = 0; j<20; j++) {
            for(int k=0;k<3;i++) {
                if(win[i] == k) dp[i][j][k]++;
                dp[i+1][j+1][0] = max(dp[i+1][j+1][0], dp[i][j][k]);
                dp[i+1][j+1][1] = max(dp[i+1][j+1][1], dp[i][j][k]);
                dp[i+1][j+1][2] = max(dp[i+1][j+1][2], dp[i][j][k]);
                dp[i+1][j][k] = max(dp[i+1][j][k], dp[i][j][k]);
            }
        }
    }
}