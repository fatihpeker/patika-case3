package tr.softtech.patika.converter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tr.softtech.patika.dto.AddNewCommentRequestDto;
import tr.softtech.patika.model.Comment;
import tr.softtech.patika.model.Product;
import tr.softtech.patika.model.User;
import tr.softtech.patika.service.ProductService;
import tr.softtech.patika.service.UserService;

@Service
@RequiredArgsConstructor
public class CommentConverter {

    private final UserService userService;

    private final ProductService productService;

    public Comment addNewCommentRequestToComment(AddNewCommentRequestDto addNewCommentRequestDto){
        User user = userService.getById(addNewCommentRequestDto.getUser_id());
        Product product = productService.getById(addNewCommentRequestDto.getProduct_id());
        Comment comment = Comment.builder()
                .commentDescription(addNewCommentRequestDto.getCommentDescription())
                .ownerUser(user)
                .ownerProduct(product)
                .build();
        return comment;
    }

}
