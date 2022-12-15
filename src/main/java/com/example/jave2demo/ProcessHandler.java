package com.example.jave2demo;


import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * ref: https://blog.csdn.net/weixin_33690367/article/details/86134029
 */
@Slf4j
public class ProcessHandler {

    public static String dealStream(Process process) {
        StringBuilder builder = new StringBuilder();

        if (process == null) {
            return null;
        }
        // 处理InputStream的线程
        new Thread(() -> {
            BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            try {
                while ((line = in.readLine()) != null) {
                    builder.append(line);
                    log.info("input===: " + line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    in.close();
                } catch (IOException e) {
                    // TODO 处理出错
                    e.printStackTrace();
                }
            }
        }).start();

        // 处理ErrorStream的线程
        new Thread(() -> {
            BufferedReader err = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            String line;
            try {
                while ((line = err.readLine()) != null) {
                    builder.append(line);
                    log.info("错误---: " + line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    err.close();
                } catch (IOException e) {
                    // TODO 处理出错
                    e.printStackTrace();
                }
            }
        }).start();

        return builder.toString();
    }
}
