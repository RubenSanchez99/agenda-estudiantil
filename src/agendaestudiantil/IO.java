package agendaestudiantil;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

public class IO {

    public static void saveMailAdress(String email) {
        try {
            FileWriter fw = new FileWriter("correo.txt", false);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(email);
            bw.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar correo");
        }
    }

    public static String readMailAdress() {
        String line = null;
        try (BufferedReader br = new BufferedReader(new FileReader("correo.txt"))) {

            String currentLine;

            while ((currentLine = br.readLine()) != null) {
                line = currentLine;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return line;
    }
}
