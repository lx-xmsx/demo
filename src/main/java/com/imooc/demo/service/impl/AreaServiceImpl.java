package com.imooc.demo.service.impl;

import com.imooc.demo.dao.AreaDao;
import com.imooc.demo.entity.Area;
import com.imooc.demo.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by liuxu on 2018/11/22.
 */
@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaDao areaDao;

    @Override
    public List<Area> getAreaList() {
        return areaDao.queryArea();
    }

    @Override
    public Area getAreaById(int areaId) {
        return areaDao.queryAreaById(areaId);
    }

    @Override
    @Transactional
    public boolean addArea(Area area) {
        if (area.getAreaName()!=null && !area.getAreaName().equals("")){
            area.setCreatTime(new Date());
            area.setLastEditTime(new Date());

            try{
                int insertArea = areaDao.insertArea(area);
                if (insertArea>0){
                    return  true;
                }else {
                    throw new RuntimeException("添加区域信息失败");
                }
            }catch (Exception e){
                throw new RuntimeException("添加区域信息失败"+e.getMessage());
            }

        }else {
            throw new RuntimeException("区域信息不能为空");
        }
    }

    @Override
    @Transactional
    public boolean modifyArea(Area area) {
        //判断空值,areaId不能为null
        if(area.getAreaId()!=null && area.getAreaId()>0){
            //设置默认值
            area.setLastEditTime(new Date());
            try{
                //更新区域信息
                int updateArea = areaDao.updateArea(area);
                if(updateArea>0){
                    return  true;
                }else {
                    throw new RuntimeException("更新区域信息失败");
                }
            }
            catch (Exception e){
                throw new RuntimeException("更新区域信息失败"+e.toString());
            }
        }else{
            throw new RuntimeException("更新区域信息失败");
        }
    }

    @Override
    @Transactional
    public boolean deleteArea(int areaId) {
        if (areaId>0){
           try{
               //删除区域信息
               int deleteArea = areaDao.deleteArea(areaId);
               if (deleteArea>0){
                   return  true;
               }else {
                   throw new RuntimeException("删除区域信息失败");
               }
           }catch (Exception e){
               throw new RuntimeException("删除区域信息失败"+e.toString());
           }
        } else{
            throw new RuntimeException("区域id不能为空!!!");
        }
    }
}
