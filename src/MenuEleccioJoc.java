import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuEleccioJoc {


    public void mostra() {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        int opcioMenu = 0;
        int opcionSubmenu = 0;
        while (opcion != 3) {
            System.out.println("Benvingut al menú del tren en ratlla, que vols fer? ");
            System.out.println("1. Jugar");
            System.out.println("2. Veure el Ranking");
            System.out.println("3. Sortir");
            try {
                System.out.println("Introdueix lo que vols fer ");
                opcion = sc.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.println();
                        System.out.println();
                        System.out.println("Jugant al Joc ");
                        TresEnRatlla jugar = new TresEnRatlla();
                        jugar.juga();
                        System.out.println();
                        System.out.println();
                        break;
                    case 2:
                        System.out.println();
                        System.out.println();
                        System.out.println("Has entrat a veure el Ranking");
                        RankingFichero ranking = new RankingFichero();
                        ranking.mostraRanking();
                        System.out.println();
                        System.out.println();
                        break;
                    case 3:
                        System.out.println("Adeu, que tinguis un bon dia");
                        break;
                    default:
                        System.out.println("només numeros entre 1 i 3 ");
                }
            } catch (InputMismatchException e) {
                System.out.println("Has d'introduir un número(no lletres ni altre digit) : ");
                sc.next();
            }
        }
    }
}

