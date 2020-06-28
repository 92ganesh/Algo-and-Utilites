/*
Usage:-
        LinkedList list = new LinkedList(1);
        list.traverse();
        list.add(2);
        list.add(3);
        list.add(3);
        list.add(2);
        list.add(3);
        list.add(3);
        list.add(4);
        list.add(3);
        list.add(3);
        list.traverse();
        list.remove(3);
        list.traverse();

 */


public class LinkedList {
    Node head,end;
      LinkedList(){
    }
    LinkedList(int val){
        head = new Node(val);
        end  = head;
    }

    class Node{
        int value;
        Node next;
        Node(int value){
            this.value = value;
        }
    }

    void add(int value) {
        if (end != null) {
            end.next = new Node(value);
            end = end.next;
        } else {
            head = new Node(value);
            end = head;
        }
    }

    void remove(int x){
          while(head!=null && head.value==x){
              head = head.next;
          }

          if(head!=null && head.next!=null){
              Node ptr1 = head;
              Node ptr2 = head.next;
              while(ptr2!=null){
                  if(ptr2.value == x){
                      ptr1.next = ptr2.next;
                  }else{
                      ptr1 = ptr1.next;
                  }
                  ptr2 = ptr2.next;
              }
          }
    }

    void traverse(){
          Node current = head;
          while(current!=null){
              System.out.print(current.value+" ");
              current = current.next;
          }
        System.out.println();
    }
}
