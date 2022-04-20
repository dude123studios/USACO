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
    bool operator<(edge y) { return c > y.c; }
};
int N, M, id[2000];
vector<edge> edges;
main()
{
    freopen("superbull.in", "r", stdin);
    freopen("superbull.out", "w", stdout);
    cin >> N;
    for (int i = 0; i < N; i++)
        cin >> id[i];
    for (int i = 0; i < N; i++)
        for (int j = i + 1; j < N; j++)
            edges.push_back({i, j, id[i] ^ id[j]});
    sort(edges.begin(), edges.end());
    int built = 0;
    long long cost = 0;
    DSU dsu(N);
    for (edge e : edges)
    {
        if (dsu.unite(e.a, e.b))
        {
            built++;
            cost += e.c;
        }
    }
    if (built != N - 1)
        cout << "IMPOSSIBLE" << endl;
    else
        cout << cost << endl;
}