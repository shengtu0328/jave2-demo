import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ws.schild.jave.process.ProcessWrapper;
import ws.schild.jave.process.ffmpeg.DefaultFFMPEGLocator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MediaUtil {

    private final Logger logger = LoggerFactory.getLogger(MediaUtil.class);
    static DefaultFFMPEGLocator  locator = new DefaultFFMPEGLocator();

    /**
     * ffmpeg -i cv.mp4 -vf fps=0.2 F:\ffmpegTest\img\out%d.png
     *
     * @param filePath
     * @param fps
     * @param weight
     * @param high
     * @param imgType
     * @param uniqueId
     * @throws IOException
     */
    public static void videoAllScreenshot(String videoResourcesPath, String fps, String imgType) throws IOException {


        List<String> command = new ArrayList<>();
        command.add( locator.getExecutablePath());
        command.add("-i");
        command.add(videoResourcesPath);
        command.add("-vf fps");
        command.add(1 + "/" + fps);
        command.add(videoResourcesPath + "." + "%d" + "." + imgType);


    }


    /**
     * 调用命令行执行
     *
     * @param command 命令行参数
     */
    public static void commandStart(List<String> command) throws IOException {
        StringBuffer FFmpegStr = new StringBuffer();
        command.forEach(v -> FFmpegStr.append(v).append(" "));

//        logger.info("FFmpeg 转换命令 : {} ", FFmpegStr);
        ProcessBuilder builder = new ProcessBuilder();
        //正常信息和错误信息合并输出
        builder.redirectErrorStream(true);
        builder.command(command);
        //开始执行命令
        builder.start();
        //如果你想获取到执行完后的信息，那么下面的代码也是需要的
//            String line = "";
//            BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
//            while ((line = br.readLine()) != null) {
//                System.out.println(line);
//            }
    }


}
