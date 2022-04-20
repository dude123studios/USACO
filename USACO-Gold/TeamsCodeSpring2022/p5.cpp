#include <iostream>
#include <vector>
using namespace std;
int N, M, Q;
vector<vector<vector<int>>> ps;

int main()
{
    cin >> N >> M >> Q;
    ps.resize(N + 1);
    for (int i = 0; i <= N; i++)
    {
        ps[i].resize(M + 1);
        for (int j = 0; j <= M; j++)
        {
            ps[i][j].resize(32, 0);
            if (!j || !i)
                continue;
            int value;
            cin >> value;
            for (int k = 0; k < 32; ++k)
                ps[i][j][k] = (value >> k) & 1;
        }
    }
    for (int i = 1; i <= N; i++)
        for (int j = 1; j <= N; j++)
            for (int k = 0; k < 32; ++k)
                ps[i][j][k] += ps[i - 1][j][k] + ps[i][j - 1][k] - ps[i - 1][j - 1][k];

    for (int q = 0; q < Q; q++)
    {
        int x1, x2, y1, y2;
        cin >> x1 >> y1 >> x2 >> y2;
        int ans = 0;
        for (int k = 0; k < 32; ++k)
            if (ps[x2][y2][k] - ps[x1 - 1][y2][k] - ps[x2][y1 - 1][k] + ps[x1 - 1][y1 - 1][k] > 0)
                ans += (1 << k);
        cout << ans << endl;
    }
}