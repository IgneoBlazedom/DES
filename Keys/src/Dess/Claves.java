package Dess;

import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Hot Cakes
 */
public class Claves {
    private final ArrayList <String> CLeft = new ArrayList<>();
    private final ArrayList <String> CRight = new ArrayList<>();
    private final ArrayList <String> Code = new ArrayList<>();
    
    public ArrayList<String> obtenerC(){
        
        Scanner leer = new Scanner(System.in);
        Convertir c = new Convertir();
        String str, strc;
        System.out.println("Ingrese Clave en Hexadecimal: ");
        str = leer.next();
        strc = c.convertido(str);
        System.out.println("Tu clave en Binario es: "+strc);    
        
        int[] cP1 = {57,49,41,33,25,17,9,1,58,50,42,34,26,18,10,2,59,51,43,35,
                     27,19,11,3,60,52,44,36,63,55,47,39,31,23,15,7,62,54,46,38,
                     30,22,14,6,61,53,45,37,29,21,13,5,28,20,12,4};
        
        String clavl="";
        String clavr="";
        String clavnewl="";
        String clavnewr="";
        for(int i=0; i<56; i++){
            if(i<28){         
                clavl=(clavl+strc.charAt(cP1[i]-1));
                
            }
            else{
                clavr=(clavr+strc.charAt(cP1[i]-1));
                
            }
            
        }
        CLeft.add(clavl);
        CRight.add(clavr);        
        for (int i = 1; i <= 16; i++) {
            if (i==1||i==2||i==9||i==16) {
                clavnewl = (clavnewl + clavl.substring(1));
                clavnewr = (clavnewr + clavr.substring(1));
                clavnewl = (clavnewl + clavl.substring(0,1));
                clavnewr = (clavnewr + clavr.substring(0,1));
            }
            else{
                clavnewl = (clavnewl + clavl.substring(2));
                clavnewr = (clavnewr + clavr.substring(2));
                clavnewl = (clavnewl + clavl.substring(0,2));
                clavnewr = (clavnewr + clavr.substring(0,2));
            }
            clavl = clavnewl;
            clavr = clavnewr;         
            clavnewl="";
            clavnewr="";
            CLeft.add(clavl);
            CRight.add(clavr);
            Code.add(CLeft.get(i)+CRight.get(i));
        }
        return Code;
    }
        
}