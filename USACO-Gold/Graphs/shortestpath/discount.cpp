#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
typedef pair<ll, ll> pll;
const ll INF = 2e18;
const int MAX = 1e5 + 1;
int N, M;
vector<tuple<int, int, int>> edges(2 * MAX);
vector<pll> flights[MAX], flights_t[MAX];
ll dist[MAX], distN[MAX];

void sp(ll *d, vector<pll> *adj, int x)
{
    for (int i = 1; i <= N; i++)
        d[i] = INF;
    d[x] = 0;
    vector<bool> v(N + 1, 0);
    priority_queue<pll> q;
    q.push({0, x});
    while (!q.empty())
    {
        int a = q.top().second;
        q.pop();
        if (v[a])
            continue;
        v[a] = 1;
        for (pll u : adj[a])
        {
            ll b = u.second, w = u.first;
            if (d[a] + w < d[b])
            {
                d[b] = d[a] + w;
                q.push({-d[b], b});
            }
        }
    }
}

int main()
{
    cin >> N >> M;
    for (int i = 0; i < M; i++)
    {
        int a, b, c;
        cin >> a >> b >> c;
        flights[a].push_back({c, b});
        flights_t[b].push_back({c, a});
        edges[i] = {a, b, c};
    }
    sp(dist, flights, 1);
    sp(distN, flights_t, N);
    ll ans = INF;
    for (int i = 0; i < M; i++)
    {
        int a = get<0>(edges[i]);
        int b = get<1>(edges[i]);
        int c = get<2>(edges[i]);
        int discount = c / 2;
        ans = min(ans, dist[a] + discount + distN[b]);
    }
    cout << ans << endl;
}