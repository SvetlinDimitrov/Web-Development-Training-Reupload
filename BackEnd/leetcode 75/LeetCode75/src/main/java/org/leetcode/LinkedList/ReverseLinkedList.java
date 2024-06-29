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
    ListNode listNode = reverseList(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))));

    while (listNode != null) {
      System.out.println(listNode.val);
      listNode = listNode.next;
    }
  }

  public static ListNode reverseList(ListNode head) {
    ListNode prev=null;
    ListNode curr=head;
    ListNode next=null;
    while(curr!=null){
      next=curr.next;
      curr.next=prev;
      prev=curr;
      curr=next;
    }return prev;
  }
}
