package xyz.zhhg.mydomain;

import xyz.zhhg.mydomain.util.EncrypDES;

/**
 * @author 周泓钢
 * @className Config
 * @date 2021/7/1
 */
public final class Config {
    private Config(){}
    public static final String accessKeyId = "6ce241bbafd45ad1754ce235b1edef211348f013ffad72c652c8f879ac8640e8";
    public static final String accessKeySecret = "6e1dc76b78b42c0d164b09154c2c5c722f08739ba860d955e2ac82f5d96d8840";
    public static final String recordId = "bb3a799190b5304fb1a859e93dab1907155bd02bd7ebd9a3";

    public static final int TASK_CYCLE_TIME = 1000*60;//定时任务循环时间


    public static final String privateKey = "8879576aa";//项目解密密钥

    public static final String getAccessKeyId(){
        try {
            EncrypDES des2 = new EncrypDES(Config.privateKey);
            return des2.decrypt(accessKeyId);
        } catch (Exception e) {
            return "";
        }
    }

    public static final String getAccessKeySecret(){
        try {
            EncrypDES des2 = new EncrypDES(Config.privateKey);
            return des2.decrypt(accessKeySecret);
        } catch (Exception e) {
            return "";
        }
    }

    public static final String getRecordId(){
        try {
            EncrypDES des2 = new EncrypDES(Config.privateKey);
            return des2.decrypt(recordId);
        } catch (Exception e) {
            return "";
        }
    }

}
