package FileManager;

import java.io.*;
import java.nio.file.Files;
import java.util.Scanner;

public class FileOperations {

    public static void newFile() throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the file name");
        String fileName = scan.nextLine();
        System.out.println("Enter the text");
        String content = scan.nextLine();

        File file = new File(fileName);

            try {
                file.createNewFile();
                PrintWriter out = new PrintWriter(file.getAbsoluteFile());

                try {
                    out.print(content);
                } finally {
                    out.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        return;
    }

    public static void delete() throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the file name for delete");
        String nameFile = scan.nextLine();

        //exists(nameFile);
        new File(nameFile).delete();
        return;
    }

    public static void rename() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the source file \nformat '*.*': ");
        String source = scan.nextLine();

        File fileSource = new File(source);
        boolean bool = false;

        try {
            System.out.println("Enter the new file name \nformat '*.*': ");
            String renamedFile = scan.nextLine();
            File newNameFile = new File(renamedFile);

            bool = fileSource.renameTo(newNameFile);

            if (bool = true) {
                System.out.println("Your file renamed!");
            } else {
                System.out.println("Your file isn't renamed!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void copy() throws IOException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the file name \nformat '*.*': ");
        File source = new File(scan.nextLine());
        System.out.println("Enter the new file name \nformat '*.*': ");
        File dest = new File(scan.nextLine());

        Files.copy(source.toPath(), dest.toPath());
    }

    public static void findWord() throws IOException {
        Scanner scan = new Scanner(System.in);
        System.out.print("Select the file: ");
        String file = scan.nextLine();
        boolean find=false;

        BufferedReader in = new BufferedReader(new FileReader(file));
        long startTime=System.currentTimeMillis();
        String line = null;
        while((line = in.readLine())!=null){
            System.out.print("Enter the word: ");
            String word = scan.nextLine();
            if(line.startsWith(word)){
                find=true;
                break;
            }
        }
        System.out.println("search time: "+(System.currentTimeMillis()-startTime)+" msec");
        if (find = true) {
            System.out.println("Your word is found this file!");
        } else {
            System.out.println("Your word isn't found this file!");
        }
        in.close();
    }

    public void fileList() throws IOException{
        System.out.println("File list: ");

        String list[] = new File(".").list();
        for(int i = 1; i < list.length; i++)
            System.out.println(i + " " + list[i]);

    }
}
