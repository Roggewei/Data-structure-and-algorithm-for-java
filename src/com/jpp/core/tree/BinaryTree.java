package com.jpp.core.tree;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 　　　　　　　　┏┓　　　┏┓
 * 　　　　　　　┏┛┻━━━┛┻┓
 * 　　　　　　　┃　　　　　　　┃
 * 　　　　　　　┃　　　━　　　┃
 * 　　　　　　　┃　＞　　　＜　┃
 * 　　　　　　　┃　　　　　　　┃
 * 　　　　　　　┃...　⌒　...　┃
 * 　　　　　　　┃　　　　　　　┃
 * 　　　　　　　┗━┓　　　┏━┛
 * 　　　　　　　　　┃　　　┃　Code is far away from bug with the animal protecting
 * 　　　　　　　　　┃　　　┃   神兽保佑,代码无bug
 * 　　　　　　　　　┃　　　┃
 * 　　　　　　　　　┃　　　┃
 * 　　　　　　　　　┃　　　┃
 * 　　　　　　　　　┃　　　┃
 * 　　　　　　　　　┃　　　┗━━━┓
 * 　　　　　　　　　┃　　　　　　　┣┓
 * 　　　　　　　　　┃　　　　　　　┏┛
 * 　　　　　　　　　┗┓┓┏━┳┓┏┛
 * 　　　　　　　　　　┃┫┫　┃┫┫
 * 　　　　　　　　　　┗┻┛　┗┻┛
 * Created by weijabin@outlook.com
 * create time for 2018/5/25/025
 */
public class BinaryTree {
    private Integer  data;
    private BinaryTree left;//左节点
    private BinaryTree right;//有节点
    
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
     * 构建二叉搜索树
     *
     */
    public void insert(BinaryTree node,Integer value){
        if(node!=null){
            //小于节点数值
            if(value<=node.data){
                //左子树不存在
                if(node.left==null){
                    node.left = new BinaryTree(value);
                }else{
                    //左子树存在
                    insert(node.left,value);
                }
            //大于节点数值
            }else{
                //右子树不存在
                if(node.right==null){
                    node.right = new BinaryTree(value);
                }else{
                    //右子树存在
                    insert(node.right,value);
                }
            }
        }
    }
    /**
     * 构造方法
     *
     * @param data
     */
    public BinaryTree(Integer  data) {
        this(data, null, null);
    }

    /**
     * 左节点插入
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
     * 右节点插入
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
     * DFS 深度优先
     * 前序遍历
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
     * DFS 深度优先
     * 中序遍历
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
     * DFS 深度优先
     * 后续遍历
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
     * BFS 广度优先遍历
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
     * 搜索节点
     * @param node
     * @param value
     * @return
     */
    public boolean findNode(BinaryTree node,Integer value){
    	if(null!=node){
    		//小于则左子树继续比较
    		if(value<node.data&&null!=node.left){
    				return findNode(node.left,value);
    		}
    		//大于则右子树继续比较
    		if(value>node.data&&null!=node.right){
    				return findNode(node.right,value);
    		}
    		return value.intValue()==node.data.intValue();
    	}
    	return false;
    }



}