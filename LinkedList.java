class Node {
  Node next;
  int data;
}

class Linked {

  /* Insertion */

  /* It'll insert given element at front position */
  public Node insertFront(int i,Node node){
    Node a=getNewNode(i);
    a.next=node;
    return a;
  }

  /* It'll insert given element at given position */
  public Node insertAtPosition(int i, int position, Node node) {
    if (position < 0) {
      System.out.println("Position can't be less than 1");
    }
    
    if (node == null && position > 1) {
      System.out.println("Position is greater than element exists");
      return node;
    }

    if (node == null && position == 1) {
      return getNewNode(i);
    }

    if (position == 1) {
      Node newNode = getNewNode(i);
      newNode.next = node;
      return newNode;
    }
    
    node.next = insertAtPosition(i, position - 1, node.next);
    return node;
  }


  // Deletion

  // Delete at front

  public Node DeleteFront(Node node){
    return node.next;
  }

  public Node deletePosition(int position, Node node) {
    if (position < 0) {
      System.out.println("Position can't be less than 1");
    }
    
    if (node == null && position > 1) {
      System.out.println("Position is greater than element exists");
      return node;
    }

    if (position == 1) {
      return node.next;
    }
    
    node.next = deletePosition(position - 1, node.next);
    return node;
  }


  // Getting Size

  public int getSize(Node node){
    if(node==null) return 0;
    return getSize(node.next)+1;
  }


  //RotatLinked List Clockwise
  public Node RotateClockWise(int k,Node node){
    if(node==null || k<=0) return node;
    
    int size=getSize(node);

    Node temp=node;
    int i=1;

    while(i<size-k){
      temp=temp.next;
      i++;
    }

    Node ans=temp.next;
    Node head=ans;
    temp.next=null;

    while(ans.next!=null){
      ans=ans.next;
    }

    ans.next=node;

    return head;
  }


  //Give value exist in linkedlist using reursion
  public boolean CheckNodeExist(int val,Node node){
    if(node==null) return false;
    if(node.data==val) return true;
    return CheckNodeExist(val, node.next);
  }


  /* getNewNode() method to generate a new node */
  public Node getNewNode(int key) {
    Node a = new Node();
    a.next = null;
    a.data = key;
    return a;
  }

  /* insert method is used to insert the element in Linked List */
  public Node insert(int key, Node node) {

    if (node == null)
      return getNewNode(key);
    else
      node.next = insert(key, node.next);

    return node;
  }

  public void printList(Node node) {
    if (node == null) {
      return;
    }

    System.out.print(node.data + " ");
    printList(node.next);
  }
}

public class LinkedList {

  public static void main(String[] args) {

    Node root = null;
    Linked a = new Linked();

    root = a.insert(12, root);
    root = a.insert(99, root);
    root = a.insert(37, root);

    int size=a.getSize(root);
    System.out.println("Size of LinkedList:"+size);

    root = a.insertFront(10, root);
    System.out.println("Inserting Front");
    a.printList(root);
    System.out.println();

    root = a.insertAtPosition(5, 2, root);
    System.out.println("Inserting at any position");
    a.printList(root);
    System.out.println();

    root=a.DeleteFront(root);
    System.out.println("Deleting Front Node");
    a.printList(root);
    System.out.println();

    root=a.deletePosition(2,root);
    System.out.println("Deleting Node at position");
    a.printList(root);
    System.out.println();

    System.out.println(a.CheckNodeExist(37,root));

    System.out.println("Actual linkedlist");
    a.printList(root);
    System.out.println();

    root=a.RotateClockWise(2,root);
    System.out.println("Roate linkedlist Clock wise");
    a.printList(root);
    System.out.println();

  }
}