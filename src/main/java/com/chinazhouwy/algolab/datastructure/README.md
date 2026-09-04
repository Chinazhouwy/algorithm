# Data Structures

本目录对应项目 README 中的 `data-structure`，实际 Java 包名为
`com.chinazhouwy.algolab.datastructure`。当前实现已经按机制拆到子包：

```text
datastructure/
├── linear/   # 顺序表、链表、栈
├── tree/     # 树（待补充）
├── graph/    # 图（待补充）
├── search/   # 查找、散列（待补充）
└── sort/     # 排序
```

本文件重点记录 `linear` 中代码的 408 边界和指针语义。

## 栈 (Stack)

### LinkedStack - 链表栈（指针实现）

**设计思路**：用链表节点实现栈，每个节点用 `prev` 指向前一个入栈的节点。

```java
static class Node {
    int value;
    Node prev;      // 指向前一个节点
}
```

**核心操作**：
- `push(value)`: 创建新节点，`prev` 指向原栈顶，新节点成为栈顶
- `pop()`: 返回栈顶值，栈顶移到 `top.prev`
- `peek()`: 查看栈顶值（不弹出）

**关键点**：
- ✓ 命名用 `prev` 而非 `next`，更符合栈的语义（每个节点指向前一个**入栈**的节点）
- ✓ 时间复杂度：push/pop/peek 都是 O(1)
- ✓ 空间复杂度：O(n)，n 为栈中元素个数

---

### StaticLinkedListSimple - 静态链表（简单版）

**设计思路**：用**固定大小数组** + **下标指针**模拟链表栈。

```java
static class Node {
    int value;
    int prev;       // 存储的是前一个节点的数组下标，不是引用
}

Node[] data = new Node[10];
int top = -1;       // 栈顶的数组下标
int size = 0;
```

**核心特点**：
- 用数组下标代替指针（模拟 C 语言指针概念）
- `-1` 表示链表结束（对应 NULL 指针）
- `top` 直接存储数组下标，不是 size

**操作示例**：

```
初始化：top = -1, size = 0

push(10):
  data[0] = Node(10, -1)
  top = 0, size = 1

push(20):
  data[1] = Node(20, 0)   // prev 指向下标 0
  top = 1, size = 2

pop():
  value = data[1].value = 20
  top = data[1].prev = 0  // 栈顶回到下标 0
  size = 1
```

**优缺点**：
- ✓ 节省内存（相比指针实现）
- ✓ 适合教学理解指针概念
- ✗ 数组大小固定，数据删除后空间浪费

---

### StaticLinkedListComplex - 静态链表（复杂版 - 带空闲链）

**设计思路**：用**单个数组** + **两条链**管理：数据链（用 `prev`）和空闲链（用 `freeNext`）。

```java
static class Node {
    int value;
    int prev;       // 数据链的前一个节点下标
    int freeNext;   // 空闲链的下一个节点下标
}

Node[] data = new Node[10];  // 唯一的数组
int top = -1;               // 数据栈顶下标
int free = 0;               // 空闲链头下标
int size = 0;
```

**初始化**：所有节点都在空闲链
```java
for (int i = 0; i < data.length-1; i++) {
    data[i] = new Node(-1, -1, i+1);  // freeNext 串成链
}
data[data.length-1] = new Node(-1, -1, -1);  // 最后一个指向 -1
free = 0;
```

**push 逻辑**：
```java
1. 从空闲链取节点：nodeIdx = free
2. 设置数据：data[nodeIdx].value = value
3. 链接到数据链：data[nodeIdx].prev = top
4. 更新 free：free = data[nodeIdx].freeNext
5. 脱离空闲链：data[nodeIdx].freeNext = -1
6. 更新 top：top = nodeIdx
```

**pop 逻辑**：
```java
1. 保存返回值和节点下标
2. 更新 top：top = data[top].prev
3. 把弹出的节点放回空闲链：
   data[nodeIdx].freeNext = free
   free = nodeIdx
```

**当前状态**：
- `top` 使用刚取出的节点下标，数据链的基本逻辑正确
- `pop` 和 `peek` 已处理空栈情况
- 仍需注意固定容量和扩容边界：`ensureCapacity` 扩容后必须把新数组重新赋给 `data`
- 容量为 `0` 时无法正常 `push`

---

## 问题总结

| 文件 | 问题 | 现象 | 修复方案 |
|------|------|------|--------|
| LinkedStack.java | ✓ 正确 | - | - |
| SeqList.java | ✓ 基本正确 | 正常增删、查找和扩容可用 | - |
| StaticLinkedListSimple.java | 扩容和容量边界 | 满容量或容量为 0 时 `push` 可能越界 | 正确回写扩容数组，并处理容量边界 |
| StaticLinkedListComplex.java | 空闲链容量边界 | 空栈或空闲节点用完时可能访问 `data[-1]` | 添加空栈、满容量处理，并正确扩展空闲链 |
| SinglyLinkedList.java | ✓ 基本正确 | 基础链表操作和指针算法可用 | - |
| DoublyList.java | ✓ 基本正确 | 基础双向链表操作和指针维护可用 | - |

## 链表练习

### SinglyLinkedList

包含单链表的基础操作，以及几个常见指针算法：

- `reverse`: 反转链表
- `mergeSorted`: 合并两个有序链表
- `deduplicateSorted`: 有序链表去重
- `removeAll`: 删除所有指定值的节点
- `kthFromEnd`: 查找倒数第 k 个节点
- `middleNode`: 查找中间节点
- `cycleEntry`: 查找环的入口节点

其中 `middleNode`、`kthFromEnd` 和 `cycleEntry` 使用快慢指针；`cycleEntry` 使用 Floyd 判环算法，不需要额外集合保存访问过的节点。

### DoublyList

使用 `prev` 和 `next` 两个方向的指针，练习插入、删除、读取和修改。插入或删除节点时，需要同时维护前驱节点的 `next` 和后继节点的 `prev`。

---

## 学习要点（408）

1. **栈的两种实现**：指针式 vs 数组式
2. **数组下标模拟指针**：理解 C 语言指针原理
3. **两条链并存**：同一个节点可同时属于两条逻辑链
4. **空闲链复用**：删除的节点可以再利用，避免浪费
