package com.db.service;

import com.db.entity.Goods;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author swedsn
 * @version 1.0
 * @date 2022-12-18 23:37
 */
public interface StatisticService {
    Double[] getStatisticList();

    List<Map<Object, Object>> getStatisticTable();

    ArrayList<Object> getStatisticEcharts();

    List<Goods> getHotSale();

    List<Goods> getNewGoods();
}
