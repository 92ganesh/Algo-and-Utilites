#include<stdio.h>
#include<graphics.h>
void drawSq();
void drawSqOneColor();
void floodFill4(int x,int y,int pre,int color);
void floodFill8(int x,int y,int pre,int color);
void boundryFill4(int x,int y,int border,int color);
void boundryFill8(int x,int y,int border,int color);

void main()
{ int gd=DETECT,gm,fillType,connected;
  clrscr();
  initgraph(&gd,&gm,"");

  printf("Enter Fill type:-\n");
  printf("1: Flood Fill\n");
  printf("2: Boundry Fill\n");
  scanf("%d",&fillType);

  printf("Enter connected type:-\n");
  printf("1: four connected\n");
  printf("2: eight connected\n");
  scanf("%d",&connected);


  if(fillType==1){
	  drawSq();
	  if(connected==1){
		  floodFill4(325,225,-1,RED);
	  }else{
		  floodFill8(325,225,-1,RED);
	  }
  }else{
	  drawSqOneColor();
	  if(connected==1){
		  boundryFill4(325,225,WHITE,RED);
	  }else{
		  boundryFill8(325,225,WHITE,RED);
	  }
  }


  getch();
  closegraph();
}

void floodFill4(int x,int y,int pre,int color)
{	int current;
	if(pre==-1)
	{	pre = getpixel(x,y);
	}

	current = getpixel(x,y);
	if(pre==current){
		 putpixel(x,y,color);
		 floodFill4(x+1,y,pre,color);
		 floodFill4(x-1,y,pre,color);
		 floodFill4(x,y+1,pre,color);
		 floodFill4(x,y-1,pre,color);
	}
}

void floodFill8(int x,int y,int pre,int color)
{	int current;
	if(pre==-1)
	{	pre = getpixel(x,y);
	}

	current = getpixel(x,y);
	if(pre==current){
		 putpixel(x,y,color);
		 floodFill8(x+1,y,pre,color);
		 floodFill8(x-1,y,pre,color);
		 floodFill8(x,y+1,pre,color);
		 floodFill8(x,y-1,pre,color);
		 
		 floodFill8(x+1,y+1,pre,color);
		 floodFill8(x+1,y-1,pre,color);
		 floodFill8(x-1,y+1,pre,color);
		 floodFill8(x-1,y-1,pre,color);
	}
}

void boundryFill4(int x,int y,int border,int color)
{   int current = getpixel(x,y);

	if(current!=border&&current!=color){
		 putpixel(x,y,color);
		 boundryFill4(x+1,y,border,color);
		 boundryFill4(x-1,y,border,color);
		 boundryFill4(x,y+1,border,color);
		 boundryFill4(x,y-1,border,color);
	}
}

void boundryFill8(int x,int y,int border,int color)
{   int current = getpixel(x,y);

	if(current!=border&&current!=color){
		 putpixel(x,y,color);
		 boundryFill8(x+1,y,border,color);
		 boundryFill8(x-1,y,border,color);
		 boundryFill8(x,y+1,border,color);
		 boundryFill8(x,y-1,border,color);
		 
		 boundryFill8(x+1,y+1,border,color);
		 boundryFill8(x+1,y-1,border,color);
		 boundryFill8(x-1,y+1,border,color);
		 boundryFill8(x-1,y-1,border,color);
	}
}

void drawSq()
{       setcolor(WHITE);
	line(300,200,350,200);
	setcolor(YELLOW);
	line(350,200,330,225);
	line(330,225,350,250);
	setcolor(BLUE);
	line(350,250,300,250);
	line(300,250,300,200);
}

void drawSqOneColor()
{       setcolor(WHITE);
	line(300,200,350,200);
	line(350,200,330,225);
	line(330,225,350,250);
	line(350,250,300,250);
	line(300,250,300,200);
}

/*

void drawSq()
{	line(300,200,350,200);
	setcolor(YELLOW);
	line(350,200,350,250);
	setcolor(BLUE);
	line(350,250,300,250);
	line(300,250,300,200);
}

*/