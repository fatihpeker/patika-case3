package tr.softtech.patika.dto;

import lombok.Data;
import tr.softtech.patika.model.Product;
import tr.softtech.patika.model.User;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

@Data
public class CommentDto {

    private String comment_id;
    private String commentDescription;
    private Date createDate;
    private Date updateDate;

}
