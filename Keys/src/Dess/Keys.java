package Dess;
import java.util.ArrayList;

public class Keys {
    private  ArrayList <String> Code = new ArrayList<>();
    private final ArrayList<String> Keys = new ArrayList<>();
    
    public ArrayList<String> obtenerLlaves(){    
        Claves Claves = new Claves();
        Code = Claves.obtenerC();
        int[] cP2 = {14,17,11,24,1,5,3,28,15,6,21,10,23,19,12,4,26,8,16,7,27,20,
            13,2,41,52,31,37,47,55,30,40,51,45,33,48,44,49,39,56,34,53,46,42,50,
            36,29,32};
        
        for (int i = 0; i < 16; i++) {
            String clav =(Code.get(i));
            String key="";
            for (int j = 0; j < 48; j++) {
                key += clav.charAt(cP2[j]-1);
                
            }
            Keys.add(key);
        }
        return Keys;
    }
    
}
