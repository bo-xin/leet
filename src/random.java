import java.util.Random;

public class random {
    public static void main(String[] args) {
        Random r=new Random();
        int a=r.nextInt(14)+1;
        System.out.println(a);
    }
}
