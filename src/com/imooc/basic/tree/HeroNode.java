package com.imooc.basic.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树
 * dxp
 * */
public class HeroNode {

    private HeroNode leftNode;

    private HeroNode rightNode;

    private String name;

    private Object value;

    // 插入 数据
    public void add(HeroNode o) {
        // 如果当前节点没有值，就把数据放在当前节点上
        if (null == value) {
            value = o.getValue();
            name = o.getName();
        }


            // 如果当前节点有值，就进行判断，新增的值与当前值的大小关系
        else {
            // 新增的值，比当前值小或者相同

            if ((Integer) o.getValue() -((Integer)value) <= 0) {
                if (null == leftNode)
                    leftNode = new HeroNode();
                leftNode.add(o);
            }
            // 新增的值，比当前值大
            else {
                if (null == rightNode)
                    rightNode = new HeroNode();
                rightNode.add(o);
            }

        }

    }
    public HeroNode() {
    }

    public HeroNode(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }

    // 中序遍历所有的节点
    public List<Object> values() {
        List<Object> values = new ArrayList<>();

        // 右节点的遍历结果
        if (null != rightNode)

            values.addAll(rightNode.values());

        // 当前节点
        values.add(toString());

        // 左节点的遍历结果
        if (null != leftNode)
            values.addAll(leftNode.values());

        return values;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }

    public static void main(String[] args) {
        int randoms[] = new int[] { 671, 71, 301, 731, 101, 10, 781, 811, 101,741 };

        HeroNode roots = new HeroNode();
        for (int i=0; i< randoms.length;i++) {
            roots.add(new HeroNode("ming"+i,randoms[i]));
        }

        System.out.println(roots.values());
    }
}
