#include <stdio.h>
#include <conio.h>
#include <graphics.h>

void pf(int a[]);
int isZero(int a[]);
int OR(int a[],int b[]);
int AND(int a[],int b[]);

void main() {
  int A[]={100,10};
  int B[]={60,150};
  int i,j,clipCount=0,inside=0;
  int gd=DETECT,gm;
  double slope;
  int bottomLeft[2];
  int topRight[2];
	int codeA[4],codeB[4],temp[4];
  double clipX[10],clipY[10];
  clrscr();

  bottomLeft[0]=50;  bottomLeft[1]=10;
  topRight[0]=80;    topRight[1]=40;

  for(i=0;i<4;i++) {
		codeA[i]=0; codeB[i]=0;
  }

  if(A[1]>topRight[1]) {
    codeA[0]=1;
  }
  if(A[1]<bottomLeft[1]) {
    codeA[1]=1;
  }
  if(A[0]>topRight[0]) {
    codeA[2]=1;
  }
  if(A[0]<bottomLeft[0]) {
    codeA[3]=1;
  }

  if(B[1]>topRight[1]) {
    codeB[0]=1;
	}
  if(B[1]<bottomLeft[1]) {
    codeB[1]=1;
  }
  if(B[0]>topRight[0]) {
    codeB[2]=1;
  }
  if(B[0]<bottomLeft[0]) {
    codeB[3]=1;
  }

  printf("A- ");pf(codeA);
  printf("B- ");pf(codeB);

  // cohen starts
  if(OR(codeA,codeB)==0) {
    //completely inside
		inside=1;
  }else if(AND(codeA,codeB)!=0) {
    // completely outside
		inside=0;
  }else {
		// clip it!
		// find which sides of windows might be intersected
		for(i=0;i<4;i++) {
			temp[i]=codeA[i]||codeB[i];
		}

		slope = ((A[1]-B[1])*1.0)/(A[0]-B[0]);
		printf("temp- "); pf(temp);
		printf("slope- %lf\n",slope);

		clipCount=0;
		if(temp[0]==1){
			clipY[clipCount]=topRight[1];
			clipX[clipCount]=((clipY[clipCount]-B[1])*1.0)/slope+B[0];
			printf("%lf - %lf\n",clipX[clipCount],clipY[clipCount]);
			if(clipX[clipCount]<bottomLeft[0]||clipX[clipCount]>topRight[0]||clipY[clipCount]<bottomLeft[1]||clipY[clipCount]>topRight[1])
			{	printf("");
			}else{
				clipCount++;
			}
		}

		if(temp[1]==1){
			clipY[clipCount]=bottomLeft[1];
			clipX[clipCount]=((clipY[clipCount]-B[1])*1.0)/slope;
			clipX[clipCount]+=B[0];
			printf("%lf - %lf\n",clipX[clipCount],clipY[clipCount]);
			if(clipX[clipCount]<bottomLeft[0]||clipX[clipCount]>topRight[0]||clipY[clipCount]<bottomLeft[1]||clipY[clipCount]>topRight[1])
			{	printf("");
			}else{
				clipCount++;
			}
		}

		if(temp[2]==1){
			clipX[clipCount]=topRight[0];
			clipY[clipCount]=slope*(clipX[clipCount]-B[0]);
			clipY[clipCount]+=B[1];
			printf("%lf - %lf\n",clipX[clipCount],clipY[clipCount]);
			if(clipX[clipCount]<bottomLeft[0]||clipX[clipCount]>topRight[0]||clipY[clipCount]<bottomLeft[1]||clipY[clipCount]>topRight[1])
			{ printf("");
			}else{
				clipCount++;
			}
		}

		if(temp[3]==1){
			clipX[clipCount]=bottomLeft[0];
			clipY[clipCount]=slope*(clipX[clipCount]-B[0])+B[1];
			printf("%lf - %lf\n",clipX[clipCount],clipY[clipCount]);
			clipCount++;
			if(clipX[clipCount]<bottomLeft[0]||clipX[clipCount]>topRight[0]||clipY[clipCount]<bottomLeft[1]||clipY[clipCount]>topRight[1])
			{ printf("");
			}else{
				clipCount++;
			}
		}
	}

	printf("rect %d %d %d %d\n",bottomLeft[0],topRight[1],topRight[0],bottomLeft[1]);
	getch();
	clrscr();
	initgraph(&gd,&gm,"");
	outtextxy(A[0],A[1],"A");
	outtextxy(B[0],B[1],"B");

	rectangle((int)bottomLeft[0],(int)topRight[1],(int)topRight[0],(int)bottomLeft[1]);

	if(clipCount==0) {
		 if(inside==1)
				setcolor(RED);

		 line(A[0],A[1],B[0],B[1]);
	}else if(clipCount==1) {
		 line(A[0],A[1],B[0],B[1]);
		 setcolor(RED);
		 if(isZero(codeA)==0) {
				clipX[1]=A[0];
		    clipY[1]=A[1];
		 }else if(isZero(codeB)==0) {
		    clipX[1]=B[0];
		    clipY[1]=B[1];
		 }
		 line(clipX[0],clipY[0],clipX[1],clipY[1]);
	}else if(clipCount==2){
		 line(A[0],A[1],B[0],B[1]);
		 setcolor(RED);
		 line(clipX[0],clipY[0],clipX[1],clipY[1]);
	}

	getch();
	closegraph();

}

int isZero(int a[]){
  int i;
  for(i=0;i<4;i++) {
    if( a[i]==1 )
      return 1;
  }
  return 0;
}

int OR(int a[],int b[]){
  int i;
  for(i=0;i<4;i++) {
    if( (a[i]||b[i])==1 )
      return 1;
  }
  return 0;
}

int AND(int a[],int b[]){
  int i;
  for(i=0;i<4;i++) {
    if( (a[i]&&b[i])==1 )
      return 1;
  }
  return 0;
}

void pf(int a[]){
  int i;
  for(i=0;i<4;i++) {
    printf("%d ",a[i]);
  } printf("\n\n");
}


















