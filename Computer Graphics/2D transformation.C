#include<stdio.h>
#include<conio.h>
#include<graphics.h>
#include<math.h>

void matMul(double c[][3],double a[][3],double b[][3],int r1);
void translation(double a[][3],int r1, double transX, double transY);
void scale(double a[][3],double result[][3],int r1, double scaleX,double scaleY);
void shear(double a[][3],double result[][3],int r1, double shearX,double shearY);
void rotation(double a[][3],double result[][3],int r1, double angle);
void reflectionX(double a[][3],double result[][3],int r1);
void reflectionY(double a[][3],double result[][3],int r1);
void reflectionO(double a[][3],double result[][3],int r1);
void drawFig(double a[][3],int r1);
void printmat(double a[][3],int r1);
void copymat(double a[][3],double result[][3],int r1);
void setup();

void main()
{ int gd=DETECT,gm,i,j,r1=4,c1=3,op;
  double val1,val2;
  double d[100][3],dcopy[100][3],result[100][3];
  clrscr();
  printf("Enter the number of vertices in the polygon: ");
  scanf("%d",&r1);
  printf("Enter the co-ordinates one by one in cycle\n");
  for(i=0;i<r1;i++)
  { scanf("%lf %lf",&dcopy[i][0],&dcopy[i][1]);  dcopy[i][2]=1;
    d[i][0]=dcopy[i][0]; d[i][1]=dcopy[i][1]; d[i][2]=dcopy[i][2];
  }

  initgraph(&gd,&gm,"C:\\TURBOC3\\BGI");
  translation(d,r1,getmaxx()/2,getmaxy()/2);
  translation(dcopy,r1,getmaxx()/2,getmaxy()/2);

  do
   {
	printf("1:Translation\n2:Scale\n3:Rotation\n4:Reflection w.r.t x-axis\n5:Reflection w.r.t y-axis\n6:Reflection w.r.t origin\n7Shear\n8Exit from the system");
	printf("Enter your option:");
	scanf("%d",&op);
	switch(op)
	{
		case 1: printf("translate in x direction by:");
			scanf("%lf",&val1);
			printf("translate in y direction by:");
			scanf("%lf",&val2);
			setup();
			copymat(dcopy,d,r1);
			drawFig(d,r1);
			translation(d,r1,val1,val2);
			drawFig(d,r1);
			getch();
			closegraph();
			break;
		case 2: printf("Scale in x direction by:");
			scanf("%lf",&val1);
			printf("Scale in y direction by:");
			scanf("%lf",&val2);
			setup();
			copymat(dcopy,d,r1);
			drawFig(d,r1);
			scale(d,result,r1,val1,val2);
			drawFig(result,r1);
			getch();
			closegraph();
			break;
		case 3: printf("rotate counter-clockwise by degree:");
			scanf("%lf",&val1);
			setup();
			copymat(dcopy,d,r1);
			drawFig(d,r1);
			rotation(d,result,r1,val1);
			drawFig(result,r1);
			getch();
			closegraph();
			break;
		case 4: setup();
			copymat(dcopy,d,r1);
			drawFig(d,r1);
			translation(d,r1,-getmaxx()/2,-getmaxy()/2);
			translation(dcopy,r1,-getmaxx()/2,-getmaxy()/2);
			reflectionX(d,result,r1);
			translation(d,r1,getmaxx()/2,getmaxy()/2);
			translation(dcopy,r1,getmaxx()/2,getmaxy()/2);
			translation(result,r1,getmaxx()/2,getmaxy()/2);
			drawFig(result,r1);
			getch();
			closegraph();
			break;
		case 5: setup();
			copymat(dcopy,d,r1);
			drawFig(d,r1);
			translation(d,r1,-getmaxx()/2,-getmaxy()/2);
			translation(dcopy,r1,-getmaxx()/2,-getmaxy()/2);
			reflectionY(d,result,r1);
			translation(d,r1,getmaxx()/2,getmaxy()/2);
			translation(dcopy,r1,getmaxx()/2,getmaxy()/2);
			translation(result,r1,getmaxx()/2,getmaxy()/2);
			drawFig(result,r1);
			getch();
			closegraph();
			break;
		case 6: setup();
			copymat(dcopy,d,r1);
			drawFig(d,r1);
			translation(d,r1,-getmaxx()/2,-getmaxy()/2);
			translation(dcopy,r1,-getmaxx()/2,-getmaxy()/2);
			reflectionO(d,result,r1);
			translation(d,r1,getmaxx()/2,getmaxy()/2);
			translation(dcopy,r1,getmaxx()/2,getmaxy()/2);
			translation(result,r1,getmaxx()/2,getmaxy()/2);
			drawFig(result,r1);
			getch();
			closegraph();
			break;
		case 7: printf("Shear in x direction by:");
			scanf("%lf",&val1);
			printf("Shear in y direction by:");
			scanf("%lf",&val2);
			setup();
			copymat(dcopy,d,r1);
			drawFig(d,r1);
			shear(d,result,r1,val1,val2);
			drawFig(result,r1);
			getch();
			closegraph();
			break;
		case 8: break;

	}

   }
   while(op!=8);
}

