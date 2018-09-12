package com.bibi.springboot.common.job;

import com.bibi.springboot.common.util.OkHttpUtil;
import com.bibi.springboot.model.Region;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.jboss.logging.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class RegionGBJob {

    private static Logger logger = Logger.getLogger(RegionGBJob.class);
    private static List<Region> list = new ArrayList<>();

   /* @Scheduled(cron = "0 0 0 * * ?")*/
    public void loadRegionData(int skip, int temp) {
        loadAllDataByRecursion(skip, temp);
    }

    public void loadAllDataByRecursion(int skip, int temp) {
        if ((temp+1)*100000 - skip <= 0) {
            return;
        }
        Map<String, Object> params = new HashMap<>();
        params.put("skip", skip);
        params.put("limit", 1000);
        String responseBody = OkHttpUtil.get("http://39.104.128.226:5080/ARGO/argo_regions/1.0.0/region", params);
        JSONObject jsonObject = JSONObject.fromObject(responseBody);
        int total = (int)jsonObject.get("total");
        JSONArray data = jsonObject.getJSONArray("data");
        for(int i = 0; i < data.size(); i++) {
            JSONObject jo = data.getJSONObject(i);
            Integer level = (Integer) jo.get("level");
            String regionCode = null;
            String regionName = null;
            String parentCode = null;
            String fullName = null;
            if (level == 1) {
                regionCode = (String) jo.get("LV1CODE");
                regionName = (String) jo.get("LV1NAME");
                parentCode = (String) "00";
                fullName = (String) jo.get("FULLNAME");
            } else if (level == 2) {
                regionCode = (String) jo.get("LV1CODE") + (String) jo.get("LV2CODE");
                regionName = (String) jo.get("LV2NAME");
                parentCode = (String) jo.get("LV1CODE");
                fullName = (String) jo.get("FULLNAME");
            } else if (level == 3) {
                regionCode = (String) jo.get("LV1CODE") + (String) jo.get("LV2CODE") + (String) jo.get("LV3CODE");
                regionName = (String) jo.get("LV3NAME");
                parentCode = (String) jo.get("LV1CODE") + (String) jo.get("LV2CODE");
                fullName = (String) jo.get("FULLNAME");
            } else if (level == 4) {
                regionCode = (String) jo.get("LV1CODE") + (String) jo.get("LV2CODE") + (String) jo.get("LV3CODE") + (String) jo.get("LV4CODE");
                regionName = (String) jo.get("LV4NAME");
                parentCode = (String) jo.get("LV1CODE") + (String) jo.get("LV2CODE") + (String) jo.get("LV3CODE");
                fullName = (String) jo.get("FULLNAME");
            } else {
                regionCode = (String) jo.get("LV1CODE") + (String) jo.get("LV2CODE") + (String) jo.get("LV3CODE") + (String) jo.get("LV4CODE") + (String) jo.get("LV5CODE");
                regionName = (String) jo.get("LV5NAME");
                parentCode = (String) jo.get("LV1CODE") + (String) jo.get("LV2CODE") + (String) jo.get("LV3CODE") + (String) jo.get("LV4CODE");
                fullName = (String) jo.get("FULLNAME");
            }

            Region region = new Region();
            region.setLevel(level);
            region.setRegionCode(regionCode);
            region.setRegionName(regionName);
            region.setParentCode(parentCode);
            region.setFullName(fullName);
            logger.info(region);
            list.add(region);
        }
        loadAllDataByRecursion(skip + 1000, temp);
    }

    public static void main(String[] args) throws IOException {
        RegionGBJob regionGBJob = new RegionGBJob();
        ExecutorService executorService = Executors.newFixedThreadPool(7);

        for (int i = 0; i < 7; i++) {

            int temp = i;
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    regionGBJob.loadRegionData(temp*100000, temp);
                }
            });
        }

        executorService.shutdown();

        BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\win 10\\Desktop\\region.json"));
        writer.write(JSONArray.fromObject(list).toString());
        writer.flush();
        writer.close();
    }

}
