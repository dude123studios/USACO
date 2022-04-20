#include <bits/stdc++.h>
using namespace std;
const int MAXN = 2e5 + 1;
int N, M, opening[MAXN];
vector<int> adj[MAXN];
string ans[MAXN];
bool open[MAXN];
struct DSU
{
    int comps;
    vector<int> e;
    DSU(int N)
    {
        e = vector<int>(N, -1);
        comps = N;
    }
    int get(int x) { return e[x] < 0 ? x : e[x] = get(e[x]); }
    bool same(int a, int b) { return get(a) == get(b); }
    int size(int x) { return -e[get(x)]; }
    bool unite(int a, int b)
    {
        a = get(a), b = get(b);
        if (a == b)
            return 0;
        if (e[a] > e[b])
            swap(a, b);
        e[a] += e[b];
        e[b] = a;
        comps--;
        return 1;
    }
};

main()
{
    freopen("closing.in", "r", stdin);
    freopen("closing.out", "w", stdout);
    cin >> N >> M;
    for (int i = 0; i < M; i++)
    {
        int a, b;
        cin >> a >> b;
        adj[a].push_back(b);
        adj[b].push_back(a);
    }
    for (int i = 0; i < N; i++)
        cin >> opening[i];
    reverse(opening, opening + N);
    DSU dsu(N);
    for (int i = 0; i < N; i++)
    {
        int n = opening[i];
        open[n] = 1;
        for (int u : adj[n])
            if (open[u])
                dsu.unite(u, n);
        if (dsu.comps == N - i)
            ans[i] = "YES";
        else
            ans[i] = "NO";
    }
    for (int i = N - 1; i >= 0; i--)
        cout << ans[i] << endl;
}