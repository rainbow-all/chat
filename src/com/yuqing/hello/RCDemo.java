package com.yuqing.hello;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class RCDemo {
    public static void main(String[] args) throws IOException {
        ServerSocket ss=new ServerSocket(10080);
        Socket socket=ss.accept();

        BufferedInputStream bis=new BufferedInputStream(socket.getInputStream());
        BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream("HelloWorld-app\\serverdir\\SS.JPG"));
        int len;
        byte[] bytes=new byte[1024];
        while((len=bis.read(bytes))!=-1){
            bos.write(bytes,0,len);
        }
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bw.write("上传成功");
        bw.newLine();
        bw.flush();

        socket.close();
        ss.close();

    }
}
