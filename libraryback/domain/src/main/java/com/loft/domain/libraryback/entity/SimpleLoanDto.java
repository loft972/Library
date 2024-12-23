package com.loft.domain.libraryback.entity;

import java.time.LocalDateTime;

public class SimpleLoanDto {

    private Integer bookId;
    private Integer customerId;
    private LocalDateTime beginDate;
    private LocalDateTime endDate;

    public SimpleLoanDto() {}

    public SimpleLoanDto(Integer bookId, Integer customerId, LocalDateTime beginDate, LocalDateTime endDate) {
        this.bookId = bookId;
        this.customerId = customerId;
        this.beginDate = beginDate;
        this.endDate = endDate;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public LocalDateTime getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(LocalDateTime beginDate) {
        this.beginDate = beginDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }
}
