#include <bits/stdc++.h>
using namespace std;

int main()
{
    int N;
    cin >> N;
    int a[N][N];
    for (int i = 0; i < N; i++)
        for (int j = 0; j < N; j++)
            cin >> a[i][j];
    int esum = 0, osum = 0;
    // horozontal alternate
    int hans = 0;
    for (int i = 0; i < N; i++)
    {
        esum = 0, osum = 0;
        for (int j = 0; j < N; j += 2)
            esum += a[i][j];
        for (int j = 1; j < N; j += 2)
            osum += a[i][j];
        hans += max(esum, osum);
    }
    // verticle alternate
    int vans = 0;
    for (int i = 0; i < N; i++)
    {
        esum = 0, osum = 0;
        for (int j = 0; j < N; j += 2)
            esum += a[j][i];
        for (int j = 1; j < N; j += 2)
            osum += a[j][i];
        vans += max(esum, osum);
    }
    cout << max(hans, vans) << endl;
}