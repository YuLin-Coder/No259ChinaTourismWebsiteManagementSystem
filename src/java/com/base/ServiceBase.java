package com.base;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import dao.Collect;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;
import util.Request;

import java.util.List;

abstract public class ServiceBase<E> {

    abstract protected Mapper<E> getDao();
    public List<E> select() {
        return getDao().select(null);
    }

    public List<E> select(E y) {
        return getDao().select(y);
    }

    public E find(Object id) {
        return getDao().selectByPrimaryKey(id);
    }

    public E findEntity(E id)
    {
        return getDao().selectOne(id);
    }

    public List<E> selectPage(E obj, int page, int pageSize) {
        //int count = dao.selectCount(obj);


        PageHelper.startPage(page , pageSize , true);
        List<E> list = select(obj);
        PageInfo<E> pageInfo = new PageInfo<E>(list);
        new Collect(pageInfo.getTotal() , pageSize , page);
        return list;
    }

    public List<E> selectPageExample(Example obj , int page , int pageSize)
    {
        PageHelper.startPage(page , pageSize , true);
        List<E> list = getDao().selectByExample(obj);
        PageInfo<E> pageInfo = new PageInfo<E>(list);
        new Collect(pageInfo.getTotal() , pageSize , page);
        return list;
    }

    public int delete(Object id)
    {
        return getDao().deleteByPrimaryKey(id);
    }
    public int insert(E y) {
        return getDao().insert(y);
    }
    public int update(E y) {
        return getDao().updateByPrimaryKeySelective(y);
    }
}
