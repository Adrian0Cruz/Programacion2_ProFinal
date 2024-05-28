package Logic;
//@author Jesús Hernández
public class Node {
    protected Node Sig;
    protected Node Ant;

    public Node (  ) { }

    @Override
    public String toString (  ) {
        return "Node{" + "Sig=" + Sig + ", Ant=" + Ant + '}'; }
}