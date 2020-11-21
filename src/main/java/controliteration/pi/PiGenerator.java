package controliteration.pi;

public class PiGenerator {

    private static String PI = "Nem a régi s durva közelítés, Mi szótól szóig így kijön Betűiket számlálva. Ludolph eredménye már, Ha itt végezzük húsz jegyen. De rendre kijő még tíz pontosan, Azt is bízvást ígérhetem. ";

    public String getPi (){
        int counter = 0;
        int decimal = 0;
        String value = "";
         for (int i = 0; i < PI.length(); i++){
             if ( (PI.charAt(i) != ' ') && (PI.charAt(i) != ',' ) && (PI.charAt(i) != '.') ) {
                 counter++;
             } else if ( PI.charAt(i) == ' ' ) {
                 value = value + Integer.toString(counter);
                 decimal++;
                 counter = 0;
                 if (decimal == 1) {
                     value = value + ".";
                 }
             }
         }
         return value;
    }

}
