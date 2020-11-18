package cn.she.dao;

import cn.she.domain.Province;

import java.util.List;

public interface ProvinceDao {
    public List<Province> findAll() throws Exception;
}
