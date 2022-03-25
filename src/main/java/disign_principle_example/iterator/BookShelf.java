package disign_principle_example.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: p40-algorithm
 * @description:
 * @author: lijie
 * @create: 2022-03-25 22:52
 */
public class BookShelf implements Aggregate {
//    private Book[] books;
    private List<Book> books;
    private int last = 0;
    public BookShelf(int maxSize){
        this.books = new ArrayList(maxSize);
    }
    public Book getBookAt(int index){
        return books.get(index);
    }
    public void appendBook(Book book){
        this.books.add(book);
        last ++;
    }
    public int getLength(){
        return last;
    }
    public Iterator iterator(){
        return new BookShelfIterator(this);
    }
}
