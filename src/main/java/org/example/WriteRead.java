package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteRead {
    public static void writeFile(String msg) {
        String PATH = "./receipt.txt";
        String osName = System.getProperty("os.name").toLowerCase();

        if (osName.contains("linux")) {
            PATH = "/home/lckmnzans/Documents/projects/Java Projects/F-BJV24001115-synrgy7-luk-binfood-ch1/struk.txt";
        } else if (osName.contains("windows")) {
            PATH = "D://Documents/Docs/struk.txt";
        }

        File file = new File(PATH);
        try {
            if (file.createNewFile()) {
                FileWriter fileWriter = new FileWriter(PATH);
                fileWriter.write(msg);
                fileWriter.close();

                System.out.println("Cetak");
            } else {
                System.out.println("File already exist");
            }
        } catch (IOException e) {
            System.out.println("Error occured");
            throw new RuntimeException();
        }
    }
}
