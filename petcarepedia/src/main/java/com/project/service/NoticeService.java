package com.project.service;

import java.util.ArrayList;


import com.project.vo.NoticeVo;

public interface NoticeService {
	//�������� ����Ʈ ���
	public ArrayList<NoticeVo> getListPage(int startCount, int endCount);
	
	//�������� ���� �ݿ� �󼼺���
	public NoticeVo getEnterContent(String nid);
	
	//�������� ���� ������ ���� �ҷ�����
	public NoticeVo getContent(String nid);
	
	//�������� ���
	public int getInsert(NoticeVo noticeVo);
	
	//�������� ����
	public int getUpdate(NoticeVo noticeVo);
	
	//�������� ����
	public int getDelete(String nid);
	
	//��ȸ�� ����
	public void getUpdateHits(String nid);
	
	//�������� ��ü ������ Ȯ��
	public int getTotalPageCount();
	
}
