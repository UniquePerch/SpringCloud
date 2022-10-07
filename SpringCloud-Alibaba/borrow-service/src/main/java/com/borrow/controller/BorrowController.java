package com.borrow.controller;

import com.alibaba.fastjson.JSONObject;
import com.borrow.entity.UserBorrowDetail;
import com.borrow.service.BorrowService;
import com.test.eneity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Collections;

@RestController
public class BorrowController {
    @Resource
    BorrowService service;

    @RequestMapping("/borrow/{uid}")
    UserBorrowDetail findUserBorrows(@PathVariable("uid") int uid){
        return service.getUserBorrowDetailByUid(uid);
    }

    @RequestMapping("/borrow/take/{uid}/{bid}")
    JSONObject borrow(@PathVariable("uid") int uid,@PathVariable("bid") int bid){
        service.doBorrow(uid, bid);
        JSONObject object = new JSONObject();
        object.put("code", "200");
        object.put("success", false);
        object.put("message", "借阅成功！");
        return object;
    }
}
