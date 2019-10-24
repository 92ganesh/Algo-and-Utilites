
import java.util.*;
import java.io.*;
class Main {
public static int numberOfVertices=7; 
public static int[] colours;
public static int[][]map;
/*
for the working code of australia map
public static int[][] map={
     //WA,NT,SA,Q,NSW,V,T
     {0,1,1,0,0,0,0},//wa
     {1,0,1,1,0,0,0},//NT
     {1,1,0,1,1,1,0},//sa
     {0,1,1,0,1,0,0},//q
     {0,0,1,1,0,1,0},//nsw
     {0,0,1,0,1,0,1},//v
     {0,0,0,0,0,1,0}//t
   };
*/
public static String[] stateNames,colourNames;
public static int numberOfColours=4;

public static boolean isSafe(int testVertex,int colour){
 //if the vertices are connected to 'testVertex' or if neighbor has same color
 for(int i=0;i<numberOfVertices;i++){
   if(map[testVertex][i]==1&&colours[i]==colour){
     return false;
   }
 }

 return true;

}

public static boolean assiginingColours(int vertex,int colours[]){
 if(vertex==numberOfVertices){
   return true;
 }
//testing out every colour combination for this vertex.
for(int i=0;i<numberOfColours;i++){
 if(isSafe(vertex, i)){
   colours[vertex]=i;
   return assiginingColours(vertex+1,colours);
 }
} 
 return false;

 }




 public static void main(String[] args) {/*
 working code for the map of australia, considering that T is conncted as well.

   stateNames=new String[]{"WA","NT","SA","Q","NSW","V","T"};
   colourNames=new String[]{"red","green","blue","yellow"};*/

//TAKING USER INPUT
//take numebr of colours
System.out.println("Welcome to the CSP backtracking solution. \nInsert the number of colours to be used");
Scanner sc=new Scanner(System.in);
numberOfColours=sc.nextInt();
colourNames=new String[numberOfColours];

//take values of colours
for(int i=0;i<numberOfColours;i++){
 System.out.println("Enter the name of the colour "+i);
 colourNames[i]=sc.next();
}



//take numebr of vertices
System.out.println("\nInsert the number of vertices to be used in graph. ie. The number of states");
numberOfVertices=sc.nextInt();
stateNames=new String[numberOfVertices];


map=new int[numberOfVertices][numberOfVertices];

//take values of state names
for(int i=0;i<numberOfVertices;i++){
 System.out.println("Enter the name of the state "+i);
 stateNames[i]=sc.next();
}

//taking teh vertice connections

 System.out.println("\n\nNow you will enter the vertex connections:");
System.out.println("For every connection insert a 1 and for no connection insert a zero.");
for(int i=0;i<numberOfVertices;i++){
 for(int j=numberOfVertices-1;j>i;j--){
   System.out.println("Is "+stateNames[i]+" connected to "+stateNames[j]+" ?");
   if(sc.nextInt()==1){
     map[i][j]=1;
     map[j][i]=1;
   }
   else{
     map[i][j]=0;
     map[j][i]=0;
   }
 }
}

  

 System.out.println("\n\nNow I am caculating!\n\n");

//PART OF MAIN CODE FOR CALCULATING THE VALUES
   colours=new int[numberOfVertices];

   if(!assiginingColours(0,colours)){
     System.out.println("No solution exists for this sum");
   }
   else{
     System.out.println("A solution exists! It is:");
    

     for(int i=0;i<numberOfVertices;i++){
       System.out.println("State name:"+stateNames[i]+"\tColour assigned:"+colourNames[colours[i]]+",");
     }

   }

  
  
 }


}


Output:


4 colours in australia map, which is written in the CSP system inputted to code.


In case of not possible solution:



