# 线性结构

这里放顺序表、链表和栈等线性结构的最小实现。当前类包括：

- `SeqList`：连续存储，元素区间为 `[0, size)`，插入位置为 `[0, size]`
- `SinglyLinkedList`：带哨兵节点的单链表，练习反转、合并、去重和快慢指针
- `DoublyList`：同时维护 `prev` 和 `next`
- `LinkedStack`、`ArrayStack`：指针式栈和顺序栈；`ArrayStack` 还演示中缀表达式转后缀表达式
- `CircularList`：维护尾指针的循环链表，并用下标删除模拟约瑟夫问题
- `LinkedQueue`：带头结点的链队列，演示尾指针在空队列重置时必须回到头结点
- `Triple`：三元组表的稀疏矩阵行逻辑存储，用 `rowIndex` 记录每一行的非零元素区间
- `OrthogonalList`：十字链表稀疏矩阵，行链和列链同时维护
- `StaticLinkedListSimple`、`StaticLinkedListComplex`：用数组下标模拟指针和空闲链

## 今日练习

### ArrayStack

`ArrayStack` 使用字符数组保存栈元素，`top` 表示下一个可写入的位置，同时也是当前元素数量；因此栈顶元素位于 `data[top - 1]`，栈满条件是 `top == data.length`。

`toPostfixt` 按以下规则把单字符操作数和 `+ - * / ( )` 组成的中缀表达式转换为后缀表达式：

- 操作数直接输出
- 左括号入栈
- 右括号持续弹栈，直到遇到左括号
- 新运算符到来时，持续弹出优先级更高或相同的栈顶运算符
- 扫描结束后弹出栈中剩余运算符

例如 `a+b*c` 的后缀表达式是 `abc*+`。这里使用 `while` 而不是 `if`，是因为一个新运算符到来时可能需要连续弹出多个旧运算符。

常见坑：栈顶是 `top - 1`，不是 `top`；扫描结束不能忘记清空运算符栈；调用 `peek` 前要确认栈非空。

### LinkedQueue

`LinkedQueue` 使用带头结点的单链表实现队列：`head.next` 指向队头，`tail` 指向队尾，空队列时两者都落在头结点上，即 `head.next == null` 且 `tail == head`。

入队操作：

```java
void enqueue(int value) {
    tail.next = new Node(value);
    tail = tail.next;
    size++;
}
```

出队操作：

```java
int dequeue() {
    if (isEmpty()) throw new RuntimeException();
    Node ret = head.next;
    head.next = ret.next;
    if (ret == tail) {
        tail = head;
    }
    size--;
    return ret.value;
}
```

这里的关键不变量是：只有在删除的是尾结点时，才需要把 `tail` 归位到 `head`；否则尾指针保持不变。这样可以保证下次入队写 `tail.next = new Node(value)` 时，`tail` 仍然是有效的队尾结点。

例如，队列状态为：

```text
head -> 10 -> 20 -> 30 -> null
                      ^
                      tail
```

如果删除 `30`，则应把 `tail` 改成 `head`，得到：

```text
head -> null
      ^
      tail
```

这样后续再执行 `enqueue(40)` 时就会从 `head.next` 接上新结点，而不是空指针崩掉。

常见坑：出队后没有维护 `tail`；空队列时把 `tail` 设为 `null`；用 `size` 判断空队列时没有同步更新；`peek()` 和 `dequeue()` 之前都要先确认非空。

复杂度：入队、出队、查看队头和判空均为 `O(1)`，空间复杂度为 `O(n)`。

### Triple：稀疏矩阵的三元组表

`Triple` 采用三元组 `(row, col, value)` 记录稀疏矩阵中的非零元素，并配合 `rowIndex` 数组记录每一行的非零元素区间。典型表示方式是：

```text
triples = [ (0, 1, 5), (1, 0, 3), (2, 2, 9) ]
rowIndex = [0, 1, 2, 3]
```

其中 `rowIndex[row]` 表示第 `row` 行的非零元素从 `triples` 的哪个位置开始，`rowIndex[row + 1]` 表示它的结束位置。这样按行访问时，只需扫描当前行对应区间，而不是扫描整张矩阵。

它的主要优点是：

- 非零元素存储紧凑
- 适合“按行逻辑存储”的稀疏矩阵
- 访问某一行的非零元素复杂度通常为 `O(k)`，其中 `k` 是该行非零元素个数

常见坑：

- 只保留非零元素时，读取 `(row, col)` 若无记录要返回 `0`
- `rowIndex` 必须保持单调增长
- 在添加新元素时要保证行区间更新顺序正确

### OrthogonalList：稀疏矩阵的十字链表

`OrthogonalList` 把每个非零元素都放在一个结点中，结点同时保留 `right` 和 `down` 两个指针，分别连接同一行和同一列中的后继结点。其结构类似于交叉链表：

```text
rowHeads[i] -> 结点 ... -> 结点
colHeads[j] -> 结点 ... -> 结点
```

这样做的好处是：

- 既能按行遍历，又能按列遍历
- 对插入、删除和转置等操作更方便
- 适合稀疏矩阵的“交叉逻辑存储”场景

常见坑：

- 维护 `right` 时要保证同一行按列递增插入
- 维护 `down` 时要保证同一列按行递增插入
- 删除元素时要同步断开行链和列链

### CircularList

`CircularList` 只保存 `tail` 和 `size`：头节点始终是 `tail.next`。插入和删除后都必须保持这个环不变量；删除唯一节点时要把 `tail` 设为 `null`。

`josephusOrder(n, step)` 默认创建 `1` 到 `n` 的环，从 `1` 开始计数，每数到 `step` 个元素删除一个。当前待删除下标为：

```text
(previousIndex + step - 1) % currentSize
```

例如 `josephusOrder(5, 3)` 的淘汰顺序是 `[3, 1, 5, 2, 4]`。`remove(index)` 使用 0-based 下标，`remove(0)` 等价于删除头节点。

常见坑：`addLast` 的首次插入必须让节点指向自己；删除后要递减 `size`；下标必须满足 `0 <= index < size`；约瑟夫计算要在删除前使用当前 `size`。

复杂度：循环链表按下标删除为 `O(n)`，完整约瑟夫模拟为 `O(n^2)`；数组栈的入栈、出栈和查看栈顶均为 `O(1)`。

后续正式实验按以下约定补齐：

```text
<experiment>/
├── README.md
├── Demo.java
└── cases.txt
```

README 至少说明 408 知识点、状态变量、Java 模型、教材例子、手算结果、Debug 观察点、常见坑和复杂度。
