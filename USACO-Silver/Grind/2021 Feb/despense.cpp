#include <bits/stdc++.h>
using namespace std;

int N, M;
int v[101][101]; // 0 cant visit, 1 can visit but hasn't, 2 has visited
vector<pair<int, int>> l[100][100];
int dr[4] = {-1, 1, 0, 0}, dc[4] = {0, 0, 1, -1};

void dfs(int r, int c)
{
    for (int i = 0; i < l[r][c].size(); i++)
    {
        // active all boxes from lever
        pair<int, int> p = l[r][c][i];
        v[p.first + 1][p.second + 1] = 1;
        for (int i = 0; i < 4; i++)
        {
            int nr = p.first + dr[i];
            int nc = p.second + dc[i];
            if (v[nr + 1][nc + 1] == 2)
            {
                v[p.first + 1][p.second + 1] = 2;
                dfs(p.first, p.second);
            }
        }
    }
    for (int i = 0; i < 4; i++)
    {
        int nr = r + dr[i];
        int nc = c + dc[i];
        if (v[nr + 1][nc + 1] == 1)
        {
            v[nr + 1][nc + 1] = 2;
            dfs(nr, nc);
        }
    }
}

int main()
{
    cin >> N >> M;
    for (int i = 0; i < M; i++)
    {
        int x, y, xp, yp;
        cin >> x >> y >> xp >> yp;
        l[x][y].push_back({xp, yp});
    }
    v[1][1] = 2;
    dfs(0, 0);
    int ans = 0;
    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < N; i++)
        {
            if (v[i + 1][j + 1] != 0)
                ans++;
        }
    }
    cout << ans << endl;
}