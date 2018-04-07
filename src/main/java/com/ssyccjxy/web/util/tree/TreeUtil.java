package com.ssyccjxy.web.util.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Description：解析树形数据工具类
 * Cteated by wangpeng
 * 2018/4/7 18:07
 */
public class TreeUtil {

    public static <E extends TreeEntity<E>> List<E> getTree(Integer topId, List<E> entityList) {

        List<E>  resultList = new ArrayList<>();

        //获取顶层元素集合
        Integer parentId;
        for (E entity : entityList) {
            parentId = entity.getPid();
            if (topId == null || topId.equals(parentId)) {
                resultList.add(entity);
            }
        }

        //获取顶层元素的子数据集合
        for (E entity : resultList) {
            entity.setChildList(getSubList(entity.getId(), entityList));
        }


        return resultList;
    }

    /**
     * 获取子数据集合
     * @param id 顶层元素id
     * @param entityList 所有元素集合
     * @param <E> 泛型
     * @return 子数据集合
     */
    private static <E extends TreeEntity<E>> List<E> getSubList(Integer id, List<E> entityList) {

        List<E> childList = new ArrayList<>();

        Integer parentId;
        //子集的直接子集
        for (E entity : entityList) {
            parentId = entity.getPid();
            if (id.equals(parentId)) {
                childList.add(entity);
            }
        }


        //子集的间接子集
        for (E entity : childList) {
            entity.setChildList(getSubList(entity.getId(), entityList));
        }

        //退出递归条件
        if (childList.size() == 0) {
            return null;
        }
        return childList;
    }
}
