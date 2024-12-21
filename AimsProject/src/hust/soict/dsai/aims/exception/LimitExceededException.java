package hust.soict.dsai.aims.exception;

public class LimitExceededException extends Exception {
    public LimitExceededException(String message) {
        super(message); // Gửi thông báo lỗi đến lớp cha Exception
    }
}
