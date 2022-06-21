package com.sistemas.informaticos.utils;

public class Utils {
    public static String cuentapalabra(String palabra) {
        int cuentavocal = 0, cuentaconsonante = 0;
        palabra = palabra.toLowerCase();
        for (int i = 0; i < palabra.length(); i++) {
            char letra = palabra.charAt(i);
            if (letra == 'a' || letra == 'e' || letra == 'i' || letra == 'o' || letra == 'u') {
                cuentavocal++;
            } else if ((letra >= 'a' && letra <= 'z')) {
                cuentaconsonante++;
            }
        }
        return "numero de vocales " + cuentavocal + " numero de consonantes " + cuentaconsonante;
    }

    public static String transformame(String palabrita) {
        return palabrita.toUpperCase();
    }

    public static char calculaLetra(int dni){
        String juegoCaracteres = "TRWAGMYFPDXBNJZSQVHLCKE";
        int modulo = dni % 23;
        char letra = juegoCaracteres.charAt(modulo);
        return letra;
    }
    public static int calculaCoincidencias(String cad1, String cad2){
        int result = 0;
        char[] aux1 = cad1.toLowerCase().toCharArray();
        char[] aux2 = cad2.toLowerCase().toCharArray();
        String letrasaux="";
        for(int i=0; i<aux1.length; i++){
            if(letrasaux.contains(Character.toString(aux1[i]))){
                continue;
            }
            for(int j=0; j<aux2.length; j++){
                if(aux1[i]==aux2[j]){
                    result++;
                    break;
                }
            }
            letrasaux += aux1[i];
        }

        return result;
    }
}
