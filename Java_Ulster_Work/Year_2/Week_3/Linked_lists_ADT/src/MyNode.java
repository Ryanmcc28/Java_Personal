public class MyNode<T> {
    private T data;
    private MyNode<T> next;

    public MyNode(T dataValue){
        data = dataValue;
        next = null;
    }
    public T getData() { return data; }
    public void setData(T dataValue) { data = dataValue; }
    public MyNode<T> getNext() { return next; }
    public void setNext(MyNode<T> nextNode) { next = nextNode; }
}
