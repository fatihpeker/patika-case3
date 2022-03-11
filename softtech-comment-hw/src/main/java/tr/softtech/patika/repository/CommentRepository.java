package tr.softtech.patika.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tr.softtech.patika.model.Comment;
import tr.softtech.patika.model.Product;
import tr.softtech.patika.model.User;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,String> {

    List<Comment> getAllByOwnerUser(User user);

    List<Comment> getAllByOwnerProduct(Product product);

    void deleteAllByOwnerUser(User user);

    void deleteAllByOwnerProduct(Product product);

}
