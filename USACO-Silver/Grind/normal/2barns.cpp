#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
int N, M;
bool v[100001];
vector<int> adj[100001];
vector<set<int>> comp;
set<int> curr;
int start, last;

void dfs(int n)
{
    v[n] = 1;
    curr.insert(n);
    for (int u : adj[n])
        if (!v[u])
            dfs(u);
}

ll connect(int i, int j)
{
    set<int> f = comp[i];
    set<int> s = comp[j];
    int dist = INT_MAX;
    auto its = s.begin();
    for (auto itf : f)
    {
        while (*its < itf && its != s.end())
        {
            dist = min(dist, abs(*its - itf));
            its++;
        }
        if (its != s.end())
            dist = min(dist, abs(*its - itf));
    }
    return dist * dist;
}

void solve()
{
    cin >> N >> M;
    vector<int> vect;
    comp.clear();
    comp.resize(N);
    fill(adj + 1, adj + N + 1, vect);
    fill(v + 1, v + N + 1, 0);
    for (int i = 0; i < M; i++)
    {
        int a, b;
        cin >> a >> b;
        adj[a].push_back(b);
        adj[b].push_back(a);
    }
    int c = 0;
    for (int i = 1; i <= N; i++)
    {
        if (v[i])
            continue;
        curr.clear();
        dfs(i);
        comp[c] = curr;
        if (curr.find(1) != curr.end())
            start = c;
        if (curr.find(N) != curr.end())
            last = c;
        c++;
    }
    if (start == last)
    {
        cout << 0 << endl;
        return;
    }
    // 1 new road
    ll ans = connect(start, last);
    // 2 roads
    for (int i = 0; i < c; i++)
    {
        if (i == start || i == last)
            continue;
        ans = min(ans, connect(start, i) + connect(i, last));
    }
    cout << ans << endl;
}

int main()
{

    int T;
    cin >> T;
    while (T--)
        solve();
}