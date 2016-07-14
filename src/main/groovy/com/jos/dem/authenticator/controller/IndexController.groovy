package com.jos.dem.authenticator.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class IndexController {

  @RequestMapping("/")
  String index(){
    'index'
  }

  @RequestMapping("/contact")
  String contact() {
    "contact"
  }

  @RequestMapping("/two-step")
  String twoStep() {
    "two_step"
  }

}
