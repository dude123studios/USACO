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
int A, B, N, M;
int a[MAX + 2], b[MAX + 2];
int id(int x, int y) { return x * (M + 1) + y; }
vector<edge> edges;
main()
{
    freopen("fencedin.in", "r", stdin);
    freopen("fencedin.out", "w", stdout);
    cin >> A >> B >> N >> M;
    a[N + 1] = A, b[M + 1] = B;
    for (int i = 1; i <= N; i++)
        cin >> a[i];
    for (int i = 1; i <= M; i++)
        cin >> b[i];
    sort(a + 1, a + N + 1);
    sort(b + 1, b + M + 1);
    for (int i = 1; i <= N; i++)
        for (int j = 0; j <= M; j++)
            edges.push_back({id(i, j), id(i - 1, j), b[j + 1] - b[j]});
    for (int i = 0; i <= N; i++)
        for (int j = 1; j <= M; j++)
            edges.push_back({id(i, j), id(i, j - 1), a[i + 1] - a[i]});
    sort(edges.begin(), edges.end());
    int cnt = 0;
    long long length = 0;
    DSU dsu((N + 1) * (M + 1));
    for (edge e : edges)
        if (dsu.unite(e.a, e.b))
        {
            length += e.c;
            cnt++;
        }
    cout << length << endl;
}