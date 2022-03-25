package disign_principle_example.iterator;

/**
 * @program: p40-algorithm
 * @description:
 * @author: lijie
 * @create: 2022-03-25 23:06
 */
public class Main {
    public static void main(String args[]){
        BookShelf bookShelf = new BookShelf(4);
        bookShelf.appendBook(new Book("Around the World in 80 Days"));
        bookShelf.appendBook(new Book("Bible"));
        bookShelf.appendBook(new Book("Cinderella"));
        bookShelf.appendBook(new Book("Daddy-Long-Legs"));

        Iterator it = bookShelf.iterator();
        while(it.hasNext()){
            Book book = (Book) it.next();
            System.out.println(book.getName());
        }
    }
}
