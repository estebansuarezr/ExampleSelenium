package com.arreglatech.project.utils.gif;

import com.arreglatech.project.utils.logs.LogUtil;
import com.arreglatech.project.utils.time.WaitUtil;
import com.madgag.gif.fmsware.AnimatedGifEncoder;
import lombok.experimental.UtilityClass;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * Spoiler (.gif evidence)
 * <[SPOILER_GIF_EVIDENCE]>
 */
@UtilityClass
public class GifUtil {

    public static void createGif(List<File> imageFiles, File output) throws IOException
    {
        try (FileOutputStream fos = new FileOutputStream(output))
        {
            AnimatedGifEncoder gifEncoder = new AnimatedGifEncoder();
            gifEncoder.start(fos);
            gifEncoder.setDelay(200); // 100ms delay between frames
            gifEncoder.setRepeat(0);  // infinite loop
            int retry = 5;

            for (File imageFile : imageFiles) {
                for(int i=0; i<retry ; i++)
                {
                    try {
                        BufferedImage bufImage = ImageIO.read(imageFile);
                        gifEncoder.addFrame(bufImage);
                        bufImage.flush();
                        break;
                    } catch (Exception e) {
                        LogUtil.error(e);
                        if(i!=(retry-1)) {
                            WaitUtil.stopFor(500);
                        }
                    }
                }
            }

            gifEncoder.finish();
        }
    }

}



