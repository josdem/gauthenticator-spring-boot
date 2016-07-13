package com.jos.dem.authenticator.controller

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.http.ResponseEntity
import org.springframework.http.HttpStatus
import org.springframework.beans.factory.annotation.Autowired

import com.modulus.uno.authenticator.service.AuthenticatorService
import com.modulus.uno.authenticator.exception.BusinessException

@RestController
class AuthenticatorController {

  @Autowired
  AuthenticatorService service

  @RequestMapping("generateKey")
  String generateKey(){
    service.generateKey()
  }

  @RequestMapping("validateToken/{key}/{token}")
  ResponseEntity<String> validateToken(@PathVariable String key, @PathVariable Integer token){
    try {
      service.isValidToken(key, token)
      return new ResponseEntity<String>("OK", HttpStatus.OK)
    } catch (BusinessException be){
      return new ResponseEntity<String>(be.getMessage(), HttpStatus.UNAUTHORIZED)
    }
  }

}

