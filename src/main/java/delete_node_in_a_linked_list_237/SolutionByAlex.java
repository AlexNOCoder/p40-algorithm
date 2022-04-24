package delete_node_in_a_linked_list_237;


import common.ListNode;

public class SolutionByAlex {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;

    }

}


