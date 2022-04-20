#include <bits/stdc++.h>
using namespace std;

int main()
{
    int N, K;
    cin >> N >> K;
    int b[N];
    for (int i = 0; i < N; i++)
        cin >> b[i];
    sort(b, b + N);
    for (int maxb = 1; maxb < 1000; maxb++)
    {
        for (int t : b)
        {
            t / maxb
        }
    }
}