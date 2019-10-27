/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class eventScheduling
{
    
    
	static ArrayList<FEL> FELArray = new ArrayList<FEL>();
	static int interArrivalTime[] = {1,1,6,3,7,5,2,4,1};
	static int serviceTime[] = {4,2,5,4,1,5,4,1,4};
	static int clock = 0,arrivalInArray = 0, serviceInArray= 0,beforeClock = 0;
	static int LQ[] = new int[18];
	static int LS[] = new int[18];
	static int nthCustomer;
	static FEL removedEvent;
		
	//Statistics
	static int totalBusyTime = 0,maximumQueueLength = 0;
	
    public static void printFELList(ArrayList<FEL> FELList){
        for(FEL ob : FELList){
            System.out.println(ob.getEvent()+" "+ob.getfutureTime());
        }
    }
    
    public static void arrivalAlgo(FEL removedEvent, int i){
        beforeClock = clock;
        clock = removedEvent.getfutureTime();
        if(LS[i-1] == 1){
            LQ[i] = LQ[i-1]+1;
            LS[i] = LS[i-1];
        }
        else{
            LS[i] = 1;
            LQ[i] = LQ[i-1];
            FELArray.add(new FEL('D',(clock+serviceTime[serviceInArray++])));
        }
        FELArray.add(new FEL('A',(clock+interArrivalTime[arrivalInArray++])));
        Collections.sort(FELArray);
        
        // Collect Statistics
    }
    
    public static void departureAlgo(FEL removedEvent, int i){
        beforeClock = clock;
        clock = removedEvent.getfutureTime();
        if(LQ[i-1] >0){
            LQ[i] = LQ[i-1]-1;
            LS[i] = LS[i-1];
            FELArray.add(new FEL('D',(clock+serviceTime[serviceInArray++])));
            Collections.sort(FELArray);
        }
        else{
            LS[i] = 0;
            LQ[i] = LQ[i-1];
        }
       
    }
    
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here

		
		// initialisation at clock time = 0
		 nthCustomer = 1000;   //when nth customer arrives stop the simulation
		 LQ[0] = 0;
		 LS[0] = 1;
		 FELArray.add(new FEL('E',60));
		 FELArray.add(new FEL('A',interArrivalTime[arrivalInArray++]));
		 FELArray.add(new FEL('D',serviceTime[serviceInArray++]));
		 Collections.sort(FELArray);
		 printFELList(FELArray);
		 
		 //Display Results Initially
		    System.out.println("clock:-"+0+" "+"LQ(Queue Length):-"+LQ[0]+" "+"LS(whether customer being served):-"+LS[0]+" B(Server Utilisation):-"+totalBusyTime);
		    for(FEL forPrint : FELArray){
		        forPrint.printFEL();
		    }
		   System.out.println();
		
		for(int i=1;arrivalInArray < nthCustomer;i++){
		    
		   if((FELArray.get(0).getfutureTime()) == (FELArray.get(1).getfutureTime())){
		       removedEvent = FELArray.remove(0);
		       arrivalAlgo(removedEvent,i);
		       clock = beforeClock;
		       removedEvent = FELArray.remove(0);
		       departureAlgo(removedEvent,++i);
		   }
		   else{
		       removedEvent = FELArray.remove(0); 
		      // System.out.println("Immenint event"+removedEvent.getEvent()+" "+removedEvent.getfutureTime());
		      if(removedEvent.getEvent() == 'A'){
		          arrivalAlgo(removedEvent,i);
		      }
		      else if(removedEvent.getEvent() == 'D'){
		          departureAlgo(removedEvent,i);
		      }
		      
		   }
		   
		   totalBusyTime += ((LS[i-1] ==1)?(clock-beforeClock):(0));
		   //Display Results
		    System.out.println("clock:-"+clock+" "+"LQ(Queue Length):-"+LQ[i]+" "+"LS(whether customer being served):-"+LS[i]+" B(Server Utilisation):-"+totalBusyTime);
		    for(FEL forPrint : FELArray){
		        forPrint.printFEL();
		    }
		   System.out.println();
		}
	}
	
    
}

class FEL implements Comparable<FEL>{
        private char Event;
        private int futureTime;
        
        public FEL(char Event, int futureTime){
            this.Event = Event;
            this.futureTime = futureTime;
        }
        
        public char getEvent(){
            return this.Event;
        }
        public int getfutureTime(){
            return this.futureTime;
        }
        
        public int compareTo(FEL f){
            int futureTimeVar = this.futureTime-f.futureTime;
            int EventVar = (this.Event)-((f.Event));
            if(futureTimeVar == 0){
                return((EventVar == 0)?futureTimeVar:EventVar);
            }
            else{
                return(futureTimeVar);
            }
            
        }
        
        public void printFEL(){
            System.out.println("Event "+getEvent()+"Future Time "+getfutureTime());
        }
        
    }

    
