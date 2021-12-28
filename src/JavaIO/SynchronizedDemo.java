package JavaIO;

/**
 * @program: leet
 * @description: 底层原理
 * @author: Tb
 * @create: 2021-12-08 21:47
 **/
public class SynchronizedDemo {
    public void method(){
        synchronized (this){
            System.out.println("Synchronized");
        }
    }
}
