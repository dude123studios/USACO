#include <bits/stdc++.h>
using namespace std;

int K, N, M, f[100], freq[1000];
bool v[1000];

vector<vector<int>> adj(1000);

void reset()
{
    for (int i = 0; i < N; i++)
        v[i] = false;
}

void dfs(int node)
{
    freq[node]++;
    for (int el : adj[node])
    {
        if (v[el] == 1)
            continue;
        v[el] = true;
        dfs(el);
    }
}

int main()
{
    cin >> K >> N >> M;
    for (int i = 0; i < K; i++)
    {
        int val;
        cin >> val;
        f[i] = val - 1;
    }
    for (int i = 0; i < M; i++)
    {
        int j, k;
        cin >> j >> k;
        adj[j - 1].push_back(k - 1);
    }
    for (int i = 0; i < K; i++)
    {
        reset();
        v[f[i]] = true;
        dfs(f[i]);
    }
    int ans = 0;
    for (int i = 0; i < N; i++)
    {
        if (freq[i] == K)
            ans++;
    }
    cout << ans << endl;
}