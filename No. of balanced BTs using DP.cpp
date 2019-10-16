#include <iostream>
#include <cmath>
using namespace std;

#define bigprimeno 1000000007
int binaryTreesOfHeightH(int h)
{
long *ans =new long [h+1];
  ans[0]=ans[1]=1;
  for(int i=2;i<=h;i++)
  {
    ans[i]=((ans[i-1]*ans[i-1])+2*(ans[i-1]*ans[i-2]))%bigprimeno;
  }
  return ans[h];
}


int main()
{
    int h;
    cin >> h;
    int ans = binaryTreesOfHeightH(h);
    ans = ans % ((int)(pow(10, 9)) + 7);
    cout << ans << endl;
}
