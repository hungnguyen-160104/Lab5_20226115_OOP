package hust.soict.dsai.aims.media;

import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media> {
    
    @Override
    public int compare(Media m1, Media m2) {
        // So sánh theo giá (Giảm dần)
        int costComparison = Float.compare(m2.getCost(), m1.getCost());
        if (costComparison != 0) {
            return costComparison;  // Nếu giá khác nhau, trả về kết quả so sánh giá
        }
        // Nếu giá giống nhau, so sánh theo tiêu đề (Tăng dần)
        return m1.getTitle().compareTo(m2.getTitle());  // So sánh theo thứ tự bảng chữ cái của tiêu đề
    }
}
