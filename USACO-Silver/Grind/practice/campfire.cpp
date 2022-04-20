#include <bits/stdc++.h>
using namespace std;

// global sum of set of numbers from i, i+1, ... j-1, j;
int glob(int i, int j)
{
    int num = j - i + 1;
    if (num == 1)
        return 0;
    if (num == 2)
        return i * j;
    int mid = (i + j) / 2;
    return glob(i, mid) + glob(mid + 1, j);
}

int main()
{
    int N;
    cin >> N;
    cout << glob(1, N) << endl;
}