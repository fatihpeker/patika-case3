package tr.softtech.patika.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class AddNewCommentRequestDto {

    @NotNull
    private String commentDescription;
    @NotNull
    private String user_id;
    @NotNull
    private String product_id;

}
