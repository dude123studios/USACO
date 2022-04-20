#include <bits/stdc++.h>
using namespace std;
struct DSU
{
    vector<int> e;
    DSU(int N) { e = vector<int>(N, -1); }
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
        return 1;
    }
};
struct edge
{
    int a, b, c;
    bool operator<(edge y) { return c < y.c; }
};
const int MAX = 2e3;
int N, d[MAX][MAX];
vector<pair<int, int>> adj[MAX];
vector<edge> edges;

bool dfs(int node, int prev, int dist, int original)
{
    if (dist != d[node][original] || dist != d[original][node])
        return 0;
    for (auto p : adj[node])
        if (p.first != prev)
            if (!dfs(p.first, node, dist + p.second, original))
                return 0;
    return 1;
}

main()
{
    cin >> N;
    for (int i = 0; i < N; i++)
        for (int j = 0; j < N; j++)
        {
            cin >> d[i][j];
            edges.push_back({i, j, d[i][j]});
        }
    sort(edges.begin(), edges.end());
    DSU dsu(N);
    for (edge e : edges)
        if (dsu.unite(e.a, e.b))
        {
            adj[e.a].push_back({e.b, e.c});
            adj[e.b].push_back({e.a, e.c});
        }
    bool works = 1;
    for (int i = 0; i < N; i++)
        works &= dfs(i, -1, 0, i);
    if (works)
        cout << "YES" << endl;
    else
        cout << "NO" << endl;
}