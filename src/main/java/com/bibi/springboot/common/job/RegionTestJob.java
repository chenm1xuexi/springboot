package com.bibi.springboot.common.job;

import com.bibi.springboot.common.util.Pagination;
import com.bibi.springboot.model.NewRegion;
import com.bibi.springboot.service.RegionService;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import net.sf.json.JSONObject;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class RegionTestJob {

    private static Logger logger = Logger.getLogger(RegionTestJob.class);

    @Autowired
    private RegionService regionService;

    /*@Scheduled(cron = "0 7 16 * * ?") //249*/
    public void testOneThread() {
        Pagination pagination = new Pagination();
        pagination.setPageSize(1000);
        pagination.setCurrentPage(1);
        long startTime = System.currentTimeMillis();
        logger.warn("begin");
        long totalCount = regionService.findAllCount();
        pagination.setTotalCount(totalCount);
        regionService.findAll(pagination);
        long endTime = System.currentTimeMillis();
        logger.warn("end time : " + (endTime - startTime));
    }

    public void testThreadPool() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        for(int i = 1; i <= 4; i++) {
            int temp = i;
                executorService.execute(new Runnable() {
                    @Override
                    public void run() {
                        Pagination pagination = new Pagination();
                        pagination.setPageSize(1000);
                        pagination.setCurrentPage(temp);
                        long totalCount = regionService.findAllCount();
                        pagination.setTotalCount(totalCount);
                        List<NewRegion> list = regionService.findAll(pagination);
                        logger.warn(Thread.currentThread().getName() + ":" + list.size());
                    }
                });
        }

        executorService.shutdown();
        }

       /* @Scheduled(cron = "0 5 16 * * ?") //3*/
        public void spendTime() throws InterruptedException {
            long startTime = System.currentTimeMillis();
            logger.warn("begin");
            testThreadPool();
            long endTime = System.currentTimeMillis();
            logger.warn("end time: " + (endTime - startTime));
        }

        @Scheduled(cron = "0 4 23 * * ?")
        public void loadRegion() {
            try {
                JsonParser jsonParser = new JsonParser();
                JsonArray jsonArray = jsonParser.parse(new FileReader("C:\\Users\\win 10\\Desktop\\region.json")).getAsJsonArray();
                for (JsonElement element : jsonArray) {
                    JSONObject jsonObject = JSONObject.fromObject(element.toString());
                    NewRegion newRegion = new NewRegion();
                    newRegion.setRegionCode(jsonObject.getString("regionCode"));
                    newRegion.setRegionName(jsonObject.getString("regionName"));
                    newRegion.setParentCode(jsonObject.getString("parentCode"));
                    newRegion.setFullName(jsonObject.getString("fullName"));
                    newRegion.setLevel(jsonObject.getInt("level"));
                    logger.warn(newRegion.toString());
                    regionService.create(newRegion);
                }
            } catch (Exception e) {
                logger.error(e.getMessage());
            }
        }

    }

