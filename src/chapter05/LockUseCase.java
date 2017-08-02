package chapter05;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 10-1
 */
public class LockUseCase {

    public static void main(String[] args) {
        new LockUseCase().lock();
    }
    public void lock() {
        Lock lock = new ReentrantLock();
        lock.lock();
        try {
            System.out.println("in lock");
        } finally {
            lock.unlock();
        }
    }
}
