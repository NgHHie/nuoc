package com.example.model.builder;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import com.example.model.HoaDon;

public class AdvanceThongKe extends ThongKeKHBuilder{
	@Override
	public ThongKeKHBuilder buildDoanhThu() {
		LocalDateTime start = thongKeKh.getStart();
		LocalDateTime end = thongKeKh.getEnd();
		List<HoaDon> hoaDons = thongKeKh.getHoadon().stream()
		        .filter(hd -> {
		            LocalDateTime ngayLap = hd.getNgaylap();
		            return (start == null || !ngayLap.isBefore(start)) && 
		                   (end == null || !ngayLap.isAfter(end));
		        })
		        .toList(); 

	    double tongDoanhThu = hoaDons.stream().mapToDouble(HoaDon::getTongsotien).sum();
	    int tongSoDon = hoaDons.size();

	    thongKeKh.setDoanhthu((float) tongDoanhThu);
	    thongKeKh.setSodonhang(tongSoDon);
	    return this;
	}
	
	@Override
	public ThongKeKHBuilder buildActivity() {
		if (thongKeKh.getHoadon().isEmpty()) {
			thongKeKh.setLastOrderDate(null);
			thongKeKh.setInactiveDays(9999);
            return this;
        }

        LocalDateTime lastOrderDate = thongKeKh.getHoadon().stream()
                .map(HoaDon::getNgaylap)
                .max(LocalDateTime::compareTo)
                .orElse(null);
        System.out.println(LocalDateTime.now());
        long inactiveDays = ChronoUnit.DAYS.between(lastOrderDate, LocalDateTime.now());

        thongKeKh.setLastOrderDate(lastOrderDate);
        thongKeKh.setInactiveDays(inactiveDays);
        return this;
	}

}
