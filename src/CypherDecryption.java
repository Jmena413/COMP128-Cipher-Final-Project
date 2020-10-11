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

    public static void main(String[] args) {
        CypherDecryption cypher = new CypherDecryption();
        String newmessage = cypher.caesarCipher("he told me i could never teach a llama to drive", 3);
        System.out.println(newmessage);
        System.out.println(cypher.caesarDecipher(newmessage, 3));
    }
}
