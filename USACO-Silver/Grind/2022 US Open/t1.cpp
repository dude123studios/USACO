#include <bits/stdc++.h>
using namespace std;
int N = 10;
int v[10] = {1, 1, 3, 2, 3, 1, 3, 1, 2, 3};
int a[10];
void solve()
{
    a[0] = v[0];
    for (int i = 1; i < N; i++)
    {
        if (a[i - 1] == v[i])
            a[i] = 0;
        else if (a[i - 1] == 0)
            a[i] = v[i];
        else if (a[i - 1] == 1)
            a[i] = v[i] == 2 ? 3 : 2;
        else if (v[i] == 1)
            a[i] = a[i - 1] == 2 ? 3 : 2;
        else
            a[i] = 1;
        cout << a[i] << endl;
    }
}
int main()
{
    solve();
}