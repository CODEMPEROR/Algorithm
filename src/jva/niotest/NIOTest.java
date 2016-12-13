package jva.niotest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.InetSocketAddress;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SelectableChannel;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

/**
 * Created by feng on 2016/10/13.
 */
public class NIOTest {

    public static void main(String[] args) {
        NIOTest nio = new NIOTest();
        //nio.readFromFileChannel();
        //nio.writeToFileChannle();
        //nio.transfer();
        nio.socketChannel();
    }

    /**
     * 从本地文件获取Channel,然后通过channel读取文件
     */
    private void readFromFileChannel() {
        try {
            RandomAccessFile aFile = new RandomAccessFile("/Users/feng/IdeaProjects/Alog/src/jva/niotest/NIOTest.java", "r");
            FileChannel fileChannel = aFile.getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            while (fileChannel.read(buffer) != -1) {
                buffer.flip();
                while (buffer.hasRemaining()) {
                    System.out.print((char) buffer.get());
                }
                buffer.clear();
            }
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

    private void writeToFileChannle() {
        try {
            File file = new File("/Users/feng/IdeaProjects/Alog/src/jva/niotest/writeToFileChannle.txt");
            if (!file.exists()) file.createNewFile();
            RandomAccessFile wFile = new RandomAccessFile(file, "rws");
            FileChannel wChannel = wFile.getChannel();
            RandomAccessFile aFile = new RandomAccessFile("/Users/feng/IdeaProjects/Alog/src/jva/niotest/NIOTest.java", "r");
            FileChannel rChannel = aFile.getChannel();

            wChannel.transferFrom(rChannel, 0, rChannel.size());

            ByteBuffer rBuffer = ByteBuffer.allocate(512);

            while (rChannel.read(rBuffer) != -1) {
                rBuffer.flip();
                while (rBuffer.hasRemaining()) {
                    wChannel.write(rBuffer);
                }
            }
            wChannel.force(true);
            wChannel.close();
            rChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void transfer() {
        try {
            File file = new File("/Users/feng/IdeaProjects/Alog/src/jva/niotest/writeToFileChannle.txt");
            if (!file.exists()) file.createNewFile();
            RandomAccessFile wFile = new RandomAccessFile(file, "rws");
            FileChannel wChannel = wFile.getChannel();
            RandomAccessFile aFile = new RandomAccessFile("/Users/feng/IdeaProjects/Alog/src/jva/niotest/NIOTest.java", "r");
            FileChannel rChannel = aFile.getChannel();

            wChannel.transferFrom(rChannel, 0, rChannel.size());

            wChannel.close();
            rChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void socketChannel() {

        new Thread() {
            @Override
            public void run() {
                super.run();
                try {
                    SocketChannel sc = SocketChannel.open(new InetSocketAddress("121.199.29.178", 8080));
                    sc.configureBlocking(false);
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    while (sc.read(buffer) != -1) {
                        buffer.flip();
                        while (buffer.hasRemaining()) {
                            System.out.print((char) buffer.get());
                        }
                    }
                    sc.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();

    }

    private void serverSocketChannle(){

    }

}
