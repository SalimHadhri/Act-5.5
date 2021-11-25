package com.thp.spring.simplecontext.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.thp.spring.simplecontext.dto.UserDto;
import com.thp.spring.simplecontext.entity.User;
import com.thp.spring.simplecontext.repository.UserRepository;
import com.thp.spring.simplecontext.service.UserService;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	private ModelMapper modelMapper = new ModelMapper();

	@Override
	public UserDto addUser(UserDto userDto) {

		User userToAdd = modelMapper.map(userDto, User.class);
		User userAdded = userRepository.save(userToAdd);

		return modelMapper.map(userAdded, UserDto.class);
	}

	@Override
	public UserDto findUserById(Long id) {

		return modelMapper.map(userRepository.findById(id).get(), UserDto.class);

	}

	@Override
	public UserDto deleteUser(Long id) {

		UserDto userDtoDeleted = findUserById(id);
		userRepository.deleteById(id);

		return userDtoDeleted;
	}

	@Override
	public List<UserDto> findAllUser() {

		List<User> usersToDisplay = userRepository.findAll();
		List<UserDto> usersDtoToDisplay = new ArrayList<UserDto>();

		for (int i = 0; i < usersToDisplay.size(); i++) {

			usersDtoToDisplay.add(modelMapper.map(usersToDisplay.get(i), UserDto.class));

		}

		return usersDtoToDisplay;
	}

	@Override
	public UserDto updateUser(Long id, UserDto userDto) {

		userDto.setIdUser(id);

		return addUser(userDto);
	}

}
