package establo;

import java.util.Date;

public class Hipodromo {

    private Date fecha;
    private Caballo[][] caballos;

    public Hipodromo(Date fecha) {
        this.fecha = fecha;
    }

    public void agregarCaballo(Caballo c) {
        boolean existe = buscarCaballo(c.getEstablo(), c.getNumero());
        if (!existe) {
            for (int i = 0; i < caballos.length; i++) {
                for (int j = 0; j < caballos[i].length; j++) {
                    if (caballos[i][j] == null) {
                        caballos[i][j] = c;
                    }
                }
            }
        }
    }

    public boolean buscarCaballo(char establo, int numero) {

        for (int i = 0; i < caballos.length; i++) {
            for (int j = 0; j < caballos[i].length; j++) {
                int col = identificarEstablo(establo);
                if (caballos[i][col] != null) {
                    if (caballos[i][col].getNumero() == numero) {
                        return true;
                    }
                }
            }
        }
        return false;

    }

    public int identificarEstablo(char l) {
        int c = (int) l - 65;
        return c;
    }

    public void cambiarCaballo(String nCaballo) {
        int max = Integer.MAX_VALUE;
        int posI = -1;
        int posJ = -1;

        for (int i = 0; i < caballos.length; i++) {
            for (int j = 0; j < caballos[i].length; j++) {
                int cant = caballos[i][j].contarJinetes();
                if (cant < max) {
                    max = cant;
                    posI = i;
                    posJ = j;
                }
            }
        }

        if (posI != -1 && posJ != -1) {
            caballos[posI][posJ].setNombre(nCaballo);
        }
    }

    public String mejorJinete() {
        String nCaballo = "";
        double mejor = Double.MAX_VALUE;
        for (int i = 0; i < caballos.length; i++) {
            for (int j = 0; j < caballos[i].length; j++) {
                if (i == 3) {
                    if (caballos[i][j] != null) {
                        if (caballos[i][j].mejorTiempo() < mejor) {
                            mejor = caballos[i][j].mejorTiempo();
                            nCaballo = caballos[i][j].getNombre();
                        }
                    }
                }

            }
        }
        return nCaballo;

    }

}
