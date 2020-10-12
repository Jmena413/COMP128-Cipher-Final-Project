import java.util.*;

public class CypherDecryption {

    String caesarCipher(String message, int offset){
        StringBuilder result = new StringBuilder();
        for (char character: message.toCharArray()) {
            if (character != ' ') {
                int originalAlphaPos = character - 'a';
                int newAlphaPos = (originalAlphaPos + offset) % 26;
                char newCharacter = (char) ('a' + newAlphaPos);
                result.append(newCharacter);
            }else{
               result.append(character);
            }
        }
        return result.toString();
    }

    String caesarDecipher(String cipheredMessage, int offset){
        return caesarCipher(cipheredMessage, 26 - (offset % 26));
    }

    String shuffleAlphabet(){
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

    String simpleSubstitutionCipher(String message, String key){
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

    String simpleSubstitutionDecipher(String cipheredMessage, String key){
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

    public static void main(String[] args) {
        CypherDecryption cypher = new CypherDecryption();
        String newmessage = cypher.caesarCipher("attack at dawn", 25);
        System.out.println(newmessage);
        System.out.println(cypher.shuffleAlphabet());
        System.out.println(cypher.caesarDecipher(newmessage, 25));
        newmessage = cypher.simpleSubstitutionCipher("attack at dawn", "phqgiumeaylnofdxjkrcvstzwb");
        System.out.println(newmessage);
        System.out.println(cypher.simpleSubstitutionDecipher(newmessage, "phqgiumeaylnofdxjkrcvstzwb"));
    }
}
