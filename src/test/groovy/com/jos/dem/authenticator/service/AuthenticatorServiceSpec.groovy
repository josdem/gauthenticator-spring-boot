package com.jos.dem.authenticator.service

import com.warrenstrange.googleauth.GoogleAuthenticator
import com.warrenstrange.googleauth.GoogleAuthenticatorKey
import org.springframework.boot.test.SpringApplicationContextLoader
import org.springframework.boot.test.IntegrationTest
import org.springframework.test.context.ContextConfiguration
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.web.WebAppConfiguration
import spock.lang.Specification

import com.jos.dem.authenticator.AuthenticatorApplication
import com.jos.dem.authenticator.service.AuthenticatorService
import com.jos.dem.authenticator.service.impl.AuthenticatorServiceImpl
import com.jos.dem.authenticator.util.GoogleAuthenticatorFactory
import com.jos.dem.authenticator.exception.BusinessException

@ContextConfiguration(loader = SpringApplicationContextLoader.class, classes = AuthenticatorApplication.class)
@IntegrationTest
@WebAppConfiguration
class AuthenticatorServiceSpec extends Specification {

  @Autowired
  AuthenticatorService service

  void "should generate key"(){
    when:"We generate key"
      String result = service.generateKey()
    then:"We expect a new key"
      result.length() == 16
  }

  void "should verify token"(){
    given:"A key"
      String key = service.generateKey()
    when:"We validate a token"
      Boolean result = service.isValidToken(key, 123456)
    then:"We expect fase"
      thrown BusinessException
  }

}

