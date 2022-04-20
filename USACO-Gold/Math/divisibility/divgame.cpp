#include <bits/stdc++.h>
using namespace std;
#define vi vector<int>
#define pb push_back

int main()
{
    int x;
    cin >> x;
    int ans;
    for (int i = 2; i * i <= x; i++)
    {
        int cnt = 0;
        while (!(x % i))
        {
            x /= i;
            cnt++;
            ;
        }

        for (int i = 1; i <= cnt; i++)
        {
            cnt -= i;
            ans++;
        }
    }
    if (x > 1)
        ans++;
    cout << ans << endl;
}