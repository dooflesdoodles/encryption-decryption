public class Unicode implements Algorithm {

    public String decrypt(String data, int key, String output, String out, String alg) {

        // loop over char array of data & shift each by the given key as unicode
        for (char item : data.toCharArray()) {
            char shiftItem = (char) (item - key);
            output += shiftItem;
        }
        return output;
    }

    public String encrypt(String data, int key, String output, String out, String alg) {

        // loop over char array of data & shift each by the given key as unicode
        for (char item : data.toCharArray()) {
            char shiftItem = (char) (item + key);
            output += shiftItem;
        }
        return output;
    }
}