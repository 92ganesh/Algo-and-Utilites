/*
Conditions for a deadlock to happen :-
1) Mutual Exclusion – A resource can be used by only one process at a time.
2) Hold and wait – Some processes must be holding some resources in the non-shareable mode and at the same time must be waiting to acquire some more resources, which are currently held by other processes in the non-shareable mode.
3) No pre-emption – Resources granted to a process can be released back to the system only as a result of voluntary action of that process after the process has completed its task.
4) Circular wait – Deadlocked processes are involved in a circular chain such that each process holds one or more resources being requested by the next process in the chain.

Methods of handling deadlocks:-
1. Deadlock Prevention - lock all resources at once and in the same order
2. Deadlock avoidance (Banker's Algorithm) - Process initiation denial and Resource allocation denial
3. Deadlock detection & recovery - periodically detect deadlocks then either kill one process or restart completely
4. Deadlock Ignorance (Ostrich Method)
 */



// Demo :-
public class Deadlock {
    public static void main(String[] args) {
        Thread t1 = new A();
        Thread t2 = new B();

        t1.start();
        t2.start();
    }
}

/*
Output :-
Thread-1 got lock on class class Resource2
Thread-0 got lock on class class Resource1
 */

class Resource1 {
    String info = "empty";
}

class Resource2 {
    String info = "empty";
}


class A extends Thread {
    @Override
    public void run() {

        synchronized (Resource1.class){
            System.out.printf("%s got lock on class %s \n", Thread.currentThread().getName(), Resource1.class);

            try {
                Thread.sleep(100);

                synchronized (Resource2.class) {
                    System.out.printf("%s got lock on class %s \n",
                            Thread.currentThread().getName(), Resource2.class);
                }
            } catch (InterruptedException e) {
            }

        }
    }
}


class B extends Thread {
    @Override
    public void run() {
        synchronized (Resource2.class){
            System.out.printf("%s got lock on class %s \n", Thread.currentThread().getName(), Resource2.class);

            try {
                Thread.sleep(100);

                synchronized (Resource1.class) {
                    System.out.printf("%s got lock on class %s \n",
                            Thread.currentThread().getName(), Resource1.class);

                }


            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}



