package com.chinazhouwy.algolab.computerorganization.instruction;

/** 指令的三个字段，暂不实现编码和译码。 */
public class Instruction {
    public Opcode opcode;
    public AddressingMode addressingMode;
    public int operand;
}
