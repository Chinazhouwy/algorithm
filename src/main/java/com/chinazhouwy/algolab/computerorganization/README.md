# 计算机组成原理

当前只定义元件类、字段和组成关系，暂不实现流程逻辑。

```text
cpu/
  CPU                 中央处理器，包含 CU 和 ALU
  CU                  控制单元：PC、IR、MAR、MDR
  ALU                 算术逻辑单元，暂包含 ACC 和 8 个通用寄存器
  register/
    PC、IR、MAR、MDR、ACC  各自独立的寄存器类，仅包含 int value
memory/
  Memory              主存数组
  Mmu                 存储管理单元，持有页表
  PageTable           页表项数组
  PageTableEntry      有效位、页框号
instruction/
  Instruction         操作码、寻址方式、操作数字段
  Opcode              操作码枚举
  AddressingMode      寻址方式枚举
  InstructionDecoder  译码器空类
```

字段保持简单、公开，方便学习时查看和修改。例如 `cpu.CU.PC.value` 表示程序计数器的值，`cpu.ALU.ACC.value` 表示累加器的值。专用寄存器分别定义，方便后续独立扩展；通用寄存器暂保留 `int[8]`。页表数组初始元素为 null，尚未创建页表项。MAR / MDR 暂归 CU，ACC 和通用寄存器暂放在 ALU 类中，属于本实验的教学简化。严格来说，ALU 是运算器的核心，运算器还包含寄存器等部件。

后续再逐步补充主存读写、地址翻译、取指、译码、寻址和执行。目前没有可运行的指令 Demo，也没有这些流程的测试。

在仓库根目录运行 `mvn test`，检查项目编译与现有测试。
