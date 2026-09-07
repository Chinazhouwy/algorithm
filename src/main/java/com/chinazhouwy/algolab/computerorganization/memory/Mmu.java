package com.chinazhouwy.algolab.computerorganization.memory;

/** 存储管理单元：后续通过页表完成地址翻译。 */
public class Mmu {
    public PageTable pageTable;

    public Mmu(PageTable pageTable) {
        this.pageTable = pageTable;
    }
}
