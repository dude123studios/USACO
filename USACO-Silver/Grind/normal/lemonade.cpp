#include <bits/stdc++.h>
using namespace std;

int main()
{
    freopen("lemonade.in", "r", stdin);
    freopen("lemonade.out", "w", stdout);
    int N;
    cin >> N;
    int w[N];
    for (int i = 0; i < N; i++)
        cin >> w[i];
    sort(w, w + N);
    int c = 0;
    for (int i = N - 1; i >= 0; i--)
    {
        if (c <= w[i])
            c++;
    }
    cout << c << endl;
}