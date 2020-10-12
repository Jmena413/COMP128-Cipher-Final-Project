public class CaesarCipher {

    public String encrypt(String message, int offset){
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

    public String decrypt(String cipheredMessage, int offset){
        return encrypt(cipheredMessage, 26 - (offset % 26));
    }
}
