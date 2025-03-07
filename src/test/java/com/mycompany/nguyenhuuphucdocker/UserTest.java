package com.mycompany.nguyenhuuphucdocker;

import com.mycompany.nguyenhuuphucdocker.User;
import org.junit.Test;
import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void testGetUserId() {
        // Arrange
        User user = new User("U001", "user1@example.com");
        
        // Act
        String userId = user.getUserId();
        
        // Assert
        assertEquals("U001", userId);
    }

    @Test
    public void testSetUserId() {
        // Arrange
        User user = new User("U001", "user1@example.com");
        
        // Act
        user.setUserId("U002");
        
        // Assert
        assertEquals("U002", user.getUserId());
    }

    @Test
    public void testGetEmail() {
        // Arrange
        User user = new User("U001", "user1@example.com");
        
        // Act
        String email = user.getEmail();
        
        // Assert
        assertEquals("user1@example.com", email);
    }

    @Test
    public void testSetEmail() {
        // Arrange
        User user = new User("U001", "user1@example.com");
        
        // Act
        user.setEmail("newuser1@example.com");
        
        // Assert
        assertEquals("newuser1@example.com", user.getEmail());
    }

    @Test
    public void testUpdateEmail() {
        // Arrange
        User user = new User("U001", "user1@example.com");
        
        // Act
        user.updateEmail("updateduser1@example.com");
        
        // Assert
        assertEquals("updateduser1@example.com", user.getEmail());
    }

    @Test
    public void testToString() {
        // Arrange
        User user = new User("U001", "user1@example.com");
        
        // Act
        String result = user.toString();
        
        // Assert
        assertEquals("| U001       | user1@example.com    |", result);
    }
}
