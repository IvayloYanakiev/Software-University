import java.util.*;
 
public class third {
 
    public static void main(String[] args) {
 
        Scanner s = new Scanner(System.in);
        String currentLine = s.nextLine();
 
        Map<Long, Long> map = new HashMap<Long, Long>();
        int lines = 0;
        Long critical = new Long("0");
        List<String> sss = new ArrayList<String>();
 
        while (!currentLine.equals("Break it.")) {
 
            String[] rawData = currentLine.split(" ");
            Long firstNumber = Long.parseLong(rawData[0]);
            Long secondNumber = Long.parseLong(rawData[1]);
            Long thirdNumber = Long.parseLong(rawData[2]);
            Long fourthNumber = Long.parseLong(rawData[3]);
 
            critical = Math.abs(firstNumber + secondNumber - thirdNumber - fourthNumber);
 
            if (!map.containsKey(critical))
                map.put(critical, (long) 1);
            else
                map.put(critical, map.get(critical) + 1);
 
            lines++;
            sss.add("Line: [" + firstNumber + ", " + secondNumber + ", " + thirdNumber + ", " + fourthNumber + "]");
            currentLine = s.nextLine();
        }
 
        Iterator it = map.entrySet().iterator();
        Long target = new Long("0");
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
 
            if (Long.parseLong(pair.getKey().toString()) != 0) {
                target = Long.parseLong(pair.getKey().toString());
                break;
            }
        }
 
        Iterator it2 = map.entrySet().iterator();
        while (it2.hasNext()) {
            Map.Entry pair = (Map.Entry) it2.next();
 
            if (Long.parseLong(pair.getKey().toString()) != target
                    && Long.parseLong(pair.getKey().toString()) != 0) {
 
                System.out.println("Critical breakpoint does not exist.");
                return;
            }
        }
 
        for (String ss : sss)
            System.out.println(ss);
 
        System.out.println("Critical Breakpoint: " + (long) (Math.pow((double) critical, (double) lines) % lines));
    }
}