package chapter01;

public class JoinMain {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("in main");
        Thread.currentThread().join();
        System.out.println("main will die");
    }
}
