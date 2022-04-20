#include <bits/stdc++.h>
using namespace std;
int N, x[101];
int main()
{
    cin >> N;
    for (int i = 1; i <= N; i++)
        cin >> x[i];
    vector<vector<int>> dp(100001, vector<int>(101, 0));
    fill(dp[0].begin(), dp[0].end(), 1);
    int ans = 0;
    vector<int> a;
    for (int i = 1; i <= 100000; i++)
    {
        bool reachable = 0;
        for (int j = 1; j <= 100; j++)
        {
            if (i - x[j] >= 0 && dp[i - x[j]][j - 1])
                dp[i][j] = 1;
            if (dp[i][j - 1])
                dp[i][j] = 1;
            if (dp[i][j])
                reachable = 1;
        }
        if (reachable)
        {
            ans++;
            a.push_back(i);
        }
    }
    cout << ans << endl;
    for (int i : a)
        cout << i << " ";
    cout << "\n";
}