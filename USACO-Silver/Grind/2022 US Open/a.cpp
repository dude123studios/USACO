#include <bits/stdc++.h>
using namespace std;
using vi = vector<int>;
typedef long long ll;
#define pb push_back
int N;
const int mx = 1e5 + 1;

// adj_t is the transpose of adj
vi adj[mx], adj_t[mx], S;
bool vis[mx];
int id[mx], v[mx];
vector<set<int>> comp;

void dfs(int x, int pass, int num = 0)
{
    vis[x] = true;
    vi &ad = (pass == 1) ? adj[x] : adj_t[x];
    for (const int &e : ad)
    {
        if (!vis[e])
            dfs(e, pass, num);
    }

    S.pb(x);
    if (pass == 2)
        id[x] = num;
}

int main()
{
    ll total = 0;
    cin >> N;
    for (int i = 1; i <= N; i++)
    {
        int a, val;
        cin >> a >> val;
        adj[i].pb(a);
        adj_t[a].pb(i);
        v[i] = val;
        total += val;
    }
    for (int i = 1; i <= N; i++)
    {
        if (!vis[i])
            dfs(i, 1);
    }
    memset(vis, false, sizeof vis);
    int components = 0;

    for (int i = N - 1; i >= 0; i--)
    {
        if (!vis[S[i]])
        {
            components++;
            dfs(S[i], 2, components);
        }
    }

    comp.resize(components + 1);
    for (int i = 1; i <= N; i++)
        comp[id[i]].insert(v[i]);
    ll ans = 0;
    for (set<int> s : comp)
    {
        if (s.size() <= 1)
            continue;
        ans += *s.begin();
    }
    cout << total - ans << endl;
}