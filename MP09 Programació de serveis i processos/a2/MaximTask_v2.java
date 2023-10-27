package a2;

import java.util.concurrent.RecursiveTask;

public class MaximTask_v2 extends RecursiveTask<Short> {
    private static final int LLINDAR=500000;
    private short[] arr ;
    private int inici, fi;

    public MaximTask_v2(short[] arr, int inici, int fi) {
        this.arr = arr;
        this.inici = inici;
        this.fi = fi;
    }

    private short getMaxSeq(){
        short max = arr[inici];
        for (int i = inici+1; i < fi; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    private short getMaxReq(){
        MaximTask_v2 task1;
        MaximTask_v2 task2;
        MaximTask_v2 task3;

        int mig1 = ((inici+fi)/3)+1;
        int mig2 = ((inici+fi)*(2/3))+1;

        task1 = new MaximTask_v2(arr, inici, mig1);
        task2 = new MaximTask_v2(arr, mig1, mig2);
        task3 = new MaximTask_v2(arr, mig2, fi);

        invokeAll(task1,task2,task3);

        return (short) Math.max(task1.join(), Math.max(task2.join(),task3.join()));
    }

    @Override
    protected Short compute() {
        if(fi - inici <= LLINDAR){
            return getMaxSeq();
        }else{
            return getMaxReq();
        }
    }
}
