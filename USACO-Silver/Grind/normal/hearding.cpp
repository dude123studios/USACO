#include <bits/stdc++.h>
using namespace std;

int main()
{

    freopen("hearding.in", "r", stdin);
    freopen("hearding.out", "w", stdout);
    int N;
    cin >> N;
    int pos[N];
    for (int i = 0; i < N; i++)
        cin >> pos[i];
    sort(pos, pos + N);
    cout << ans << endl;
}