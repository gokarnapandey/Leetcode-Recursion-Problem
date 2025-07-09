✅ Problem:
Sort a stack in descending order (largest element at the bottom, smallest at the top) using only recursion.

💡 Approach:
We use two recursive functions:

solve(Stack s) — Recursively pops all elements and pushes them back in sorted order.

insert(Stack s, int x) — Inserts an element x into the sorted stack at the correct position.

The recursion ensures:

When popping, we reach the smallest element.

While inserting, each element is placed in the right spot so that the stack remains sorted.
===========================================================================================================================
🔁 Algorithm:
sort(Stack s)
  
Call solve(s) to start the recursive sorting process.
Return the sorted stack.

solve(Stack s)
Base case: If size is 1, return.
Pop the top element.
Recursively call solve() on the rest of the stack.
Use insert() to insert the popped element back in sorted order.

insert(Stack s, int temp)
Base case: If the stack is empty or top of the stack ≤ temp, push temp.
Else, pop the top, recursively call insert() with temp.
Push back the popped element.
=============================================================================================================================
🧱 Pseudocode:
function sort(stack):
    solve(stack)
    return stack

function solve(stack):
    if stack.size == 1:
        return
    temp = stack.pop()
    solve(stack)
    insert(stack, temp)

function insert(stack, temp):
    if stack.isEmpty() or stack.peek() <= temp:
        stack.push(temp)
        return
    last = stack.pop()
    insert(stack, temp)
    stack.push(last)
==========================================================================================================================================
✅ Final Organized Java Code:

import java.util.Stack;

class GfG {

    // Inserts an element into the sorted stack
    private static void insert(Stack<Integer> s, int temp) {
        if (s.isEmpty() || s.peek() <= temp) {
            s.push(temp);
            return;
        }

        int last = s.pop();
        insert(s, temp);
        s.push(last);
    }

    // Recursively sorts the stack
    private static void solve(Stack<Integer> s) {
        if (s.size() == 1) {
            return;
        }

        int temp = s.pop();
        solve(s);
        insert(s, temp);
    }

    // Public method to start sorting
    public Stack<Integer> sort(Stack<Integer> s) {
        solve(s);
        return s;
    }
}
