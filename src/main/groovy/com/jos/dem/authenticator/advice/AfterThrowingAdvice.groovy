package com.jos.dem.authenticator.advice

import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.AfterThrowing
import org.springframework.stereotype.Component

import com.jos.dem.authenticator.exception.BusinessException

@Aspect
@Component
class AfterThrowingAdvice {

  @AfterThrowing(pointcut = "execution(* com.jos.dem.authenticator.service..**.*(..))", throwing = "ex")
  void doRecoveryActions(RuntimeException ex){
    println "Wrapping exception ${ex}"
    throw new BusinessException(ex.getMessage(), ex)
  }

}


