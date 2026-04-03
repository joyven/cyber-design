package com.evolve.framework.captcha;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import com.google.code.kaptcha.NoiseProducer;
import com.google.code.kaptcha.util.Configurable;

/**
 * 赛博科技风格干扰线 (Cyber-Tech Captcha Noise)
 * 
 * @author evolve
 */
public class CyberTechNoise extends Configurable implements NoiseProducer
{
    @Override
    public void makeNoise(BufferedImage image, float factorOne, float factorTwo, float factorThree, float factorFour)
    {
        Graphics2D graph = (Graphics2D) image.getGraphics();
        graph.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        int width = image.getWidth();
        int height = image.getHeight();

        // 绘制几条精细的青色干扰线 (Fine cyan tech lines/glitches)
        graph.setColor(new Color(37, 173, 181, 80)); // #25ADB5
        graph.setStroke(new BasicStroke(1.2f));
        
        java.util.Random rand = new java.util.Random();
        for (int i = 0; i < 3; i++)
        {
            int y1 = rand.nextInt(height);
            int y2 = rand.nextInt(height);
            graph.drawLine(0, y1, width, y2);
        }
        graph.dispose();
    }
}
