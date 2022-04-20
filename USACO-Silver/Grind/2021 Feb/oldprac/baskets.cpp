#include <bits/stdc++.h>
using namespace std;

int A, B, C;
set<int> possible;
bool vis[20][20];

void dfs(int b, int c) {
    int a = C - b - c;
    if(vis[b][c]) return;
    vis[b][c] = true;
    //try all pourings
    if(a > 0 && b < B) {
        dfs(a - min(a, B -b));
    }
}

int main() {
	
}