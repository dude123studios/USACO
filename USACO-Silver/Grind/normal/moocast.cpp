#include <bits/stdc++.h>
using namespace std;
int N;
int x[200], y[200], p[200];
vector<int> adj[200];
int a;
bool v[200];

void dfs(int n)
{
    v[n] = 1;
    a++;
    for (int u : adj[n])
        if (!v[u])
            dfs(u);
}

int main()
{

    freopen("moocast.in", "r", stdin);
    freopen("moocast.out", "w", stdout);
    cin >> N;
    for (int i = 0; i < N; i++)
        cin >> x[i] >> y[i] >> p[i];
    for (int i = 0; i < N; i++)
        for (int j = i + 1; j < N; j++)
        {
            int dist = (x[i] - x[j]) * (x[i] - x[j]) + (y[i] - y[j]) * (y[i] - y[j]);
            if (p[i] * p[i] >= dist)
                adj[i].push_back(j);
            if (p[j] * p[j] >= dist)
                adj[j].push_back(i);
        }
    int ans = 0;
    for (int i = 0; i < N; i++)
    {
        a = 0;
        fill(v, v + N, 0);
        dfs(i);
        ans = max(ans, a);
    }
    cout << ans << endl;
}