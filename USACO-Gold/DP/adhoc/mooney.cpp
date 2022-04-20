#include <bits/stdc++.h>
using namespace std;
int N, M, C;
vector<int> adj[1001];
int m[1001], dp[1001][1001];
int main()
{
    freopen("time.in", "r", stdin);
    freopen("time.out", "w", stdout);
    cin >> N >> M >> C;
    for (int i = 1; i <= N; i++)
        cin >> m[i];
    for (int i = 0; i < M; i++)
    {
        int u, v;
        cin >> u >> v;
        adj[v].push_back(u);
    }
    for (int i = 2; i <= N; i++)
        dp[0][i] = -1001;
    for (int t = 1; t <= 1000; t++)
        for (int i = 1; i <= N; i++)
            for (int u : adj[i])
                dp[t][i] = max(dp[t][i], dp[t - 1][u] + m[i]);
    int ans = 0;
    for (int t = 1; t <= 1000; t++)
        ans = max(ans, dp[t][1] - C * t * t);

    cout << ans << endl;
}