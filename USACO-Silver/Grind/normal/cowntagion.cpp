#include <bits/stdc++.h>
using namespace std;
int N;
vector<int> adj[100001];
int ans = 0;
void dfs(int n, int prev)
{
    int neighbors = adj[n].size() - (prev ? 1 : 0); // exclude previous
    if (neighbors == 0)
        return;
    ans += ((int)log2(neighbors)) + 1 + neighbors;
    for (int u : adj[n])
        if (u != prev)
            dfs(u, n);
}

int main()
{
    cin >> N;
    for (int i = 0; i < N - 1; i++)
    {
        int a, b;
        cin >> a >> b;
        adj[a].push_back(b);
        adj[b].push_back(a);
    }
    dfs(1, 0);
    cout << ans << endl;
}