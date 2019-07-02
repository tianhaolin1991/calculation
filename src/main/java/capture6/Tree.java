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
    public Node find(int index) {
        Node current = root;//因为我们的查询是需要通过root节点开始查询的
        while (true) {
            if (current == null) {
                break;
            }
            if (index > current.index) {
                current = current.rightChild;
            } else if (index < current.index) {
                current = current.leftChild;
            } else {
                break;
            }
        }
        return current;
    }

    //插入
    public void insert(int index, double data) {
        Node newNode = new Node();
        newNode.data = data;
        newNode.index = index;
        if (root == null) {//如果为空树,则直接将新的节点赋值给root节点
            root = newNode;
        } else {
            Node current = root;
            Node parent;
            while (true) {
                parent = current;
                if (index < current.index) {
                    current = current.leftChild;
                    if (current == null) {//如果当前节点为空,则有位置插入新的节点
                        parent.leftChild = newNode;
                        return;
                    }
                } else {
                    current = current.rightChild;
                    if (current == null) {
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }

    //二叉树的删除

    /**
     * 1.如果没有子节点,直接删除即可
     * 2.如果左子节点不为空,右子节点为空,则使用左子节点代替当前节点
     * 2.如果右子节点不为空,左子节点为空,则使用右子节点代替当前节点
     * 4.如果左右子节点均不为空,需要对左节点进行规则遍历,找到节点继承者
     * 规则遍历:查找右子树的最小节点
     */
    public boolean delete(int index) {
        Node current = root;
        Node parent = root;
        //查找到想要删除的节点
        boolean isLeftChild = false;
        while (true) {//查找节点
            if (current == null) {
                return false;
            }
            if (current.index == index) {
                break;
            }
            if (index < current.index) {//向左查询
                parent = current;
                current = current.leftChild;
                isLeftChild = true;
            } else {//向右查询
                parent = current;
                current = current.rightChild;
                isLeftChild = false;
            }
        }

        //删除操作
        //1.没有左右节点
        if (current.leftChild == null && current.rightChild == null) {
            if (current == root) {
                root = null;
            } else if (isLeftChild) {
                parent.leftChild = null;
            } else {
                parent.rightChild = null;
            }
        } else if (current.rightChild == null) {//2.只有左子节点
            if (current == root) {
                root = current.leftChild;
            } else if (isLeftChild) {
                parent.leftChild = current.leftChild;
            } else {
                parent.rightChild = current.leftChild;
            }
        } else if (current.leftChild == null) {//3.只有右子节点
            if (current == root) {
                root = current.rightChild;
            } else if (isLeftChild) {
                parent.leftChild = current.rightChild;
            } else {
                parent.rightChild = current.rightChild;
            }
        } else {//4.左右子节点都有,需要找到右子树的最小节点
            Node successor = getSuccessor(current);
            if( current == root){
                root = successor;
            }
            if (isLeftChild) {
                parent.leftChild = successor;
            } else {
                parent.rightChild = successor;
            }
        }
        return true;
    }

    //寻找继承者
    private Node getSuccessor(Node deleteNode) {
        Node successorParent = deleteNode;
        Node successor = deleteNode.rightChild;
        while (successor.leftChild != null) {
            successorParent = successor;
            successor = successor.leftChild;
        }
        if (successor != deleteNode.rightChild) {
            successorParent.leftChild = successor.rightChild;//将successor的右节点赋值给SuccsssorParent
            successor.rightChild = deleteNode.rightChild;
        }
        return successor;
    }

    //前序遍历
    private void preOrder(Node localNode){
        if(localNode!=null){
            System.out.println(localNode);
            preOrder(localNode.leftChild);
            preOrder(localNode.rightChild);
        }
    }
    //中序遍历
    private void inOrder(Node localNode){
        if(localNode!=null){
            inOrder(localNode.leftChild);
            System.out.println(localNode);
            inOrder(localNode.rightChild);
        }
    }
    //后序遍历
    private void postOrder(Node localNode){
        if(localNode!=null){
            postOrder(localNode.leftChild);
            postOrder(localNode.rightChild);
            System.out.println(localNode);
        }
    }

    public void traverse(int type){
        switch (type){
            case 1:
                System.out.print("pre");
                preOrder(root);
                break;
            case 2:
                System.out.print("in");
                inOrder(root);
                break;
            case 3:
                System.out.print("post");
                postOrder(root);
                break;
            default:
                break;
        }
    }
}

class Node {
    public Node leftChild;
    public Node rightChild;//需要关联的时候进行一个数据指定,并且此属性代表了二叉树利用了链表的结构
    public int index;//索引值,说明了二叉树的节点利用了数组的索引结构,这样有利于快速的查询
    public double data;

    public String toString() {
        return "{" + index + "," + data + "}";
    }
}
