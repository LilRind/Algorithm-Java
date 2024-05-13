//package Lian0412;
//
//import java.util.Scanner;
//import java.util.concurrent.Semaphore;
//
//class Pn {
//    private int n;
//
//    private Semaphore a0 = new Semaphore(1);
//
//    private Semaphore a1 = new Semaphore(0);
//
//    private Semaphore a2 = new Semaphore(0);
//
//    public Pn(int num){
//        this.n = num;
//    }
//
//    public void zero(){
//        try{
//            for (int i = 1; i<=n; i++){
//                a0.acquire();
//                System.out.print("0");
//                if(i%2==1){
//                    a2.release();
//                }else{
//                    a1.release();
//                }
//            }
//        }catch (InterruptedException e){
//            e.printStackTrace();
//        }
//    }
//
//    public void odd(){
//        try{
//            for (int i = 1; i<=n; i+=2){
//                a1.acquire();
//                System.out.print(i);
//                a0.release();
//            }
//        }catch (InterruptedException e){
//            e.printStackTrace();
//        }
//    }
//
//    public void even(){
//        try{
//            for (int i = 2; i<=n; i+=2){
//                a2.acquire();
//                System.out.print(i);
//                a0.release();
//            }
//        }catch (InterruptedException e){
//            e.printStackTrace();
//        }
//    }
//
//
//}
//
//public class Yimian {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        int n = sc.nextInt();
//        sc.close();
//
//        Pn pn = new Pn(n);
//
//        Thread t0 = new Thread(pn::zero);
//        Thread t1 = new Thread(pn::even);
//        Thread t2 = new Thread(pn::odd);
//
//
//        t0.start();
//        t1.start();
//        t2.start();
//
//    }
//}
