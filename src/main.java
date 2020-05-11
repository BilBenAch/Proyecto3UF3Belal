import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        System.out.println();
        System.out.println();
        System.out.println("******************************");
        System.out.println("Benvingut al joc de tres en ratlla, espero que t'ho passis bé :DD");
        System.out.println();
        Scanner sc = new Scanner(System.in);
        TresEnRatlla jugar = new TresEnRatlla();

        jugar.iniciarTabla();

        jugar.mostarTablero();

        boolean turno = true;
        int filas;
        int columnas;

        while (!jugar.estaLLeno() && !jugar.comprobarGanador()) {
            if (turno) {
                System.out.println("es el torn del jugador 1");
                System.out.println("Introdueix la posició que vulguis (files, columnes) ");
                jugar.Turno(turno);
                filas = sc.nextInt() - 1;
                columnas = sc.nextInt() - 1;
                while (jugar.comprobarPosicion(filas, columnas)) {
                    System.out.println("No has introduït una posició correcta o ja està plena, introdueix de nou: ");
                    filas = sc.nextInt() - 1;
                    columnas = sc.nextInt() - 1;
                }
                jugar.introducirPosicion(filas, columnas);
                turno = false;
            } else {
                System.out.println("es el torn del jugador 2");
                System.out.println("Introdueix la posició que vulguis (files, columnes) ");
                System.out.println();
                jugar.Turno(turno);
                filas = sc.nextInt() - 1;
                columnas = sc.nextInt() - 1;
                while (jugar.comprobarPosicion(filas, columnas)) {
                    System.out.println("No has introduït una posició correcta o ja està plena, introdueix de nou: ");
                    filas = sc.nextInt() - 1;
                    columnas = sc.nextInt() - 1;
                }
                jugar.introducirPosicion(filas, columnas);
                turno = true;
            }
            jugar.comprobarGanador();
            jugar.mostarTablero();
        }
        if (jugar.comprobarGanador()) {
            if (jugar.jugador) {
                System.out.println("Felicitats ha guanyat el jugador 1");
            } else {
                System.out.println("Felicitats ha guanyat el jugador 2");
            }
        } else System.out.println("Empat");

        System.out.println();
        System.out.println("******************************");
        System.out.println();
        System.out.println();
    }
}
