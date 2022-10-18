package com.gcbeen.springmall.nosql.mongodb.repository;

import java.util.List;

import com.gcbeen.springmall.nosql.mongodb.document.MemberReadHistory;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * 用户浏览商品历史 Repository
 */
public interface IMemberReadHistoryRepository extends MongoRepository<MemberReadHistory, String> {
    /**
     * 根据会员 id 按时间倒序获取浏览记录
     * @param memberId 会员 ID
     * @return
     */
    List<MemberReadHistory> findByMemberIdOrderByCreateTimeDesc(Long memberId);

}
