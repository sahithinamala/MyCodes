import java.util.*;
import java.io.*;
import java.net.*;

import java.awt.*;
import java.awt.image.*;

import javax.imageio.*;

class TimeOutTask extends TimerTask {
boolean isTimedOut = false;

public void run() {
isTimedOut = true;
}
}

class CaptchaServer {
static String captcha;

static BufferedImage createCaptcha() {
BufferedImage bImg = new BufferedImage(200, 200, BufferedImage.TYPE_INT_RGB);
Graphics g = bImg.getGraphics();

Random r = new Random();
captcha = new String();
for(int i=0 ; i<6 ; i++) {
captcha += r.nextInt(10);
}
g.drawString(captcha,r.nextInt(100),r.nextInt(140)+20);
g.setColor(Color.WHITE);
for(int i=0 ; i<25 ; i++) {
if(r.nextInt(2) == 0) {
if(r.nextInt(2) == 1) {
g.drawLine(0, r.nextInt(200), 200, r.nextInt(200));
} else {
g.drawLine(0, r.nextInt(200), r.nextInt(200), 200);
}
} else {
if(r.nextInt(2) == 1) {
g.drawLine(r.nextInt(200), 0, 200, r.nextInt(200));
} else {
g.drawLine(r.nextInt(200), 0, r.nextInt(200), 200);
}
}
}

return bImg;
}

public static void main(String args[]) throws Exception {
ServerSocket serverSocket = new ServerSocket(7777);
System.out.println("Server running and waiting for client…   ");
System.out.println();
Socket clientSocket = serverSocket.accept();
ObjectOutputStream objectOut = new ObjectOutputStream(clientSocket.getOutputStream());
PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

BufferedImage i = createCaptcha();
System.out.println("Sending CAPTCHA…  ");
System.out.println();
ImageIO.write(i, "JPG", clientSocket.getOutputStream());
clientSocket.close();
clientSocket = serverSocket.accept();
out = new PrintWriter(clientSocket.getOutputStream(), true);
in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

TimeOutTask task = new TimeOutTask();
Timer t = new Timer();
t.schedule(task, 15000L);

String newCaptcha = in.readLine();
if(task.isTimedOut) {
out.println("Time out!");
} else if(!newCaptcha.equals(captcha)) {
out.println("Incorrect OTP!");
} else {
out.println("Logged In!");
}

in.close();
out.close();
clientSocket.close();
serverSocket.close();
System.exit(0);
}
}