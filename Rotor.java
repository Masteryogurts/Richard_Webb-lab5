public class Rotor {

    
    private String rotorValues;
    private char startChar;
        
    public Rotor(String v, char c){
        this.rotorValues = new String(v);
        this.startChar = c;
        
        while(!this.rotate());
            
    }
    //abc -- cab -- bca -- 
    public boolean rotate(){
        //TODO
        char startingchar = rotorValues.charAt(rotorValues.length() - 1);
        //find the last point in the array and add that to the front while also minusing from the end
        rotorValues = startingchar + rotorValues.substring(0, rotorValues.length()-1);

        if (rotorValues.charAt(0) == startChar) {
            return true;
        }else{
            return false;
        }


               
    }
    

    public int indexOf(char c){
        //TODO
        //loop through the array 
        for (int i = 0; i < rotorValues.length(); i++){
            //if the character at i is equal to the index we put in (c)
            if (rotorValues.charAt(i) == c){
                //return that index
                return (i);
            }
        }
        return -1; //failed if it didnt find i since it would return later.
    }

    public char charAt(int idx){
        //TODO
        //sanity check
        if (idx < 0 || idx >= rotorValues.length()){
            return '?';//character type to return 
        }

        //go through the array
        for (int i = 0; i < rotorValues.length(); i++){
            //find where i equals idx
            if (i == idx){
                //return the character at that position
                return rotorValues.charAt(i); //I DONT KNOW HOW TO CREATE MY OWN CHARAT JAVA CAN DO IT FOR ME
            }
        }
        return '?';//indicating failure
    }
}
    
