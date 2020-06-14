学习笔记
分析 Queue 和 Priority Queue 的源码

Queue 是一个接口，提供了以下接口方法
//向队列中增加元素，如果容量允许，则返回true，否则，抛出异常
boolean add(E e);
//向队列中增加元素，如果容量允许，添加成功，返回true，否则返回false
boolean offer(E e);
//查找并移除队列头节点，同时返回头节点。如果队列空，则抛出异常。
E remove();
//查找并移除队列头节点，同时返回头节点。如果队列空，则返回null。
E poll();
//查找并返回头节点，但不移除它。如果队列空，则抛出异常。
E element();
查找并返回头节点，但不移除它。如果队列空，则返回null。
E peek();


PriorityQueue 是 Queue 的具体实现类，其属于优先级队列,可将队列中的数据按升、降序排列。默认
new PriorityQueue<>() 是升序排列的队列，其初始化，也可自定义 Comparator 实现，或者 SortedSet 等。

