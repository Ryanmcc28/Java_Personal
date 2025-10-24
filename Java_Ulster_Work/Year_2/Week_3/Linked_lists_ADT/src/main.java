public class main {
    public static void main(String[] args) {
        MyNode<Integer> node1 = new MyNode<>(50);
        MyNode<Integer> node2 = new MyNode<>(100);
        MyNode<Integer> node3 = new MyNode<>(200);

        node1.setNext(node2);
        node2.setNext(node3);

        System.out.println(node1.getData());
        System.out.println(node1.getNext().getData());
        System.out.println(node1.getNext().getNext().getData());

    }
}
