package com.lp.leetcodeLp.design;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用队列实现栈的下列操作：
 *
 * push(x) -- 元素 x 入栈
 * pop() -- 移除栈顶元素
 * top() -- 获取栈顶元素
 * empty() -- 返回栈是否为空
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-stack-using-queues
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MyStack {


    private List<Integer> integerList;

    /** Initialize your data structure here. */
    public MyStack() {
        integerList = new ArrayList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        integerList.add(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return integerList.remove(integerList.size()-1);
    }

    /** Get the top element. */
    public int top() {
        return integerList.get(integerList.size()-1);
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return integerList.isEmpty();
    }

    public static void main(String[] args){
        MyStack queue = new MyStack();
        queue.push(1);
        queue.push(2);
        System.out.println(queue.top());  // 返回 1
        System.out.println(queue.pop());   // 返回 1
        System.out.println(queue.empty()); // 返回 false

    }
}
