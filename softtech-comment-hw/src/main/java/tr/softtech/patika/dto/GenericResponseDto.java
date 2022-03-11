package tr.softtech.patika.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenericResponseDto<T> implements Serializable {

    private T data;
    private Date responseDate;
    private boolean isSuccess;
    private String messages;

    public GenericResponseDto(T data, boolean isSuccess) {
        this.data = data;
        this.isSuccess = isSuccess;
        responseDate = new Date();
    }

    public static <T> GenericResponseDto<T> of(T t,String messages){
        return new GenericResponseDto<>(t, true );
    }

    public static <T> GenericResponseDto<T> error(T t){
        return new GenericResponseDto<>(t, false);
    }

    public static <T> GenericResponseDto<T> empty(){
        return new GenericResponseDto<>(null, true);
    }

}
