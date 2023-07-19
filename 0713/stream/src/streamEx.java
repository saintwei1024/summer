// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class streamEx {
    public static void main(String[] args) {
        List<Integer> data = new ArrayList<Integer>();
        Random random=new Random();
        for(int i=0;i<20;i++){
            data.add(random.nextInt(100));
        System.out.println(data);
        long count=data.stream().count();
        System.out.println(count);
        int min=data.stream().min(Integer::compareTo).orElseThrow();
        System.out.println(min);
        List<Integer> newlist=data.stream().filter((x)->{return x%2==0;})
                .map((x)->2*x+1)
                .collect(Collectors.toList());
        System.out.println(newlist);
        }
    }
}