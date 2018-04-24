package ltd.api.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ltd.api.response.MessageResponse;
import ltd.service.MessageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by song1993 on 2017/9/27.
 */
@RestController
@RequestMapping("/message")
@Api(value = "短信", produces = "application/json")
public class MessageController {

    @Resource
    private MessageService messageService;

    @ApiOperation("获取短信历史列表")
    @GetMapping(value = "/list")
    public List<MessageResponse> list() {
        return messageService.list();
    }

}
