package collectionsclass;

import java.util.Collections;
import java.util.List;

public class CollectionManager {

    List<Book> library;

    public CollectionManager(List<Book> library){
        this.library = library;
    }

    public List<Book> createUnmodifiableLibrary(){
        return Collections.unmodifiableList(library);
    }

    public List<Book> reverseLibrary(){
       Collections.sort(library);
        Collections.reverse(library);
        return library;
    }

    public Book getFirstBook(){
        Collections.sort(library);
        return Collections.min(library);
    }

    public Book getLastBook(){
        Collections.sort(library);
        return Collections.max(library);
    }

}
