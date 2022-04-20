#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
const int MAX = 500;
int N, grid[MAX][MAX], dx[4] = {1, -1, 0, 0}, dy[4] = {0, 0, 1, -1};
int id(int x, int y) { return x * N + y; }
struct edge
{
    int i, j, d;
    bool operator<(edge y) { return d < y.d; }
};
vector<edge> edges;
struct DSU
{
    int largest = -1;
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
        largest = max(largest, size(a));
        return 1;
    }
};

main()
{
    freopen("tractor.in", "r", stdin);
    freopen("tractor.out", "w", stdout);
    cin >> N;
    for (int i = 0; i < N; i++)
        for (int j = 0; j < N; j++)
            cin >> grid[i][j];
    for (int i = 0; i < N; i++)
        for (int j = 0; j < N; j++)
            for (int k = 0; k < 4; k++)
            {
                int ni = i + dx[k];
                int nj = j + dy[k];
                if (ni >= 0 && ni < N && nj >= 0 && nj < N)
                    edges.push_back({id(i, j), id(ni, nj), abs(grid[ni][nj] - grid[i][j])});
            }
    sort(edges.begin(), edges.end());
    DSU dsu(N * N);
    set<int> visited;
    for (edge e : edges)
    {
        dsu.unite(e.i, e.j);
        if (2 * dsu.largest >= N * N)
        {
            cout << e.d << endl;
            return 0;
        }
    }
}