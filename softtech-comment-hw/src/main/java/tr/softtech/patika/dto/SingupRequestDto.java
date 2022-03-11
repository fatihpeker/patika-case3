package tr.softtech.patika.dto;

import lombok.Data;
import tr.softtech.patika.enums.RoleType;

import javax.validation.constraints.NotNull;


@Data
public class SingupRequestDto {

    @NotNull
    private String username;
    @NotNull
    private String email;
    @NotNull
    private Long phoneNumber;
    @NotNull
    private RoleType roleType;

}
