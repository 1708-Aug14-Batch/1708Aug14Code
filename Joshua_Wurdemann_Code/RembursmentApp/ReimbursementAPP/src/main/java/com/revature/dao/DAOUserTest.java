package com.revature.dao;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.revature.model.User;

public class DAOUserTest {
private DAOUser userTest; 
  @Before
  public void setUp() throws Exception {
  userTest = new DAOUser();
  
  }

  @Test
  public void editUserTest() {
    User u = new User(1, "Joshua", "Wurdemann", "joshua@gmail.com", "Jjwwd123", false);
    int actual = userTest.editUser(u);
   
    assertEquals(1, actual);
  }

}
