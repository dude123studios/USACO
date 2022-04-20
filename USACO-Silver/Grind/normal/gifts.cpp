#include <bits/stdc++.h>
using namespace std;
int N;
vector<int> adj[501];
bool reach[501][501];

void dfs(int src, int cur)
{
    if (reach[src][cur] == 1)
        return;
    reach[src][cur] = 1;
    for (int i : adj[cur])
        dfs(src, i);
}

int main()
{
    cin >> N;
    for (int i = 1; i <= N; i++)
    {
        adj[i].resize(N);
        for (int &v : adj[i])
            cin >> v;
        while (adj[i].back() != i)
            adj[i].pop_back();
    }
    for (int i = 1; i <= N; i++)
        dfs(i, i);
    for (int i = 1; i <= N; i++)
        for (int j : adj[i])
            if (reach[j][i] == 1)
            {
                cout << j << endl;
                break;
            }
}