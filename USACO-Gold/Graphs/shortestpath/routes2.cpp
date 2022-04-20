#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
typedef pair<ll, int> p;
const ll INF = 1e18;
int main()
{
    int N, M;
    cin >> N >> M;
    vector<ll> dist(N + 1, INF);
    vector<p> adj[N + 1];
    vector<bool> v(N + 1, 0);
    dist[1] = 0;
    for (int i = 0; i < M; i++)
    {
        int a, b, c;
        cin >> a >> b >> c;
        adj[a].push_back({c, b});
    }
    priority_queue<p> q;
    q.push({0, 1});
    while (!q.empty())
    {
        int a = q.top().second;
        q.pop();
        if (v[a])
            continue;
        v[a] = 1;
        for (p n : adj[a])
        {
            int b = n.second;
            ll w = n.first;
            if (dist[a] + w < dist[b])
            {
                dist[b] = dist[a] + w;
                q.push({-dist[b], b});
            }
        }
    }
    for (int i = 1; i <= N; i++)
        cout << dist[i] << " ";
    cout << '\n';
}