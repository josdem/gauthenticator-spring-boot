package com.jos.dem.authenticator.util

import org.springframework.stereotype.Component

import com.warrenstrange.googleauth.GoogleAuthenticator

@Component
class GoogleAuthenticatorFactory {

  GoogleAuthenticator createGoogleAuthenticator(){
    new GoogleAuthenticator()
  }

}

