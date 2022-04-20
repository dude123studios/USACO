#include <bits/stdc++.h>
using namespace std;
#define MAX 100000

int N, t[MAX], g[MAX];
vector<int> adj[MAX];

void dfs(int n)
{
}

int main()
{
    freopen("clocktree.in", "r", stdin);
    freopen("clocktree.out", "w", stdout);
    cin >> N;
    for (int i = 0; i < N; i++)
        cin >> t[i];
    for (int i = 0; i < N - 1; i++)
    {
        int a, b;
        cin >> a >> b;
        adj[a - 1].push_back(b - 1);
        adj[b - 1].push_back(a - 1);
    }
}