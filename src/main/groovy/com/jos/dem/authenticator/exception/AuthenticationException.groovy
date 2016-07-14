package com.jos.dem.authenticator.exception

import java.lang.RuntimeException

class AuthenticationException extends RuntimeException {

  @Override
  String getMessage() {
    'Authentification failed'
  }

}


