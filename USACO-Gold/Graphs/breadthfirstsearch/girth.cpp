#include <bits/stdc++.h>
using namespace std;
const int MAX = 2501, INF = 1e9 + 7;
int N, M;
vector<int> adj[MAX];

int shortest_cycle(int i)
{
    int ans = INF;
    vector<int> dist(N + 1, -1);
    queue<int> q;
    q.push(i);
    dist[i] = 0;
    while (!q.empty())
    {
        int node = q.front();
        q.pop();
        for (int adj_node : adj[node])
        {
            if (dist[adj_node] == -1)
            {
                dist[adj_node] = dist[node] + 1;
                q.push(adj_node);
            }
            else if (dist[adj_node] >= dist[node])
                ans = min(ans, dist[adj_node] + dist[node] + 1);
        }
    }
    return ans;
}
int main()
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cin >> N >> M;
    for (int i = 0; i < M; i++)
    {
        int a, b;
        cin >> a >> b;
        adj[a].push_back(b);
        adj[b].push_back(a);
    }
    int ans = INF;
    for (int i = 1; i <= N; i++)
        ans = min(ans, shortest_cycle(i));
    if (ans == INF)
        cout << -1 << endl;
    else
        cout << ans << endl;
}