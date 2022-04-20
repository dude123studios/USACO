#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
const ll INF = 2e18;
int main()
{
    int N, M, Q;
    cin >> N >> M >> Q;
    vector<vector<ll>> dist(N + 1, vector<ll>(N + 1, INF));
    for (int i = 0; i < M; i++)
    {
        ll a, b, c;
        cin >> a >> b >> c;
        dist[a][b] = min(dist[a][b], c);
        dist[b][a] = min(dist[b][a], c);
    }
    for (int i = 1; i <= N; i++)
        dist[i][i] = 0;
    for (int k = 1; k <= N; k++)
        for (int i = 1; i <= N; i++)
            for (int j = 1; j <= N; j++)
                dist[i][j] = min(dist[i][j], dist[i][k] + dist[k][j]);
    for (int i = 0; i < Q; i++)
    {
        int a, b;
        cin >> a >> b;
        cout << (ll)(dist[a][b] == INF ? -1 : dist[a][b]) << endl;
    }
}