package com.chinazhouwy.algolab.computerorganization.cpu;

import com.chinazhouwy.algolab.computerorganization.cpu.register.ACC;

/** ALU = Arithmetic Logic Unit，算术逻辑单元；本教学骨架暂将相关寄存器一并放在这里。 */
public class ALU {
    public ACC ACC;
    public int[] registers = new int[8];

    public ALU() {
        ACC = new ACC();
    }
}
