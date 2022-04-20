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
int N, M;
vector<edge> edges;
main()
{
    cin >> N >> M;
    for (int i = 0; i < M; i++)
    {
        int a, b, c;
        cin >> a >> b >> c;
        edges.push_back({a - 1, b - 1, c});
    }
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
        if (built == N - 1)
            break;
    }
    if (built < N - 1)
        cout << "IMPOSSIBLE" << endl;
    else
        cout << cost << endl;
}