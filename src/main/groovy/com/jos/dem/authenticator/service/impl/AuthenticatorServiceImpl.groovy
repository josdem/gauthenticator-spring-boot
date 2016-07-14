package com.jos.dem.authenticator.service.impl

import org.springframework.stereotype.Service
import org.springframework.beans.factory.annotation.Autowired

import com.warrenstrange.googleauth.GoogleAuthenticatorKey
import com.warrenstrange.googleauth.GoogleAuthenticator

import com.jos.dem.authenticator.service.AuthenticatorService
import com.jos.dem.authenticator.util.GoogleAuthenticatorFactory
import com.jos.dem.authenticator.exception.AuthenticationException

@Service
class AuthenticatorServiceImpl implements AuthenticatorService {

  @Autowired
  GoogleAuthenticatorFactory factory

  String generateKey(){
    GoogleAuthenticator gAuth = factory.createGoogleAuthenticator()
    final GoogleAuthenticatorKey key = gAuth.createCredentials()
    key.getKey()
  }

  Boolean isValidToken(String key, Integer token){
    GoogleAuthenticator gAuth = factory.createGoogleAuthenticator()
    if(!gAuth.authorize(key, token)){
      throw new AuthenticationException()
    }
  }

}

