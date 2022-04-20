#include <bits/stdc++.h>
using namespace std;
int N, M, C;
vector<int> adj[1001];
int dp[1001][1001];
int m[1001];

int main()
{
    cin >> N >> M >> C;
    for (int i = 1; i <= N; i++)
        cin >> m[i];
    for (int i = 1; i <= N; i++)
    {
        int a, b;
        cin >> a >> b;
        adj[a].push_back(b);
    }
    for (int d = 0; d < 1000; d++)
    {
        for (int i = 1; i <= N; i++)
        {
            dp[d + 1][i] = dp[d][i];
            for (int u : adj[i])
        }
    }
}