#include<stdio.h>
#include<conio.h>
#include<graphics.h>
void plotSmile(int cenX,int cenY,int x,int y);
void plot(int cenX,int cenY,int x,int y);
void midCircle(int cenX,int cenY,int r);
void smile(int cenX,int cenY,int r);

void main()
{ int gd=DETECT,gm;
  clrscr();
  initgraph(&gd,&gm,"C://TC//BGI");

  midCircle(300,300,100);
  smile(300,300,50);
  midCircle(250,250,20);
  midCircle(350,250,20);


  getch();
  closegraph();

}

void midCircle(int cenX,int cenY,int r)
{ double d,x,y;
  d = 5/4 - r;
  x=0;y=r;
  do{
     plot(cenX, cenY, x, y);
     if(d<0)
     {  d=d+2*x+3;
     }else{
	d=d+2*(x-y)+5;
	y=y-1;
     }
     x=x+1;
     delay(10);
  }while(x<=y);
}

void smile(int cenX,int cenY,int r)
{ double d,x,y;
  x=0;y=r;
  d = 5/4 - r;
  do{
     plotSmile(cenX, cenY, x, y);
     if(d<0)
     {  d=d+2*x+3;
     }else{
	d=d+2*(x-y)+5;
	y=y-1;
     }
     x=x+1;
     delay(10);
  }while(x<=y);

}

void plotSmile(int cenX,int cenY,int x,int y)
{  putpixel(cenX+x, cenY+y, WHITE);
   putpixel(cenX-x, cenY+y, WHITE);
}

void plot(int cenX,int cenY,int x,int y)
{  putpixel(cenX+x, cenY+y, WHITE);
   putpixel(cenX+x, cenY-y, WHITE);
   putpixel(cenX-x, cenY+y, WHITE);
   putpixel(cenX-x, cenY-y, WHITE);

   putpixel(cenX+y, cenY+x, WHITE);
   putpixel(cenX+y, cenY-x, WHITE);
   putpixel(cenX-y, cenY+x, WHITE);
   putpixel(cenX-y, cenY-x, WHITE);
}
