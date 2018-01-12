package com.cuiniaobao.service.mapper;

import com.cuiniaobao.service.model.Agent;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created: 2018-01-12 11:30:12
 *
 * @author  Michael.Zhang
 */
@Mapper
public interface AgentMapper extends BaseMapper<Agent> {

    void updateLogin(Agent agent);

    void updateLockOrNot(Agent agent);

    Agent selectByLoginName(String loginName);

    List<Agent> selectAll();

}
