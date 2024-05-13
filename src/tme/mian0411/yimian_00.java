//package tme.mian0411;
//
//import java.util.concurrent.Semaphore;
//
//class PrintNumbers {
//    private int n;
//    private Semaphore zeroSemaphore = new Semaphore(1); // 控制0的输出
//    private Semaphore evenSemaphore = new Semaphore(0); // 控制偶数的输出
//    private Semaphore oddSemaphore = new Semaphore(0); // 控制奇数的输出
//
//    public PrintNumbers(int n) {
//        this.n = n;
//    }
//
//    public void zero() {
//        try {
//            for (int i = 1; i <= n; i++) {
//                zeroSemaphore.acquire(); // 获取0的信号量
//                System.out.print("0");
//                if (i % 2 == 0) {
//                    evenSemaphore.release(); // 释放偶数信号量
//                } else {
//                    oddSemaphore.release(); // 释放奇数信号量
//                }
//            }
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void even() {
//        try {
//            for (int i = 2; i <= n; i += 2) {
//                evenSemaphore.acquire(); // 获取偶数信号量
//                System.out.print(i);
//                zeroSemaphore.release(); // 释放0的信号量
//            }
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void odd() {
//        try {
//            for (int i = 1; i <= n; i += 2) {
//                oddSemaphore.acquire(); // 获取奇数信号量
//                System.out.print(i);
//                zeroSemaphore.release(); // 释放0的信号量
//            }
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//}
//
//public class yimian_00 {
//    public static void main(String[] args) {
//        int n = 9;
//        PrintNumbers pn = new PrintNumbers(n);
//
//        Thread threadA = new Thread(pn::zero);
//        Thread threadB = new Thread(pn::even);
//        Thread threadC = new Thread(pn::odd);
//
//        threadA.start();
//        threadB.start();
//        threadC.start();
//    }
//}