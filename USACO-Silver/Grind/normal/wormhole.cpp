#include <bits/stdc++.h>
using namespace std;
int N, M;
int p[100001];
bool v[100001];
vector<pair<int, int>> adj[100001];
set<int> cowcomp, poscomp;

void dfs(int n, int x)
{
    v[n] = 1;
    poscomp.insert(n);
    cowcomp.insert(p[n]);
    for (auto u : adj[x])
        if (!v[u.first] && u.second >= x)
            dfs(u.first, x);
}

bool check(int x)
{
    for (int i = 1; i <= N; i++)
    {
        if (v[i])
            continue;
        cowcomp.clear();
        poscomp.clear();
        dfs(i, x);
        if (cowcomp == poscomp)
            continue;
        return 0;
    }
    return 1;
}

int main()
{

    freopen("wormsort.in", "r", stdin);
    freopen("wormsort.out", "w", stdout);
    cin >> N >> M;
    bool sorted = 1;
    for (int i = 1; i <= N; i++)
    {
        cin >> p[i];
        if (p[i] != i)
            sorted = 0;
    }
    if (sorted)
    {
        cout << -1 << endl;
        return 0;
    }
    int high = 0;
    for (int i = 0; i < M; i++)
    {
        int a, b, w;
        cin >> a >> b >> w;
        high = max(w, high);
        adj[a].push_back({b, w});
        adj[b].push_back({a, w});
    }

    fill(v, v + N, 0);
    int low = 0;

    while (low < high)
    {
        int mid = low + (high - low) / 2;
        if (check(mid) == 1)
            high = mid;
        else
            low = mid + 1;
    }
    cout << low << endl;
}