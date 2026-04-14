/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node CopyNode(Node head){
        Node temp = head;

        while(temp != null){
            Node copyNode = new Node (temp.val);
            copyNode.next = temp.next;
            temp.next = copyNode;
            temp = temp.next.next;
        }
        return head;
    }

    public Node connectRandomPointer(Node head){
        Node temp = head;
        while(temp != null){
            Node  copyNode = temp.next;
            if(temp.random != null) copyNode.random = temp.random.next;
            else copyNode.random = null;

            temp = temp.next.next;
        }
        return head;
    }

    public Node connectNextPointer(Node head){
        Node dnode = new Node(-1);
        Node res = dnode;
        Node temp = head;

        while(temp != null){
            res.next = temp.next;
            temp.next = temp.next.next;
            res = res.next;
            temp = temp.next;
        }
        return dnode.next;
    }
    public Node copyRandomList(Node head) {

        // if(head==null) return null;

        // Map<Node, Node> mpp = new HashMap<>();
        // Node temp = head;

        // while(temp != null){
        //     Node newNode = new Node(temp.val);
        //     mpp.put(temp, newNode);
        //     temp = temp.next;
        // }

        // temp = head;

        // while(temp != null){
        //     Node copyNode = mpp.get(temp);
        //     copyNode.next = mpp.get(temp.next);
        //     copyNode.random = mpp.get(temp.random);
        //     temp = temp.next;
        // }

        // return mpp.get(head);

        CopyNode(head);
        connectRandomPointer(head);
        return connectNextPointer(head);
    }
}