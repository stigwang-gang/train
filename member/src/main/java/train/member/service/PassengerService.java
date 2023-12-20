package train.member.service;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateTime;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import train.context.LoginMemberContext;
import train.member.domain.Passenger;
import train.member.mapper.PassengerMapper;
import train.member.resp.PassengerSaveReq;
import train.util.SnowUtil;
@Service
public class PassengerService {
@Resource
private PassengerMapper passengerMapper;

public void save(PassengerSaveReq req) {
    DateTime now = DateTime.now();
    Passenger passenger = BeanUtil.copyProperties(req, Passenger.class);
    passenger.setMemberId(LoginMemberContext.getId());
    passenger.setId(SnowUtil.getSnowflakeNextId());
    passenger.setCreateTime(now);
    passenger.setUpdateTime(now);
    passengerMapper.insert(passenger);
}
}
