#include <bits/stdc++.h>
using namespace std;
int N, Q;
int v[200001];            // 1 -> C, 2 -> O, 3 -> W
int l[200001], r[200001]; // what it simplifies to, 0 -> empty, 1 -> C, 2 -> O, 3 -> W
void solve(int *a)
{
    a[0] = v[0];
    for (int i = 1; i <= N; i++)
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
    }
}

bool worksl(int a, int b)
{
    if (a == 0)
        return l[b] == 1;
    if (l[a - 1] == 0 && l[b] == 1)
        return 1;
    if (l[a - 1] == 1 && l[b] == 0)
        return 1;
    if (l[a - 1] == 2 && l[b] == 3)
        return 1;
    if (l[a - 1] == 3 && l[b] == 2)
        return 1;
    return 0;
}
bool worksr(int a, int b)
{
    if (b == N - 1)
        return r[N - 1 - a] == 1;
    int t = r[N - 1 - a];
    int p = r[N - 2 - b];
    if (p == 0 && t == 1)
        return 1;
    if (p == 1 && t == 0)
        return 1;
    if (p == 2 && t == 3)
        return 1;
    if (p == 3 && t == 2)
        return 1;
    return 0;
}

int main()
{
    string ln;
    cin >> ln;
    N = ln.size();
    for (int i = 0; i < N; i++)
    {
        if (ln[i] == 'C')
            v[i] = 1;
        else
            v[i] = ln[i] == 'O' ? 2 : 3;
    }
    solve(l);
    reverse(v, v + N);
    solve(r);
    cin >> Q;
    for (int i = 0; i < Q; i++)
    {
        int a, b;
        cin >> a >> b;
        if (worksr(a - 1, b - 1) || worksl(a - 1, b - 1))
            cout << "Y";
        else
            cout << "N";
    }
}