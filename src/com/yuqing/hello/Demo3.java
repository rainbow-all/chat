package com.yuqing.hello;

import java.io.*;
import java.net.Socket;

public class Demo3 {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 10080);
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("HelloWorld-app\\clientdir\\LL.JPG"));
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        byte[] bytes = new byte[1024];
        int len;
        while ((len = bis.read(bytes)) != -1) {
            bos.write(bytes, 0, len);
        }
        socket.shutdownOutput();
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String line = br.readLine();
        System.out.println(line);
        socket.close();

    }
}

