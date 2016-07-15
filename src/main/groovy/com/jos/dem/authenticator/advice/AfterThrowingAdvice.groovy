package com.jos.dem.authenticator.advice

import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.AfterThrowing
import org.springframework.stereotype.Component
import org.slf4j.Logger
import org.slf4j.LoggerFactory

import com.jos.dem.authenticator.exception.BusinessException

@Aspect
@Component
class AfterThrowingAdvice {

  Logger logger = LoggerFactory.getLogger(this.class)

  @AfterThrowing(pointcut = "execution(* com.jos.dem.authenticator.service..**.*(..))", throwing = "ex")
  void doRecoveryActions(RuntimeException ex){
    logger.info "Wrapping exception ${ex}"
    throw new BusinessException(ex.getMessage(), ex)
  }

}


