package xyz.zhhg.mydomain.service;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.profile.DefaultProfile;
import com.google.gson.Gson;
import java.util.*;
import com.aliyuncs.alidns.model.v20150109.*;
import sun.net.util.IPAddressUtil;
import xyz.zhhg.mydomain.Config;
import xyz.zhhg.mydomain.util.DoMainUtils;

public class UpdateDomainRecordService {

    public static String currentIp = "";

    public static void update(UpdateDomainRecordRequest request) {
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", Config.getAccessKeyId(), Config.getAccessKeySecret());
        IAcsClient client = new DefaultAcsClient(profile);

        request.setRegionId("cn-hangzhou");
        request.setRecordId(Config.getRecordId());
        request.setRR("test");
        request.setType("A");

        try {
            UpdateDomainRecordResponse response = client.getAcsResponse(request);
            System.out.println(new Gson().toJson(response));
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            System.out.println("ErrCode:" + e.getErrCode());
            System.out.println("ErrMsg:" + e.getErrMsg());
            System.out.println("RequestId:" + e.getRequestId());
        }

    }

    public static void updateForHostIp() throws Exception {
        //获取当前ip
        String ip = DoMainUtils.getIp();
        System.out.println("当前ip:"+ip);
        System.out.println("上一次ip:"+currentIp);
        if (ip.equals(currentIp)) {
            return;
        }
        //判断ip是否变更
        currentIp = ip;
        UpdateDomainRecordRequest updateDomainRecordRequest = new UpdateDomainRecordRequest();
        updateDomainRecordRequest.setValue(ip);
        update(updateDomainRecordRequest);
    }


}
