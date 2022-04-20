#include <bits/stdc++.h>
using namespace std;

typedef long long ll;
typedef pair<ll, ll> pll;
const ll INF = 2e18;
const int MAXN = 5e4 + 1, MAXM = 1e5 + 1;

int N, M, K;
int t[MAXN], y[MAXN];
vector<pll> adj[MAXN];

int sp(int flow)
{
    vector<ll> d(N + 1, INF);
    vector<bool> v(N + 1, 0);
    priority_queue<pll> q;
    q.push({0, 1});
    d[1] = 0;
    while (!q.empty())
    {
        int a = q.top().second;
        q.pop();
        if (v[a])
            continue;
        v[a] = 1;
        for (pll u : adj[a])
        {
            ll b = u.first, id = t[u.second] - y[u.second];
            if ((f[id] >= flow) && d[a] + c[id] < d[b])
            {
                d[b] = d[a] + c[id];
                q.push({-d[b], b});
            }
        }
    }
    return d[N];
}
int main()
{
    /*
    freopen("dining.in", "r", stdin);
    freopen("dining.out", "w", stdout);*/
    cin >> N >> M >> K;
    for (int i = 0; i < M; i++)
    {
        int a, b;
        cin >> a >> b >> t[i];
        adj[a].push_back({b, i});
        adj[b].push_back({a, i});
    }
    double ans = 0;
    for (int i = 0; i < M; i++)
    {
        double dist = sp(f[i]);
        ans = max(ans, ((double)f[i]) / dist);
    }
    cout << (int)(ans * 1e6) << endl;
}