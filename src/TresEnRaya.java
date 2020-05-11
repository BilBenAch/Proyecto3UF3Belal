
class TresEnRatlla {

    char tabla[][];
    boolean jugador;

    TresEnRatlla() {
        tabla = new char[3][3];
        boolean jugador = true;
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

}
