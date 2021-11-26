package com.thp.spring.simplecontext.controller;

import static com.auth0.jwt.algorithms.Algorithm.HMAC512;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auth0.jwt.JWT;
import com.thp.spring.simplecontext.dto.UserDto;
import com.thp.spring.simplecontext.entity.User;
import com.thp.spring.simplecontext.security.UserPrincipal;
import com.thp.spring.simplecontext.service.UserService;



@RestController
@RequestMapping("/userManagement")
public class UserController {



	
	@Autowired
	public UserService userService ;

	
	@PostMapping(value = "/addUser")
	public  UserDto addUser(@RequestBody UserDto userDto) {

		return userService.addUser(userDto) ;

	}

	@GetMapping(value = "/ListAllUser")
	public List<UserDto> findAllUsers() {


		return  userService.findAllUser();

	}

	@GetMapping(value = "/findUser/{id}")
	public UserDto findUserById(@PathVariable Long id) {
		return userService.findUserById(id) ;

	}

	@DeleteMapping(value = "/deleteUser/{id}")
	public UserDto delete(@PathVariable Long id) {
		return userService.deleteUser(id) ;
	}

	@PutMapping(value = "/updateUser/{id}")
	public UserDto updateUserById(@PathVariable Long id, @RequestBody UserDto userDto) 
			{

		return userService.updateUser(id, userDto) ;

	}
	private ModelMapper modelMapper = new ModelMapper();

	
	 @PostMapping("/auth")
	    public Map<String, String> GenerateToken(@RequestBody UserDto userDto)  {

	        List<UserDto> userDtos = userService.findAllUser() ;

	        for (int i = 0; i < userDtos.size(); i++) {
	            if ((userDto.getUsername().equals(userDtos.get(i).getUsername())) && (userDto.getPassword().equals(userDtos.get(i).getPassword()))) {
	                UserPrincipal principal = new UserPrincipal(modelMapper.map(userDto, User.class));
	                String token = JWT.create()
	                        .withSubject(principal.getUsername())
	                        .withExpiresAt(new Date(System.currentTimeMillis() + com.thp.spring.simplecontext.security.JwtProperties.EXPIRATION_TIME)) //EXPIRATION_TIME : property created earlier
	                        .sign(HMAC512(com.thp.spring.simplecontext.security.JwtProperties.SECRET.getBytes()));
	                String auth = "";
	                for (Iterator<? extends GrantedAuthority> iter = principal.getAuthorities().iterator(); iter.hasNext(); ) {
	                    GrantedAuthority element = iter.next();
	                    auth = auth + element.getAuthority();
	                }
	                HashMap<String, String> map = new HashMap<>();

	                Long id = userDtos.get(i).getIdUser() ;
	                String idString = Long.toString(id);
	                map.put("username", principal.getUsername());
	                map.put("role", "ROLE_" + userDtos.get(i).getRoles());
	                map.put("token", token);
	                map.put("user_id", idString);
	                return map;
	            }
	        }

	        boolean username = false;
	        boolean password = false;

	        for (int i = 0; i < userDtos.size(); i++) {
	            if (userDto.getUsername().equals(userDtos.get(i).getUsername())) {
	                username = true;
	            }
	            if (userDto.getPassword().equals(userDtos.get(i).getPassword())) {
	                password = true;
	            }

	        }
	        // In case of non existing USER with the username and password credentials fulfilled in the form
	        if (!username | !password) {
				throw new Error("username or password incorrect") ;
	        }
	        return null;
	    }

	

}
