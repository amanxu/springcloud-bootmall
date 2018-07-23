package com.product.service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: niexx <br>
 * @date: 2018-06-24 12:41 <br>
 */
@RestController
public class ServerController {

    @GetMapping("/msg")
    public String msg() {

        return "Server-Controller-Msg";
    }
}
