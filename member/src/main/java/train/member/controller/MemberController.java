package train.member.controller;

import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import train.member.req.MemberLoginReq;
import train.member.req.MemberRegisterReq;
import train.member.req.MemberSendCodeReq;
import train.member.resp.MemberLoginResp;
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
    public CommonResp<Long>  register(@Valid MemberRegisterReq req) {
        long register = memberService.register(req);
//        CommonResp<Long>commonResp=new CommonResp<>();
//        commonResp.setContent(register);
        return new CommonResp<>(register);
    }
    @PostMapping("/send-code")
    public CommonResp<Long>  sendCode(@Valid @RequestBody MemberSendCodeReq req) {
         memberService.sendCode(req);
//        CommonResp<Long>commonResp=new CommonResp<>();
//        commonResp.setContent(register);
        return new CommonResp<>();
    }
    @PostMapping("/login")
    public CommonResp<MemberLoginResp>  login(@Valid @RequestBody MemberLoginReq req) {
        MemberLoginResp resp = memberService.login(req);
        return new CommonResp<>(resp);
    }

}
