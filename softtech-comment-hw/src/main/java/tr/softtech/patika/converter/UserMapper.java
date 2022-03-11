package tr.softtech.patika.converter;


import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import tr.softtech.patika.dto.SingupRequestDto;
import tr.softtech.patika.dto.UpdateUserRequestDto;
import tr.softtech.patika.dto.UserDto;
import tr.softtech.patika.model.User;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User singupDtoToUser(SingupRequestDto singupRequestDto);

    UserDto userToUserDto(User user);

    User updateUserRequestDtoToUser(UpdateUserRequestDto updateUserRequestDto);

    List<UserDto> userListToUserDtoList(List<User> userList);

}
