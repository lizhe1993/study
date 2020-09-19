package com.study.bfys._4;



import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * @className: Piped
 * @description: 通道流测试
 * @author: lz-mac
 * @date: 2020/9/2 20:49
 * @history: <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
public class Piped {

    static class Print implements Runnable {
        private PipedReader in;

        public Print(PipedReader in) {
            this.in = in;
        }

        @Override
        public void run() {
            int receive = 0;
            try {
                while ((receive = in.read()) != -1) {
                    System.out.print((char) receive);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) throws IOException {
        PipedWriter out = new PipedWriter();
        PipedReader in = new PipedReader();
        // 将输出流和输入流进行连接，否则在使用时会抛出IOException
        out.connect(in);
        Thread printThread = new Thread(new Print(in),"PrintThread");
        printThread.start();
        int receive = 0;
        try {
            while ((receive = System.in.read())!=-1){
                out.write(receive);
            }
        } finally {
            out.close();
        }
    }
}
