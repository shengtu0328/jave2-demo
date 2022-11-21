package com.example.jave2demo;

import ws.schild.jave.process.ProcessWrapper;
import ws.schild.jave.process.ffmpeg.DefaultFFMPEGLocator;

public class TestDefaultFFMPEGLocator {

    public static final String INPUT = "G:\\ffmpeg\\input.mp4";
    public static final String OUTPUT = "G:\\ffmpeg\\output.avi";

    public static void main(String[] args) {
        DefaultFFMPEGLocator locator = new DefaultFFMPEGLocator();
        ProcessWrapper localFFMPEG = locator.createExecutor();
        localFFMPEG.addArgument("-i");
        localFFMPEG.addArgument(INPUT);
        localFFMPEG.addArgument("-vb");
        localFFMPEG.addArgument("19000");
        localFFMPEG.addArgument("-movflags");
        localFFMPEG.addArgument("faststart");
        localFFMPEG.addArgument("-f");
        localFFMPEG.addArgument("mp4");
        localFFMPEG.addArgument("-y");
        localFFMPEG.addArgument(OUTPUT);
        try {
            localFFMPEG.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
