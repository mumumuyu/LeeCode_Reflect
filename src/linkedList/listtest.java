package linkedList;

import java.util.Scanner;

public class listtest {
    public static void main(String[] args) throws Exception {
        int n=10;
        LinkList L = new LinkList();
        for(int i=0;i<n;i++)
            L.insert(i,i);
        System.out.println("请输入i的值：");
        int i = new Scanner(System.in).nextInt();
        if(0<i && i <  n-1){
            System.out.println("第" + i + "个元素的直接前驱是：" +L.get(i-1));
            System.out.println("第" + i + "个元素的直接后继是：" +L.get(i+1));
        }
        else
            System.out.println("第" + i + "个元素的直接前驱或后继不存在！" );
    }
}

interface IList {
    public int length();
    public void insert(int i,Object x )throws Exception;
}


class LinkList implements IList{
    public Node head;
    public LinkList () {
        head = new Node();
    }
    public boolean isEmpty(){
        return head.next ==null;
    }
    public int length(){
        Node p = head.next;
        int length = 0;
        while(p != null){
            p = p.next;
            ++length;
        }
        return length;
    }
    public Object get(int i)throws Exception{
        Node p = head.next;
        int j = 0;
        while (p != null && j<i){
            p = p.next;
            ++j;
        }
        if (j>i||p==null){
            throw new Exception("第" + i + "个元素不存在");
        }
        return p.data;
    }
    public void insert(int i , Object x )throws Exception{
        Node p = head;
        int j = -1;
        while (p != null && j < i - 1){
            p = p.next;
            ++j;
        }
        if (j >i-1||p==null)
            throw new Exception("插入位置不合理");
        Node s = new Node (x);
        s.next=p.next;
        p.next =s ;
    }
}

class Node {
    public Object data;
    public Node next;
    public Node (){
        this (null, null);
    }
    public Node(Object data){
        this(data,null);
    }
    public Node(Object data,Node next){
        this.data = data;
        this.next=next;
    }
}

