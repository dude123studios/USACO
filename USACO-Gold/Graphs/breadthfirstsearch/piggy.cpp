#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
const int MAX = 4e4 + 1;
int B, E, P, N, M;
int distB[MAX], distE[MAX], distN[MAX];
vector<int> adj[MAX];
void bfs(int *dist, int i)
{
    fill(dist, dist + N + 1, -1);
    queue<int> q;
    q.push(i);
    dist[i] = 0;
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

    freopen("piggyback.in", "r", stdin);
    freopen("piggyback.out", "w", stdout);
    cin >> B >> E >> P >> N >> M;
    for (int i = 0; i < M; i++)
    {
        int a, b;
        cin >> a >> b;
        adj[a].push_back(b);
        adj[b].push_back(a);
    }
    bfs(distB, 1);
    bfs(distE, 2);
    bfs(distN, N);
    ll ans = 1e18;
    for (int x = 1; x <= N; x++)
        if (distB[x] > -1 && distE[x] > -1 && distN[x] > -1)
            ans = min(ans, (ll)(B * distB[x] + E * distE[x] + P * distN[x]));
    cout << ans << endl;
}