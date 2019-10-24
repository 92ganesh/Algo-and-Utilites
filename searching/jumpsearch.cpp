#include <iostream>
#include<math.h>
using namespace std;

#define SIZE 1000
//insert sorted array in arr[]
int arr[SIZE]={};
int main()
{
    int i,j,req,last;
    int sqroot=sqrt(SIZE);

    cout<<"Enter Required No.";
    cin>>req;

    last=0;
    i=sqroot;
    while(i<SIZE&&arr[i-1]<req){
        last=i;
        i=i+sqroot;
    }

    int index=-1;
    for(j=last;j<i&&j<SIZE;j++){
            if(arr[j]==req){
                index=j;
                break;
            }
    }
    if(index!=-1){
    cout<<"Index: "<<index<<endl;
    }
    else{
        cout<<"Element not found\n";
    }

    return 0;
}