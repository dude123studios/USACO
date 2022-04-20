#include <bits/stdc++.h>
using namespace std;
int main()
{
    int N;
    cin >> N;
    int x[N], dp[N];
    for (int i = 0; i < N; i++)
        cin >> x[i];
    int ans = 0;
    for (int i = 0; i < N; i++)
    {
        int prevmax = 0;
        for (int j = i - 1; j >= 0; j--)
            if (x[j] < x[i])
                prevmax = max(prevmax, dp[j]);
        dp[i] = prevmax + 1;
        ans = max(ans, dp[i]);
    }
    cout << ans << endl;
}