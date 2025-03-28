package com.example.model.builder;

import java.time.LocalDateTime;

import com.example.model.HoaDon;

public class BasicThongKe extends ThongKeKHBuilder{

	@Override
	public ThongKeKHBuilder buildDoanhThu() {
		int tongSoDon = thongKeKh.getHoadon().size();
        double tongDoanhThu = thongKeKh.getHoadon().stream().mapToDouble(HoaDon::getTongsotien).sum();

        thongKeKh.setDoanhthu((float) tongDoanhThu);
        thongKeKh.setSodonhang(tongSoDon);
        thongKeKh.setXephang(getRankBasedOnDoanhThu(tongDoanhThu));
        return this;
	}
	
	private String getRankBasedOnDoanhThu(double doanhthu) {
        if (doanhthu > 10000000) return "VIP";
        if (doanhthu > 5000000) return "Gold";
        return "Silver";
    }

}
