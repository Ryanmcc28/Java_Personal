public class Stack<T> implements StackInterface<T> {
    private MyNode<T> topNode;

    public Stack() {
        topNode = null;
    }

    @Override
    public void push(T newEntry) {
        MyNode<T> newNode = new MyNode<>(newEntry);

        newNode.setNext(topNode);

        topNode = newNode;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            return null;
        }

        T topData = topNode.getData();

        topNode = topNode.getNext();

        return topData;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            return null;
        }

        return topNode.getData();
    }

    @Override
    public boolean isEmpty() {
        return topNode == null;
    }

    @Override
    public void clear() {
        topNode = null;
    }
}
