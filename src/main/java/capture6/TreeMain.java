package capture6;

public class TreeMain {
    public static void main(String[] args) {
        //构建二叉查找树
        Tree tree = new Tree();
        tree.insert(50,1.3);
        tree.insert(25,1.1);
        tree.insert(75,1.7);
        tree.insert(12,1.3);
        tree.insert(37,1.9);
        tree.insert(43,1.4);
        tree.insert(87,1.6);
        tree.insert(93,1.2);
        tree.insert(97,1.5);
        tree.insert(30,1.4);
        tree.insert(19,1.3);


        tree.traverse(1);
    }
}
