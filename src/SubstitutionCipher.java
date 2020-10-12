import java.util.HashMap;
import java.util.Map;

public class SubstitutionCipher {

    public String shuffleAlphabet(){
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        char[] alphaArray = alphabet.toCharArray();
        for (int i = 0; i < alphaArray.length; i++){
            int randomIndex = (int) (Math.random() * alphaArray.length);
            char temp = alphaArray[i];
            alphaArray[i] = alphaArray[randomIndex];
            alphaArray[randomIndex] = temp;
        }
        return new String(alphaArray);
    }

    public String encrypt(String message, String key){
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        Map<Character, Integer> alphabetMap = new HashMap<>();
        int count = 0;
        for (char character: alphabet.toCharArray()) {
            alphabetMap.put(character, count);
            count++;
        }
        char[] keyArray = key.toCharArray();
        StringBuilder result = new StringBuilder();
        for (char character : message.toCharArray()){
            if (character != ' ') {
                result.append(keyArray[alphabetMap.get(character)]);
            }else{
                result.append(character);
            }
        }
        return result.toString();
    }

    public String decrypt(String cipheredMessage, String key){
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        Map<Character, Integer> keyMap = new HashMap<>();
        int count = 0;
        for (char character : key.toCharArray()){
            keyMap.put(character, count);
            count++;
        }
        char[] alphabetArray = alphabet.toCharArray();
        StringBuilder result = new StringBuilder();
        for (char character : cipheredMessage.toCharArray()){
            if (character != ' ') {
                result.append(alphabetArray[keyMap.get(character)]);
            }else{
                result.append(character);
            }
        }
        return result.toString();
    }
}
