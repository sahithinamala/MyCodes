import java.util.*;
import java.io.*;
import java.net.*;

import java.awt.*;
import java.awt.image.*;

import javax.swing.*;
import javax.imageio.*;

class ImagePanel extends JPanel {
BufferedImage img;

ImagePanel(BufferedImage img) {
this.img = img;
}

public void paint(Graphics g) {
g.drawImage(img, 0, 0, this);
}
}

class CaptchaClient {
static BufferedImage img;
public static void main(String args[]) throws Exception {
JFrame frame = new JFrame();

Scanner scan = new Scanner(System.in);
System.out.println("Connecting to the server…");
Socket clientSocket = new Socket("localhost", 7777);
ObjectInputStream objectIn = new ObjectInputStream(clientSocket.getInputStream());
PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

BufferedImage i = ImageIO.read(clientSocket.getInputStream());
clientSocket.close();
clientSocket = new Socket("localhost", 7777);
out = new PrintWriter(clientSocket.getOutputStream(), true);
in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

ImagePanel pane = new ImagePanel(i);
pane.setSize(200,200);
frame.add(pane);
frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
frame.setSize(218, 245);
frame.setLocationRelativeTo(null);
frame.setVisible(true);

System.out.println("Enter the CAPTCHA: ");
String captcha = scan.nextLine();
System.out.println("Verifying…");
out.println(captcha);
out.flush();
System.out.println(in.readLine());

in.close();
out.close();
clientSocket.close();
System.exit(0);
}
}