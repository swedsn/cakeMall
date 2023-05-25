package com.db.contorller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.db.entity.Goods;
import com.db.service.StatisticService;
import com.db.service.impl.StatisticImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author swedsn
 * @version 1.0
 * @date 2022-12-18 17:03
 */

@CrossOrigin
@RestController
public class StatisticController {

    StatisticService statisticService = new StatisticImpl();

    @GetMapping("/getStatisticEcharts")
    public String getStatisticEcharts() {
        ArrayList<Object> statisticEcharts = statisticService.getStatisticEcharts();

        //int[] array = new int[]{328, 288, 358, 528, 388, 600, 100, 200, 300, 400, 500, 600};
        return JSON.toJSONString(statisticEcharts);
    }

    @GetMapping("/getStatistic")
    public JSONObject getStatistic() {
        Double[] statisticList1 = statisticService.getStatisticList();
        System.out.println(statisticList1[1]);
        JSONObject statistic = new JSONObject();
        JSONObject statisticList = new JSONObject();
        statisticList.put("dayMoney", statisticList1[0]);
        statisticList.put("monthMoney", statisticList1[1]);
        statisticList.put("daySale", statisticList1[2]);
        statisticList.put("monthSale", statisticList1[3]);
        statistic.put("statisticList", statisticList);

        return statistic;
    }

    @GetMapping("/getStatisticTable")
    public String getStatisticTable() {
        List<Map<Object, Object>> statisticList1 = statisticService.getStatisticTable();
        return JSON.toJSONString(statisticList1);
    }
    @GetMapping("/getHotSale")
    public String getHotSale() {
        List<Goods> hotSale = statisticService.getHotSale();
        return JSON.toJSONString(hotSale);
    }
    @GetMapping("/getNewGoods")
    public String getNewGoods() {
        List<Goods> newGoods = statisticService.getNewGoods();
        return JSON.toJSONString(newGoods);
    }
}
