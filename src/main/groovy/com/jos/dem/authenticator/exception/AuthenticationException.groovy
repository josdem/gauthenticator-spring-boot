package com.modulus.uno.authenticator.exception

import java.lang.RuntimeException

class AuthenticationException extends RuntimeException {

  @Override
  String getMessage() {
    'Authentification failed'
  }

}


