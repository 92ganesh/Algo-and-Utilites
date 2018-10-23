#include<stdio.h>
#include<math.h>
#include<conio.h>
#include<graphics.h>
void DDA(int x0,int y0,int x1,int y1);
void main()
{  int x0,y0,x1,y1;
   int gd = DETECT, gm;
   clrscr();
   initgraph(&gd,&gm,"C:\\TURBOC3\\BGI");

   // draw line
   DDA(200,50,400,100);

   // draw rectangle
   DDA(200,100,400,100);
   DDA(400,100,400,150);
   DDA(400,150,200,150);
   DDA(200,150,200,100);





   // draw square
   DDA(200,200,300,200);
   DDA(300,200,300,300);
   DDA(300,300,200,300);
   DDA(200,300,200,200);

   // draw triangle
   DDA(350,300,450,200);
   DDA(450,200,550,300);
   DDA(550,300,350,300);


   getch();
   closegraph();
}


void DDA(int x0,int y0,int x1,int y1)
{ int i;
  int dx = x1-x0;
  int dy = y1-y0;

  int len = abs(dx)>abs(dy)?abs(dx):abs(dy);

  int xInc = dx*1.0/len;
  int yInc = dy*1.0/len;

  int x=x0,y=y0;
  for(i=0;i<=len;i++)
  {  putpixel(x,y,WHITE);
     x+=xInc;
     y+=yInc;
     delay(1);
  }
}


