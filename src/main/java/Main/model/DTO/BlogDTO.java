package Main.model.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BlogDTO {
    private Integer id;
    private String title;
    private String content;
    private String tags;
    private String category;
    private Integer comments_count;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
    private String image_url;
}
