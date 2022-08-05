package easy_compute;

import java.util.*;

/**
 * @Description:
 * @author: LGD
 * @date:2022/8/5 10:23
 */
public class WorkId {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        List<Integer> workId = new ArrayList<>();
        Set<Integer> id = new HashSet<>();
        List<Integer> chongtu = new ArrayList<>();
        int count = 0;
        while(scanner.hasNextLine() && i <= count && count != 0) {
            String next = scanner.nextLine();
            String[] s = next.split(" ");
            //id已存在就加到冲突列表中
            if (id.contains(Integer.valueOf(s[1]))) {
                chongtu.add(Integer.valueOf(s[0]));
            } else{
                workId.add(Integer.valueOf(s[0]));
                id.add(Integer.valueOf(s[1]));
            }
            count++;
        }
        workId.addAll(chongtu);
        System.out.println(workId);
    }

}
