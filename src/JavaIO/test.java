package JavaIO;

import org.junit.Test;

import java.util.Random;

/**
 * @program: leet
 * @description:
 * @author: Tb
 * @create: 2021-12-01 09:47
 **/
public class test {
    @Test
    public void testRandom(){
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            System.out.println(r.nextInt(2));
        }
    }
}
