#include <bits/stdc++.h>
using namespace std;
#define mx 201
int N, x[mx], y[mx], p[mx], cnt;
vector<int> adj[mx];
bool v[mx];
void dfs(int n)
{
    cnt++;
    v[n] = 1;
    for (int u : adj[n])
        if (!v[u])
            dfs(u);
}
int main()
{
    cin >> N;
    for (int i = 1; i <= N; i++)
        cin >> x[i] >> y[i] >> p[i];
    for (int i = 1; i <= N; i++)
        for (int j = 1; j <= N; j++)
            if (pow(x[i] - x[j], 2) + pow(y[i] - y[j], 2) <= pow(p[i], 2))
                adj[i].push_back(j);

    int ans = 0;
    for (int i = 1; i <= N; i++)
    {
        fill(v + 1, v + N + 1, 0);
        cnt = 0;
        dfs(i);
        ans = max(ans, cnt);
    }
    cout << ans << endl;
}