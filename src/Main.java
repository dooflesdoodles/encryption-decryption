import java.io.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {

        String mode = "";
        String data = "";
        String in = "";
        String alg = "";
        String output = "";
        String out = "";
        int key = 0;

        // loop over args & fill fields with given content if keyword is found
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
            } else if (args[i].equals("-alg")) {
                alg = args[i + 1];
            }
        }

        // read file into data-string
        if ( data.equals("") && !in.equals("") ){
            String path = in;
            try {
                data = readFile(path);
            } catch (IOException e) {
                System.out.println( "Cannot read file: " + e.getMessage() );
            }
        }

        // check for algorithm
        Algorithm algorithm;
        switch (alg) {
            case "unicode":
                algorithm = new Unicode();
                break;
            default:
                algorithm = new Shift();
                break;
        }

        // check if program should run in encryption oder decryption mode
        switch (mode) {
            case "dec":

                // write to console or to file
                if (out.equals("")) {
                    System.out.println(algorithm.decrypt(data, key, output, out, alg));
                    break;
                }else{
                    writeFile(algorithm.decrypt(data, key, output, out, alg), out);
                    break;
                }
            default:

                // write to console or to file
                if (out.equals("")) {
                    System.out.println(algorithm.encrypt(data, key, output, out, alg));
                    break;
                }else{
                    writeFile(algorithm.encrypt(data, key, output, out, alg), out);
                    break;
                }
        }
    }

    // read file & return it's content
    public static String readFile(String fileName) throws IOException {
        return new String(Files.readAllBytes( Paths.get(fileName) ));
    }

    // write file
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

}