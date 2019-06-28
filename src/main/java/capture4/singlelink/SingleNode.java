package capture4.singlelink;

/**
 * 这是一个单向节点
 */
public class SingleNode<T> {
    private T data;
    private SingleNode<T> next;

    public SingleNode(SingleNode<T> next,T data){
        this.next = next;
        this.data = data;
    }
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public SingleNode<T> getNext() {
        return next;
    }

    public void setNext(SingleNode<T> next) {
        this.next = next;
    }
}
