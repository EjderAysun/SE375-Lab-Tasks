package LAB_2.LAB2_JAVA;
// For test: 
class MyRunnable implements Runnable {
    public void run() {
        System.out.println("-------------------");
        System.out.println("Thread started:::"+Thread.currentThread().getName());
        System.out.println("-------------------");
    }
}