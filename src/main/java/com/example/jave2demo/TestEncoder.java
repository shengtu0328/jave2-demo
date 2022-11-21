package com.example.jave2demo;

import ws.schild.jave.Encoder;
import ws.schild.jave.MultimediaObject;
import ws.schild.jave.encode.AudioAttributes;
import ws.schild.jave.encode.EncodingAttributes;
import ws.schild.jave.encode.VideoAttributes;

import java.io.File;

public class TestEncoder {
    public static final String INPUT = "G:\\ffmpeg\\input.mp4";
    public static final String OUTPUT = "G:\\ffmpeg\\output.avi";


    public static void main(String[] args) {
        boolean succeeded;
        try {
            File source = new File(INPUT);
            File target = new File(OUTPUT);

            AudioAttributes audio =new AudioAttributes();

            //Audio Attributes
            VideoAttributes video = new VideoAttributes();
            video.setBitRate(19000);

            //Encoding attributes
            EncodingAttributes attrs = new EncodingAttributes();
            attrs.setOutputFormat("mp4");
            attrs.setVideoAttributes(video);
            attrs.setAudioAttributes(audio);

            //Encode
            Encoder encoder = new Encoder();
            encoder.encode(new MultimediaObject(source), target, attrs);

        } catch (Exception ex) {
            ex.printStackTrace();
            succeeded = false;
        }
    }
}
