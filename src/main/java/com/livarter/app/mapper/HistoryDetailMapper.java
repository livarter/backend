package com.livarter.app.mapper;

import com.livarter.app.domain.HistoryDetail;

import java.util.List;

/**
 * @author : 변형준
 * @fileName : HistoryDetailMapper
 * @since : 2024-01-23
 */
public interface HistoryDetailMapper {
    void saveHistoryDetail(HistoryDetail historyDetail);
    List<HistoryDetail> selectHistoryDetailByMemberId(int memberId);

}
