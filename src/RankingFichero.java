import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class RankingFichero {

    private static String FILENAME = "ranking.txt";

    public void mostraRanking() {
        try {
            Map<String, Integer> map = new HashMap<>();

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
            map.entrySet().stream()
                    .sorted(Collections.reverseOrder((Map.Entry.comparingByValue())))
                    .collect(Collectors.toList()).forEach(System.out::println);
            reader.close();
        }catch(IOException e){
            System.out.println("Ha habido un error en la lectura");
        }

    }

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

}
