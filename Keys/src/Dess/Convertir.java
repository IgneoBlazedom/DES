package Dess;

public class Convertir {
    public String convertido(String str){
        String conv="";
        for (int i=0; i<16; i++){
            String bit="";
            switch(str.charAt(i)){
                case '0':
                    bit="0000";
                    break;
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
                case ('A'):
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
    
    public String Bin2Dec(String str){
        if (str.length()<4) {
            for (int i = 0; i < (str.length()+1); i++) {
            if (str.length()<4) 
                str="0"+str;          
            } 
        }
        String conv="";
                           
        switch(str){
            case ("0000"):
            conv="0";
            break;
            case ("0001"):
            conv="1";
            break;
            case ("0010"):
            conv="2";
            break;
            case ("0011"):
            conv="3";
            break;
            case ("0100"):
            conv="4";
            break;
            case ("0101"):
            conv="5";
            break;
            case ("0110"):
            conv="6";
            break;
            case ("0111"):
            conv="7";
            break;
            case ("1000"):
            conv="8";
            break;
            case ("1001"):
            conv="9";
            break;
            case ("1010"):
            conv="10";
            break;
            case ("1011"):
            conv="11";
            break;
            case ("1100"):
            conv="12";
            break;
            case ("1101"):
            conv="13";
            break;
            case ("1110"):
            conv="14";
            break;
            case ("1111"):
            conv="15";
            break;
        }
        return conv;
    }
    
    public String pacajas(String str){
        String conv="";
                           
        switch(str){
            case ("0"):
            conv="0000";
            break;
            case ("1"):
            conv="0001";
            break;
            case ("2"):
            conv="0010";
            break;
            case ("3"):
            conv="0011";
            break;
            case ("4"):
            conv="0100";
            break;
            case ("5"):
            conv="0101";
            break;
            case ("6"):
            conv="0110";
            break;
            case ("7"):
            conv="0111";
            break;
            case ("8"):
            conv="1000";
            break;
            case ("9"):
            conv="1001";
            break;
            case ("10"):
            conv="1010";
            break;
            case ("11"):
            conv="1011";
            break;
            case ("12"):
            conv="1100";
            break;
            case ("13"):
            conv="1101";
            break;
            case ("14"):
            conv="1110";
            break;
            case ("15"):
            conv="1111";
            break;
        }
        return conv;
    }
}
