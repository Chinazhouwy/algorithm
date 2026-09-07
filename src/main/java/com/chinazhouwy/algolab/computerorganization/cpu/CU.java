package com.chinazhouwy.algolab.computerorganization.cpu;

import com.chinazhouwy.algolab.computerorganization.cpu.register.PC;
import com.chinazhouwy.algolab.computerorganization.cpu.register.IR;
import com.chinazhouwy.algolab.computerorganization.cpu.register.MAR;
import com.chinazhouwy.algolab.computerorganization.cpu.register.MDR;

/** CU = Control Unit，控制单元。 */
public class CU {
    public PC PC;
    public IR IR;
    // 本教学模型暂将访存接口寄存器放在控制器中。
    public MAR MAR;
    public MDR MDR;

    public CU() {
        PC = new PC();
        IR = new IR();
        MAR = new MAR();
        MDR = new MDR();
    }
}
