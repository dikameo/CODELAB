

public class Book {
    private String bookId;
    private String title;
    private String author;
    private String category;
    private int stock;
    private int duration;




    public Book(){

    }

    public Book(String bookId, String title, String author, String category, int duration,String nim){
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.category = category;
        this.duration = duration;
    }

    public void setBookId(String bookId){
        this.bookId = bookId;
    }

    public String getBookId(){
        return this.bookId;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getTitle(){
        return this.title;
    }
    public void setAuthor(String author){
        this.author = author;
    }

    public String getAuthor(){
        return this.author;
    }
    public void setCategory(String category){
        this.category = category;
    }

    public String getCategory(){
        return this.category;
    }

    public void setStock(int stock){
        this.stock = stock;
    }

    public int getStock(){
        return this.stock;
    }
    public void setDuration(int duration){
        this.duration = duration;
    }

    public int getDuration(){
        return this.duration;
    }



}
