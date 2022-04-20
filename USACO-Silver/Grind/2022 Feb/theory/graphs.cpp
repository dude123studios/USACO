#include <bits/stdc++.h>
using namespace std;
int N, M;
vector<int> adj[100005];
bool v[100005];

// connected components
int comp[100005];
void dfs_comp(int n, int c)
{
    comp[n] = c;
    v[n] = 1;
    for (auto u : adj[n])
    {
        if (!v[u])
            dfs_comp(u, c);
    }
}
void connected_comp()
{
    int c = 0;
    for (int i = 0; i < N; i++)
    {
        if (!v[i])
            dfs_comp(i, c);
        c++;
    }
}

// cycles
bool cycles = false;
void dfs_cycle(int n, int p)
{
    v[n] = 1;
    for (auto u : adj[n])
    {
        if (!v[u])
            dfs_cycle(u, n);
        else if (u != p)
            cycles = true;
    }
}

// bipartite check
bool bipartite = true;
bool color[100005];
void dfs_bp(int n, bool c)
{
    v[n] = 1;
    color[n] = c;
    for (auto u : adj[n])
    {
        if (!v[u])
            dfs_bp(u, !c);
        else if (color[u] == c)
            bipartite = false;
    }
}

int main()
{
    cin >> N >> M;
    for (int i = 0; i < M; i++)
    {
        int a, b;
        cin >> a >> b;
        adj[a - 1].push_back(b - 1);
        adj[b - 1].push_back(a - 1);
    }
}