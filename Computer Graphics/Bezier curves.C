
#include<stdio.h>
#include<conio.h>
#include<graphics.h>
#include<math.h>
#define N 4
//number of degrees.= no.of points +1

//the exisitn control points.
int Px[N+1];
int Py[N+1];

int n;

//calculate fact
int fact(int x){

	int i=1;
	int result=1;

	if(x==0){
		return 1;
	}
	else{
		for(i=1;i<=x;i++){
			result*=i;
		}


	return result;

	}
}

//Calculates nCx
int ncx(int k,int i){
	return fact(k)/(fact(i)*fact(k-i));

}


//the B(u) function in the formula
double B(int i,double u){
	return ncx(n,i)*pow(u,i)*pow((1-u),n-i);


}


//the Q(u) function
void plot(double u){
int i=0;
int x=0;
int y=0;

	x+=Px[0];
	y+=Py[0];
	for(i=1;i<=n;i++){
		 x+=(int)Px[i]*B(i,u);
		 y+=(int)Py[i]*B(i,u);

	}
	putpixel(x,y,WHITE);

}


void main(){
float u;

int i=0;
int gd=DETECT,gm;

printf("Enter the number of points\n");
scanf("%d",&n);
n--;

printf("Now enter the points in x,y format.\n");

for(i=0;i<=n;i++){
	scanf("%d%d",&Px[i],&Py[i]);
	printf("\n");
}
i=0;



initgraph(&gd, &gm, " ");



for(i=0;i<n+1;i++){
	putpixel(Px[i],Py[i],YELLOW);
}


for(u=0.01;u<=1;u+=0.01){
	plot(u);
}

getch();
closegraph();

}