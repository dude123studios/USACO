#include <bits/stdc++.h>
using namespace std;
typedef pair<int, int> pi;
typedef long long ll;
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
struct e
{
    int a, b;
    ll c;
    bool operator<(e y) { return c < y.c; }
};
int N;
pi closest[11];
vector<e> coords, edges;
main()
{
    cin >> N;
    for (int i = 0; i < N; i++)
    {
        int x, y;
        cin >> x >> y;
        coords.push_back({i, y, x});
    }
    sort(coords.begin(), coords.end());

    for (int i = 0; i <= 10; i++)
        closest[i] = {-1, 0};
    for (e p : coords)
    {
        for (int i = 0; i <= 10; i++)
            if (closest[i].first != -1)
                edges.push_back({p.a, closest[i].second, (ll)(pow(p.c - closest[i].first, 2) + pow(p.b - i, 2))});
        closest[p.b] = {p.c, p.a};
    }
    sort(edges.begin(), edges.end());
    ll cost = 0;
    DSU dsu(N);
    for (e edge : edges)
        if (dsu.unite(edge.a, edge.b))
            cost += edge.c;
    cout << cost << endl;
}