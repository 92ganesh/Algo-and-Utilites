///      Selection  Sort

#include <stdio.h>
#include <conio.h>
void main()
{
int i,n,j,t,temp,pos;
int a[50];
printf("enter the no.of elements\n" );
scanf("%d",&n);
printf("Enter the elements one by one\n");
for(i=0;i<=n-1;i++)
{  scanf("%d",&a[i]);
}

printf("\n\nSorted array in acending order is\n");
// selection sort
 for(i=0;i<=n-2;i++)
    {
       t=a[i];
       for(j=i+1;j<=n-1;j++)
       {   if(a[j]<t)
           {  t=a[j];
               pos=j;
            }
        }
        if(a[i]>t)
        {
          temp=a[i];
          a[i]=a[pos];
          a[pos]=temp;
         }
    }
 
 // printing the output
for(i=0;i<=n-1;i++)
printf("%d\n",a[i]);
getch();
}