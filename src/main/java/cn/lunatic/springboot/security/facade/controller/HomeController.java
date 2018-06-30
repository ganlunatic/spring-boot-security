package cn.lunatic.springboot.security.facade.controller;

import cn.lunatic.springboot.security.facade.model.MessageRes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String home(Model model) {
        MessageRes res = new MessageRes("测试标题", "测试内容", "额外消息（admin可看）");
        model.addAttribute("msg", res);
        return "index";
    }

    @RequestMapping("/index")
    public String index(Model model) {
        MessageRes res = new MessageRes("Index Title", "Index Content", "Other Information");
        model.addAttribute("msg", res);
        return "index";
    }
}
