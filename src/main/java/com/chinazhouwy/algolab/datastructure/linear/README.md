# 线性结构

这里放顺序表、链表和栈等线性结构的最小实现。当前类包括：

- `SeqList`：连续存储，元素区间为 `[0, size)`，插入位置为 `[0, size]`
- `SinglyLinkedList`：带哨兵节点的单链表，练习反转、合并、去重和快慢指针
- `DoublyList`：同时维护 `prev` 和 `next`
- `LinkedStack`、`ArrayStack`：指针式栈和顺序栈
- `StaticLinkedListSimple`、`StaticLinkedListComplex`：用数组下标模拟指针和空闲链

后续正式实验按以下约定补齐：

```text
<experiment>/
├── README.md
├── Demo.java
└── cases.txt
```

README 至少说明 408 知识点、状态变量、Java 模型、教材例子、手算结果、Debug 观察点、常见坑和复杂度。
