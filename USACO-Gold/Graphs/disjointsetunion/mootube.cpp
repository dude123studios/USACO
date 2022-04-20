#include <bits/stdc++.h>
using namespace std;
typedef pair<int, int> pii;
#define n first
#define r second
const int MAX = 1e5 + 1;
int N, Q, ans[MAX];

struct e
{
    int a, b, c;
    bool operator<(e y) { return c > y.c; }
};
e edges[MAX], queries[MAX];

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

main()
{

    freopen("mootube.in", "r", stdin);
    freopen("mootube.out", "w", stdout);
    cin >> N >> Q;
    for (int i = 0; i < N - 1; i++)
    {
        int a, b, r;
        cin >> a >> b >> r;
        edges[i] = {a, b, r};
    }
    for (int i = 0; i < Q; i++)
    {
        int k, v;
        cin >> k >> v;
        queries[i] = {i, v, k};
    }
    sort(edges, edges + N - 1);
    sort(queries, queries + Q);

    DSU dsu(N);
    int idx = 0;
    for (int i = 0; i < Q; i++)
    {
        e q = queries[i];
        while (idx < N - 1 && edges[idx].c >= q.c)
        {
            dsu.unite(edges[idx].a, edges[idx].b);
            idx++;
        }
        ans[q.a] = dsu.size(q.b) - 1;
    }
    for (int i = 0; i < Q; i++)
        cout << ans[i] << endl;
}