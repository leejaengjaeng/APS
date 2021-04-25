package problems;

public class AddTwoNumbers {

    public static void main(String[] args) {
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();

//        [9, 9,9,9, 9,9,9]
//        [9,9,9,9]

        ListNode l1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));
        ListNode l2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));

        ListNode l3 = addTwoNumbers.addTwoNumbers(l1, l2);
        while (l3 != null) {
            System.out.println(l3.val);
            l3 = l3.next;
        }
    }


    /*
        2, 4, 3 -> 342
        5, 6, 4 -> 465
        342 + 465 = 807 -> 7,0,8


        1,2,3 -> 321
        1     -> 1
        321 + 1 = 322 -> 2,2,3

        [9,9,9,9,9,9,9]
        [9,9,9,9]
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int up = 0;
        boolean hasNext = true;

        ListNode emptyNode = new ListNode(0);

        ListNode answer = emptyNode;  //EmptyNode for loop
        ListNode current = answer;

        while (hasNext) {
            int sumCurrent = l1.val + l2.val + up;
            up = sumCurrent / 10;

            current.next = new ListNode(sumCurrent % 10);
            current = current.next;

            if (l1.next == null || l1 == emptyNode) {
                l1 = emptyNode;
            } else {
                l1 = l1.next;
            }
            if (l2.next == null || l2 == emptyNode) {
                l2 = emptyNode;
            } else {
                l2 = l2.next;
            }

            hasNext = !(l1 == emptyNode && l2 == emptyNode);
        }
        if(up != 0) {
            current.next = new ListNode(up);
        }

        return answer.next; //remove first empty node
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}