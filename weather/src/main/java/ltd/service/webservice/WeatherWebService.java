package ltd.service.webservice;

import ltd.config.WeatherConfig;
import ltd.util.HttpUtils;
import org.springframework.stereotype.Service;
import sun.misc.BASE64Encoder;

import javax.annotation.Resource;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/*
 * 天气查询服务
 *
 * songshu 2017/11/23 14:14
 */
@Service
public class WeatherWebService {

    @Resource
    private WeatherConfig weatherConfig;

    /**
     * 根据城市名获取
     */
    public String getByLocation(String location) throws IOException {
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("location", location);
        params.put("username", weatherConfig.getUsername());
        params.put("t", "" + System.currentTimeMillis());
        params.put("sign", getSignature(params, weatherConfig.getUserkey()));
        return HttpUtils.sendGet(weatherConfig.getWeatherurl(), params);
    }

    /**
     * 和风天气签名生成算法
     */
    public static String getSignature(HashMap<String, String> params, String secret) throws IOException {
        // 先将参数以其参数名的字典序升序进行排序
        Map<String, String> sortedParams = new TreeMap<String, String>(params);
        Set<Map.Entry<String, String>> entrys = sortedParams.entrySet();

        // 遍历排序后的字典，将所有参数按"key=value"格式拼接在一起
        StringBuilder baseString = new StringBuilder();
        for (Map.Entry<String, String> param : entrys) {
            //sign参数 和 空值参数 不加入算法
            if (param.getValue() != null && !"".equals(param.getKey().trim()) && !"sign".equals(param.getKey().trim()) && !"".equals(param.getValue().trim())) {
                baseString.append(param.getKey().trim()).append("=").append(param.getValue().trim()).append("&");
            }
        }
        if (baseString.length() > 0) {
            baseString.deleteCharAt(baseString.length() - 1).append(secret);
        }
        // 使用MD5对待签名串求签
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] bytes = md5.digest(baseString.toString().getBytes("UTF-8"));
            return new BASE64Encoder().encode(bytes);
        } catch (GeneralSecurityException ex) {
            throw new IOException(ex);
        }
    }

}