#include <bits/stdc++.h>
using namespace std;

int N, M, nodes;
vector<vector<int>> gt(100), lt(100);
bool v[100];

void reset()
{
    for (int i = 0; i < N; i++)
        v[i] = false;
    nodes = 0;
}

void dfs(int node, vector<vector<int>> adj)
{
    for (int el : adj[node])
    {
        if (v[el] == 1)
            continue;
        v[el] = true;
        nodes++;
        dfs(el, adj);
    }
}

int main()
{
    cin >> N >> M;
    for (int i = 0; i < M; i++)
    {
        int j, k;
        cin >> j >> k;
        gt[k - 1].push_back(j - 1);
        lt[j - 1].push_back(k - 1);
    }
    int ans = 0;
    for (int i = 0; i < N; i++)
    {
        reset();
        dfs(i, gt);
        int curr = nodes;
        reset();
        dfs(i, lt);
        curr += nodes;
        if (curr == N - 1)
            ans++;
    }
    cout << ans << endl;
}