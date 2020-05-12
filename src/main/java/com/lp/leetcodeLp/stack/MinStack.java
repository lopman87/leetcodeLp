package com.lp.leetcodeLp.stack;

import java.util.PriorityQueue;
import java.util.Stack;

/**
 * 请设计一个栈，除了常规栈支持的pop与push函数以外，还支持min函数，该函数返回栈元素中的最小值。执行push、pop和min操作的时间复杂度必须为O(1)。
 *
 *
 * 示例：
 *
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/min-stack-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 注意最小的元素不会经常变化。它只在添加更小的元素或最小的元素被弹出时才发生变化。
 */
public class MinStack {
    private Stack<Integer> integerStack;
    private PriorityQueue<Integer> MIN_VAL;
    public MinStack() {
        integerStack = new Stack<>();
        MIN_VAL = new PriorityQueue<>();
    }

    public void push(int x) {
        Integer val_x = new Integer(x);
        integerStack.push(val_x);
        MIN_VAL.add(val_x);
    }

    public void pop() {
        Integer val_x = integerStack.pop();
        MIN_VAL.remove(val_x);
    }

    public int top() {
        return integerStack.peek();
    }

    public int getMin() {
        return MIN_VAL.peek();
    }

    public static void main(String args[]){
        long start = System.currentTimeMillis();
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println( minStack.getMin());  // --> 返回 -3.
        minStack.pop();
        System.out.println(minStack.top());     // --> 返回 0.
        System.out.println( minStack.getMin()); //  --> 返回 -2.
        long end = System.currentTimeMillis();
        System.out.println("cost:"+(end - start));
    }
}
