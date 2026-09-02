# Data Structures

408 数据结构实现记录

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

### StaticLinkedList - 静态链表（简单版）

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

**已知问题**：
- ⚠️ `push` 方法有 bug：`top = free` 应该是 `top = nodeIdx`
  - 当前代码让 top 指向**下一个空闲节点**，而不是**刚取出的节点**
  - 导致数据链构建错误

---

## 问题总结

| 文件 | 问题 | 现象 | 修复方案 |
|------|------|------|--------|
| LinkedStack.java | ✓ 正确 | - | - |
| StaticLinkedList.java | ✓ 基本正确 | 需补完 isEmpty/peek/pop 方法 | 添加边界检查 |
| StaticLinkedListComplex.java | `push()` 中 `top = free` | 数据链无法正确串联，pop 时会取到空闲链节点 | 改为 `int nodeIdx = free; ... top = nodeIdx;` |

---

## 学习要点（408）

1. **栈的两种实现**：指针式 vs 数组式
2. **数组下标模拟指针**：理解 C 语言指针原理
3. **两条链并存**：同一个节点可同时属于两条逻辑链
4. **空闲链复用**：删除的节点可以再利用，避免浪费
