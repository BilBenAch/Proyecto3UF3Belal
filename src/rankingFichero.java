import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class rankingFichero implements ranking {

    private static String FILENAME = "ranking.txt";

    @Override
    public void mostraRanking() {
        try {
            //Map<String, Integer> map = new HashMap<>();
            HashMap<String, Integer> map = new HashMap<String, Integer>();

            String line;
            BufferedReader reader = new BufferedReader(new FileReader(FILENAME));
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("=");
                if (parts.length >= 2) {
                    String username = parts[0];
                    Integer wins = Integer.valueOf(parts[1]);
                    if(map.containsKey(username)) {
                        Integer victorias = map.get(username);
                        map.put(username, victorias+1);
                    } else {
                        map.put(username, wins);
                    }
                } else {
                    System.out.println("ignoring line: " + line);
                }
            }
            System.out.println("-RANKING-");
            System.out.println();
            System.out.println();
            System.out.println("Usuario"+"\t"+"Victorias");
            Map<String, Integer> hm1 = sortByValue(map);
            for (Map.Entry<String, Integer> en : hm1.entrySet()) {
                System.out.println(en.getKey() +"\t"+ en.getValue());
            }
            /*map.entrySet().stream()
                    .sorted(Collections.reverseOrder((Map.Entry.comparingByValue())))
                    .collect(Collectors.toList()).forEach(System.out::println);*/
            reader.close();
        }catch(IOException e){
            System.out.println("Ha habido un error en la lectura");
        }

    }
    @Override
    public void actualitzaRanking(String username)  {
        FileWriter escritura = null;
        try {
            escritura = new FileWriter(FILENAME, true);
            escritura.write(username + "=1\n");
            escritura.close();
        } catch (IOException e) {
            System.out.println("Ha habido un error en la escritura");

        }
    }


    public static HashMap<String, Integer> sortByValue(HashMap<String, Integer> map)
    {

        List<Map.Entry<String, Integer> > list =
                new LinkedList<Map.Entry<String, Integer> >(map.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2)
            {
                return (o2.getValue()).compareTo(o1.getValue());

            }
        });

        HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());

        }
        return temp;
    }


}
