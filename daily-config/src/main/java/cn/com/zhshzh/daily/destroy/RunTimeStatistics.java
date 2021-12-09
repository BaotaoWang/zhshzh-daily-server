package cn.com.zhshzh.daily.destroy;

import cn.com.zhshzh.daily.core.constant.DateTimeConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 运行时长统计
 *
 * @author wangbt
 * @since 2022-01-01
 */
@Component
@Slf4j
public class RunTimeStatistics {
    /**
     * 项目启动时的时间
     */
    private static final LocalDateTime startTime;

    static {
        startTime = LocalDateTime.now();
    }

    /**
     * 项目停止时，打印项目运行时间统计
     */
    @PreDestroy
    public void printTimeStatistics() {
        // 项目结束时的时间
        LocalDateTime endTime = LocalDateTime.now();
        // 项目结束时间与启动时间的时间差
        Duration duration = Duration.between(startTime, endTime);
        // 运行的天数
        long days = duration.toDays();
        Duration minusDays = duration.minusDays(days);
        // 运行的小时数
        long hours = minusDays.toHours();
        Duration minusHours = minusDays.minusHours(hours);
        // 运行的分钟数
        long minutes = minusHours.toMinutes();
        Duration minusMinutes = minusHours.minusMinutes(minutes);
        // 运行的秒数
        long seconds = minusMinutes.toMillis() / 1000;

        DateTimeFormatter formatter = DateTimeConstants.LOCAL_DATE_TIME_FORMATTER;
        log.info("**********************************");
        log.info("项目启动时间： {}", startTime.format(formatter));
        log.info("项目结束时间： {}", endTime.format(formatter));
        log.info("项目运行时长： {}天{}小时{}分钟{}秒", days, hours, minutes, seconds);
        log.info("**********************************");
    }
}
