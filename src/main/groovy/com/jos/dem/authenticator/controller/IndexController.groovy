package com.jos.dem.authenticator.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class IndexController {

  @RequestMapping("/")
  String index(){
    'index'
  }

}
