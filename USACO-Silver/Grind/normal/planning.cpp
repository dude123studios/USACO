#include <bits/stdc++.h>
using namespace std;
int N, M;
int x[100000], y[100000];
bool v[100000];
vector<int> adj[100000];
int maxx, maxy, minx, miny;

void dfs(int n)
{
    v[n] = 1;
    maxx = max(maxx, x[n]);
    maxy = max(maxy, y[n]);
    minx = min(minx, x[n]);
    miny = min(miny, y[n]);
    for (int u : adj[n])
    {
        if (v[u] != 1)
            dfs(u);
    }
}

int main()
{
    freopen("fenceplan.in", "r", stdin);
    freopen("fenceplan.out", "w", stdout);
    cin >> N >> M;
    for (int i = 0; i < N; i++)
        cin >> x[i] >> y[i];
    for (int i = 0; i < M; i++)
    {
        int a, b;
        cin >> a >> b;
        adj[a - 1].push_back(b - 1);
        adj[b - 1].push_back(a - 1);
    }
    int ans = INT_MAX;
    for (int i = 0; i < N; i++)
    {
        if (v[i] == 1)
            continue;
        maxx = 0;
        maxy = 0;
        minx = INT_MAX;
        miny = INT_MAX;
        dfs(i);
        ans = min(ans, (maxx - minx) + (maxy - miny));
    }
    cout << 2 * ans << endl;
}