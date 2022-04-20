#include <bits/stdc++.h>
using namespace std;
const int MAX = 1e6;
#define ll long long
void solve()
{
    int x;
    cin >> x;
    int ans = 0;
    for (int i = 1; i * i <= x; i++)
        if (!(x % i))
            ans += i * i == x ? 1 : 2;
    cout << ans << endl;
}

int max_div[MAX + 1];
void solve_fast()
{
    int x;
    cin >> x;
    ll ans = 1;
    while (x != 1)
    {
        int p = max_div[x];
        int cnt = 0;
        while (!(x % p))
        {
            cnt++;
            x /= p;
        }
        ans *= (cnt + 1);
    }
    cout << ans << endl;
}

int main()
{
    int N;
    cin >> N;
    /*
    while (N--)
        solve();
    */
    for (int i = 2; i <= MAX; i++)
        if (!max_div[i])
            for (int j = i; j <= MAX; j += i)
                max_div[j] = i;
    while (N--)
        solve_fast();
}