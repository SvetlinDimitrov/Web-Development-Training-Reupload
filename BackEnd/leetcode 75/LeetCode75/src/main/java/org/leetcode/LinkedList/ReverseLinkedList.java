package org.leetcode.LinkedList;

import java.util.ArrayDeque;
import java.util.Deque;

public class ReverseLinkedList {
  public static class ListNode {
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
  /*
  Given the head of a singly linked list, reverse the list, and return the reversed list.

  Example 1:
  Input: head = [1,2,3,4,5]
  Output: [5,4,3,2,1]

  Example 2:
  Input: head = [1,2]
  Output: [2,1]

  Example 3:
  Input: head = []
  Output: []
  * */

  public static void main(String[] args) {

  }

  public ListNode reverseList(ListNode head) {
    Deque<Integer> deque = new ArrayDeque<>();

    while (head.next != null) {

      deque.push(head.val);
      head = head.next;
    }

    return null;
  }
}
