package com.algorithm.tree;

/**
 * B-Tree
 * m阶B-Tree，表示每个节点最多有m个子节点，每个节点最多有m-1个关键字
 * 1. 每个节点最多有 m 个子节点
 * 2. 除根节点和叶子节点，其它每个节点至少有 [m/2] （向上取整的意思）个子节点
 * 3. 若根节点不是叶子节点，则其至少有2个子节点
 * 4. 所有NULL节点到根节点的高度都一样
 * 5. 除根节点外，其它节点都包含 n 个key，其中 [m/2] -1 <= n <= m-1
 */
public class BTree {
    
}
