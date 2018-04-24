package ltd.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/*
 * 天气配置
 *
 * songshu 2017/11/23 14:16
 */
@Component
@ConfigurationProperties(prefix = "weather")
public class WeatherConfig {

    private String weatherurl;
    private String username;
    private String userkey;

    public String getUserkey() {
        return userkey;
    }

    public void setUserkey(String userkey) {
        this.userkey = userkey;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getWeatherurl() {
        return weatherurl;
    }

    public void setWeatherurl(String weatherurl) {
        this.weatherurl = weatherurl;
    }
}
