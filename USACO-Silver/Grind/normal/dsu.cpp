#include <bits/stdc++.h>
using namespace std;
struct DSU
{
    vector<int> p;
    vector<int> sz;
    DSU(int N)
    {
        p = vector<int>(N);
        for (int i = 0; i < N; i++)
            p[i] = i;
        sz = vector<int>(N, 1);
    }
    int get(int x) { return p[x] == x ? x : get(p[x]); }
    bool same(int a, int b) { return get(a) == get(b); }
    int size(int x) { return sz[x]; }
    void unite(int a, int b)
    {
        a = get(a);
        b = get(b);
        if (sz[a] < sz[b])
            swap(a, b);
        sz[a] += sz[b];
        p[b] = a;
    }
};

main()
{
    int N, M;
    cin >> N >> M;
    DSU dsu(N);
    for (int i = 0; i < M; i++)
    {
        string t;
        int a, b;
        cin >> t >> a >> b;
        if (t == "union")
            dsu.unite(a - 1, b - 1);
        else if (dsu.same(a - 1, b - 1))
            cout << "YES" << endl;
        else
            cout << "NO" << endl;
    }
}