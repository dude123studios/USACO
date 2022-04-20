#include <bits/stdc++.h>
using namespace std;
int N, a[200000];

int main()
{
    cin >> N;
    for (int i = 0; i < N; i++)
        cin >> a[i];
    vector<int> anss;
    for (int i = 1; i <= N / 2; i++)
    {
        int ans = 0, pos = 0;
        int x = __gcd(N, i);
        for (int i = 0; i < N / x; i++)
        {
            ans += a[pos];
            pos = (x + pos) % N;
        }
        cout << ans << endl;
        anss.push_back(ans);
    }
    if (N % 2 == 0)
        anss.pop_back();
    reverse(anss.begin(), anss.end());
    for (int i : anss)
        cout << i << endl;
    cout << a[0] << endl;
}