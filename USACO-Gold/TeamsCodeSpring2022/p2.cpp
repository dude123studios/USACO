#include <bits/stdc++.h>
using namespace std;
int dx[4] = {0, 0, -1, 1}, dy[4] = {-1, 1, 0, 0};
// U, D, L R
void solve()
{
    int N;
    string ln;
    cin >> N >> ln;
    int s[N];
    for (int i = 0; i < N; i++)
    {
        if (ln[i] == 'U')
            s[i] = 0;
        else if (ln[i] == 'D')
            s[i] = 1;
        else if (ln[i] == 'L')
            s[i] = 2;
        else
            s[i] = 3;
    }
    int maxx = INT_MIN, maxy = INT_MIN, minx = INT_MAX, miny = INT_MAX;
    int x = 0, y = 0;
    maxx = max(maxx, x);
    maxy = max(maxy, y);
    minx = min(minx, x);
    miny = min(miny, y);
    for (int i = 0; i < N; i++)
    {
        x += dx[s[i]];
        y += dy[s[i]];
        maxx = max(maxx, x);
        maxy = max(maxy, y);
        minx = min(minx, x);
        miny = min(miny, y);
    }
    cout << (abs(maxx - minx) + 1) * (abs(maxy - miny) + 1) << endl;
}

int main()
{
    int T;
    cin >> T;
    while (T--)
        solve();
}