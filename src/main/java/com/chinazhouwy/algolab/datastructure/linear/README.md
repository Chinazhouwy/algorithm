# 线性结构

这里放顺序表、链表和栈等线性结构的最小实现。当前类包括：

- `SeqList`：连续存储，元素区间为 `[0, size)`，插入位置为 `[0, size]`
- `SinglyLinkedList`：带哨兵节点的单链表，练习反转、合并、去重和快慢指针
- `DoublyList`：同时维护 `prev` 和 `next`
- `LinkedStack`、`ArrayStack`：指针式栈和顺序栈；`ArrayStack` 还演示中缀表达式转后缀表达式
- `CircularList`：维护尾指针的循环链表，并用下标删除模拟约瑟夫问题
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
