package com.example.diary.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.diary.mapper.CommentMapper;
import com.example.diary.mapper.NoticeMapper;
import com.example.diary.vo.Member;
import com.example.diary.vo.Notice;

@Service
@Transactional
public class NoticeService {
   @Autowired
   private NoticeMapper noticeMapper;
   
   public List<Notice> selectNoticeList(Map<String, Object> noticeMap){
      List<Notice> resultNotice = noticeMapper.selectNoticeList(noticeMap);
      return resultNotice;
   }
    public int noticeCount() {
      int row = noticeMapper.noticeCount();
      return row;
   }
   //공지추가
   public int insertNotice(Notice paramnotice) {
      int row = noticeMapper.insertNotice(paramnotice);
      return row;
   }
   
   //공지 상세보기
   public Notice selectNoticeOne(Notice paramnotice) {
      Notice resultNotice = noticeMapper.selectNoticeOne(paramnotice);
      return resultNotice;
   }
   
   // 공지 수정
   public int updateNotice(Notice paramnotice) {
	  int row = noticeMapper.updateNotice(paramnotice);
	  return row;
   }
   
   // 공지 삭제
   public int deleteNotice(Notice notice) {
	  int row = noticeMapper.deleteNotice(notice);
	  return row;
     
   } 
   
   @Autowired
   private CommentMapper commentMapper;
   
   
   
   
}