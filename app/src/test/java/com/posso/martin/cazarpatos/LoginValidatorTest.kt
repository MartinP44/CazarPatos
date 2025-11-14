package com.posso.martin.cazarpatos

import org.junit.Test
import org.junit.Assert.*

/**
 * Unit tests for LoginValidator
 */
class LoginValidatorTest {
    
    @Test
    fun validEmail_returnsTrue() {
        assertTrue(LoginActivity.isValidEmail("user@example.com"))
        assertTrue(LoginActivity.isValidEmail("test.user@domain.co.uk"))
        assertTrue(LoginActivity.isValidEmail("name+tag@example.org"))
    }
    
    @Test
    fun invalidEmail_returnsFalse() {
        assertFalse(LoginActivity.isValidEmail(""))
        assertFalse(LoginActivity.isValidEmail("notanemail"))
        assertFalse(LoginActivity.isValidEmail("@example.com"))
        assertFalse(LoginActivity.isValidEmail("user@"))
        assertFalse(LoginActivity.isValidEmail("user @example.com"))
    }
    
    @Test
    fun validPassword_returnsTrue() {
        assertTrue(LoginActivity.isValidPassword("12345678"))
        assertTrue(LoginActivity.isValidPassword("password"))
        assertTrue(LoginActivity.isValidPassword("MySecureP@ss123"))
        assertTrue(LoginActivity.isValidPassword("verylongpassword"))
    }
    
    @Test
    fun invalidPassword_returnsFalse() {
        assertFalse(LoginActivity.isValidPassword(""))
        assertFalse(LoginActivity.isValidPassword("short"))
        assertFalse(LoginActivity.isValidPassword("1234567"))
        assertFalse(LoginActivity.isValidPassword("Pass@1"))
    }
    
    @Test
    fun passwordWithExactly8Characters_returnsTrue() {
        assertTrue(LoginActivity.isValidPassword("12345678"))
    }
    
    @Test
    fun passwordWith7Characters_returnsFalse() {
        assertFalse(LoginActivity.isValidPassword("1234567"))
    }
}
