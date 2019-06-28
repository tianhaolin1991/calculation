package capture4.singlelink;

/**
 * 使用Java实现单链表
 */
public class SingleLink<T> {
    private SingleNode<T> endNode = new SingleNode<T>(null,null);
    private SingleNode<T> startNode = new SingleNode<T>(endNode,null);
    private Integer length = 0;

    public void add(T data){
        SingleNode<T> newNode = new SingleNode<T>(endNode, data);
        SingleNode<T> node = startNode;
        while(!node.getNext().equals(endNode)){
            node = node.getNext();
        }
        node.setNext(newNode);
        length++;
    }

    public void delete(Integer index){
        if(index<length){
            SingleNode<T> prev = startNode;
            SingleNode<T> node = startNode.getNext();
            for (Integer i = 0; i < index; i++) {
                prev = node;
                node = node.getNext();
            }
            prev.setNext(node.getNext());
            length--;
        }else{
            throw new IndexOutOfBoundsException();
        }
    }

    public T get(Integer index){
        if(index<length){
            SingleNode<T> node = startNode.getNext();
            for (Integer i = 0; i < index; i++) {
                node = node.getNext();
            }
            return node.getData();
        }else{
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public String toString(){
        SingleNode<T> node = startNode.getNext();
        StringBuilder stringBuilder = new StringBuilder("{");
        while(!node.getNext().equals(endNode)){
            stringBuilder.append(node.getData().toString()+",");
            node = node.getNext();
        }
        stringBuilder.append(node.getData()+"}");
        return stringBuilder.toString();
    }
}
