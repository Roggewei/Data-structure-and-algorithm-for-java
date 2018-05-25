package com.jpp.core.tree;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * ������������������������������
 * �������������������ߩ��������ߩ�
 * ��������������������������������
 * ��������������������������������
 * ��������������������������������
 * ��������������������������������
 * ����������������...���С�...����
 * ��������������������������������
 * ��������������������������������
 * ������������������������������Code is far away from bug with the animal protecting
 * ����������������������������   ���ޱ���,������bug
 * ����������������������������
 * ����������������������������
 * ����������������������������
 * ����������������������������
 * ������������������������������������
 * �����������������������������������ǩ�
 * ��������������������������������������
 * �����������������������������ש�����
 * �����������������������ϩϡ����ϩ�
 * �����������������������ߩ������ߩ�
 * Created by weijabin@outlook.com
 * create time for 2018/5/25/025
 */
public class BinaryTree {
    private Integer  data;
    private BinaryTree left;//��ڵ�
    private BinaryTree right;//�нڵ�
    
    public Integer getData() {
		return data;
	}

	public void setData(Integer data) {
		this.data = data;
	}

	public BinaryTree getLeft() {
		return left;
	}

	public void setLeft(BinaryTree left) {
		this.left = left;
	}

	public BinaryTree getRight() {
		return right;
	}

	public void setRight(BinaryTree right) {
		this.right = right;
	}

	public BinaryTree(Integer  data, BinaryTree left, BinaryTree right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    /**
     * ��������������
     *
     */
    public void insert(BinaryTree node,Integer value){
        if(node!=null){
            //С�ڽڵ���ֵ
            if(value<=node.data){
                //������������
                if(node.left==null){
                    node.left = new BinaryTree(value);
                }else{
                    //����������
                    insert(node.left,value);
                }
            //���ڽڵ���ֵ
            }else{
                //������������
                if(node.right==null){
                    node.right = new BinaryTree(value);
                }else{
                    //����������
                    insert(node.right,value);
                }
            }
        }
    }
    /**
     * ���췽��
     *
     * @param data
     */
    public BinaryTree(Integer  data) {
        this(data, null, null);
    }

    /**
     * ��ڵ����
     * @param value
     */
    public void insertLeft(Integer value){
        if(value!=null){
            if(this.left==null){
                this.left = new BinaryTree(value);
            }else{
                BinaryTree leftTree = new BinaryTree(value);
                leftTree.left = this.left;
                this.left = leftTree;
            }
        }

    }
    /**
     * �ҽڵ����
     * @param value
     */
    public void insertRight(Integer value){
        if(value!=null){
            if(this.right ==null){
                this.right = new BinaryTree(value);
            }else{
                BinaryTree rightTree = new BinaryTree(value);
                rightTree.right = this.right;
                this.right = rightTree;
            }
        }

    }

    /**
     * DFS �������
     * ǰ�����
     * @param node
     */
    public void proOrder(BinaryTree node){
        if(node!=null){
            System.out.println(node.data);
            if(node.left!=null){
                proOrder(node.left);
            }
            if(node.right!=null){
                proOrder(node.right);
            }
        }
    }

    /**
     * DFS �������
     * �������
     * @param node
     */
    public void inOrder(BinaryTree node){
        if(node!=null){
            if(node.left!=null){
                inOrder(node.left);
            }
            System.out.println(node.data);
            if(node.right!=null){
                inOrder(node.right);
            }
        }
    }

    /**
     * DFS �������
     * ��������
     * @param node
     */
    public void postOrder(BinaryTree node){
        if(node!=node){
            if(node.right!=null){
                postOrder(node.right);
            }
            System.out.println(node.data);
            if(node.left!=null){
                postOrder(node.left);
            };
        }
    }

    /**
     * BFS ������ȱ���
     * @param node
     */
    public void bfsOrder(BinaryTree node){
        if(node!=null){
            Queue<BinaryTree> queue = new ArrayDeque<BinaryTree>();
            queue.add(node);
            while(!queue.isEmpty()){
                BinaryTree cnode = queue.poll();
                System.out.println(cnode.data);
                if(cnode.left!=null){
                    queue.add(cnode.left);
                }
                if(cnode.right!=null){
                    queue.add(cnode.right);
                }
            }
        }
    }
    
    /**
     * �����ڵ�
     * @param node
     * @param value
     * @return
     */
    public boolean findNode(BinaryTree node,Integer value){
    	if(null!=node){
    		//С���������������Ƚ�
    		if(value<node.data&&null!=node.left){
    				return findNode(node.left,value);
    		}
    		//�����������������Ƚ�
    		if(value>node.data&&null!=node.right){
    				return findNode(node.right,value);
    		}
    		return value.intValue()==node.data.intValue();
    	}
    	return false;
    }



}