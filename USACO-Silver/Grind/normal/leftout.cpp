#include <bits/stdc++.h>
using namespace std;

int main()
{
    /*
    freopen("leftout.in", "r", stdin);
    freopen("leftout.out", "w", stdout);
    */
    int N;
    cin >> N;
    bool c[N][N];
    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < N; j++)
        {
            char s;
            cin >> s;
            c[i][j] = s == 'R';
        }
    }
    for (int i = 0; i < N; i++)
    {
        bool p = 1;
        for (int j = 0; j < N; j++)
            if (c[i][j] == 0)
                p = 0;
        if (p == 0)
        {
            for (int j = 0; j < N; j++)
                c[i][j] = !c[i][j];
        }
    }
    for (int i = 0; i < N; i++)
    {
        bool p = 1;
        for (int j = 0; j < N; j++)
            if (c[j][i] == 0)
                p = 0;
        if (p == 0)
        {
            for (int j = 0; j < N; j++)
                c[j][i] = !c[j][i];
        }
    }
    for (int i = 0; i < N; i++)
    {

        for (int j = 0; j < N; j++)
            cout << c[i][j] << " ";
        cout << "\n";
    }

    int pi = -1, pj = -1;
    for (int i = 0; i = N; i++)
    {
        for (int j = 0; j < N; j++)
        {
            if (c[i][j] == 1)
                continue;
            if (pi == -1 && pj == -1)
            {
                pi = i;
                pj = j;
            }
            else
            {
                if (pi == i)
                {
                    for (int k = 0; k < N; k++)
                    {
                        if (c[i][k] == 1)
                        {
                            cout << i + 1 << " " << k + 1 << endl;
                            return 0;
                        }
                    }
                }
            }
        }
    }
    cout << pi + 1 << pj + 1;
}