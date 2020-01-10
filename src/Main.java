import java.io.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        int key = 0;
        String output = "";
        String mode = "enc";
        String data = "";
        String in = "";
        String out = "";

        for (int i = 0; i < args.length; i += 2) {
            if (args[i].equals("-mode")) {
                mode = args[i+1];
            } else if (args[i].equals("-key")) {
                key = Integer.parseInt(args[i+1]);
            } else if (args[i].equals("-data")) {
                data = args[i+1];
            } else if (args[i].equals("-in")) {
                in = args[i + 1];
            } else if (args[i].equals("-out")) {
                out = args[i + 1];
            }
        }

        if (data.equals("") && !in.equals(""){
            String path = in;
            try {
                data = readFile(path);
            } catch (IOException e) {
                System.out.println("Cannot read file: " + e.getMessage());
            }
        }

        switch (mode) {
            case "enc":
                getEncryption(data, key, output, out);
                break;
            case "dec":
                getDecryption(data, key, output, out);
                break;
            default:
                System.out.println("Unknown operation");
                break;
        }
    }

    public static String readFile(String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }

    public static void writeFile(String output, String out){
        File file = new File(out);
        FileWriter writer = null;
        try {
            writer = new FileWriter(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            writer.write(output);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void getDecryption(String data, int key, String output, String out) {
        for (char item : data.toCharArray()) {
            char shiftItem = (char) (item - key);
            output += shiftItem;
        }
        if (out == "") {
            System.out.println(output);
        } else{
            writeFile(output, out);
        }
    }

    public static void getEncryption(String data, int key, String output, String out) {
        for (char item : data.toCharArray()) {
            char shiftItem = (char) (item + key);
            output += shiftItem;
        }
        if (out == "") {
            System.out.println(output);
        } else {
            writeFile(output, out);
        }
    }
}
