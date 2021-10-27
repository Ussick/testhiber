package ua.itea.component;

import ua.itea.dto.UserDto;
import ua.itea.model.UserEntity;

public class UserMapper {
    public ua.itea.dto.UserDto entityToDto(UserEntity entity) {
        return new ua.itea.dto.UserDto()
                .setId(entity.getId())
                .setLogin(entity.getLogin())
                .setName(entity.getName())
                .setPassword(entity.getPassword())
                .setGender(entity.getGender())
                .setRegion(entity.getRegion())
                .setComment(entity.getComment());
    }

    public UserEntity dtoToEntity(UserDto dto) {
        return new UserEntity()
                .setId(dto.getId())
                .setLogin(dto.getLogin())
                .setName(dto.getName())
                .setPassword(dto.getPassword())
                .setGender(dto.getGender())
                .setRegion(dto.getRegion())
                .setComment(dto.getComment());
    }
}
