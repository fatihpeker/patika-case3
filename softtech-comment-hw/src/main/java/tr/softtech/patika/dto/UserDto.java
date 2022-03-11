package tr.softtech.patika.dto;

import lombok.Data;
import org.springframework.data.annotation.LastModifiedDate;
import tr.softtech.patika.enums.RoleType;

import javax.persistence.Column;
import java.util.Date;

@Data
public class UserDto {

    private String user_id;
    private String username;
    private String email;
    private Long phoneNumber;
    private RoleType roleType;
    private Date createDate;
    private Date updateDate;

}
