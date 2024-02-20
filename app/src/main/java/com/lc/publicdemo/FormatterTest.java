package com.lc.publicdemo;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;

import java.util.Locale;

/**
 * @Author: LinChen
 * @Date: 2021/10/15 1:41 下午
 */
public class FormatterTest {

    private static class FixUnits {
        private static final String UNIT_B = "字节";
        private static final String UNIT_KB = "千字节";
        private static final String UNIT_MB = "兆字节";
        private static final String UNIT_GB = "吉字节";
        private static final String UNIT_TB = "太字节";
        private static final String UNIT_PB = "拍字节";
    }

    private static class FixedUnits {
        private static final String UNIT_B = "B";
        private static final String UNIT_KB = "KB";
        private static final String UNIT_MB = "MB";
        private static final String UNIT_GB = "GB";
        private static final String UNIT_TB = "TB";
        private static final String UNIT_PB = "PB";
    }

    public static String formatFileSize(@Nullable Context context, long sizeBytes) {
        String result = formatFileSizeImpl(context, sizeBytes);

        if (TextUtils.isEmpty(result)) {
            return "";
        } else if (result.indexOf(FixUnits.UNIT_PB) > -1) {
            return result.replace(FixUnits.UNIT_PB, FixedUnits.UNIT_PB);
        } else if (result.indexOf(FixUnits.UNIT_TB) > -1) {
            return result.replace(FixUnits.UNIT_TB, FixedUnits.UNIT_TB);
        } else if (result.indexOf(FixUnits.UNIT_GB) > -1) {
            return result.replace(FixUnits.UNIT_GB, FixedUnits.UNIT_GB);
        } else if (result.indexOf(FixUnits.UNIT_MB) > -1) {
            return result.replace(FixUnits.UNIT_MB, FixedUnits.UNIT_MB);
        } else if (result.indexOf(FixUnits.UNIT_KB) > -1) {
            return result.replace(FixUnits.UNIT_KB, FixedUnits.UNIT_KB);
        } else if (result.indexOf(FixUnits.UNIT_B) > -1) {
            return result.replace(FixUnits.UNIT_B, FixedUnits.UNIT_B);
        } else {
            return result;
        }
    }

    /** * get file format size * * @param context context * @param roundedBytes file size * @return file format size (like 2.12k) */
    public static String formatFileSizeImpl(Context context, long roundedBytes) {
        return formatFileSize(context, roundedBytes, false, Locale.US);
    }

    public static String formatFileSizeImpl(Context context, long roundedBytes, Locale locale) {
        return formatFileSize(context, roundedBytes, false, locale);
    }


    private static String formatFileSize(Context context, long roundedBytes, boolean shorter, Locale locale) {
        if (context == null) {
            return "";
        }
        float result = roundedBytes;
        String suffix = "B";
        if (result > 900) {
            suffix = "KB";
            result = result / 1024;
        }
        if (result > 900) {
            suffix = "MB";
            result = result / 1024;
        }
        if (result > 900) {
            suffix = "GB";
            result = result / 1024;
        }
        if (result > 900) {
            suffix = "TB";
            result = result / 1024;
        }
        if (result > 900) {
            suffix = "PB";
            result = result / 1024;
        }
        String value;
        if (result < 1) {
            value = String.format(locale, "%.2f", result);
        } else if (result < 10) {
            if (shorter) {
                value = String.format(locale, "%.1f", result);
            } else {
                value = String.format(locale, "%.2f", result);
            }
        } else if (result < 100) {
            if (shorter) {
                value = String.format(locale, "%.0f", result);
            } else {
                value = String.format(locale, "%.2f", result);
            }
        } else {
            value = String.format(locale, "%.0f", result);
        }
        return String.format("%s%s", value, suffix);
    }
}
