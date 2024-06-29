package org.leetcode.LinkedList;

public class OddEvenLinkedList {

  /*
  Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices, and return the reordered list.

  The first node is considered odd, and the second node is even, and so on.

  Note that the relative order inside both the even and odd groups should remain as it was in the input.

  You must solve the problem in O(1) extra space complexity and O(n) time complexity.

  Example 1:
  Input: head = [1,2,3,4,5]
  Output: [1,3,5,2,4]

  Example 2:
  Input: head = [2,1,3,5,6,4,7]
  Output: [2,3,6,7,1,5,4]
  * */

  public static void main(String[] args) {
    ListNode listNode = oddEvenList(
        new ListNode(1,
            new ListNode(2,
                new ListNode(3,
                    new ListNode(4,
                        new ListNode(5,
                            new ListNode(6,
                                new ListNode(7,
                                    new ListNode(8)
                                )
                            )
                        )
                    )
                )
            )
        )
    );

    while (listNode != null) {
      System.out.println(listNode.val);
      listNode = listNode.next;
    }
  }

  public static ListNode oddEvenList(ListNode head) {

    if (head == null) return null;

    int i = 0;
    var curr = head;
    var odd = curr.next;
    var oddRef = odd;
    var even = curr;
    var answer = even;

    while (curr != null) {

      if (i % 2 != 0) {
        if (i != 1) {
          odd.next = odd.next.next;
          odd = odd.next;
        }
      } else {
        if (i != 0) {
          even.next = even.next.next;
          even = even.next;
        }
      }

      i++;
      curr = curr.next;
    }
    if (odd != null) odd.next = null;
    even.next = oddRef;
    return answer;
  }
}
