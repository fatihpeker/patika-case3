package tr.softtech.patika.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UpdateUserRequestDto {
    @NotNull
    private String user_id;
    private String username;
    private String email;
    private Long phoneNumber;
}
