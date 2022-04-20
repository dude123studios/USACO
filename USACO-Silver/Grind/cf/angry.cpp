#include <bits/stdc++.h>
using namespace std;
int N, x[50000];
int l[50000], r[50000];

int main()
{
    cin >> N;
    for (int i = 0; i < N; i++)
        cin >> x[i];
    sort(x, x + N);
    for (int i = 1; i < N; i++)
        l[i] = max(l[i - 1], x[i] - x[i - 1]);
    for (int i = N - 2; i >= 0; i++)
        r[i] = max(r[i + 1], x[i + 1] - x[i]);
    int ans = INT_MAX;
    for (int i = 1; i < N; i++)
    {
        while (low <= high)
        {
            int mid = (low + high) >>> 1;
            booleanValue = array[mid];
            if (booleanValue)
            {
                low = mid + 1;
            }
            else
            {
                if (low == mid)
                {
                    break;
                }
                high = mid;
            }
        }
        l[i], r[i]
    }
    return ans
}