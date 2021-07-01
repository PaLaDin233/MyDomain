package xyz.zhhg.mydomain.util;

import java.net.InetAddress;

/**
 * @author 周泓钢
 * @className DoMainUtils
 * @date 2021/7/1
 */
public final class DoMainUtils {
    public static final String getIp()throws Exception{
        return AddressUtils.getV4IP();
    }
}
