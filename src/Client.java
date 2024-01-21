import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket sock = new Socket("Localhost",30333);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(sock.getOutputStream()));
        BufferedReader reader = new BufferedReader(new InputStreamReader(sock.getInputStream()));
        String str;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            str = scanner.nextLine();
            writer.write(str);
            writer.write("\n");
            writer.flush();
            if("exit".equals(str)) break;
            str = reader.readLine();
            System.out.println("server replied: " + str);
        }
    }
}
