#include <bits/stdc++.h>
using namespace std;
const int MAXN = 1e5 + 1;
int N, M;

struct DSU
{
    vector<int> e;
    int largest = 1;
    DSU(int N) { e = vector<int>(N, -1); }

    // get representive component (uses path compression)
    int get(int x) { return e[x] < 0 ? x : e[x] = get(e[x]); }

    bool same(int a, int b) { return get(a) == get(b); }

    int size(int x) { return -e[get(x)]; }

    bool unite(int x, int y)
    { // union by size
        x = get(x), y = get(y);
        if (x == y)
            return false;
        if (e[x] > e[y])
            swap(x, y);
        e[x] += e[y];
        e[y] = x;
        N--;
        largest = max(largest, -e[x]);
        return true;
    }
};

main()
{
    cin >> N >> M;
    DSU dsu(N);
    while (M--)
    {
        int a, b;
        cin >> a >> b;
        dsu.unite(a, b);
        cout << N << " " << dsu.largest << endl;
    }
}