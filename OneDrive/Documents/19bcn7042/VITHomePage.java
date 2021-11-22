import javax.swing.text.*;
import javax.swing.*;
import java.io.*;
import java.awt.*;
public class VITHomePage {
public static void main(String[] args) {
JEditorPane jep = new JEditorPane( );
jep.setEditable(false);
try {
jep.setPage("https://www.vitap.ac.in");
}
catch (IOException ex) {
jep.setContentType("text/html");
jep.setText("<html>Could not load https://www.vitap.ac.in </html>");
}
JScrollPane scrollPane = new JScrollPane(jep);
JFrame f = new JFrame("VIT-AP");
f.setVisible(true);
f.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
f.setContentPane(scrollPane);
f.setSize(512, 512);

}
}
