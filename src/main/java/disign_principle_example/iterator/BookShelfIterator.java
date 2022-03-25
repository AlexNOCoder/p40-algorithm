package disign_principle_example.iterator;

/**
 * @program: p40-algorithm
 * @description:
 * @author: lijie
 * @create: 2022-03-25 22:59
 */
public class BookShelfIterator implements Iterator {
    private BookShelf bookShelf;
    private int index;
    public BookShelfIterator(BookShelf bookShelf){
        this.bookShelf = bookShelf;
        this.index = 0;
    }
    public boolean hasNext(){
        if (index < bookShelf.getLength()){
            return true;
        }else {
            return false;
        }
    }
    public Object next(){
        Book book = bookShelf.getBookAt(index);
        index ++;
        return book;
    }
}
