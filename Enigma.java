public class Enigma{

    private String rotorInit[] = {"#GNUAHOVBIPWCJQXDKRYELSZFMT",
        "#EJOTYCHMRWAFKPUZDINSXBGLQV",
        "#BDFHJLNPRTVXZACEGIKMOQSUWY",
        "#NWDKHGXZVRIFJBLMAOPSCYUTQE",
        "#TGOWHLIFMCSZYRVXQABUPEJKND"};


    private Rotor rotors[];

    //hardcode the alphabet in here as our fixed outer ring
    private String s = "#ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        
    public Enigma(int id1, int id2, int id3, String start){

        rotors = new Rotor[3];
        rotors[0] = new Rotor(rotorInit[id1-1], start.charAt(0));
        rotors[1] = new Rotor(rotorInit[id2-1], start.charAt(1));
        rotors[2] = new Rotor(rotorInit[id3-1], start.charAt(2));
        
    }


    public String decrypt(String message){        
        //TODO
        String result = ""; //start with an empty string variable called result where we will hold everything later

        //loop through message
        for (int i = 0; i < message.length(); i++) {
            //find the character
            char character = message.charAt(i);

            //this time, we go backward instead of forwards (like in encryption)
            //first, finding the position inside rotor 2 which is where we ended in encryption
            int index = rotors[2].indexOf(character);
            //map that back to the outer ring
            character = rotors[1].charAt(index);

            //now go through rotor 1 except in reverse
            index = rotors[2].indexOf(character);
            character = rotors[0].charAt(index); //map that back to the outer ring again

            //append that to the result
            result = result + character;
            //then rotate after each character
            rotate();

        }
        //return that result
        return result;

        
    }


    
    public String encrypt(String message){
        //TODO
        //create a result that we add to later
        String result = "";

        //iterate through the message
        for (int i = 0; i < message.length(); i++) {

            //find the character
            char character = message.charAt(i);

            //find the position of that character in the outer ring
            int index = rotors[0].indexOf(character);

            //go through the 0th rotor
            character = rotors[2].charAt(index);
            //convert that back to an index in the second ring
            index = rotors[1].indexOf(character);

            //then go through that first rotor and keep rinsing and repeating this
            character = rotors[2].charAt(index);
            result = result + character;
            //then rotate after each character is completely found 
            rotate();
        }
        //return the full result
        return result;
    }

    
    private void rotate(){
        if(rotors[0].rotate()){
            if(rotors[1].rotate()){
                rotors[2].rotate();
            }
        }
    }
    
}
