package com.chilun.petStore.Util;

import java.io.IOException;
import java.util.Date;
import java.util.logging.*;

/**
 * @Title:
 * @Description:
 * @author: anthor
 * @date:2022/11/120:57
 */
class LoggerFormatter extends Formatter {

    @Override
    public String format(java.util.logging.LogRecord record) {
        return "[" + new Date() + "]" + " [" + record.getLevel() + "] "
                + record.getClass() + record.getMessage() + "\n";
    }


}

