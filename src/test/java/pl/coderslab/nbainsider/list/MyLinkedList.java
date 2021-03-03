//package pl.coderslab.nbainsider.list;
//
//import com.google.common.base.MoreObjects;
//
//
//public class MyLinkedList implements MyList {
//
//    private Node first = null;
//
//    private static class Node {
//        Node next;
//        Node previous;
//        String value;
//
//        @Override
//        public String toString() {
//            return MoreObjects.toStringHelper(this)
//                    .add("value", value)
//                    .toString();
//        }
//    }

    @Override
    public String toString() {

        MoreObjects.ToStringHelper toStringHelper = MoreObjects.toStringHelper(this);
        Node n = first;
//        toStringHelper.add("first", first);
        while (n != null){
            toStringHelper.add("next", n);
            n = n.next;
        }

        return toStringHelper
                .toString();
    }

    @Override
    public void add(String element) {
        if (first == null) {
            first = new Node();
            first.value = element;
        } else {
            Node node = first;
            while (node.next != null) {
                node = node.next;
            }
            Node nextone = new Node();
            nextone.value = element;
            node.next = nextone;
            nextone.previous = node;
        }


    }

    @Override
    public void delete(String element) {

    }

    @Override
    public void showList() {

    }

    @Override
    public void count() {

    }
}
