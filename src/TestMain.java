public class TestMain {

   public static void main(String args[]) {

      DoublyLinkedList intlist = new DoublyLinkedList();

      Filterable filterFunc = new Filterable() {
         public boolean filterItem(Node node) {
            if ((Integer) node.data >= 30)
               return true;
            else
               return false;
         }
      };

      int ia, ib, ic, id, ie, ik, ig, ih;

      ia = 10;
      ib = 20;
      ic = 30;
      id = 40;
      ie = 50;
      ik = 60;
      ig = 70;
      ih = 56;

      intlist.pushHead(ia);
      intlist.pushHead(ib);
      intlist.pushHead(ic);
      intlist.pushTail(id);
      intlist.pushTail(ie);
      intlist.pushTail(ik);
      intlist.PrintDblLinkedList();

      System.out.print("reverse: ");
      intlist.reverse().PrintDblLinkedList();

      System.out.print("filter >= 30: ");
      intlist.filter(filterFunc).PrintDblLinkedList();


      System.out.println("length:" + intlist.getSize());
      System.out.println("2th element: " + intlist.getNth(2).data);
      System.out.println("5th element: " + intlist.getNth(5).data);

      System.out.println("find node with 50 value::" + intlist.findNode(50).data);
      if (intlist.findNode(56)==null)
         System.out.println("no node with 56 value");

      System.out.println("popHead: "+ intlist.popHead());
      System.out.println("popHead: "+ intlist.popHead());
      intlist.PrintDblLinkedList();

      System.out.println("Head: "+ intlist.getHead().data);
      System.out.println("Tail: "+ intlist.getTail().data);

      System.out.println("popTail: "+ intlist.popTail());
      System.out.println("popTail: "+ intlist.popTail());
      intlist.PrintDblLinkedList();

      System.out.println("length: "+ intlist.getSize());
      System.out.print("push 70 after 0th element: ");
      intlist.pushNth(0, 70);
      intlist.PrintDblLinkedList();

      System.out.print("pop 1th element: ");
      intlist.popNth(1);
      intlist.PrintDblLinkedList();

      System.out.println("isListEmpty: " + intlist.isListEmpty());
      System.out.println("popTail: "+ intlist.popTail());
      System.out.println("popTail: "+ intlist.popTail());
      System.out.println("isListEmpty: " + intlist.isListEmpty());


      //multithreading tests

   }

}
