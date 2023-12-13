package train.member.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import train.member.req.MemberRegisterReq;
import train.member.service.MemberService;
import train.resp.CommonResp;

@RestController
@RequestMapping("/member")
public class MemberController {
    @Resource
    private MemberService memberService;
    @GetMapping("/count")
    public CommonResp<Integer> count() {
        int count = memberService.count();
//        CommonResp<Integer>commonResp=new CommonResp<>();
//        commonResp.setContent(count);
        return new CommonResp<>(count);
    }

    @PostMapping("/register")
    public CommonResp<Long>  register(MemberRegisterReq req) {
        long register = memberService.register(req);
//        CommonResp<Long>commonResp=new CommonResp<>();
//        commonResp.setContent(register);
        return new CommonResp<>(register);
    }
}
