#include <bits/stdc++.h>
using namespace std;
typedef pair<int, int> pii;
const int MAX = 1e5 + 1;
int N, M, C;
int dp[MAX];
vector<int> adj[MAX];
vector<pii> adj_t[MAX];

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
        for (pii n : adj_t[u])
            dp[u] = max(dp[u], dp[n.second] + n.first);
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
    freopen("timeline.in", "r", stdin);
    freopen("timeline.out", "w", stdout);
    cin >> N >> M >> C;
    for (int i = 1; i <= N; i++)
        cin >> dp[i];
    for (int i = 0; i < C; i++)
    {
        int a, b, x;
        cin >> a >> b >> x;
        adj[a].push_back(b);
        adj_t[b].push_back({x, a});
        indegree[b]++;
    }
    bfs_solve();
    for (int i = 1; i <= N; i++)
        cout << dp[i] << endl;
}