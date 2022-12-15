package com.example.jave2demo;

import ws.schild.jave.process.ffmpeg.DefaultFFMPEGLocator;

import java.io.IOException;

public class TestRuntime {

    public static void main(String[] args) throws Exception {
        DefaultFFMPEGLocator locator = new DefaultFFMPEGLocator();
        String cmd = locator.getExecutablePath() +
//                " -i /Users/videopls/develop/ffmpeg/input.avi -c:v libx264 -c:a aac -strict -2 -f hls -hls_list_size 2 -hls_time 15 /Users/videopls/develop/ffmpeg/m3u8out/output.m3u8";

        " -i /Users/videopls/develop/ffmpeg/input.avi -vf fps=1/1  /Users/videopls/develop/ffmpeg/input.avi.%d.jpg";

        System.out.println("cmd======"+cmd);
        try {
            Runtime runtime = Runtime.getRuntime();
            Process process = runtime.exec(cmd);
//            Process p=Runtime.getRuntime().exec(command1);
            process.waitFor();
        }catch (IOException ioe){
            throw ioe;
        }catch (InterruptedException ie){
            throw ie;
        }
        System.out.println("结束了");

    }
}
