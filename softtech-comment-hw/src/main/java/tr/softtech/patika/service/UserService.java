package tr.softtech.patika.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tr.softtech.patika.converter.UserMapper;
import tr.softtech.patika.dto.SingupRequestDto;
import tr.softtech.patika.dto.UpdateUserRequestDto;
import tr.softtech.patika.dto.UserDto;
import tr.softtech.patika.exception.ItemNotFoundException;
import tr.softtech.patika.exception.ParameterAlreadyExistException;
import tr.softtech.patika.exception.UserPropertiesNotMatchException;
import tr.softtech.patika.model.User;
import tr.softtech.patika.repository.UserRepository;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final BaseEntityService<User> baseEntityService;

    public ResponseEntity<UserDto> singup(SingupRequestDto singupRequestDto){
        if (userRepository.existsByUsername(singupRequestDto.getUsername())){
            throw new ParameterAlreadyExistException("Username already exist");
        }
        else if (userRepository.existsByEmail(singupRequestDto.getEmail())){
            throw new ParameterAlreadyExistException("email already exist");

        }
        else if (userRepository.existsByPhoneNumber(singupRequestDto.getPhoneNumber())){
            throw new ParameterAlreadyExistException("phone number already exist");

        }
        User user = UserMapper.INSTANCE.singupDtoToUser(singupRequestDto);
        baseEntityService.addBaseEntityProperties(user);
        UserDto userDto = UserMapper.INSTANCE.userToUserDto(userRepository.save(user));
        return new ResponseEntity<>(userDto, HttpStatus.CREATED);
    }

    public void deleteUser(String username, Long phoneNumber){
        User user = userRepository.findByUsername(username).orElseThrow(() -> new ItemNotFoundException("User not found"));
        if (!Objects.equals(user.getPhoneNumber(), phoneNumber)){
            throw new UserPropertiesNotMatchException(user.getUsername() + " kullanıcı adı ile " + phoneNumber + " telefon bilgileri uyuşmamaktadır");
        }
        userRepository.deleteById(user.getUser_id());

    }

    //Girilen bilgiler başkası tarafından kullanılmıyor ise bu bilgileri kullanarak update et
    public UserDto updateUser(UpdateUserRequestDto updateUserRequestDto){
        User userFromDb = userRepository.getById(updateUserRequestDto.getUser_id());
        if (!userRepository.existsByUsername(updateUserRequestDto.getUsername())){
            userFromDb.setUsername(updateUserRequestDto.getUsername());
        }
        if (!userRepository.existsByEmail(updateUserRequestDto.getEmail())){
            userFromDb.setEmail(updateUserRequestDto.getEmail());
        }
        if (!userRepository.existsByPhoneNumber(updateUserRequestDto.getPhoneNumber())){
            userFromDb.setPhoneNumber(updateUserRequestDto.getPhoneNumber());
        }
        baseEntityService.addBaseEntityProperties(userFromDb);
        UserDto userDto = UserMapper.INSTANCE.userToUserDto(userRepository.save(userFromDb));
        return userDto;
    }

    public UserDto getUserByUsernameWithControl(String username){
        User user = userRepository.findByUsername(username).orElseThrow(()-> new ItemNotFoundException("User not found"));
        UserDto userDto = UserMapper.INSTANCE.userToUserDto(user);
        return userDto;
    }

    public UserDto getUserById(String id){
        UserDto userDto = UserMapper.INSTANCE.userToUserDto(userRepository.getById(id));
        return userDto;
    }

    public UserDto getUserByIdWithControl(String id){
        User  user = userRepository.findById(id).orElseThrow(() -> new ItemNotFoundException("User not found"));
        UserDto userDto = UserMapper.INSTANCE.userToUserDto(user);
        return userDto;
    }

    public List<UserDto> getAllUser(){
        List<UserDto> userDtoList = UserMapper.INSTANCE.userListToUserDtoList(userRepository.findAll());
        return userDtoList;
    }
    //Uygulama içerisinde userDto değil user gerektiğinde kullanmak için
    public User getById(String id){
        return userRepository.getById(id);
    }

    public User getByUsername(String username){
        return userRepository.getUserByUsername(username);
    }

}
