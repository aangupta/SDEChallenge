package Day09;

/* https://leetcode.com/problems/merge-two-sorted-lists/description/

You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.

Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]

Input: list1 = [], list2 = []
Output: []
*/

//TC - O(m + n)
//SC - O(1)
class Solution {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        // Dummy node helps simplify
        // edge cases while building result list
        ListNode dummy = new ListNode(-1);

        // Pointer used to build merged list
        ListNode current = dummy;

        // Compare nodes from both lists
        // and attach the smaller one
        while (list1 != null && list2 != null) {

            if (list1.val <= list2.val) {

                current.next = list1;
                list1 = list1.next;

            } else {

                current.next = list2;
                list2 = list2.next;
            }

            current = current.next;
        }

        current.next = (list1 != null ? list1 : list2);

        // Skip dummy node and return actual head
        return dummy.next;
    }
}