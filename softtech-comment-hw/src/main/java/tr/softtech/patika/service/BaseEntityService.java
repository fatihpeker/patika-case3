package tr.softtech.patika.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tr.softtech.patika.model.BaseEntity;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class BaseEntityService<E extends BaseEntity> {

    //Tüm entity ler için create ve update date bilgilerini giriyor
    public void addBaseEntityProperties(E entity){
        if (entity.getCreateDate()==null){
            entity.setCreateDate(new Date());
        }
        entity.setUpdateDate(new Date());
    }

}
