package com.jos.dem.authenticator.service

interface AuthenticatorService {

  String generateKey()
  Boolean isValidToken(String key, Integer token)

}

