package keys;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Hot Cakes
 */
public class Metodos {
    ArrayList <String> Code = new ArrayList<String>();
    
    
    public Clave[] obtenerC(){
        Clave[] codes = new Clave[16];
        
        Scanner leer = new Scanner(System.in);
        Convertir c = new Convertir();
        String str, strc;
        System.out.println("Ingrese Clave en Hexadecimal");
        str = leer.next();
        strc = c.convertido(str);
        System.out.println("Tu clave en Binario es: "+strc);    
        
        int[] cP1 = {57,49,41,33,25,17,9,1,58,50,42,34,26,18,10,2,59,51,43,35,
                     27,19,11,3,60,52,44,36,63,55,47,39,31,23,15,7,62,54,46,38,
                     30,22,14,6,61,53,45,37,29,21,13,5,28,20,12,4};
        
        Clave code = new Clave();
        for(int i=0; i<56; i++){
            if(i<28){
                code.setLeft(code.getLeft()+strc.charAt(cP1[i]-1));                
            }
            else{
                code.setRight(code.getRight()+strc.charAt(cP1[i]-1));
            }
        }
        System.out.print("C0 "+code.getLeft());
        System.out.println("   D0 "+code.getRight());
        
        for (int i = 1; i <= 16; i++) {
            Clave cn = new Clave();
            if (i==1||i==2||i==9||i==16) {
                cn.setLeft(code.getLeft().substring(1));
                cn.setRight(code.getRight().substring(1));
                cn.setLeft(cn.getLeft()+code.getLeft().substring(0,1));
                cn.setRight(cn.getRight()+code.getRight().substring(0,1));
            }
            else{
                cn.setLeft(code.getLeft().substring(2));
                cn.setRight(code.getRight().substring(2));
                cn.setLeft(cn.getLeft() + code.getLeft().substring(0, 2));
                cn.setRight(cn.getRight() + code.getRight().substring(0,2));
            }
            System.out.print("C"+i+" "+cn.getLeft());
            System.out.println("   D"+i+" "+cn.getRight());
            code = cn;
            codes[i-1] = cn;            
        }
        return codes;
    }
    
    public void obtenerLlaves(){
        Clave codes[] = obtenerC();
        int[] cP2 = {14,17,11,24,1,5,3,28,15,6,21,10,23,19,12,4,26,8,16,7,27,20,
            13,2,41,52,31,37,47,55,30,40,51,45,33,48,44,49,39,56,34,53,46,42,50,
            36,29,32};
        
        for (int i = 0; i < 16; i++) {
            String clav = codes[i].getLeft() + codes[i].getRight();
            String key="";
            for (int j = 0; j < 48; j++) {
                key += clav.charAt(cP2[j]-1);
            }
            System.out.println("K"+(i+1)+" "+key);
        }
    }
        
}