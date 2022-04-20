#include <bits/stdc++.h>
using namespace std;
int N, M;
int f[100000], s[100000];
int taken[100001];
int ans = 0;

bool take(int c, int cow)
{
    int t = taken[c];
    if (t < cow)
    {
        taken[c] = cow;
        if (t != -1)
        {
            if (c == s[t])
                ans--;
            else if (!take(s[t], t))
                ans--;
        }
        return 1;
    }
    return 0;
}

int main()
{

    freopen("cereal.in", "r", stdin);
    freopen("cereal.out", "w", stdout);
    cin >> N >> M;
    for (int i = N - 1; i >= 0; i--)
        cin >> f[i] >> s[i];
    fill(taken + 1, taken + M + 1, -1);
    int rans[N];
    for (int i = 0; i < N; i++)
    {
        ans++;
        if (!take(f[i], i))
            if (!take(s[i], i))
                ans--;
        rans[i] = ans;
    }
    for (int i = N - 1; i >= 0; i--)
        cout << rans[i] << endl;
}