import java.io.*;

public class Main {

     static void printDirectory(PrintWriter out, String dirName, String prefix) {

        File folder = new File(dirName);
        if (!folder.isDirectory())
            return;
        File[] listOfFiles = folder.listFiles();
        for (int i = 0; i < listOfFiles.length; i++) {
            String curStr = listOfFiles[i].getName();
            if (listOfFiles[i].isFile()) {
                out.println(prefix + curStr);
            } else if (listOfFiles[i].isDirectory()) {
                out.println(prefix + curStr);
                printDirectory(out, curStr, "--" + prefix);
            }
        }
    }

    public static void main(String[] args) {
        try {
            String origstr = System.getProperty("user.dir");
            String str = origstr;
            System.out.println(str);
            for (int i = str.length() - 1; i >= 0; i--) {
                if (str.charAt(i) == '\\' || str.charAt(i) == '/') {
                    str = str.substring(i + 1, str.length());
                    break;

                }

            }
            try (PrintWriter out = new PrintWriter(new File("DirectoryTree_of_" + str + ".txt"))) {

                out.println("Directory : " + str);
                printDirectory(out, origstr, "->");
//
            }

        } catch(Exception E) { E.printStackTrace(); }

    }
}