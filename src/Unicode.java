public class Unicode implements Algorithm {

    String output = "";

    public String decrypt(String data, int key) {

        // loop over char array of data & shift each by the given key as unicode
        for (char item : data.toCharArray()) {
            char shiftItem = (char) (item - key);
            output += shiftItem;
        }
        return output;
    }

    public String encrypt(String data, int key) {

        // loop over char array of data & shift each by the given key as unicode
        for (char item : data.toCharArray()) {
            char shiftItem = (char) (item + key);
            output += shiftItem;
        }
        return output;
    }
}