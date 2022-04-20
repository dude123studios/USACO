#include <bits/stdc++.h>
using namespace std;
int N;
bool a[102][102][102];
int dx[6] = {0, 0, 0, 0, 1, -1}, dy[6] = {0, 0, 1, -1, 0, 0}, dz[6] = {1, -1, 0, 0, 0, 0};
void ff(int x, int y, int z)
{
    a[x][y][z] = 0;
    for (int i = 0; i < 6; i++)
    {
        int nx = dx[i] + x;
        int ny = dy[i] + y;
        int nz = dz[i] + z;
        if (a[nx][ny][nz] == 1)
            ff(nx, ny, nz);
    }
}

int main()
{
    cin >> N;
    for (int i = 1; i <= N; i++)
    {
        for (int j = 1; j <= N; j++)
        {
            for (int k = 1; k <= N; k++)
            {
                char s;
                cin >> s;
                a[i][j][k] = s == '*';
            }
        }
    }
    int ans = 0;
    for (int i = 1; i <= N; i++)
    {
        for (int j = 1; j <= N; j++)
        {
            for (int k = 1; k <= N; k++)
            {
                if (a[i][j][k] == 1)
                {
                    ff(i, j, k);
                    ans++;
                }
            }
        }
    }
    cout << ans << endl;
}