package tr.softtech.patika.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tr.softtech.patika.dto.AddNewCommentRequestDto;
import tr.softtech.patika.service.CommentService;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/comment")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("addComment")
    public ResponseEntity addNewComment(@Valid @RequestBody AddNewCommentRequestDto addNewCommentRequestDto){
        return new ResponseEntity<>(commentService.addNewComment(addNewCommentRequestDto), HttpStatus.CREATED);
    }

    @DeleteMapping("deleteComment")
    public ResponseEntity deleteComment(@RequestParam String id){
        commentService.deleteComment(id);
        return ResponseEntity.ok(Void.TYPE);
    }

    @GetMapping("getCommentByUser")
    public ResponseEntity getCommentByUser(@RequestParam String user_id){
        return commentService.getCommentByUser(user_id);
    }

    @GetMapping("getCommentByProduct")
    public ResponseEntity getCommentByProduct(@RequestParam String product_id){
        return commentService.getCommentByProduct(product_id);
    }

}
