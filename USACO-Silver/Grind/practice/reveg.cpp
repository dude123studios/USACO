#include <bits/stdc++.h>
using namespace std;
#define MAX 100000

int N, M;
vector<pair<int, bool>> adj[MAX]; // true -> same, false -> diff
int v[MAX];                       // 0-> type 1, 1 -> type 2, -1 -> unused;
bool impos = false;

void dfs(int n, int c)
{
    v[n] = c;
    for (auto [i, b] : adj[n])
    {
        int newc = b ? c : 1 - c;
        if (v[i] == -1)
            dfs(i, newc);
        else if (v[i] != newc)
            impos = true;
    }
}

int main()
{
    freopen("revegetate.in", "r", stdin);
    freopen("revegetate.out", "w", stdout);
    cin >> N >> M;
    for (int i = 0; i < M; i++)
    {
        int a, b;
        char t;
        cin >> t >> a >> b;
        bool same = t == 'S';
        adj[a - 1].push_back({b - 1, same});
        adj[b - 1].push_back({a - 1, same});
    }
    fill(v, v + N, -1);
    int ans = 0;
    for (int i = 0; i < N; i++)
    {
        if (v[i] != -1)
            continue;
        dfs(i, 0);
        ans++;
    }
    if (impos)
        cout << 0 << endl;
    else
    {
        cout << 1;
        for (int i = 0; i < ans; i++)
        {
            cout << 0;
        }
        cout << '\n';
    }
}