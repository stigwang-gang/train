package train.member.service;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.RandomUtil;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import train.exception.BusinessException;
import train.exception.BusinessExceptionEnum;
import train.member.domain.Member;
import train.member.domain.MemberExample;
import train.member.mapper.MemberMapper;
import train.member.req.MemberRegisterReq;
import train.member.req.MemberSendCodeReq;
import train.util.SnowUtil;

import java.util.List;
import java.util.Random;

@Service
public class MemberService {
    private static final Logger LOG = LoggerFactory.getLogger(MemberService.class);
@Resource
    private MemberMapper memberMapper;
        public int count(){
            return Math.toIntExact(memberMapper.countByExample(null));
        }
        public long  register(MemberRegisterReq req){
            String mobile=req.getMobile();
            MemberExample memberExample = new MemberExample();
            memberExample.createCriteria().andMobileEqualTo(mobile);
            List<Member> list = memberMapper.selectByExample(memberExample);
                if (CollUtil.isNotEmpty(list)) {           // return list.get(0).getId();
                    throw new BusinessException(BusinessExceptionEnum.MEMBER_MOBILE_EXIST);
                }
            Member member=new Member();
            member.setId(SnowUtil.getSnowflakeNextId());
            member.setMobile(mobile);
            memberMapper.insert(member);
            return member.getId();
        }

    public void  sendCode(MemberSendCodeReq req){
        String mobile=req.getMobile();
        MemberExample memberExample = new MemberExample();
        memberExample.createCriteria().andMobileEqualTo(mobile);
        List<Member> list = memberMapper.selectByExample(memberExample);
        //如果手机号不存在插入
        if (CollUtil.isEmpty(list)) {
            LOG.info("如果手机号不存在插入");
            // return list.get(0).getId();
            Member member=new Member();
            member.setId(SnowUtil.getSnowflakeNextId());
            member.setMobile(mobile);
            memberMapper.insert(member);
        }else {
            LOG.info("如果手机号存在不插入");
        }
        //生成验证码
        String code = RandomUtil.randomString(4);
        LOG.info("生成短信验证码:{}",code);
        //保存短信记录表：手机号，短信验证码，有效期，是否已使用，业务类型，发送时间，使用时间
        LOG.info("保存短信记录表");
        //对接短信通道发送短信
        LOG.info("对接短信通道发送短信");
    }
}
