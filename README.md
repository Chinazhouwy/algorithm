# 408 Algorithm Lab

面向 408 和面试复习的 Java 最小可运行实验室。这里实现的是“机制模型”，重点是把题目还原成状态、指针、数组、队列、表项和可观察的中间变量，而不是复刻完整产品或操作系统。

## 目录结构

项目按 408 四科组织；Java 包名使用全小写且不含连字符，因此 README 中的 `data-structure`、`operating-system` 等概念目录分别对应 `datastructure`、`operatingsystem` 等 Java 包。

```text
408-algorithm-lab/
├── src/main/java/com/chinazhouwy/algolab/
│   ├── datastructure/                 # data-structure
│   │   ├── linear/                    # 顺序表、链表、栈
│   │   ├── tree/                      # 树
│   │   ├── graph/                     # 图
│   │   ├── search/                    # 查找、散列
│   │   └── sort/                      # 排序
│   ├── operatingsystem/               # operating-system
│   │   ├── process/
│   │   ├── sync/
│   │   ├── memory/
│   │   └── disk/
│   ├── computerorganization/          # computer-organization
│   │   ├── number/
│   │   ├── cpu/
│   │   ├── cache/
│   │   └── pipeline/
│   ├── computernetwork/               # computer-network
│   │   ├── link/
│   │   ├── network/
│   │   ├── transport/
│   │   └── application/
│   ├── leetcode/                      # 补充题解，不与 408 实验混放
│   └── utils/                         # 通用工具
├── src/test/java/                     # 行为测试
├── pom.xml
└── README.md
```

空的学科目录会保留 README 作为入口和后续实验清单；没有 README、Demo 或测试的条目不代表已经实现。

## 当前实现

### 数据结构

代码位于 [`datastructure/linear`](src/main/java/com/chinazhouwy/algolab/datastructure/linear) 和 [`datastructure/sort`](src/main/java/com/chinazhouwy/algolab/datastructure/sort)：

- 线性结构：`SeqList`、`SinglyLinkedList`、`DoublyList`、`LinkedStack`、`ArrayStack`
- 静态链表：`StaticLinkedListSimple`、`StaticLinkedListComplex`
- 排序：`InsertionSort`、`SelectionSort`；`OptimizedInsertionSort` 仍是草稿
- 线性结构的边界说明见 [`datastructure/README.md`](src/main/java/com/chinazhouwy/algolab/datastructure/README.md)

### LeetCode 补充区

`leetcode` 保留动态规划、链表、堆和每日题等练习。它们用于算法训练，不强行归入四科实验目录；需要 408 状态模拟的新内容应放到对应学科包中。

## 实验约定

每个正式实验逐步收敛到以下结构：

```text
<experiment>/
├── README.md     # 知识点、模型、例子、观察点和复杂度
├── Demo.java     # 可直接运行的最小演示
└── cases.txt     # 教材例子和边界输入
```

实验 README 固定记录：

1. 408 知识点
2. 状态变量
3. Java 模型
4. 一组教材例子
5. 手算结果
6. Debug 观察点
7. 常见坑
8. 复杂度或公式

## 学习顺序

按 ROI 逐科推进：

```text
数据结构 → 操作系统 → 计算机组成原理 → 计算机网络
```

每科先完成 S 级实验，再扩展 A 级内容。当前仓库先完成数据结构基础和目录骨架，后续优先补充循环队列、KMP、树、堆、并查集、BFS/DFS、最短路、页面置换、Cache 和 TCP 窗口等状态模拟。

## 运行

项目使用 Maven 和 Java 8：

```bash
mvn clean test
```

测试应验证行为和边界，不以打印日志代替断言。
