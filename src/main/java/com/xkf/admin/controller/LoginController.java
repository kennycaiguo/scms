package com.xkf.admin.controller;

import com.xkf.common.WebSecurityConfig;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * 登陆注册
 */
@Controller
@RequestMapping("/admin")
public class LoginController {

//    @GetMapping("/index")
//    public String index(@SessionAttribute(WebSecurityConfig.SESSION_KEY) String account, Model model) {
////        model.addAttribute("name", account);
//        return "admin/index";
//    }

    @GetMapping("/index")
//    @ResponseBody
    public String index( Model model) {
        return "admin/index";
//        return "redirect:/admin/login";
    }

    @GetMapping("/login")
    public String login(String message, Model model) {
        model.addAttribute("message", message);

        return "admin/login";
    }

//    @PostMapping("/doLogin")
//    @ResponseBody
//    public Map<String, Object> loginPost(String account, String password, HttpSession session) {
//        Map<String, Object> map = new HashMap<>();
//        if (!"123456".equals(password)) {
//            map.put("success", false);
//            map.put("message", "密码错误");
//            return map;
//        }
//
//        // 设置session
//        session.setAttribute(WebSecurityConfig.SESSION_KEY, account);
//
//        map.put("success", true);
//        map.put("message", "登录成功");
//        return map;
//    }

    @RequestMapping(value = "/dologin", method = RequestMethod.POST)
//    @ResponseBody
    public String dologin(String userName,String password,Model model) throws UnsupportedEncodingException {
//        return "admin/dologind";
        // 处理完了之后跑到新的页面

        System.out.println("userName is:"+userName);
        System.out.println("password is:"+password);

        if (!"123456".equals(password)) {
            // http://www.cnblogs.com/wuduliantian/p/4936378.html :get请求URL传值时中文乱码解决办法
            String ss = java.net.URLEncoder.encode("用户名或密码错误","utf-8");
            return "redirect:/admin/login?message=" + ss;
        } else {
            return "redirect:/admin/index"; // 跳到新的连接
        }
//        return "redirect:/admin/index";

    }

    @GetMapping("/home")
    public String home() {
        return "admin/home";
    }


    @GetMapping("/test1")
    public String test1() {
        return "admin/test1";
    }

    @GetMapping("/test2")
    public String test2() {
        return "admin/test2";
    }
}
