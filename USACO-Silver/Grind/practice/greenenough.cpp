#include <bits/stdc++.h>
using namespace std;

int main()
{
    int N;
    cin >> N;
    int p[N][N], ge100[N][N + 1], g100[N][N + 1];
    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < N; j++)
        {
            int val;
            cin >> val;
            ge100[i][j + 1] = ge100[i][j] + (val >= 100 ? 0 : 1);
            g100[i][j + 1] = g100[i][j] + (val > 100 ? 0 : 1);
        }
    }
    int ans = 0;
    for (int i = 0; i < N; i++)
    {
        for (int j = i; j < N; j++)
        {
            int rge100 = 0, rg100 = 0;
            for (int k = 0; k < N; k++)
            {
                int a = ge100[k][j + 1] - ge100[k][i];
                int b = g100[k][j + 1] - g100[k][i];
                if (a == 0)
                    ans += ++rge100;
                else
                    rge100 = 0;
                if (b == 0)
                    ans -= ++rg100;
                else
                    rg100 = 0;
            }
        }
    }
    cout << ans << endl;
}