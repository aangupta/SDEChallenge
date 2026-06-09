package Day09;

/*
https://leetcode.com/problems/reverse-linked-list/description/

Given the head of a singly linked list, reverse the list, and return the reversed list.

Example 1:
Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]
*/

//Approach 1 : Iterative
//TC - O(n)
//SC - O(1)
class Solution {

    public ListNode reverseList(ListNode head) {

        // Previous node of current node
        ListNode previous = null;

        // Current node being processed
        ListNode current = head;

        while (current != null) {

            // Store next node before breaking the link
            ListNode nextNode = current.next;

            // Reverse the link
            current.next = previous;

            // Move pointers forward
            previous = current;
            current = nextNode;
        }

        // previous becomes the new head
        return previous;
    }
}

// Approach 2 : Recursive
