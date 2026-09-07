package com.chinazhouwy.algolab.computerorganization.cpu;

/** CPU 由控制器和运算器组成；状态保存在所属部件中，方便展开 Debug。 */
public class CPU {
    // 控制器
    public CU CU;

    // 运算器
    public ALU ALU;

    public CPU() {
        CU = new CU();
        ALU = new ALU();
    }
}
