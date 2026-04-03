package com.evolve.framework.captcha;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import com.google.code.kaptcha.BackgroundProducer;
import com.google.code.kaptcha.util.Configurable;

/**
 * 赛博科技风格验证码背景 (Cyber-Tech Captcha Background)
 * 
 * @author evolve
 */
public class CyberTechBackground extends Configurable implements BackgroundProducer
{
    @Override
    public BufferedImage addBackground(BufferedImage baseImage)
    {
        int width = baseImage.getWidth();
        int height = baseImage.getHeight();

        BufferedImage imageWithBackground = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D graph = (Graphics2D) imageWithBackground.getGraphics();
        graph.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // 1. 绘制深色背景梯度 (Deep Navy to Slate Gradient) - 匹配 Cyber-Tech 主题
        GradientPaint gradient = new GradientPaint(0, 0, new Color(15, 23, 42), width, height, new Color(30, 41, 59));
        graph.setPaint(gradient);
        graph.fillRect(0, 0, width, height);

        // 2. 绘制装饰性科技网格 (Cyber-Tech Grid Lines)
        graph.setColor(new Color(37, 173, 181, 30)); // #25ADB5 with low opacity
        for (int i = 0; i < width; i += 20)
        {
            graph.drawLine(i, 0, i, height);
        }
        for (int i = 0; i < height; i += 20)
        {
            graph.drawLine(0, i, width, i);
        }

        // 3. 将文字层绘制到背景上 (Draw the word image onto the background)
        graph.drawImage(baseImage, 0, 0, null);
        graph.dispose();

        return imageWithBackground;
    }
}
