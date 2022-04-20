#include <bits/stdc++.h>
using namespace std;
#define pi pair<int, int>
#define x first
#define y second
const int MAX = 1e3 + 2;
int N, M, dx[4] = {0, 0, 1, -1}, dy[4] = {1, -1, 0, 0}, sx, sy, ex, ey;
bool grid[MAX][MAX];
string dir = "RLDU";
;
int main()
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cin >> N >> M;
    vector<vector<int>> path(N + 2, vector<int>(M + 2, -1));
    for (int i = 0; i < N; i++)
    {
        string ln;
        cin >> ln;
        for (int j = 0; j < M; j++)
        {
            if (ln[j] == 'A')
            {
                sx = i + 1;
                sy = j + 1;
                grid[sx][sy] = 1;
            }
            else if (ln[j] == 'B')
            {
                ex = i + 1;
                ey = j + 1;
                grid[ex][ey] = 1;
            }
            else if (ln[j] == '.')
                grid[i + 1][j + 1] = 1;
        }
    }
    if (!sx || !sy || !ex || !ey)
    {
        cout << "NO" << endl;
        return 0;
    }
    queue<pi> q;
    q.push({sx, sy});
    bool reached = 0;
    while (!q.empty())
    {
        pi n = q.front();
        q.pop();
        if (!grid[n.x][n.y])
            continue;
        grid[n.x][n.y] = 0;
        for (int i = 0; i < 4; i++)
        {
            int nx = n.x + dx[i];
            int ny = n.y + dy[i];
            if (!grid[nx][ny])
                continue;
            path[nx][ny] = i;
            q.push(make_pair(nx, ny));
        }
    }
    if (path[ex][ey] < 0)
        cout << "NO" << endl;
    else
    {
        cout << "YES" << endl;
        pi c = {ex, ey};
        vector<char> moves;
        while (!(c.x == sx && c.y == sy))
        {
            int i = path[c.x][c.y];
            moves.push_back(dir[i]);
            c.x -= dx[i];
            c.y -= dy[i];
        }
        cout << moves.size() << endl;
        reverse(moves.begin(), moves.end());
        for (char i : moves)
            cout << i;
    }
}