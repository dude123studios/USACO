#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
const int MAXN = 1000;
int N, x[MAXN], y[MAXN];
struct edge
{
    int i, j;
    ll d;
    bool operator<(edge y) { return d < y.d; }
};
vector<edge> edges;
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

    freopen("moocast.in", "r", stdin);
    freopen("moocast.out", "w", stdout);
    cin >> N;
    for (int i = 0; i < N; i++)
        cin >> x[i] >> y[i];
    for (int i = 0; i < N; i++)
        for (int j = i + 1; j < N; j++)
            edges.push_back({i, j, (ll)(pow(x[i] - x[j], 2) + pow(y[i] - y[j], 2))});
    sort(edges.begin(), edges.end());
    DSU dsu(N);
    for (edge e : edges)
    {
        dsu.unite(e.i, e.j);
        if (dsu.comps == 1)
        {
            cout << e.d << endl;
            return 0;
        }
    }
}