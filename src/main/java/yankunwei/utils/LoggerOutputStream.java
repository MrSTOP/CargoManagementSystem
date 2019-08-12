package yankunwei.utils;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.OutputStream;

public class LoggerOutputStream extends OutputStream {
    private static final int BUFFER_SIZE = 1024;
    private static final byte UTF_8_1_BYTE_MASK = (byte) 0x80;
    private static final byte UTF_8_1_BYTE_DATA = ~UTF_8_1_BYTE_MASK;
    private static final byte UTF_8_1_BYTE_RESULT = (byte) 0x00;
    private static final byte UTF_8_2_BYTE_TOP_MASK = (byte) 0xE0;
    private static final byte UTF_8_2_BYTE_TOP_DATA = ~UTF_8_2_BYTE_TOP_MASK;
    private static final byte UTF_8_2_BYTE_TOP_RESULT = (byte) 0xC0;
    private static final byte UTF_8_3_BYTE_TOP_MASK = (byte) 0xF0;
    private static final byte UTF_8_3_BYTE_TOP_DATA = UTF_8_3_BYTE_TOP_MASK;
    private static final byte UTF_8_3_BYTE_TOP_RESULT = (byte) 0xE0;
    private static final byte UTF_8_4_BYTE_TOP_MASK = (byte) 0xF8;
    private static final byte UTF_8_4_BYTE_TOP_DATA = ~UTF_8_4_BYTE_TOP_MASK;
    private static final byte UTF_8_4_BYTE_TOP_RESULT = (byte) 0xF0;
    private static final byte UTF_8_MULTI_BYTE_MASK = (byte) 0xC0;
    private static final byte UTF_8_MULTBYTE_DATA = UTF_8_MULTI_BYTE_MASK;
    private static final byte UTF_8_MULTBYTE_RESULT = (byte) 0x80;
    private final Logger logger;
    private final Level level;
    private final StringBuilder stringBuilder;
    private final byte[] buffer = new byte[BUFFER_SIZE];
    private int pos = 0;

    public LoggerOutputStream(Class<?> clazz, Level level) {
        this(LogManager.getLogger(clazz), level);
    }

    public LoggerOutputStream(String logger, Level level) {
        this(LogManager.getLogger(logger), level);
    }

    public LoggerOutputStream(Logger logger, Level level) {
        this.logger = logger;
        this.level = level;
        this.stringBuilder = new StringBuilder(2048);
    }

    @Override
    public void write(int i) throws IOException {
        char c = (char)i;
        boolean flushed = false;
        buffer[pos] = (byte) i;
        ++pos;
        if (pos == BUFFER_SIZE) {
            if (c == '\r' || c == '\n') {
                cleanCR_LF();
            }
            flush();
            flushed = true;
        }
        if (c == '\r' || c == '\n') {
            if (!flushed) {
                cleanCR_LF();
            }
            flush();
            if (stringBuilder.length() > 0) {
                logger.log(level, stringBuilder.toString());
                stringBuilder.setLength(0);
            }
        }
    }

    @Override
    public void flush() throws IOException {
        boolean isFullChar = false;
        boolean findFinish = false;
        int copyCount = 0;
        int lastPos = pos - 1;
        int firstPos = pos - 4;
        byte[] temp = new byte[4];
        if (pos > 4) {
            for (int i = lastPos; i >= firstPos && !findFinish; --i) {
                byte b = buffer[i];
                if (b == 0) {
                    continue;
                }
                if ((b & UTF_8_1_BYTE_MASK) == UTF_8_1_BYTE_RESULT) {
                    //logger.trace("1 Byte UTF-8");
                    if (i == lastPos) {
                        findFinish = true;
                        isFullChar = true;
                        copyCount = 0;
                    }
                }
                if ((b & UTF_8_2_BYTE_TOP_MASK) == UTF_8_2_BYTE_TOP_RESULT) {
                    //logger.trace("2 Byte UTF-8");
                    if (i == lastPos) {
                        findFinish = true;
                        isFullChar = false;
                        copyCount = 1;
                    } else if (i == lastPos - 1) {
                        findFinish = true;
                        isFullChar = true;
                        copyCount = 0;
                    }
                }
                if ((b & UTF_8_3_BYTE_TOP_MASK) == UTF_8_3_BYTE_TOP_RESULT) {
                    //logger.trace("3 Byte UTF-8");
                    if (i == lastPos) {
                        findFinish = true;
                        isFullChar = false;
                        copyCount = 1;
                    } else if (i == lastPos - 1) {
                        findFinish = true;
                        isFullChar = false;
                        copyCount = 2;
                    } else if (i == lastPos - 2) {
                        findFinish = true;
                        isFullChar = true;
                        copyCount = 0;
                    }
                }
                if ((b & UTF_8_4_BYTE_TOP_MASK) == UTF_8_4_BYTE_TOP_RESULT) {
                    //logger.trace("4 Byte UTF-8");
                    if (i == lastPos) {
                        findFinish = true;
                        isFullChar = false;
                        copyCount = 1;
                    } else if (i == lastPos - 1) {
                        findFinish = true;
                        isFullChar = false;
                        copyCount = 2;
                    } else if (i == lastPos - 2) {
                        findFinish = true;
                        isFullChar = false;
                        copyCount = 3;
                    } else if (i == lastPos - 3) {
                        findFinish = true;
                        isFullChar = true;
                        copyCount = 0;
                    }
                }
                if ((b & UTF_8_MULTI_BYTE_MASK) == UTF_8_MULTBYTE_RESULT){
                    //logger.trace("Multi Byte UTF-8");
                    ++copyCount;
                }
            }
            if (!isFullChar) {
                byteArrayCopy(buffer, lastPos - copyCount + 1, lastPos, temp, 0);
            }
            String s = new String(buffer, 0, lastPos - copyCount + 1);
            stringBuilder.append(s);
            if (!isFullChar) {
                byteArrayCopy(temp, 0, copyCount - 1, buffer, 0);
            }
            pos = copyCount;
        }
    }

    private void byteArrayCopy(byte[] src, int start, int end, byte[] dst, int offset) {
            for (int i = start, j = offset; i <= end; i++, j++) {
                dst[j] = src[i];
        }
    }

    private void cleanCR_LF() {
        buffer[pos - 1] = 0;
        --pos;
    }
}
