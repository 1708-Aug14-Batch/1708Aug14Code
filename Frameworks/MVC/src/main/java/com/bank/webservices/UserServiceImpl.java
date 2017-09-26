
package com.bank.webservices;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;

import com.bank.dao.UserDao;
import com.bank.domain.User;
import com.bank.dto.UserDto;

//Service Implementing Bean
@WebService(endpointInterface = "com.bank.webservices.UserService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDaoImpl;
	
	
	public void setDao(UserDao dao) {
		this.userDaoImpl = dao;
	}

	@Override
	public String getUser(String username) {
		UserDto userDTO = new UserDto();
		User u = userDaoImpl.findUserByUsername(username);
		if(u != null) {
			userDTO.setAuthenticated(true);
			userDTO.setId(u.getId().intValue());
			userDTO.setUsername(username);
			userDTO.setPassword(u.getPassword());
			
		}else {
			userDTO.setAuthenticated(false);
			userDTO.setId(-1);
			userDTO.setUsername(username);
			userDTO.setPassword("empty");
		}
		return userDTO.toString();
	}
}

