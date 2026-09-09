package com.chinazhouwy.algolab.datastructure.linear;

/**
 * 稀疏矩阵的十字链表存储。
 *
 * 思路：
 * 1. 每个非零元素都用一个结点表示；
 * 2. 结点同时保存向右和向下的指针；
 * 3. 用行头指针数组和列头指针数组维护矩阵的行/列链表。
 *
 * 适用于：
 * - 稀疏矩阵的插入、删除、转置等运算；
 * - 需要按行/按列高效遍历的场景。
 */
public class OrthogonalList {
    static final class Node {
        int row;
        int col;
        int value;
        Node right;
        Node down;

        Node(int row, int col, int value) {
            this.row = row;
            this.col = col;
            this.value = value;
        }
    }

    private final int rows;
    private final int cols;
    private final Node[] rowHeads;
    private final Node[] colHeads;
    private int size;

    public OrthogonalList(int rows, int cols) {
        if (rows <= 0 || cols <= 0) {
            throw new IllegalArgumentException("rows and cols must be > 0");
        }
        this.rows = rows;
        this.cols = cols;
        this.rowHeads = new Node[rows];
        this.colHeads = new Node[cols];
    }

    /**
     * 只添加非零元素。
     */
    public void add(int row, int col, int value) {
        if (row < 0 || row >= rows || col < 0 || col >= cols) {
            throw new IndexOutOfBoundsException("matrix index out of range");
        }
        if (value == 0) {
            return;
        }

        Node node = new Node(row, col, value);
        size++;

        // 插入到该行的右链表
        Node prevRow = null;
        Node curRow = rowHeads[row];
        while (curRow != null && curRow.col < col) {
            prevRow = curRow;
            curRow = curRow.right;
        }
        node.right = curRow;
        if (prevRow == null) {
            rowHeads[row] = node;
        } else {
            prevRow.right = node;
        }

        // 插入到该列的下链表
        Node prevCol = null;
        Node curCol = colHeads[col];
        while (curCol != null && curCol.row < row) {
            prevCol = curCol;
            curCol = curCol.down;
        }
        node.down = curCol;
        if (prevCol == null) {
            colHeads[col] = node;
        } else {
            prevCol.down = node;
        }
    }

    /**
     * 获取指定位置的值。
     */
    public int get(int row, int col) {
        if (row < 0 || row >= rows || col < 0 || col >= cols) {
            throw new IndexOutOfBoundsException("matrix index out of range");
        }

        Node cur = rowHeads[row];
        while (cur != null && cur.col < col) {
            cur = cur.right;
        }
        if (cur != null && cur.col == col) {
            return cur.value;
        }
        return 0;
    }

    /**
     * 按行迭代非零元素。
     */
    public void traverseByRow() {
        for (int row = 0; row < rows; row++) {
            Node cur = rowHeads[row];
            while (cur != null) {
                System.out.println("row=" + cur.row + ", col=" + cur.col + ", value=" + cur.value);
                cur = cur.right;
            }
        }
    }

    /**
     * 按列迭代非零元素。
     */
    public void traverseByCol() {
        for (int col = 0; col < cols; col++) {
            Node cur = colHeads[col];
            while (cur != null) {
                System.out.println("row=" + cur.row + ", col=" + cur.col + ", value=" + cur.value);
                cur = cur.down;
            }
        }
    }

    public int rows() {
        return rows;
    }

    public int cols() {
        return cols;
    }

    public int size() {
        return size;
    }
}
