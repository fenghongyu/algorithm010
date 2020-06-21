学习笔记-HashMap总结

简介：
HashMap 是一个存储key-value映射关系的数据结构。其底层是基于数组实现。
添加元素的思路：
将不同的key值，做hash 处理后，放到数组指定的index位置。为解决 hash 冲突问题，引入链表。
为解决链表过长导致的查询等效率过低，当链表长度达到8的时候，会进化成红黑树。

查询元素思路：
获取hash值，直接取对应位置的值即可。 O（1）

简要描述 put 的过程：
    public V put(K key, V value) {
        //1。hash(key):计算key 的hash 值
        return putVal(hash(key), key, value, false, true);
    }
    
    static final int hash(Object key) {
        int h;
        //取哈希值后，再与其高16位值进行与运算，为其散列更均匀
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
    
    
    
    final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
                       boolean evict) {
            //p 为目标位置的节点
            Node<K,V>[] tab; Node<K,V> p; int n, i;
            if ((tab = table) == null || (n = tab.length) == 0)
                //当前table 为空，先扩容
                n = (tab = resize()).length;
            if ((p = tab[i = (n - 1) & hash]) == null)
                //目标位上为空，则直接构建新节点，赋值上去即可
                tab[i] = newNode(hash, key, value, null);
            else {
                //处理出现hash 冲突的case
                Node<K,V> e; K k;
                if (p.hash == hash &&
                        ((k = p.key) == key || (key != null && key.equals(k))))
                    // hash值相等，且（key 相等），则表示新加元素与当前节点元素相等，则直接替换。
                    e = p;
                else if (p instanceof TreeNode)
                    // 如果目标节点是树，则走树的增加逻辑
                    e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
                else {
                    //对hash 冲突，且链表未进化成树的场景处理
                    for (int binCount = 0; ; ++binCount) {
                        //遍历当前出现hash 冲突的链表
                        if ((e = p.next) == null) {
                            //如果目标节点的下一个节点，是空，则直接赋值
                            p.next = newNode(hash, key, value, null);
                            if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                                //判断是否需要进化成红黑树
                                treeifyBin(tab, hash);
                            //结束当前遍历
                            break;
                        }
                        if (e.hash == hash &&
                                ((k = e.key) == key || (key != null && key.equals(k))))
                            // 目标节点与待存的节点值完全相等，则结束对当前链表的遍历。
                            break;
                        //继续下一个节点的遍历
                        p = e;
                    }
                }
                if (e != null) { // existing mapping for key
                    //判断是否需要返回已存在的值 或者覆盖已存在的值
                    V oldValue = e.value;
                    if (!onlyIfAbsent || oldValue == null)
                        e.value = value;
                    afterNodeAccess(e);
                    return oldValue;
                }
            }
            ++modCount;
            if (++size > threshold)
                //判断是否需要扩容
                resize();
            afterNodeInsertion(evict);
            return null;
        }
