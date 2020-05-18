package com.codegym.Controller;

import com.codegym.Model.PostEntity;
import com.codegym.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@CrossOrigin("*")
@RestController
public class PostController {

    //--------------------------TOAN----------------------

    //--------------------------TIEN----------------------

    //--------------------------TU----------------------

    //--------------------------DUNG----------------------
    @Autowired
    private PostService postService;

    @RequestMapping(value = "/posts/", method = RequestMethod.GET)
    public ResponseEntity<List<PostEntity>> listAllPosts() {
        List<PostEntity> posts = postService.findAll();
        if (posts.isEmpty()) {
            return new ResponseEntity<List<PostEntity>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<PostEntity>>(posts, HttpStatus.OK);
    }

    @RequestMapping(value = "/posts/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PostEntity> getPost(@PathVariable("id") long id) {
        System.out.println("Fetching Post with id " + id);
        PostEntity postEntity = postService.findById(id);
        if (postEntity == null) {
            System.out.println("Post with id " + id + " not found");
            return new ResponseEntity<PostEntity>(HttpStatus.NOT_FOUND);
        }
    return new ResponseEntity<PostEntity>(postEntity, HttpStatus.OK);
    }

    @RequestMapping(value = "/posts/", method = RequestMethod.POST)
    public ResponseEntity<Void> createPost(@RequestBody PostEntity post, UriComponentsBuilder ucBuilder) {
        System.out.println("Creating Post " + post.getTitle());
        postService.save(post);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/posts/{id}").buildAndExpand(post.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/posts/{id}", method = RequestMethod.PUT)
    public ResponseEntity<PostEntity> updatePost(@PathVariable("id") long id, @RequestBody PostEntity postEntity) {
        System.out.println("Updating Post " + id);

        PostEntity currentPost = postService.findById(id);

        if (currentPost == null) {
            System.out.println("Post with id " + id + " not found");
            return new ResponseEntity<PostEntity>(HttpStatus.NOT_FOUND);
        }

//        currentPost.setId(post.getId());
//        currentPost.setUserID(post.getUserID());
//        currentPost.setTitle(post.getTitle());
//        currentPost.setPublishedStatus(post.getPublishedStatus());
//        currentPost.setPublishTime(post.getPublishTime());
//        currentPost.setCreatedAt(post.getCreatedAt());
//        currentPost.setUpdatedAt(post.getUpdatedAt());
//        currentPost.setContent(post.getContent());

        postService.save(currentPost);
        return new ResponseEntity<PostEntity>(currentPost, HttpStatus.OK);
    }

    @RequestMapping(value = "/posts/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<PostEntity> deletePost(@PathVariable("id") long id) {
        System.out.println("Fetching & Deleting Post with id " + id);

        PostEntity post = postService.findById(id);
        if (post == null) {
            System.out.println("Unable to delete. Post with id " + id + " not found");
            return new ResponseEntity<PostEntity>(HttpStatus.NOT_FOUND);
        }

        postService.remove(id);
        return new ResponseEntity<PostEntity>(HttpStatus.NO_CONTENT);
    }


}
