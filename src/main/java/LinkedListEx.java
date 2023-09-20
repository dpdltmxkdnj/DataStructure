package main.java;

public class LinkedListEx<T> {
    private Node<T> first;
    private Node<T> last;
    private int size;

    public int getSize() {
        return size;
    }

    LinkedListEx(){

    }
    static class Node<T> {
        Node<T> prev;
        Node<T> next;
        private T value;

        public void setValue(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }
    }

    void add(T num) {
        Node<T> node = new Node();
        node.setValue(num);

        if (first == null) {
            first = node;
            last = node;

        } else {
            last.next=node;
            node.prev=last;

            last=node;
        }


        size++;

    }
    void remove(int num) {
        if (num == 0) {
            first=null;
            return;
        }else if(num==size-1){
            last=null;
            return;
        }
        Node<T> tNode = get(num);
        Node<T> prev=tNode.prev;
        Node<T> next=tNode.next;
        prev.next=next;
        next.prev=prev;
        tNode=null;
        size--;

    }

    Node<T> get(int index) {

        if(index<0) throw new NullPointerException();

        Node<T> next=first.next;
        for (int i = 0; i < index-1; i++) {
            next = next.next;
        }
        return index==0?first:next;
    }

    void insert(int index,T num) {
        Node<T> node = new Node<>();
        node.setValue(num);

        if (first==null || index==size-1) {
            add(num);
            return;
        } else if (index==0) {
            first.prev=node;
            node.next=first;
            first=node;
        }else{
            Node<T> tNode = get(index);
            Node<T> prev = tNode.prev;
            prev.next=node;
            node.prev=prev;
            node.next=tNode;
            tNode.prev=node;
        }
        size++;
    }

    public static void main(String[] args) {
//        try {
//            ex<Integer> ex = new ex();
//            ex.add(1);
//            ex.add(2);
//            ex.add(3);
//            ex.add(4);
//            ex.insert(3, 9);
//            System.out.println(ex.get(-1).getValue());
//        } catch (Exception exception) {
//            System.out.println(exception.getStackTrace());
//        }
        LinkedListEx<Integer> ex = new LinkedListEx();
        ex.add(1);
        ex.add(2);
        ex.add(3);
        ex.add(4);
        ex.insert(3,9);
        System.out.println(ex.get(0).getValue());

    }
}
