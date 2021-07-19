package top.musuixin.lanqiao.basic;

public class BASIC7 {
    public static void main(String[] args) {
        for (int i = 1; i <=9; i++) {
            for (int j = 0; j <=9; j++) {
                for (int k = 0; k <=9; k++) {
                    if(i*i*i+j*j*j+k*k*k==new Integer(""+i+j+k)){
                        System.out.println(""+i+j+k);
                    }
                }
            }
        }
    }
}
