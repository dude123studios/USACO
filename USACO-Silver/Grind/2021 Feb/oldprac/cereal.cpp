#include <bits/stdc++.h>
using namespace std;

void setIO(string name = "cereal")
{
    cin.tie(0)->sync_with_stdio(0); // see /general/fast-io
    if ((int)(name).size())
    {
        freopen((name + ".in").c_str(), "r", stdin); // see /general/input-output
        freopen((name + ".out").c_str(), "w", stdout);
    }
}
int N, M;
int f[100000], s[100000], g[100000];

int r(int cow)
{
    if (g[f[cow]] > 0)
    {
        if (g[f[cow]] < cow)
        {
            int nc = g[f[cow]] - 1;
            g[f[cow]] = cow + 1;
            return r(nr);
        }
        else
        {
            if (g[s[cow]] > 0)
            {
                if (g[s[cow]] < cow)
                {
                    int nc = g[s[cow]] - 1;
                    g[s[cow]] = cow + 1;
                    return r(nc);
                }
                else
                {
                }
            }
            else
            {
                g[s[cow]] = cow + 1;
                return 0;
            }
        }
    }
    else
    {
        g[f[cow]] = cow + 1;
        return 0;
    }
}

int main()
{
    setIO();
    int N, M;
    cin >> N >> M;
    for (int i = 0; i < N; i++)
    {
        cin >> f[i] >> s[i];
    }
    int ans[N];
    g[f[0]] = 1;
    ans[N - 1] = 1;
    for (int i = 1; i < N; i++)
    {
        if (g[f[i]] > 0)
        {
            int cow = g[f[i]] - 1;
            g[f[i]] = i + 1;
            if (g[s[cow]] > 0)
            {
                if (g[s[cow]] - 1 < cow)
                {
                }
            }
            else
            {
                g[s[cow]] = cow + 1;
            }
        }
    }
}