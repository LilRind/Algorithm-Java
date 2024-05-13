package Mianshilianxi0412;

import java.util.Scanner;
import java.util.concurrent.Semaphore;

class Pn {
    private int n;

    private Semaphore z0 = new Semaphore(1);

    private Semaphore odd1 = new Semaphore(0);

    private Semaphore even1 = new Semaphore(0);

    public Pn(int num){
        this.n = num;
    }

    public void zero(){
        try {
            for(int i = 1; i <= n; i++) {
                z0.acquire();
                System.out.print("0");
                if(i%2 == 0){
                    even1.release();
                }else {
                    odd1.release();
                }
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public void even(){
        try {
            for(int i = 2; i <= n; i+=2) {
                even1.acquire();
                System.out.print(i);
                z0.release();
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public void odd(){
        try {
            for(int i = 1; i <= n; i+=2) {
                odd1.acquire();
                System.out.print(i);
                z0.release();
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

}

public class Yimian01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Pn pn = new Pn(n);

        Thread t0 = new Thread(pn::zero);
        Thread t1 = new Thread(pn::even);
        Thread t2 = new Thread(pn::odd);

        t0.start();
        t1.start();
        t2.start();
    }
}
