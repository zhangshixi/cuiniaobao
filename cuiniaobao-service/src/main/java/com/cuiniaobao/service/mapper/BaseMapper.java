package com.cuiniaobao.service.mapper;

import java.util.List;

/**
 * Created: 2017-12-19 20:26:04
 *
 * @author  Michael.Zhang
 */
public interface BaseMapper<T> {

    void insert(T instance);
    void batchInsert(List<T> instanceList);

    void deleteById(Long id);
    void batchDeleteById(List<Long> idList);

    int update(T instance);
    int updateSelect(T instance);

    T selectById(Long id);
    List<T> selectByIdList(List<Long> idList);
    List<T> selectByPage();

}
