package csu.csci325;

public class Main {

    public static void main(String[] args) {

	    LinkedQueue<String> lq = new LinkedQueue<>();
        CircularArrayQueue<Integer> ca = new CircularArrayQueue<>();
        //LinkedQueue testing.
        System.out.println(lq.isEmpty());
        System.out.println(lq.dequeue());

        lq.enqueue("first");
        lq.enqueue("second");
        lq.enqueue("third");
        lq.enqueue("forth");

        System.out.println(lq.first());
        System.out.println(lq.size());

        while(!lq.isEmpty()) {
            System.out.println(lq.dequeue());
        }

        System.out.println(lq.isEmpty());
        System.out.println(lq.size());

        //CircularArrayQueue testing.
        System.out.println(ca.isEmpty());
        System.out.println(ca.dequeue());
        System.out.println(ca.size());

        ca.enqueue(555);
        ca.enqueue(16799);
        ca.enqueue(4);

        System.out.println(ca.first());
        System.out.println(ca.size());

        while(!ca.isEmpty()){
            System.out.println(ca.dequeue());
        }
        System.out.println(ca.isEmpty());
        //testing an array over 100.
        for(int index = 0; index < 150; index++){
            ca.enqueue(index);
        }
        System.out.println(ca.size());

    }
}



