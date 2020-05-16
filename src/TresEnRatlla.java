import java.util.Scanner;

 class TresEnRatlla {

    char tabla[][];
    boolean jugador;
    String nombreJugador1;
    String nombreJugador2;
    RankingFichero ranking = new RankingFichero();

    TresEnRatlla() {
        tabla = new char[3][3];
    }

    void iniciarTabla() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tabla[i][j] = '-';
            }
        }
    }

    boolean estaLLeno() {
        boolean lleno = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tabla[i][j] == '-') {
                    lleno = false;
                }
            }
        }
        return lleno;
    }

    public void mostarTablero() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(tabla[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    public boolean Turno(boolean jugador) {
        this.jugador = jugador;
        return jugador;
    }

    public void introducirPosicion(int filas, int columnas) {
        if ((filas < 3 && filas >= 0) && (columnas >= 0 && columnas < 3)) {
            if (Turno(jugador)) {
                if (tabla[filas][columnas] == '-') {
                    tabla[filas][columnas] = 'X';
                }
            } else {
                if (tabla[filas][columnas] == '-') {
                    tabla[filas][columnas] = 'O';
                }
            }
        }
    }

    public boolean comprobarPosicion(int filas, int columnas) {
        if (((filas < 3 && filas >= 0) && (columnas >= 0 && columnas < 3)) && (tabla[filas][columnas] == '-')) {
            return false;
        }
        return true;
    }

    public boolean comprobarGanadorColumnas() {
        for (int j = 0; j < 3; j++) {
            if ((tabla[0][j] == 'X') && (tabla[1][j] == 'X') && (tabla[2][j] == 'X')) {
                return true;
            } else if (tabla[0][j] == 'O' && tabla[1][j] == 'O' && tabla[2][j] == 'O') {
                return true;
            }
        }
        return false;
    }

    public boolean comprobarGanadorFilas() {
        for (int i = 0; i < 3; i++) {
            if ((tabla[i][0] == 'X') && (tabla[i][1] == 'X') && (tabla[i][2] == 'X')) {
                return true;
            } else if ((tabla[i][0] == 'O') && (tabla[i][1] == 'O') && (tabla[i][2] == 'O')) {
                return true;
            }
        }
        return false;
    }


    public boolean comprobarganadorDiagonal() {
        if (((tabla[0][0] == 'X') && (tabla[1][1] == 'X') && (tabla[2][2] == 'X'))
                || (tabla[0][2] == 'X') && (tabla[1][1] == 'X') && (tabla[2][0] == 'X')) {
            return true;
        } else if (((tabla[0][0] == 'O') && (tabla[1][1] == 'O') && (tabla[2][2] == 'O'))
                || (tabla[0][2] == 'O') && (tabla[1][1] == 'O') && (tabla[2][0] == 'O')) {
            return true;
        }
        return false;
    }

    public boolean comprobarGanador() {
        return comprobarGanadorColumnas() || comprobarGanadorFilas() || comprobarganadorDiagonal();
    }

     public String getNombreJugador1() {
         return nombreJugador1;
     }

     public String getNombreJugador2() {
         return nombreJugador2;
     }

     public void setNombreJugador1(String nombreJugador1) {
         this.nombreJugador1 = nombreJugador1;
     }

     public void setNombreJugador2(String nombreJugador2) {
         this.nombreJugador2 = nombreJugador2;
     }

     public void mostraGanador(){
         if (comprobarGanador()) {
             if (jugador) {
                 ranking.actualitzaRanking(getNombreJugador1());
                 System.out.println("Felicitats ha guanyat "+getNombreJugador1());
             } else {
                 ranking.actualitzaRanking(getNombreJugador2());
                 System.out.println("Felicitats ha guanyat "+getNombreJugador2());
             }
         } else System.out.println("Empat");
     }



     void juga() {
        System.out.println();
        System.out.println();
        System.out.println("******************************");
        System.out.println("Benvingut al joc de tres en ratlla, espero que t'ho passis bé :DD");
        System.out.println();
        Scanner sc = new Scanner(System.in);

        boolean comprobarNombre = true;

        System.out.println("Introdueix el nom del jugador1 ");
        String jugador1 = sc.nextLine();
        setNombreJugador1(jugador1);

        System.out.println("Introdueix el nom del jugador2 ");
        String jugador2 = sc.nextLine();
        setNombreJugador2(jugador2);
        while(comprobarNombre){
            if(jugador1.equals(jugador2) || jugador1.trim().isEmpty() || jugador2.trim().isEmpty()){
                System.out.println("No poden tenir el mateix nom a la mateixa partida els dos jugadors ");
                System.out.println("Introdueix el nom del jugador1 ");
                jugador1 = sc.nextLine();
                setNombreJugador1(jugador1);

                System.out.println("Introdueix el nom del jugador2 ");
                jugador2 = sc.nextLine();
                setNombreJugador2(jugador2);
            }
            else{
                comprobarNombre = false;
            }
        }

        iniciarTabla();

        mostarTablero();

        boolean turno = true;
        int filas;
        int columnas;


        while (!estaLLeno() && !comprobarGanador()) {
            if (turno) {
                System.out.println("es el torn de "+ jugador1);
                System.out.println("Introdueix la posició que vulguis (files, columnes) ");
                Turno(turno);
                filas = sc.nextInt() - 1;
                columnas = sc.nextInt() - 1;
                while (comprobarPosicion(filas, columnas)) {
                    System.out.println("No has introduït una posició correcta o ja està plena, introdueix de nou: ");
                    filas = sc.nextInt() - 1;
                    columnas = sc.nextInt() - 1;
                }
                introducirPosicion(filas, columnas);
                turno = false;
            } else {
                System.out.println("es el torn de "+ jugador2);
                System.out.println("Introdueix la posició que vulguis (files, columnes) ");
                System.out.println();
                Turno(turno);
                filas = sc.nextInt() - 1;
                columnas = sc.nextInt() - 1;
                while (comprobarPosicion(filas, columnas)) {
                    System.out.println("No has introduït una posició correcta o ja està plena, introdueix de nou: ");
                    filas = sc.nextInt() - 1;
                    columnas = sc.nextInt() - 1;
                }
                introducirPosicion(filas, columnas);
                turno = true;
            }
            comprobarGanador();
            mostarTablero();
        }


        mostraGanador();


        System.out.println();
        System.out.println("******************************");
        System.out.println();
        System.out.println();


    }
}
