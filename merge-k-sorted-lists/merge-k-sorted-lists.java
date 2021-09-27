/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        
        if(lists.length == 1) return lists[0];
        
        
        
        ListNode mergedList = merge(lists[0],lists[1]);
        
        for(int i =2;i<lists.length;i++){
            mergedList = merge(mergedList,lists[i]);
        }
        
        return mergedList;
    }
    
    public ListNode merge(ListNode l1,ListNode l2){
        //Create the dummyNode for return list
        ListNode dummyHead = new ListNode();
        ListNode out = dummyHead;
        
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                out.next = l1;
                l1 = l1.next;
                out = out.next;
                out.next = null;
            }else{
                out.next = l2;
                l2 = l2.next;
                out = out.next;
                out.next = null;
            }
        }
        while(l1 != null){
            out.next = l1;
            l1 = l1.next;
            out = out.next;
            out.next = null;
        }
        while(l2 != null){
            out.next = l2;
            l2 = l2.next;
            out = out.next;
            out.next = null;
        }
        return dummyHead.next;
    }
}