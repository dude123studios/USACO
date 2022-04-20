#include <bits/stdc++.h>
using namespace std;

int main()
{
    int N;
    cin >> N;
    int a[N][N];
    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < N; j++)
            cin >> a[i][j];
    }
    int ans1 = 0, ans2 = 0;
    for (int i = 0; i < N; i++)
    {
        int s1 = 0, s2 = 0;
        for (int j = 0; j < N; j += 2)
            s1 += a[i][j];
        for (int j = 1; j < N; j += 2)
            s2 += a[i][j];
        ans1 += max(s1, s2);
    }
    for (int j = 0; j < N; j++)
    {
        int s1 = 0, s2 = 0;
        for (int i = 0; i < N; i += 2)
            s1 += a[i][j];
        for (int i = 1; i < N; i += 2)
            s2 += a[i][j];
        ans2 += max(s1, s2);
    }
    cout << min(ans1, ans2) << endl;
}