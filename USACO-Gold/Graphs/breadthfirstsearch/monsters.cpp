#include <bits/stdc++.h>
using namespace std;
#define pi pair<int, int>
#define x first
#define y second
#define mp make_pair
const int MAX = 1e3 + 2;
int N, M, dx[4] = {0, 0, 1, -1}, dy[4] = {1, -1, 0, 0};
string dir = "RLDU";
queue<pi> q;
vector<vector<int>> dist(MAX, vector<int>(MAX, INT_MAX));
int path[MAX][MAX];
bool v1[MAX][MAX], v2[MAX][MAX];
pi start;

int main()
{
    // read input
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cin >> N >> M;
    for (int i = 0; i < N; i++)
    {
        string ln;
        cin >> ln;
        for (int j = 0; j < M; j++)
        {
            v1[i + 1][j + 1] = 1;
            v2[i + 1][j + 1] = 1;
            if (ln[j] == 'A')
                start = mp(i + 1, j + 1);
            else if (ln[j] == '#')
            {
                v1[i + 1][j + 1] = 0;
                v2[i + 1][j + 1] = 0;
            }
            else if (ln[j] == 'M')
            {
                q.push(mp(i + 1, j + 1));
                dist[i + 1][j + 1] = 0;
            }
        }
    }
    if (!start.first || !start.second)
    {
        cout << "NO" << endl;
        return 0;
    }
    // process monsters
    while (!q.empty())
    {
        pi n = q.front();
        q.pop();
        if (!v1[n.x][n.y])
            continue;
        v1[n.x][n.y] = 0;
        for (int i = 0; i < 4; i++)
        {
            int nx = n.x + dx[i];
            int ny = n.y + dy[i];
            if (!v1[nx][ny] || dist[nx][ny] < INT_MAX)
                continue;
            dist[nx][ny] = 1 + dist[n.x][n.y];
            q.push(mp(nx, ny));
        }
    }
    // process A
    q.push(start);
    queue<int> t;
    t.push(0);
    pi reaches = mp(-1, -1);
    while (!q.empty())
    {
        pi n = q.front();
        int time = t.front();
        q.pop(), t.pop();
        if (n.x == 1 || n.x == N || n.y == 1 || n.y == M)
        {
            reaches = n;
            break;
        }
        if (!v2[n.x][n.y])
            continue;
        v2[n.x][n.y] = 0;
        for (int i = 0; i < 4; i++)
        {
            int nx = n.x + dx[i];
            int ny = n.y + dy[i];
            if (!v2[nx][ny] || dist[nx][ny] <= time + 1)
                continue;
            path[nx][ny] = i;
            q.push(mp(nx, ny));
            t.push(time + 1);
        }
    }
    if (reaches.first < 0)
        cout << "NO" << endl;
    else
    {
        cout << "YES" << endl;
        pi c = reaches;
        vector<char> moves;
        int reps = 0;
        while (c != start)
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