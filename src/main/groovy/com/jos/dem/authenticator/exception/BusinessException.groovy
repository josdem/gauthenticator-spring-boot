package com.jos.dem.authenticator.exception

import org.springframework.core.NestedRuntimeException

class BusinessException extends NestedRuntimeException {

  BusinessException(String message){
    super(message)
  }

  BusinessException(String message, Throwable cause){
    super(message, cause)
  }

}


