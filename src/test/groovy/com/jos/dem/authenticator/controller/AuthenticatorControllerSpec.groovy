package com.jos.dem.authenticator.service

import org.springframework.http.HttpStatus
import spock.lang.Specification

import com.jos.dem.authenticator.service.AuthenticatorService
import com.jos.dem.authenticator.controller.AuthenticatorController
import com.jos.dem.authenticator.exception.BusinessException

class AuthenticatorControllerSpec extends Specification {

  AuthenticatorController controller = new AuthenticatorController()

  AuthenticatorService service = Mock(AuthenticatorService)

  def setup(){
    controller.service = service
  }

  void "should validate token"(){
    given:"An key and token"
      String key = 'XCJEGONC4MOOREGH'
      Integer token = 123456
    when:"We validate token"
      def result = controller.validateToken(key, token)
    then:"We expect a valid token"
      1 * service.isValidToken(key, token)
      result.getStatusCode() == HttpStatus.OK
      result.getBody() == 'OK'
  }

  void "should know is not a valid token"(){
    given:"An key and token"
      BusinessException businessException = new BusinessException("Unauthorized")
    when:"We validate token"
      def result = controller.handleException(businessException)
    then:"We expect a valid token"
      result.getStatusCode() == HttpStatus.UNAUTHORIZED
      result.getBody() == 'Unauthorized'
  }

}

