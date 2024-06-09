/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var middleNode = function(head) {
    const a = [];
    while (head){
        a.push(head.val);
        head = head.next;
    }
    let head2;
    let head3;
    for (let i = Math.floor(a.length/2); i < a.length; i++) {
        if(Math.floor(a.length/2) === i){
            head3 = head2 = new ListNode(a[i], null);
        }
        else {
            head2.next = new ListNode(a[i], null);
            head2 = head2.next;
        }
    }
    return head3;
};

function ListNode(val, next) {
    this.val = (val===undefined ? 0 : val);
    this.next = (next===undefined ? null : next);
}

// Create a linked list: 1 -> 2 -> 3 -> 4 -> 5
let node5 = new ListNode(5, null);
let node4 = new ListNode(4, node5);
let node3 = new ListNode(3, node4);
let node2 = new ListNode(2, node3);
let head = new ListNode(1, node2);

console.log(middleNode(head)); // Expected: 3 -> 4 -> 5
