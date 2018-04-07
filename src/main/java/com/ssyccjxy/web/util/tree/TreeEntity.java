package com.ssyccjxy.web.util.tree;

import java.util.List;

/**
 * Description：树形数据实体接口
 * Cteated by wangpeng
 * 2018/4/7 18:13
 */
public interface TreeEntity<E> {

    public Integer getId();

    public Integer getPid();

    public void setChildList(List<E> childList);
}
