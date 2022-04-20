// silver 2021 dec q2
#include <bits/stdc++.h>
using namespace std;

int T, N, M;
vector<int> adj[10000];

vector<vector<int>> clusters;
int c1, c2;
bool v[10000];

void dfs(int n, int c)
{
    if (n == 0)
        c1 = c;
    else if (n == N - 1)
    {
        c2 = c;
    }
    v[n] = true;
    for (int next : adj[n])
    {
        if (v[next] == 1)
            continue;
        clusters[c].push_back(next);
        dfs(next, c);
    }
}

long long dist(vector<int> clust1, vector<int> clust2)
{
    int d = 10000;
    sort(clust1.begin(), clust1.end());
    sort(clust2.begin(), clust2.end());

    for (int n : clust1)
    {
        int idx = lower_bound(clust2.begin(), clust2.end(), n) - clust2.begin();
        if (idx != clust2.size() - 1)
            d = min(d, abs(n - clust2[idx + 1]));
        d = min(d, abs(n - clust2[idx]));
    }
    return ((long long)d) * ((long long)d);
}

void solve()
{
    // read inputs
    cin >> N >> M;
    for (int i = 0; i < N; i++)
    {
        int v1, v2;
        cin >> v1 >> v2;
        adj[v1 - 1].push_back(v2 - 1);
        adj[v2 - 1].push_back(v1 - 1);
    }

    // form clusters
    int c = 0;
    for (int i = 0; i < N; i++)
    {
        if (v[i] == 1)
            continue;
        vector<int> newc{i};
        clusters.push_back(newc);
        dfs(i, c);
        c++;
    }

    // in same group
    if (c1 == c2)
    {
        cout << 0 << endl;
        return;
    }
    //
    long long d = dist(clusters[c1], clusters[c2]);
    for (int i = 0; i < clusters.size(); i++)
    {
        if (i == c1 || i == c2)
            continue;
        d = min(d, dist(clusters[c1], clusters[i]) + dist(clusters[i], clusters[c2]));
    }
    cout << d << endl;
}

int main()
{
    cin >> T;
    for (int i = 0; i < T; i++)
    {
        // RESET EVERYTHING
        solve();
    }
}