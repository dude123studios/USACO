#include <bits/stdc++.h>
using namespace std;
int N, K;
int PSUM[1001][1001];

int main()
{

    freopen("paintbarn.in", "r", stdin);
    freopen("paintbarn.out", "w", stdout);
    cin >> N >> K;
    for (int i = 0; i < N; i++)
    {
        int x1, y1, x2, y2;
        cin >> x1 >> y1 >> x2 >> y2;
        PSUM[x1][y1]++;
        PSUM[x1][y2]--;
        PSUM[x2][y1]--;
        PSUM[x2][y2]++;
    }
    int ans = 0;
    for (int i = 0; i < 1000; i++)
    {
        for (int j = 0; j < 1000; j++)
        {
            if (i)
                PSUM[i][j] += PSUM[i - 1][j];
            if (j)
                PSUM[i][j] += PSUM[i][j - 1];
            if (i && j)
                PSUM[i][j] -= PSUM[i - 1][j - 1];
            if (PSUM[i][j] == K)
                ans++;
        }
    }
    cout << ans << endl;
}