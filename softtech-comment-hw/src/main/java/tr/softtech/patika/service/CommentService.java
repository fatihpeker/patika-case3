package tr.softtech.patika.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tr.softtech.patika.converter.CommentConverter;
import tr.softtech.patika.converter.CommentMapper;
import tr.softtech.patika.dto.AddNewCommentRequestDto;
import tr.softtech.patika.dto.CommentDto;
import tr.softtech.patika.model.Comment;
import tr.softtech.patika.model.Product;
import tr.softtech.patika.model.User;
import tr.softtech.patika.repository.CommentRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    private final CommentConverter commentConverter;

    private final UserService userService;

    private final ProductService productService;

    private final BaseEntityService<Comment> baseEntityService;

    public CommentDto addNewComment(AddNewCommentRequestDto addNewCommentRequestDto){
        Comment comment = commentConverter.addNewCommentRequestToComment(addNewCommentRequestDto);
        baseEntityService.addBaseEntityProperties(comment);
        CommentDto commentDto = CommentMapper.INSTANCE.commentToCommentDto(commentRepository.save(comment));
        return commentDto;
    }

    public void deleteComment(String id){
        commentRepository.deleteById(id);
    }

    public ResponseEntity getCommentByUser(String user_id){
        User user = userService.getById(user_id);
        List<Comment> commentList = commentRepository.getAllByOwnerUser(user);
        if (commentList.isEmpty()){
            return ResponseEntity.ok(user.getUsername() + " kullanıcı henüz bir yorum yazmamıştır”");
        }
        List<CommentDto> commentDtoList = CommentMapper.INSTANCE.commentListToCommentDtoList(commentList);
        return ResponseEntity.ok(commentDtoList);
    }

    public ResponseEntity getCommentByProduct(String product_id){
        Product product = productService.getById(product_id);
        List<Comment> commentList = commentRepository.getAllByOwnerProduct(product);
        if (commentList.isEmpty()){
            return ResponseEntity.ok(product.getName() + " ürüne henüz yorum yazılmamıştır");
        }
        List<CommentDto> commentDtoList = CommentMapper.INSTANCE.commentListToCommentDtoList(commentList);
        return ResponseEntity.ok(commentDtoList);
    }

    public void deleteByUser(String username){
        commentRepository.deleteAllByOwnerUser(userService.getByUsername(username));
    }

    public void deleteByProduct(String product_id){
        commentRepository.deleteAllByOwnerProduct(productService.getById(product_id));
    }

}
