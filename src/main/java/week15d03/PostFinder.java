package week15d03;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PostFinder {

    private List<Post> addresses;

    public PostFinder(List<Post> addresses) {
        this.addresses = addresses;
    }

    public List<Post> findPostsFor(String user){
        List<Post> result = new ArrayList<>();
        for (Post currentPost : addresses){
            if (currentPost.getPublishedAt().isBefore(LocalDate.now())
                    && currentPost.getOwner().equals(user)
                    && currentPost.getContent() != null
                && currentPost.getTitle() != null
                && (currentPost.getDeletedAt() == null || currentPost.getDeletedAt().isAfter(LocalDate.now()))){
                    result.add(currentPost);
            }
        }
        return result;
    }

}
