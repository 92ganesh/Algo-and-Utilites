#include<stdio.h>
#include<conio.h>
#include<graphics.h>
#include<math.h>
void thick(int x1,int y1,int x2,int y2,int thickness);
void bresen(int x1,int y1,int x2,int y2);
void dotted(int x1,int y1,int x2,int y2);
void dash(int x1,int y1,int x2,int y2);

void main()
{  int gm,gd=DETECT,x1=50,y1=100,x2=100,y2=400;
   clrscr();
   initgraph(&gd,&gm,"C:\\TURBOC3\\BGI");

   thick(x1,y1,x2,y2,3);
   dotted(x1+70,y1,x2+70,y2);
   dash(x1+140,y1,x2+140,y2);


   getch();
   closegraph();
}

void thick(int x1,int y1,int x2,int y2,int thickness)
{   int xInc=0,yInc=0,dx,dy,i;
    dx = abs(x1-x2);
    dy = abs(y1-y2);

    if(dx>=dy)
    {  xInc=1; yInc=0;
    }else
    {  xInc=0; yInc=1;
    }

    for(i=0;i<thickness;i++)
    {   bresen(x1+(xInc*i), y1+(yInc*i), x2+(xInc*i), y2+(yInc*i));
    }

}


void dash(int x1,int y1,int x2,int y2)
{   int dx,dy,xInc,yInc,x,y,P,plot=1,dashWidth=5,check=1;
    dx = abs(x1-x2);
    dy = abs(y1-y2);

    // calc xInc and yInc
    if(x1<x2)
       xInc = 1;
    else
       xInc = -1;

    if(y1<y2)
       yInc = 1;
    else
       yInc = -1;

    x=x1; y=y1;
    if(plot==1)
	putpixel(x,y,WHITE);

    if(dx>=dy)
    {
	P = 2*dy - dx;
	while(x!=x2)
	{  if(P<0)
	   {  P = P + 2*dy;
	   }else
	   {  P = P + 2*(dy-dx);
	      y=y+yInc;
	   }
	   x=x+xInc;
	   if(plot==1)
		putpixel(x,y,WHITE);

	   check++;
	   if(check==dashWidth)
	   {  if(plot==1) plot=0;
	      else	  plot=1;

	      check=1;
	   }

	}
    }else{

	P = 2*dx - dy;
	while(y!=y2)
	{  if(P<0)
	   {  P = P + 2*dy;
	   }else
	   {  P = P + 2*(dx-dy);
	      x=x+xInc;
	   }
	   y=y+yInc;
	   if(plot==1)
		putpixel(x,y,WHITE);
	   check++;
	   if(check==dashWidth)
	   {  if(plot==1) plot=0;
	      else	  plot=1;

	      check=1;
	   }
	}
    }


}


void dotted(int x1,int y1,int x2,int y2)
{   int dx,dy,xInc,yInc,x,y,P,plot=1;
    dx = abs(x1-x2);
    dy = abs(y1-y2);

    // calc xInc and yInc
    if(x1<x2)
       xInc = 1;
    else
       xInc = -1;

    if(y1<y2)
       yInc = 1;
    else
       yInc = -1;

    x=x1; y=y1;
    if(plot==1)
    { putpixel(x,y,WHITE);
      plot=0;
    }else
    { plot=1;
    }
    if(dx>=dy)
    {
	P = 2*dy - dx;
	while(x!=x2)
	{  if(P<0)
	   {  P = P + 2*dy;
	   }else
	   {  P = P + 2*(dy-dx);
	      y=y+yInc;
	   }
	   x=x+xInc;
	   if(plot==1)
	   { putpixel(x,y,WHITE);
	     plot=0;
	   }else
	   { plot=1;
	   }
	}
    }else{

	P = 2*dx - dy;
	while(y!=y2)
	{  if(P<0)
	   {  P = P + 2*dy;
	   }else
	   {  P = P + 2*(dx-dy);
	      x=x+xInc;
	   }
	   y=y+yInc;
	   if(plot==1)
	   { putpixel(x,y,WHITE);
	     plot=0;
	   }else
	   { plot=1;
	   }
	}
    }


}




void bresen(int x1,int y1,int x2,int y2)
{   int dx,dy,xInc,yInc,x,y,P;
    dx = abs(x1-x2);
    dy = abs(y1-y2);

    // calc xInc and yInc
    if(x1<x2)
       xInc = 1;
    else
       xInc = -1;

    if(y1<y2)
       yInc = 1;
    else
       yInc = -1;

    x=x1; y=y1;
    putpixel(x,y,WHITE);

    if(dx>=dy)
    {
	P = 2*dy - dx;
	while(x!=x2)
	{  if(P<0)
	   {  P = P + 2*dy;
	   }else
	   {  P = P + 2*(dy-dx);
	      y=y+yInc;
	   }
	   x=x+xInc;
	   putpixel(x,y,WHITE);
	}
    }else{

	P = 2*dx - dy;
	while(y!=y2)
	{  if(P<0)
	   {  P = P + 2*dy;
	   }else
	   {  P = P + 2*(dx-dy);
	      x=x+xInc;
	   }
	   y=y+yInc;
	   putpixel(x,y,WHITE);
	}
    }


}
