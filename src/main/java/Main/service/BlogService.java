package Main.service;

import Main.model.DTO.BlogDTO;
import Main.model.Entity.BlogEntity;
import Main.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BlogService {

    @Autowired
    BlogRepository blogRepository;



    public List<BlogDTO>getAll(){

        List<BlogEntity> blogEntities = blogRepository.findAll();
        List<BlogDTO>blogDTOS=new ArrayList<>();

        for (BlogEntity blogEntity: blogEntities){
            BlogDTO blogDTO =new BlogDTO();
            blogDTO.setId(blogEntity.getId());
            blogDTO.setTitle(blogEntity.getTitle());
            blogDTO.setContent(blogEntity.getContent());
            blogDTO.setTags(blogEntity.getTags());
            blogDTO.setCategory(blogEntity.getCategory());
            blogDTO.setComments_count(blogEntity.getComments_count());
            blogDTO.setCreated_at(blogEntity.getCreated_at());
            blogDTO.setUpdated_at(blogEntity.getUpdated_at());
            blogDTO.setImage_url(blogEntity.getImage_url());

            blogDTOS.add(blogDTO);
        }
        return blogDTOS;
    }
    public void addBlog(BlogDTO blogDTO ){
        BlogEntity blogEntity =new BlogEntity();
        blogEntity.setId(blogDTO.getId());
        blogEntity.setTitle(blogDTO.getTitle());
        blogEntity.setContent(blogDTO.getContent());
        blogEntity.setTags(blogDTO.getTags());
        blogEntity.setCategory(blogDTO.getCategory());
        blogEntity.setComments_count(blogDTO.getComments_count());
        blogEntity.setCreated_at(blogDTO.getCreated_at());
        blogEntity.setUpdated_at(blogDTO.getUpdated_at());
        blogEntity.setImage_url(blogDTO.getImage_url());

        blogRepository.save(blogEntity);
    }

    public BlogDTO searchBlog(Integer id) {
        Optional<BlogEntity> blogEntity = blogRepository.findById(id);
        if (blogEntity.isPresent()) {
            BlogEntity entity = blogEntity.get();
            BlogDTO blogDTO = new BlogDTO();
            blogDTO.setId(entity.getId());
            blogDTO.setTitle(entity.getTitle());
            blogDTO.setContent(entity.getContent());
            blogDTO.setTags(entity.getTags());
            blogDTO.setCategory(entity.getCategory());
            blogDTO.setComments_count(entity.getComments_count());
            blogDTO.setCreated_at(entity.getCreated_at());
            blogDTO.setUpdated_at(entity.getUpdated_at());
            blogDTO.setImage_url(entity.getImage_url());
            return blogDTO;
        }
        return null;
    }

    public void deleteBlog(Integer id){
        blogRepository.deleteById(id);
    }
    public void updatebtn(BlogDTO blogDTO){
        BlogEntity entity=new BlogEntity();

        entity.setId(blogDTO.getId());
        entity.setTitle(blogDTO.getTitle());
        entity.setContent(blogDTO.getContent());
        entity.setTags(blogDTO.getTags());
        entity.setCategory(blogDTO.getCategory());
        entity.setComments_count(blogDTO.getComments_count());
        entity.setCreated_at(blogDTO.getCreated_at());
        entity.setUpdated_at(blogDTO.getUpdated_at());
        entity.setImage_url(blogDTO.getImage_url());

        blogRepository.save(entity);
    }
}
