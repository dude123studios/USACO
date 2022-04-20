#include <bits/stdc++.h>
using namespace std;
#define MAX 100000

int N, M;
vector<pair<int, bool>> adj[MAX];
bool c[MAX];
bool v[MAX];
bool pos = true;
void dfs(int n, bool col)
{
    v[n] = 1;
    c[n] = col;
    for (pair<int, int> i : adj[n])
    {
        int u = i.first;
        bool same = i.second;
        if (v[u] == 1)
        {
            if ((c[u] == col) != same)
                pos = false;
            continue;
        }
        if (same)
            dfs(u, col);
        else
            dfs(u, !col);
    }
}

int main()
{
    cin >> N >> M;
    for (int i = 0; i < M; i++)
    {
        char s;
        int a, b;
        cin >> s >> a >> b;
        adj[a - 1].push_back({b - 1, s == 'S'});
        adj[b - 1].push_back({a - 1, s == 'S'});
    }
    int ans = 0;
    for (int i = 0; i < N; i++)
    {
        if (v[i] != 1)
        {
            dfs(i, 1);
            ans++;
        }
    }
    if (!pos)
    {
        cout << 0 << endl;
        return 0;
    }
    cout << 1;
    for (int i = 0; i < ans; i++)
        cout << 0;
    cout << '\n';
}