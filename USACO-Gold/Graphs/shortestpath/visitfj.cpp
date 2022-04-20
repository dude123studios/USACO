#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
struct e
{
    long long d;
    int x, y, t;
    bool operator<(const e &other) const { return d > other.d; }
};

const ll INF = 2e18;
const int MAX = 102;

int N, T;
int dx[4] = {0, 0, -1, 1}, dy[4] = {1, -1, 0, 0};
ll grass[MAX][MAX], dist[MAX][MAX][3];
bool v[MAX][MAX][3];

int main()
{
    freopen("visitfj.in", "r", stdin);
    freopen("visitfj.out", "w", stdout);
    cin >> N >> T;
    for (int i = 1; i <= N; i++)
        for (int j = 1; j <= N; j++)
            cin >> grass[i][j];

    // dijsktra
    for (int i = 1; i <= N; i++)
        for (int j = 1; j <= N; j++)
            for (int k = 0; k < 3; k++)
            {
                v[i][j][k] = 1;
                dist[i][j][k] = INF;
            }

    priority_queue<e> q;
    q.push({0, 1, 1, 0});
    dist[1][1][0] = 0;
    while (!q.empty())
    {
        int x = q.top().x;
        int y = q.top().y;
        int t = q.top().t;
        q.pop();
        if (!v[x][y][t])
            continue;
        v[x][y][t] = 0;
        int w = T + (t == 0 ? grass[x][y] : 0), nt = (t + 1) % 3;
        for (int i = 0; i < 4; i++)
        {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (!v[nx][ny][nt])
                continue;
            if (dist[x][y][t] + w < dist[nx][ny][nt])
            {
                dist[nx][ny][nt] = dist[x][y][t] + w;
                q.push({dist[nx][ny][nt], nx, ny, nt});
            }
        }
    }
    cout << min({dist[N][N][0] + grass[N][N], dist[N][N][1], dist[N][N][2]}) - grass[1][1] << endl;
}
