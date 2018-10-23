///      bubble  Sort

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
// bubble sort
for(i =0;i <=n-2; i++)  // note  n-2
{
	   for (j=0; j <=n-2; j++)  // note  n-2
	   {
	   	   if(a [j]>a [j+1])
	   	   {  temp=a [j];
	   	       a [j]= a [j+1];
	   	       a [j+1 ]=temp;
	   	   }
	   }
	 
}
 
 // printing the output
for(i=0;i<=n-1;i++)
printf("%d\n",a[i]);
getch();
}