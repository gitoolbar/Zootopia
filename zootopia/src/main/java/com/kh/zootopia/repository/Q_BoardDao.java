package com.kh.zootopia.repository;

import com.kh.zootopia.entity.Q_BoardDto;

public interface Q_BoardDao {
	public int write (Q_BoardDto q_boardDto);

	public Q_BoardDto read(int q_board_no);
}