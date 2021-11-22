import java.io.*;    
    import java.net.*;    
    public class URLExm {    
    public static void main(String[] args){    
    try{    
    URL url=new URL("http://sahithi-lifetour.blogspot.com/");    
    URLConnection urlcon=url.openConnection();    
    InputStream stream=urlcon.getInputStream();    
    int i;    
    while((i=stream.read())!=-1){    
    System.out.print((char)i);    
    }    
    }catch(IOException e){
    System.out.println(e);}    
    }   
  }    