package com.project.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.project.vo.NoticeVo;

public interface NoticeService {
	//�������� ����Ʈ ���
	ArrayList<NoticeVo> getListPage(int startCount, int endCount);
	
	//�������� ���� �ݿ� �󼼺���
	NoticeVo getEnterContent(String nid);
	
	//�������� ���� ������ ���� �ҷ�����
	NoticeVo getContent(String nid);
	
	//�������� ���
	int getInsert(NoticeVo noticeVo);
	
	//�������� ����
	int getUpdate(NoticeVo noticeVo);
	
	//�������� ����
	int getDelete(String nid);
	
	//��ȸ�� ����
	void getUpdateHits(String nid);
	
	//�������� ��ü ������ Ȯ��
	int getTotalPageCount();
	
}
