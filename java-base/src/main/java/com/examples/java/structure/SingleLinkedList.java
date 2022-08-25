package com.examples.java.structure;

/**
 * 单项链表-数据结构
 */
public class SingleLinkedList<E> {

    // 头节点
    private Node head;

    // 元素个数
    private int size;

    /**
     * 无惨构造设置初始值
     */
    public SingleLinkedList() {
        this.head = null;
        this.size = 0;
    }

    /**
     * 获取链表个数
     */
    public int getSize() {
        return this.size;
    }

    /**
     * 判断链表是否为空
     */
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * 链表头部添加元素
     */
    public void addFirst(E e) {
        Node node = new Node(e);
        // 这两步进行了置换，相当于吧新插入的节点置为head
        node.next = this.head;
        this.head = node;
        this.size++;
    }

    /**
     * 向链表尾部插入元素
     */
    public void addLast(E e) {
        add(e, size);
    }

    /**
     * 根据下标插入元素
     */
    public void add(E e, int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index is not allowed.");
        }
        if (index == 0) {
            addFirst(e);
            return;
        }
        Node preNode = head;
        // 找到要插入节点的前一个节点
        for (int i = 0; i < index - 1; i++) {
            preNode = preNode.next;
        }
        Node node = new Node(e);
        // 要插入的节点的下一个节点指向preNode节点的下一个节点
        node.next = preNode.next;
        // preNode的下一个节点指向要插入节点node
        preNode.next = node;
        size++;
    }

    /**
     * 删除元素
     */
    public void remove(E e) {
        if (head == null) {
            System.out.println("无元素可删除");
            return;
        }
        // 要删除的元素与头节点的元素相同
        while (head != null && head.e.equals(e)) {
            head = head.next;
            size--;
        }
        // 上面已经对头节点判别是否要进行删除，所以要对头节点的下一个节点进行判别
        Node cur = head;
        while (cur != null && cur.next != null) {
            if (cur.next.e.equals(e)) {
                size--;
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
    }

    /**
     * 删除第一个元素
     */
    public E removeFirst() {
        if (head == null) {
            System.out.println("无元素可删除");
            return null;
        }
        Node delNode = head;
        head = head.next;
        delNode.next = null;
        size--;
        return delNode.e;
    }

    /**
     * 删除最后一个元素
     */
    public E removeLast() {
        if (head == null) {
            System.out.println("无元素可删除");
            return null;
        }
        // 只有一个元素
        if (getSize() == 1) {
            return removeFirst();
        }
        // 纪录当前节点
        Node cur = head;
        Node pre = head;
        while (cur.next != null) {
            pre = cur;
            cur = cur.next;
        }
        pre.next = cur.next;
        size--;
        return cur.e;
    }

    /**
     * 判断链表是否包含某个元素
     */
    public boolean contains(E e) {
        Node cur = head;
        while (cur != null) {
            if (cur.e.equals(e)) {
                return true;
            } else {
                cur = cur.next;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        Node cur = this.head;
        while (cur != null) {
            sb.append(cur.e + "->");
            cur = cur.next;
        }
        sb.append("NULL");
        return sb.toString();
    }

    /**
     * 定义内部节点类
     */
    private class Node {
        // 元素
        private E e;
        // 指向下一个元素
        private Node next;

        /**
         * 构造函数
         */
        public Node(E e) {
            this.e = e;
        }
    }

    public static void main(String[] args) {
        SingleLinkedList<Integer> list = new SingleLinkedList();
        for (int i = 0; i < 10; i++) {
            list.addFirst(i);
            System.out.println(list);
        }
        list.addLast(33);
        list.addFirst(33);
        list.add(33, 5);
        System.out.println(list);
        list.remove(33);
        System.out.println(list);
        System.out.println("删除第一个元素：" + list.removeFirst());
        System.out.println(list);
        System.out.println("删除最后一个元素：" + list.removeLast());
        System.out.println(list);
    }
}