void scale(double a[][3],double result[][3],int r1, double scaleX,double scaleY)
{ double scaleMat[][3]={-1,0,0,0,-1,0,0,0,1};
  double originX,originY;
  scaleMat[0][0]=scaleX;
  scaleMat[1][1]=scaleY;
  originX=-a[0][0];
  originY=-a[0][1];
  translation(a,r1,originX,originY);
  matMul(result,a,scaleMat,r1);
  translation(result,r1,-originX,-originY);
}
void shear(double a[][3],double result[][3],int r1, double shearX,double shearY)
{ double shearMat[][3]={1,-1,0, -1,1,0, 0,0,1};
  double originX,originY;
  shearMat[0][1]=shearY;
  shearMat[1][0]=shearX;
  originX=-a[0][0];
  originY=-a[0][1];
  translation(a,r1,originX,originY);
  matMul(result,a,shearMat,r1);
  translation(result,r1,-originX,-originY);
}
void rotation(double a[][3],double result[][3],int r1, double angle)
{ double rotationMat[][3]={-1,-1,0, -1,-1,0, 0,0,1};
  double originX,originY;
  double angleRad= 3.14*angle/180;
  rotationMat[0][0]=cos(angleRad);
  rotationMat[0][1]=sin(angleRad);
  rotationMat[1][0]=-sin(angleRad);
  rotationMat[1][1]=cos(angleRad);

  originX=-a[0][0];
  originY=-a[0][1];
  translation(a,r1,originX,originY);
  matMul(result,a,rotationMat,r1);
  translation(result,r1,-originX,-originY);
}

void reflectionX(double a[][3],double result[][3],int r1)
{ double reflectionMat[][3]={1,0,0, 0,-1,0, 0,0,1};
  matMul(result,a,reflectionMat,r1);
}

void reflectionY(double a[][3],double result[][3],int r1)
{ double reflectionMat[][3]={-1,0,0, 0,1,0, 0,0,1};
  matMul(result,a,reflectionMat,r1);
}

void reflectionO(double a[][3],double result[][3],int r1)
{ double reflectionMat[][3]={-1,0,0, 0,-1,0, 0,0,1};
  matMul(result,a,reflectionMat,r1);
}

void translation(double a[][3],int r1, double transX, double transY)
{  int i,c1=3;
   for(i=0;i<r1;i++)
   { a[i][0]+=transX;
     a[i][1]+=transY;
   }
}

void setup()
{ int gd=DETECT,gm,xmax,ymax;
  clrscr();
  initgraph(&gd,&gm,"C:\\TURBOC3\\BGI");
  xmax=getmaxx();
  ymax=getmaxy();
  line(xmax/2,0,xmax/2,ymax);
  line(0,ymax/2,xmax,ymax/2);
}

void printmat(double a[][3],int r1)
{ int i,j,c1=3;
  for(i=0;i<r1;i++)
  {   for(j=0;j<3;j++)
     { printf("%d\t",a[i][j]);
     }printf("\n");
  }
  printf("\n");
}

void copymat(double a[][3],double result[][3],int r1)
{ int i,j,c1=3;
  for(i=0;i<r1;i++)
  {  for(j=0;j<3;j++)
     { result[i][j]=a[i][j];
     }
  }
}

void drawFig(double a[][3],int r1)
{ int i,c1=3;
  for(i=0;i<r1;i++)
  { line(a[i][0],a[i][1],a[((i+1)%r1)][0],a[((i+1)%r1)][1]);
  }
  delay(1000);
}

void matMul(double c[][3],double a[][3],double b[][3],int r1)
{  int c1=3,i,j,k;
   for(i=0;i<r1;i++)
   { for(j=0;j<c1;j++)
     { c[i][j]=0;
       for(k=0;k<c1;k++)
       { c[i][j] +=  a[i][k]*b[k][j];
       }
     }
   }
}
