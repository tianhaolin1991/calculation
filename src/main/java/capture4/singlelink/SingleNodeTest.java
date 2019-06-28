package capture4.singlelink;

/**
 * @author:tianhaolin
 * @version:1.0
 */
public class SingleNodeTest {
    public static void main(String[] args) {
        SingleLink<String> stringSingleLink = new SingleLink<String>();
        stringSingleLink.add("Node1");
        stringSingleLink.add("Node2");
        stringSingleLink.add("Node3");
        stringSingleLink.add("Node4");
        System.out.println(stringSingleLink);
        stringSingleLink.delete(3);
        System.out.println(stringSingleLink);
        String s = stringSingleLink.get(2);
        System.out.println(s);
    }
}
