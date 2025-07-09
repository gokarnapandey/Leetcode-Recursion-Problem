✅ Problem Statement:
Given a stack, delete its middle element using only recursion. You should not use any additional stack or array.
If the stack has odd number of elements, delete the exact middle.
If it has even number of elements, delete the (n/2)th element (1-based index).
==================================================================================================================================
💡 Approach:
We use recursion to pop elements until we reach the middle, then:
Skip popping the middle element (i.e., delete it),
Then push back the rest of the elements in reverse order to restore the original stack (minus the middle).
=====================================================================================================================================
🔁 Why Recursion?
Because we’re not allowed to use another stack or list, we use the function call stack as temporary storage while we go deeper.
===================================================================================================================================
🔄 Algorithm Steps:
In the deleteMid() method:
  Get the current size n of the stack.
  Compute k = n/2 + 1 (1-based index for middle).
Call the helper recursive method solve(stack, k).

In the solve(stack, k) method:
  Base case: if k == 1, pop the top (middle element).
Otherwise:
  Pop the top.
  Recurse with k - 1.
  Push the popped value back after recursion.
================================================================================================================================
🧱 Pseudocode:
function deleteMid(stack):
    n = stack.size()
    k = (n / 2) + 1
    solve(stack, k)

function solve(stack, k):
    if k == 1:
        stack.pop()  // delete the middle
        return

    temp = stack.pop()
    solve(stack, k - 1)
    stack.push(temp)  // restore elements after deleting middle
=====================================================================================================================================
  
  ✅ Final Organized Java Code:
import java.util.Stack;

class Solution {

    // Recursive helper function to delete the kth element
    private static void solve(Stack<Integer> s, int k) {
        if (k == 1) {
            s.pop(); // delete middle
            return;
        }

        int temp = s.pop(); // store top
        solve(s, k - 1);    // go deeper
        s.push(temp);       // push back after middle is deleted
    }

    // Function to delete the middle element of a stack
    public void deleteMid(Stack<Integer> s) {
        int n = s.size();
        int k = (n / 2) + 1; // position of middle (1-based)
        solve(s, k);
    }
}
