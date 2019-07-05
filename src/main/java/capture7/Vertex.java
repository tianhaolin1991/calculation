package capture7;
/**
 * 顶点类
 */
public class Vertex{
    public char label;//顶点的数据
    public boolean wasVisited;

    public Vertex(char label){
        this.label = label;
        wasVisited = false;
    }
}
