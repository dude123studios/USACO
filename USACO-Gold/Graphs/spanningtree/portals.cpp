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
int N;
vector<edge> edges;
main()
{
    cin >> N;
    DSU dsu(2 * N);
    for (int i = 0; i < N; i++)
    {
        int c, p1, p2, p3, p4;
        cin >> c >> p1 >> p2 >> p3 >> p4;
        dsu.unite(p1 - 1, p2 - 1);
        dsu.unite(p3 - 1, p4 - 1);
        edges.push_back({p1 - 1, p3 - 1, c});
    }
    sort(edges.begin(), edges.end());
    int cost = 0;
    for (edge e : edges)
        if (dsu.unite(e.a, e.b))
            cost += e.c;
    cout << cost << endl;
}