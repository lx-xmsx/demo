package com.imooc.demo.service;

import com.imooc.demo.entity.Area;

import java.util.List;

/**
 * Created by liuxu on 2018/11/22.
 */
public interface AreaService {

    List<Area> getAreaList();

    Area getAreaById (int areaId);

    boolean addArea (Area area);

    boolean modifyArea(Area area);

    boolean deleteArea (int areaId);
 }
