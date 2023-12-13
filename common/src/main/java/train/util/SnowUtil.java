package train.util;

import cn.hutool.core.util.IdUtil;

public class SnowUtil {
//雪花算法生成数据库id
    private static long dataCenterId = 1;  //数据中心
    private static long workerId = 1;     //机器标识

            public static long getSnowflakeNextId() {
                return IdUtil.getSnowflake(workerId, dataCenterId).nextId();
            }

            public static String getSnowflakeNextIdStr() {
                return IdUtil.getSnowflake(workerId, dataCenterId).nextIdStr();
            }
}
