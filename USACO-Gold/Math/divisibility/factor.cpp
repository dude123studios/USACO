#include <bits/stdc++.h>
using namespace std;
#define vi vector<int>
#define pb push_back

void solve()
{
    int x;
    cin >> x;
    vi ans;
    for (int i = 2; i * i <= x; i++)
        while (!(x % i))
        {
            x /= i;
            ans.pb(i);
        }
    for (int i : ans)
        cout << i << " ";
    if (x > 1)
        cout << x << " ";
    cout << endl;
}

int main()
{
    int N;
    cin >> N;
    while (N--)
        solve();
}