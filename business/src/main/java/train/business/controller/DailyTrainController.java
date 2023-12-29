package train.business.controller;

import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import train.context.LoginMemberContext;
import train.business.req.DailyTrainQueryReq;
import train.business.resp.DailyTrainQueryResp;
import train.business.req.DailyTrainSaveReq;
import train.business.service.DailyTrainService;
import train.resp.CommonResp;
import train.resp.PageResp;

@RestController
@RequestMapping("/daily-train")
public class DailyTrainController {

    @Resource
    private DailyTrainService dailyTrainService;

    @PostMapping("/save")
    public CommonResp<Object> save(@Valid @RequestBody DailyTrainSaveReq req) {
        dailyTrainService.save(req);
        return new CommonResp<>();
    }

    @GetMapping("/query-list")
    public CommonResp<PageResp<DailyTrainQueryResp>> queryList(@Valid DailyTrainQueryReq req) {
        PageResp<DailyTrainQueryResp> list = dailyTrainService.queryList(req);
        return new CommonResp<>(list);
    }

    @DeleteMapping("/delete/{id}")
    public CommonResp<Object> delete(@PathVariable Long id) {
        dailyTrainService.delete(id);
        return new CommonResp<>();
    }

}