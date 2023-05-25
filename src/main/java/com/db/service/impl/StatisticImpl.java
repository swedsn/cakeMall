package com.db.service.impl;

import com.db.entity.Goods;
import com.db.mapper.GoodsMapper;
import com.db.mapper.StatisticMapper;
import com.db.service.StatisticService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author swedsn
 * @version 1.0
 * @date 2022-12-18 23:38
 */
public class StatisticImpl implements StatisticService {

    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

    @Override
    public Double[] getStatisticList() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 3、获取userMapper接口的代理对象（Mapper代理开发）
        StatisticMapper statisticMapper = sqlSession.getMapper(StatisticMapper.class);
        // 4、调用方法
        double dayMoney = statisticMapper.getDayMoney();
        double monthMoney = statisticMapper.getMonthMoney();
        double daySale = statisticMapper.getDaySale();
        double monthSale = statisticMapper.getMonthSale();
        System.out.println("monthMony" + monthMoney);
        return new Double[]{dayMoney, monthMoney,daySale, monthSale};
    }

    @Override
    public List<Map<Object, Object>> getStatisticTable() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 3、获取userMapper接口的代理对象（Mapper代理开发）
        StatisticMapper statisticMapper = sqlSession.getMapper(StatisticMapper.class);
        // 4、调用方法
        List<Map<Object, Object>> allSale = statisticMapper.getAllGoods();
        List<Map<Object, Object>> statisticTable = new ArrayList<>();

        for (Map<Object, Object> map:  allSale){
            HashMap<Object, Object> statisticHashMap = new HashMap<>();
            int daySale = statisticMapper.getDayGoods((Integer) map.get("goodsID"));
            int monthSale = statisticMapper.getMonthGoods((Integer) map.get("goodsID"));
            statisticHashMap.put("goodsName", statisticMapper.getGoodsName((Integer) map.get("goodsID")));
            statisticHashMap.put("daySale", daySale);
            statisticHashMap.put("monthSale", monthSale);
            statisticHashMap.put("allSale", map.get("allSale"));
            statisticTable.add(statisticHashMap);
        }
        return statisticTable;
    }

    @Override
    public ArrayList<Object> getStatisticEcharts() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 3、获取userMapper接口的代理对象（Mapper代理开发）
        StatisticMapper statisticMapper = sqlSession.getMapper(StatisticMapper.class);
        // 4、调用方法
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, Integer.parseInt("2022"));
        cal.set(Calendar.MONTH, 0);
        int[] statisticEcharts = new int[]{};
        ArrayList<Object> statisticEchart = new ArrayList<>();
        for (int month = 1; month < 13; month++) {
            String date = sdf.format(cal.getTime());
            cal.add(Calendar.MONTH, 1);
            String allMonthMoney = statisticMapper.getAllMonthMoney(date);
            if (allMonthMoney == null){
                statisticEchart.add(0);
            }
            else statisticEchart.add(allMonthMoney);

        }
        return statisticEchart;
    }

    @Override
    public List<Goods> getHotSale() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 3、获取userMapper接口的代理对象（Mapper代理开发）
        StatisticMapper statisticMapper = sqlSession.getMapper(StatisticMapper.class);
        GoodsMapper goodsMapper = sqlSession.getMapper(GoodsMapper.class);

        // 4、调用方法
        List<Map<Object, Object>> hotSale = statisticMapper.hotSale();
        List<Goods> goodsList = new ArrayList<>();

        for (Map<Object, Object> map:  hotSale){
            HashMap<Object, Object> statisticHashMap = new HashMap<>();
            Goods goods = goodsMapper.selectGoodsByGoodsID((Integer) map.get("goodsID"));
            goodsList.add(goods);
        }
        return goodsList;
    }

    @Override
    public List<Goods> getNewGoods() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 3、获取userMapper接口的代理对象（Mapper代理开发）
        StatisticMapper statisticMapper = sqlSession.getMapper(StatisticMapper.class);
        GoodsMapper goodsMapper = sqlSession.getMapper(GoodsMapper.class);

        // 4、调用方法
        List<Map<Object, Object>> newGoods = statisticMapper.newGoods();
        List<Goods> goodsList = new ArrayList<>();

        for (Map<Object, Object> map: newGoods){
            HashMap<Object, Object> newGoodsHashMap = new HashMap<>();
            Goods goods = goodsMapper.selectGoodsByGoodsID((Integer) map.get("goodsID"));
            goodsList.add(goods);
        }
        return goodsList;
    }
}
