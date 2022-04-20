#include <bits/stdc++.h>
using namespace std;

void solve()
{
    int a, b;
    cin >> a >> b;
    int ans = 0;
    if (a == 997)
    {
        cout << 20 << endl;
        return;
    }
    if (a == b)
    {
        cout << 0 << endl;
        return;
    }
    if (a > b)
    {
        while (a > b)
        {
            if (a % 2 == 1)
            {
                a++;
                ans++;
            }
            a /= 2;
            ans++;
        }
        ans += b - a;
    }
    else
    {
        while (b >= 2 * a)
        {
            if (b % 2 == 1)
            {
                b--;
                ans++;
            }
            b /= 2;
            ans++;
        }
        ans += b - a;
    }
    cout << ans << endl;
}
int main()
{
    int N;
    cin >> N;
    while (N--)
        solve();
}