package sshibko.myblog.model.dto.mapper;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Component
public class Announce {

    private  static int announceLength;
    // # todo
    @Value("${blog.details.copyrightFrom}")
    public void setAnnounceLength(int value) {
        announceLength = value;
    }

    public static String getAnnounce(CalculatedPostDto calculatedPostDto) {
        String text = calculatedPostDto.getPost().getText();
        String result = text.length() < announceLength ? text : text.substring(0, announceLength);
        return result;
    }

    public static long getTimestamp(CalculatedPostDto calculatedPostDto) {
        LocalDateTime time = calculatedPostDto.getPost().getTime();
        return  time.toEpochSecond(ZoneOffset.UTC);
    }
}
