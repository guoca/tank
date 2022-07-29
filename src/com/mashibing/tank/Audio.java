
package com.mashibing.tank;

import javax.sound.sampled.*;
import java.io.IOException;

/**
 * 音频对象
 */
public class Audio {

    private static final int BUFFER_SIZE = 1024 * 1024 * 15;
    private static final byte[] BUFFER_BYTE_ARR = new byte[BUFFER_SIZE];
    private static final int READ_LIMIT = Integer.MAX_VALUE;

    private AudioInputStream audioInputStream = null;
    private AudioFormat audioFormat = null;
    private SourceDataLine sourceDataLine = null;
    private DataLine.Info dataLine_info = null;




    /**
     * 循环播放
     */
    public void loop() {
        try {
            while (true) {
                play();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 根据文件路名构建音频对象
     * @param fileName
     */
    public Audio(String fileName) {
        try {
            //获取音频输入流
            audioInputStream = AudioSystem.getAudioInputStream(Audio.class.getClassLoader().getResource(fileName));
//            System.out.println("测试此音频输入流是否支持 mark 和 reset 方法："+audioInputStream.markSupported());
            //获取音频流的格式
            audioFormat = audioInputStream.getFormat();

            dataLine_info = new DataLine.Info(SourceDataLine.class, audioFormat);
            sourceDataLine = (SourceDataLine) AudioSystem.getLine(dataLine_info);
            // 音量控制
            //FloatControl volctrl=(FloatControl)sourceDataLine.getControl(FloatControl.Type.MASTER_GAIN);
            //volctrl.setValue(-40);//

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void play() {
        try {
            int len = 0;
            sourceDataLine.open(audioFormat, BUFFER_SIZE);
            sourceDataLine.start();

            audioInputStream.mark(READ_LIMIT);
            while ((len = audioInputStream.read(BUFFER_BYTE_ARR)) > 0) {
                sourceDataLine.write(BUFFER_BYTE_ARR, 0, len);
            }
            audioInputStream.reset();

            sourceDataLine.drain();
            sourceDataLine.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void close() {
        try {
            audioInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Audio a = new Audio("audio/explode.wav");
//        Audio a = new Audio("audio/war1.wav");
        a.play();

    }

}
