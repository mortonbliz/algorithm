package com.hshc.partner.modules.tmall;

public class MyCircularDeque {
    private int[] values;
    private int capacity;
    private int size;
    private int front;
    private int rear;

    /** 构造函数，初始化队列长度 */
    public MyCircularDeque(int k) {
        capacity = k;
        values = new int[capacity];
        size = 0;
        front = -1;
        rear = -1;
    }

    /** 添加到队列头 */
    public boolean insertFront(int value) {
        if (isFull())
            return false;
        // 添加第一个元素
        if (front == -1 && rear == -1) {
            values[0] = value;
            front = 0;
            rear = 0;
            size++;
            return true;
        }
        for (int i = rear + 1; i > 0; i--){
            values[i] = values[i - 1];
        }
        values[0] = value;
        rear++;
        size++;
        return true;
    }

    /** 插入到队列尾 */
    public boolean insertLast(int value) {
        if (isFull())
            return false;
        // 添加第一个元素
        if (front == -1 && rear == -1) {
            values[0] = value;
            front = 0;
            rear = 0;
            size++;
            return true;
        }
        values[++rear] = value;
        size++;
        return true;
    }

    /** 删除队列头 */
    public boolean deleteFront() {
        if (isEmpty())
            return false;
        if (size == 1) {
            size = 0;
            front = -1;
            rear = -1;
            return true;
        }
        for (int i = 0; i < rear; i++)
            values[i] = values[i + 1];
        rear--;
        size--;
        return true;
    }

    /** 删除队列尾 */
    public boolean deleteLast() {
        if (isEmpty())
            return false;
        if (size == 1) {
            size = 0;
            front = -1;
            rear = -1;
            return true;
        }
        rear--;
        size--;
        return true;
    }

    /** 获取头 */
    public int getFront() {
        if (isEmpty())
            return -1;
        return values[0];
    }

    /** 获取尾 */
    public int getRear() {
        if (isEmpty())
            return -1;
        return values[rear];
    }

    /** 判断是否为空 */
    public boolean isEmpty() {
        return size == 0;
    }

    /** 判断队列是否已满 */
    public boolean isFull() {
        return capacity == size;
    }
}
