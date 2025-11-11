package com.posso.martin.cazarpatos

import org.junit.Test
import org.junit.Assert.*

/**
 * Unit tests for LoginValidator
 */
class LoginValidatorTest {
    
    @Test
    fun validEmail_returnsTrue() {
        assertTrue(LoginValidator.isValidEmail("user@example.com"))
        assertTrue(LoginValidator.isValidEmail("test.user@domain.co.uk"))
        assertTrue(LoginValidator.isValidEmail("name+tag@example.org"))
    }
    
    @Test
    fun invalidEmail_returnsFalse() {
        assertFalse(LoginValidator.isValidEmail(""))
        assertFalse(LoginValidator.isValidEmail("notanemail"))
        assertFalse(LoginValidator.isValidEmail("@example.com"))
        assertFalse(LoginValidator.isValidEmail("user@"))
        assertFalse(LoginValidator.isValidEmail("user @example.com"))
    }
    
    @Test
    fun validPassword_returnsTrue() {
        assertTrue(LoginValidator.isValidPassword("12345678"))
        assertTrue(LoginValidator.isValidPassword("password"))
        assertTrue(LoginValidator.isValidPassword("MySecureP@ss123"))
        assertTrue(LoginValidator.isValidPassword("verylongpassword"))
    }
    
    @Test
    fun invalidPassword_returnsFalse() {
        assertFalse(LoginValidator.isValidPassword(""))
        assertFalse(LoginValidator.isValidPassword("short"))
        assertFalse(LoginValidator.isValidPassword("1234567"))
        assertFalse(LoginValidator.isValidPassword("Pass@1"))
    }
    
    @Test
    fun passwordWithExactly8Characters_returnsTrue() {
        assertTrue(LoginValidator.isValidPassword("12345678"))
    }
    
    @Test
    fun passwordWith7Characters_returnsFalse() {
        assertFalse(LoginValidator.isValidPassword("1234567"))
    }
}
