package com.evolve.web.controller.common;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import jakarta.annotation.Resource;
import javax.imageio.ImageIO;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FastByteArrayOutputStream;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.google.code.kaptcha.Producer;
import com.evolve.common.config.EvolveConfig;
import com.evolve.common.constant.CacheConstants;
import com.evolve.common.constant.Constants;
import com.evolve.common.core.domain.AjaxResult;
import com.evolve.common.core.redis.RedisCache;
import com.evolve.common.utils.sign.Base64;
import com.evolve.common.utils.uuid.IdUtils;
import com.evolve.system.service.ISysConfigService;

/**
 * 验证码操作处理
 *
 * @author evolve
 */
@RestController
@RequestMapping("/admin/common")
public class CaptchaController
{
    @Resource(name = "captchaProducer")
    private Producer captchaProducer;

    @Resource(name = "captchaProducerMath")
    private Producer captchaProducerMath;

    @Autowired
    private RedisCache redisCache;
    
    @Autowired
    private ISysConfigService configService;
    /**
     * 生成验证码
     */
    @GetMapping("/captchaImage")
    public AjaxResult getCode(HttpServletResponse response) throws IOException
    {
        boolean captchaEnabled = configService.selectCaptchaEnabled();
        Map<String, Object> data = new HashMap<>(4);
        data.put("captchaEnabled", captchaEnabled);
        if (!captchaEnabled)
        {
            return AjaxResult.success(data);
        }

        // 保存验证码信息
        String uuid = IdUtils.simpleUUID();
        String verifyKey = CacheConstants.CAPTCHA_CODE_KEY + uuid;

        String capStr = null, code = null;
        BufferedImage image = null;

        // 生成验证码
        String captchaType = EvolveConfig.getCaptchaType();
        if ("math".equals(captchaType))
        {
            String capText = captchaProducerMath.createText();
            capStr = capText.substring(0, capText.lastIndexOf("@"));
            code = capText.substring(capText.lastIndexOf("@") + 1);
            image = captchaProducerMath.createImage(capStr);
        }
        else if ("char".equals(captchaType))
        {
            capStr = code = captchaProducer.createText();
            image = captchaProducer.createImage(capStr);
        }

        redisCache.setCacheObject(verifyKey, code, Constants.CAPTCHA_EXPIRATION, TimeUnit.MINUTES);
        // 转换流信息写出
        FastByteArrayOutputStream os = new FastByteArrayOutputStream();
        try
        {
            ImageIO.write(image, "jpg", os);
        }
        catch (IOException e)
        {
            return AjaxResult.error(e.getMessage());
        }
        data.put("uuid", uuid);
        data.put("img", "data:image/jpg;base64," + Base64.encode(os.toByteArray()));

        return AjaxResult.success(data);
    }
}
