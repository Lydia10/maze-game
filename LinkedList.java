public class LinkedList {
    private Node headNode;
    public void addHeadNode(int x, int y) {
        Node oNode = new Node();
        oNode.xPosition = x;
        oNode.yPosition = y;
        oNode.nextNode = headNode;
        headNode = oNode;
    }

    public Node removeHeadNode(){
        Node tempNode = headNode;
        if(headNode != null) {
            headNode = headNode.nextNode;
        }
        return tempNode;
    }

    public Node getHeadNode(){
        return headNode;
    }

}
