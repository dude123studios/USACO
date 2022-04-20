#include <bits/stdc++.h>
using namespace std;
#define vi vector<int>
#define pb push_back
const int MAX = 1e5 + 1, INF = 1e9 + 7;
int N, K;
vi distB(MAX, -1), distE(MAX, -1);
vi adj[MAX];
queue<int> q;
void bfs(vi &dist)
{
    while (!q.empty())
    {
        int node = q.front();
        q.pop();
        for (int adj_node : adj[node])
            if (dist[adj_node] == -1)
            {
                dist[adj_node] = dist[node] + 1;
                q.push(adj_node);
            }
    }
}

int main()
{

    freopen("atlarge.in", "r", stdin);
    freopen("atlarge.out", "w", stdout);
    cin >> N >> K;
    for (int i = 0; i < N - 1; i++)
    {
        int a, b;
        cin >> a >> b;
        adj[a].pb(b);
        adj[b].pb(a);
    }
    q.push(K);
    distB[K] = 0;
    bfs(distB);
    for (int i = 1; i <= N; i++)
        if (adj[i].size() == 1)
        {
            distE[i] = 0;
            q.push(i);
        }
    bfs(distE);
    int ans = 0;
    q.push(K);
    vector<bool> v(N + 1, 0);
    while (!q.empty())
    {
        int node = q.front();
        q.pop();
        if (distE[node] <= distB[node])
        {
            ans++;
            continue;
        }
        if (v[node])
            continue;
        v[node] = 1;
        for (int u : adj[node])
            q.push(u);
    }
    cout << ans << endl;
}