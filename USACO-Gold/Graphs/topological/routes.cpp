#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
const int MAX = 1e5 + 1, MOD = 1e9 + 7;
int N, M;
ll dp[MAX];
vector<int> adj[MAX], adj_t[MAX];

// solved with bfs (kahns algorithm)
int indegree[MAX];
void bfs_solve()
{
    deque<int> q;
    for (int i = 1; i <= N; i++)
        if (indegree[i] == 0)
            q.push_back(i);
    while (!q.empty())
    {
        int u = q.front();
        q.pop_front();
        for (int n : adj_t[u])
            dp[u] = (dp[u] + dp[n]) % MOD;
        for (int n : adj[u])
        {
            indegree[n]--;
            if (!indegree[n])
                q.push_back(n);
        }
    }
}

int main()
{
    cin >> N >> M;
    for (int i = 0; i < M; i++)
    {
        int a, b;
        cin >> a >> b;
        adj[a].push_back(b);
        adj_t[b].push_back(a);
        indegree[b]++;
    }
    dp[1] = 1;
    bfs_solve();
    cout << dp[N] << endl;
}