#include <bits/stdc++.h>
using namespace std;

int N, Q;
// list of (v, relevance)
vector<pair<int, long long>> adj[5000];

bool vis[5000];
int nodes = 0;

void reset(int v)
{
    nodes = 0;
    for (int i = 0; i < N; i++)
        vis[i] = false;
    vis[v] = true;
}

// traverse paths with k
void dfs(int k, int v)
{
    for (auto p : adj[v])
    {
        if (vis[p.first] == 1 || p.second < k)
            continue;
        vis[p.first] = true;
        nodes++;
        dfs(k, p.first);
    }
}

int main()
{
    cin >> N >> Q;
    for (int i = 0; i < N - 1; i++)
    {
        int a, b, c;
        cin >> a >> b >> c;
        adj[a - 1].push_back({b - 1, c});
        adj[b - 1].push_back({a - 1, c});
    }
    for (int i = 0; i < Q; i++)
    {
        int k, v;
        cin >> k >> v;
        reset(v - 1);
        dfs(k, v - 1);
        cout << nodes << endl;
    }
}