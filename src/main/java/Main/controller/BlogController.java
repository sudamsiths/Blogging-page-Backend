package Main.controller;


import Main.model.DTO.BlogDTO;
import Main.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
public class BlogController {

    @Autowired
    BlogService blogService;


    @GetMapping
    public List<BlogDTO>getAll(){
        return blogService.getAll();
    }
    @PostMapping
    public void addBlog(@RequestBody BlogDTO blogDTO){
        blogService.addBlog(blogDTO);
    }

    @GetMapping("/{id}")
    public BlogDTO searchBlog(@PathVariable Integer id) {
        return blogService.searchBlog(id);
    }

    @DeleteMapping("/{id}")
    public void deleteBlog(@PathVariable  Integer id){
        blogService.deleteBlog(id);
    }

    @PutMapping
    public void updateBlog(@RequestBody BlogDTO blogDTO){
        blogService.updatebtn(blogDTO);
    }
//controller

}
