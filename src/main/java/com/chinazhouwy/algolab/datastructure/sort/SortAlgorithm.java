package com.chinazhouwy.algolab.datastructure.sort;

public abstract class SortAlgorithm {

    private int[] data;

    public SortAlgorithm setData(int[] data) {
        this.data = data;
        return this;
    }

    public void run(){
        long start = System.nanoTime();
        System.out.println(String.format("算法[%s]执行开始",this.getClass().getSimpleName()));
        execute(this.data);
        System.out.println(
                String.format("算法[%s]执行结束，耗时:%sms",
                        this.getClass().getSimpleName(),(System.nanoTime()-start)/(1000.0*1000.0)));
    }


    public abstract void execute(int[] data);

}
