public class Shift implements Algorithm{

    String output = "";

    public String encrypt (String data, int key) {
        char[] chars = data.toCharArray();
        for (char item : chars) {
            if (item >= 'a' && item <= 'z') {
                char shiftItem = (char) (((item - 'a' + key) % 26) + 'a');
                output += shiftItem;

            } else if (item >= 'A' && item <= 'Z') {
                char shiftItem = (char) (((item - 'A' + key) % 26) + 'A');
                output += shiftItem;

            } else {
                output += item;
            }
        }
        return output;
    }

    public String decrypt (String data, int key) {
        char[] chars = data.toCharArray();
        for (char item : chars) {
            if (item >= 'a' && item <= 'z') {
                char shiftItem = (char) (((item - 'a' - key) % 26) + 'a');
                output += shiftItem;

            } else if (item >= 'A' && item <= 'Z') {
                char shiftItem = (char) (((item - 'A' - key) % 26) + 'A');
                output += shiftItem;

            } else {
                output += item;
            }
        }
        return output;
    }
}