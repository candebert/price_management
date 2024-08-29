package com.gft.price_management.delivery

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class HomeController {

    @RequestMapping("/")
    fun index(): String = "redirect:swagger-ui.html"
}
