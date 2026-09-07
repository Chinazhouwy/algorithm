package com.chinazhouwy.algolab.computerorganization.memory;

/** 单级页表：256 个页表项，尚未设置的数组位置为 null。 */
public class PageTable {
    public PageTableEntry[] entries = new PageTableEntry[256];
}
