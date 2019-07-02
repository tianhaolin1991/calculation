package capture6;

/**
 * 实现一个二叉树
 */
public class Tree {
    private Node root;//根节点

    public Tree() {
        this.root = null;//创建一个空树
    }

    //查询
    public Node find(int index){
        Node current = root;//因为我们的查询是需要通过root节点开始查询的
        while(index != current.index){
            if(index<current.index){
                current  = current.leftChild;//如果小于当前的index则向左查找
            }else{
                current  = current.rightChild;//如果大于当前的indx,则向右查找
            }
            if(current == null){
                return null;
            }
        }
        return current;
    }

    //插入
    public void insert(int index,double data){
        Node newNode = new Node();
        newNode.data = data;
        newNode.index = index;
        if(root == null){//如果为空树,则直接将新的节点赋值给root节点
            root  = newNode;
        }else{
            Node current = root;
            Node parent;
            while(true){
                parent = current;
                if(index<current.index){
                    current = current.leftChild;
                    if(current==null){//如果当前节点为空,则有位置插入新的节点
                        parent.leftChild = newNode;
                        return;
                    }
                }else{
                    current = current.rightChild;
                    if(current ==null){
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }
}

class Node{
    public Node leftChild;
    public Node rightChild;//需要关联的时候进行一个数据指定,并且此属性代表了二叉树利用了链表的结构
    public int index;//索引值,说明了二叉树的节点利用了数组的索引结构,这样有利于快速的查询
    public double data;

    public void displayNode(){
        System.out.println("{");
        System.out.println(index);
        System.out.println(",  ");
        System.out.println(data);
        System.out.println("}");
    }
}
