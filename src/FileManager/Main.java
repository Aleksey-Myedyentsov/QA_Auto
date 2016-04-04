package FileManager;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

 public class Main {

    public static void main(String[] args) throws IOException {

        mainMenu();
    }

    public static void mainMenu() throws IOException {
        FileOperations fileOperations = new FileOperations();

        int choice = 0;
        Scanner scan = new Scanner(System.in);
        System.out.println(" --------------MainMenu-------------- \n " +
                "| 1. View files in your directory; | \n " +
                "| 2. Create new file               |  \n " +
                "| 0. Exit.                         | \n" +
                " ====================================");
        do {
            choice = scan.nextInt();
            switch (choice) {
                case 1:
                    fileOperations.fileList();
                    selectOperation();
                    break;
                case 2:
                    FileOperations.newFile();
                    mainMenu();
                    break;
                case 0:
                    break;
                default:

                        System.out.println("An incorrect value");
                        break;
                    }
            }
            while (!(choice == 0)) ;
            System.exit(0);
        }


    public static void selectOperation() throws IOException {
        FileOperations fileOperations = new FileOperations();

        int choice = 0;
        Scanner scan = new Scanner(System.in);
        System.out.println(" ______________________________Select Operation ______________________________\n" +
                "|1.Create| 2.Delete| 3.Rename| 4.Copy| 5.Find| 6.Main menu| 7.Refresh| 0.Exit|");
        do {
            choice = scan.nextInt();
            switch (choice) {
                case 1:
                    FileOperations.newFile();
                    selectOperation();
                    break;
                case 2:
                    FileOperations.delete();
                    selectOperation();
                   break;
                case 3:
                    FileOperations.rename();
                    selectOperation();
                    break;
                case 4:
                    FileOperations.copy();
                    selectOperation();
                    break;
                case 5:
                    fileOperations.findWord();
                    selectOperation();
                case 6:
                    mainMenu();
                    break;
                case 7:
                    fileOperations.fileList();
                    selectOperation();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("An incorrect value");
                    break;
            }
        } while (!(choice == 0));
        System.exit(0);
    }
}