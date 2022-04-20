#include <bits/stdc++.h>
using namespace std;

int main()
{
    for (float i = 1; i <= 10000; i++)
        for (float j = 1; j <= 10000; j++)
            for (float k = 1; k <= 10000; k++)
                if (abs(i / j + j / k + k / i - 73) < 0.0000000000000000000000000000000000000000001)
                    cout << i << ", " << j << ", " << k << endl;
}