package Dess;

import java.util.ArrayList;
import java.util.Scanner;

public class LeftRights {
    
    public void ObtenerLR(){
        
        Scanner leer = new Scanner(System.in);
        Convertir Convertir = new Convertir();
        String dato;
        System.out.println("Ingrese el Dato en Hexadecimal:");
        dato = (Convertir.convertido(leer.next()));
        System.out.println("Tu Dato en binario es: "+dato);
        
        String left0 = "";
        String right0 = "";
        String dIP="";
//        Convocamos LLaves
        ArrayList<String> Llaves;                    
        Keys Keys = new Keys();
        Llaves = Keys.obtenerLlaves();
            
            int[] cIP = {58, 50, 42, 34, 26, 18, 10, 2, 60, 52, 44, 36, 28, 20, 12, 4,62, 54, 46, 38, 30, 22, 14, 6,64, 56, 48, 40, 32, 24, 16, 8,57, 49, 41, 33, 25, 17, 9, 1,59, 51, 43, 35, 27, 19, 11, 3,61, 53, 45, 37, 29, 21, 13, 5,63, 55, 47, 39, 31, 23, 15, 7};

        
        
            for (int j = 0; j<64; j++) {            
                dIP = (dIP+dato.charAt(cIP[j]-1));
            }
            System.out.println("PermIP:"+dIP);
        //Hasta aquí ya está permutado
        
        
        
            for (int j = 0; j < 64; j++) {
                if (j<32) 
                    left0 = (left0+dIP.charAt(j));            
                else
                    right0 = (right0+dIP.charAt(j));
            }
            
            for (int i = 0; i < 16; i++) {
            System.out.println("Nuevo***************************************************************************");
            System.out.println("L"+(i)+" = "+left0);
            System.out.println("R"+(i)+" = "+right0);
            //Left&Right ya divididos

            String right="";
            String prodxor="";
            int cExp[] = {32, 1, 2, 3, 4, 5,4, 5, 6, 7, 8, 9,8, 9, 10, 11, 12, 13, 12, 13, 14, 15, 16, 17,16, 17, 18, 19, 20, 21,20, 21, 22, 23, 24, 25,24, 25, 26, 27, 28, 29, 28, 29, 30, 31, 32, 1};
       
            for (int j = 0; j < cExp.length; j++) 
            right = (right+right0.charAt(cExp[j]-1));    
           
            System.out.println("");
            System.out.println("R"+i+" = "+right);
            System.out.println("K"+(i+1)+" = "+Llaves.get(i));
            for (int k = 0; k < Llaves.get(i).length(); k++) {
                if (right.charAt(k)==Llaves.get(i).charAt(k))
                    prodxor+="0";
                else
                    prodxor+="1";
            }
            System.out.println("---------------------XoR---------------------------");
            System.out.println(prodxor);
            //Hasta aquí XoR de LLave y Right

            String divXor[] = new String[8];
            int cont=0;
            for (int k = 0; k < 8; k++) {                    
                divXor[k] = prodxor.substring(cont,cont+6);
                cont=cont+6;
            }
            for (int k = 0; k < 8; k++) {
                System.out.println(divXor[k]);
            }
            //Hasta aquí xOr dividido entre 6
            String coorx;
            String coory;
            String numx;
            String numy;
            int coordenada[] = new int[8];
            int coordenada1[][];

            for (int k = 0; k < 8; k++) {
                Sboxes Box = new Sboxes();
                Convertir Conv = new Convertir();
                coorx=(divXor[k].substring(0,1)+divXor[k].substring(5,6));
                coory=(divXor[k].substring(1,5));
                numx = Conv.Bin2Dec(coorx);
                numy = Conv.Bin2Dec(coory);
                System.out.println("X:"+coorx+" Y:"+coory);
                System.out.println("X:"+numx+" Y:"+numy);
                if (k==0) {
                    coordenada1 = Box.S1();
                    coordenada[k] = coordenada1[Integer.parseInt(numx)][Integer.parseInt(numy)];                        
                }
                if (k==1) {
                    coordenada1 = Box.S2();
                    coordenada[k] = coordenada1[Integer.parseInt(numx)][Integer.parseInt(numy)];                        
                }
                if (k==2) {
                    coordenada1 = Box.S3();
                    coordenada[k] = coordenada1[Integer.parseInt(numx)][Integer.parseInt(numy)];                        
                }
                if (k==3) {
                    coordenada1 = Box.S4();
                    coordenada[k] = coordenada1[Integer.parseInt(numx)][Integer.parseInt(numy)];                        
                }
                if (k==4) {
                    coordenada1 = Box.S5();
                    coordenada[k] = coordenada1[Integer.parseInt(numx)][Integer.parseInt(numy)];                        
                }
                if (k==5) {
                    coordenada1 = Box.S6();
                    coordenada[k] = coordenada1[Integer.parseInt(numx)][Integer.parseInt(numy)];                        
                }
                if (k==6) {
                    coordenada1 = Box.S7();
                    coordenada[k] = coordenada1[Integer.parseInt(numx)][Integer.parseInt(numy)];                        
                }
                if (k==7) {
                    coordenada1 = Box.S8();
                    coordenada[k] = coordenada1[Integer.parseInt(numx)][Integer.parseInt(numy)];                        
                }

            }

            String coords[] = new String[8];
            for (int k = 0; k < 8; k++) {
                coords[k]=Integer.toString(coordenada[k]);
                System.out.println("Coordenada"+k+": "+coords[k]);
            }

            String afterbox="";
            for (int k = 0; k < 8; k++) {
                Convertir Conv = new Convertir();
                afterbox = afterbox+Conv.pacajas(coords[k]);                    
            }
            System.out.println("Después de S's"+afterbox);
            //Hasta aquí saca las coordenadas

            int perm[] = {16, 7, 20, 21,29, 12, 28, 17,1, 15, 23, 26,5, 18,31, 10,2, 8, 24, 14,32, 27, 3, 9,19, 13, 30, 6,22, 11, 4, 25};

            String permp="";
            for (int k = 0; k < afterbox.length(); k++) {
                permp = (permp+afterbox.charAt(perm[k]-1));
            }
            String xorLnP="";
            for (int k = 0; k < permp.length(); k++) {
                if (permp.charAt(k)==left0.charAt(k)) 
                    xorLnP=xorLnP+"0";
                else
                   xorLnP=xorLnP+"1"; 
            }
            System.out.println("");
            System.out.println(permp+"  Permutada con P");
            System.out.println(left0+"  Left"+i);
            System.out.println("------------------------------XoR----------------------");
            System.out.println(xorLnP);
            System.out.println("");
            left0=right0;
            right0=xorLnP;
            System.out.println("L"+(i+1)+" = "+left0);
            System.out.println("R"+(i+1)+" = "+right0);
            right = "";
            prodxor="";                
        }
            System.out.println(right0+left0);
            int finP[] = {40, 8, 48, 16, 56, 24, 64, 32,39, 7, 47, 15, 55, 23, 63, 31,38, 6, 46, 14, 54, 22, 62, 30,37, 5, 45, 13, 53, 21, 61, 29,36, 4, 44, 12, 52, 20, 60, 28,35, 3, 43, 11, 51, 19, 59, 27,34, 2, 42, 10, 50, 18, 58, 26,33, 1, 41, 9, 49, 17, 57, 25};
            String End="";
            for (int i = 0; i < finP.length; i++) {
                End=End+((right0+left0).charAt(finP[i]-1));
            }
            Convertir Conv = new Convertir();
            System.out.println("Cifrado: " + Conv.Bin2Hex(End));
    }
}
