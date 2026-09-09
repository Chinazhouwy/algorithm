package com.chinazhouwy.algolab.datastructure.linear;

/**
 * 稀疏矩阵的行逻辑存储：三元组表。
 *
 * 思路：
 * 1. 只记录非零元素，按 (row, col, value) 的形式存储；
 * 2. 对矩阵按行分组，行号相同的元素连续存放；
 * 3. 通过 rowIndex 数组记录每一行第一个非零元素在 triples 中的起始位置。
 *
 * 这种设计适合“行逻辑存储”场景：在稀疏矩阵中，按行遍历时无需扫描整个矩阵。
 */
public class Triple {
    static final class Node {
        int row;
        int col;
        int value;

        Node(int row, int col, int value) {
            this.row = row;
            this.col = col;
            this.value = value;
        }
    }

    private final int rows;
    private final int cols;
    private final Node[] triples;
    private final int[] rowIndex;
    private int size;

    public Triple(int rows, int cols, int maxNonZero) {
        if (rows <= 0 || cols <= 0 || maxNonZero < 0) {
            throw new IllegalArgumentException("rows, cols and maxNonZero must be positive");
        }
        this.rows = rows;
        this.cols = cols;
        this.triples = new Node[maxNonZero];
        this.rowIndex = new int[rows + 1];
    }

    /**
     * 添加一个非零元素。
     */
    public void add(int row, int col, int value) {
        if (row < 0 || row >= rows || col < 0 || col >= cols) {
            throw new IndexOutOfBoundsException("matrix index out of range");
        }
        if (value == 0) {
            return;
        }
        if (size >= triples.length) {
            throw new IllegalStateException("triple table is full");
        }

        triples[size] = new Node(row, col, value);
        size++;

        for (int i = row + 1; i <= rows; i++) {
            rowIndex[i]++;
        }
    }

    /**
     * 获取指定位置的值；若非零元素不存在，则返回 0。
     */
    public int get(int row, int col) {
        if (row < 0 || row >= rows || col < 0 || col >= cols) {
            throw new IndexOutOfBoundsException("matrix index out of range");
        }

        int start = rowIndex[row];
        int end = rowIndex[row + 1];
        for (int i = start; i < end; i++) {
            if (triples[i].col == col) {
                return triples[i].value;
            }
        }
        return 0;
    }

    /**
     * 按行遍历非零元素。
     */
    public void traverseByRow() {
        for (int row = 0; row < rows; row++) {
            int start = rowIndex[row];
            int end = rowIndex[row + 1];
            for (int i = start; i < end; i++) {
                Node node = triples[i];
                System.out.println("row=" + row + ", col=" + node.col + ", value=" + node.value);
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
