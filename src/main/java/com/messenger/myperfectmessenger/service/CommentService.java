package com.messenger.myperfectmessenger.service;

import com.messenger.myperfectmessenger.domain.Comment;
import com.messenger.myperfectmessenger.domain.Post;
import com.messenger.myperfectmessenger.exception.CommentNotFoundException;
import com.messenger.myperfectmessenger.exception.PostNotFoundException;
import com.messenger.myperfectmessenger.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {
    private final CommentRepository commentRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public List<Comment> getComments() {
        return commentRepository.findAll();
    }

    public Optional<Comment> getComment(Long id) {
        return commentRepository.findById(id);
    }

    public void createComment(Comment comment) {
        commentRepository.save(comment);
    }

    public void updateComment(Comment comment) {
        commentRepository.saveAndFlush(comment);
    }

    public void putLike(Long id) {
        Comment comment = getComment(id).orElseThrow(CommentNotFoundException::new);
        comment.setLikes(comment.getLikes()+1);
        commentRepository.saveAndFlush(comment);
    }
    public void putDislike(Long id) {
        Comment comment = getComment(id).orElseThrow(CommentNotFoundException::new);
        comment.setDislikes(comment.getDislikes()+1);
        commentRepository.saveAndFlush(comment);
    }

    public void deleteCommentById(Long id) {
        commentRepository.deleteById(id);
    }

}