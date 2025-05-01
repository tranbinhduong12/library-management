package models;

public class Book {
    private String id; // duy nhất, k được để trống
    private String title; // không được để trống, giới hạn 200 ký tự
    private String author; // không được để trống, giới hạn 100 ký tự
//    private boolean isBorrowed;
    private int quantity; // số nguyên và > 0, giới hạn 100

    public Book(String id, String title, String author, int quantity) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

//    public boolean isBorrowed() {
//        return isBorrowed;
//    }
//    public void setBorrow(boolean borrowed) {
//        isBorrowed = borrowed;
//    }


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // ktra còn sách k
    public boolean isAvailable() {
        return quantity > 0; // còn sách thì có thể mượn
    }

    // giảm số lượng sách khi mượn
    public void borrow() {
        if (quantity > 0) {
            quantity--;
        }
    }

    // tăng số lượng sách khi trả lại
    public void returnBook() {
        quantity++;
    }

    @Override
    public String toString() {
        return "Book{id='" + id + "', title='" + title + "', quantity=" + quantity + "}";
    }
}
