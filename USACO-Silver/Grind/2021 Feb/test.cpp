#include <bits/stdc++.h>
using namespace std;

main()
{
    int N;
    cin >> N;
    bool v[N + 2][N + 2];
    for (int i = 0; i < N; i++)
    {
        string l;
        cin >> l;
        for (int j = 0; j < N; j++)
        {
            v[i + 1][j + 1] = l[j] == '*';
        }
    }
    queue<tuple<int, int, int>> q;
    q.push({0, 0, 0});
    int dir[4][2] = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    while (!q.empty())
    {
        tuple<int, int, int> loc = q.front();
        int r = get<0>(loc), c = get<1>(loc), t = get<2>(loc);
        q.pop();
        if (r == N - 1 && c == N - 1)
        {
            cout << t << '\n';
            break;
        }
        for (int i = 0; i < 4; i++)
        {
            int nr = r + dir[i][0];
            int nc = c + dir[i][1];
            if (v[r + 1][c + 1])
            {
                v[r + 1][c + 1] = false;
                q.push({nr, nc, t + 1});
            }
        }
    }
}