package Dess;

public class Convertir {
    public String convertido(String str){
        String conv="";
        for (int i=0; i<16; i++){
            String bit="";
            switch(str.charAt(i)){
                case '1':
                    bit="0001";
                    break;
                case '2':
                    bit="0010";
                    break; 
                case '3':
                    bit="0011";
                    break;
                case '4':
                    bit="0100";
                    break;
                case '5':
                    bit="0101";
                    break;
                case '6':
                    bit="0110";
                    break;
                case '7':
                    bit="0111";
                    break;
                case '8':
                    bit="1000";
                    break;
                case '9':
                    bit="1001";
                    break;
                case 'A':
                    bit="1010";
                    break;
                case 'B':
                    bit="1011";
                    break;
                case 'C':
                    bit="1100";
                    break;
                case 'D':
                    bit="1101";
                    break;
                case 'E':
                    bit="1110";
                    break;
                case 'F':
                    bit="1111";
                    break;
            }
            conv = conv + bit;
        }    
        return conv;
    }
}
