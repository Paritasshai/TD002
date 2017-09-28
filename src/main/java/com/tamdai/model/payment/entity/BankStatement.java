package com.tamdai.model.payment.entity;

import com.tamdai.model.security.entity.UserEntity;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "bankStatement")
public class BankStatement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "bankId")
    private Long bankId;

    @Column(name = "bankName")
    private String bankName;

    @Column(name = "statementDate")
    private String statementDate;

    @Column(name = "statementTime")
    private String statementTime;

    @Column(name = "statementAmount")
    private BigDecimal statementAmount;

    @Column(name = "accountId")
    private Long accountId;

    @Column(name = "createDate")
    private String createDate;

    @Column(name = "createTime")
    private String createTime;

    @Column(name = "createUserId")
    private Long createUserId;

    @Column(name = "updateDate")
    private String updateDate;

    @Column(name = "updateTime")
    private String updateTime;

    @Column(name = "updateUserId")
    private Long updateUserId;

    @Column(name = "statusBank")
    private String statusBank;

    @Column(name = "bankOrderId")
    private Long bankOrderId;

    @Column(name = "paymentId")
    private String paymentId;

    @ManyToMany(fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Set<UserEntity> users = new HashSet<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getBankId() {
        return bankId;
    }

    public void setBankId(Long bankId) {
        this.bankId = bankId;
    }

    public String getStatementDate() {
        return statementDate;
    }

    public void setStatementDate(String statementDate) {
        this.statementDate = statementDate;
    }

    public String getStatementTime() {
        return statementTime;
    }

    public void setStatementTime(String statementTime) {
        this.statementTime = statementTime;
    }

    public BigDecimal getStatementAmount() {
        return statementAmount;
    }

    public void setStatementAmount(BigDecimal statementAmount) {
        this.statementAmount = statementAmount;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Long getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public Long getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(Long updateUserId) {
        this.updateUserId = updateUserId;
    }

    public String getStatusBank() {
        return statusBank;
    }

    public void setStatusBank(String statusBank) {
        this.statusBank = statusBank;
    }

    public Set<UserEntity> getUsers() {
        return users;
    }

    public void setUsers(Set<UserEntity> users) {
        this.users = users;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public Long getBankOrderId() {
        return bankOrderId;
    }

    public void setBankOrderId(Long bankOrderId) {
        this.bankOrderId = bankOrderId;
    }

    public BankStatement() {
    }

    public BankStatement(Long bankId, String bankName, String statementDate, String statementTime, BigDecimal statementAmount, Long accountId, String createDate, String createTime, Long createUserId, String updateDate, String updateTime, Long updateUserId, String statusBank, Long bankOrderId, String paymentId, Set<UserEntity> users) {
        this.bankId = bankId;
        this.bankName = bankName;
        this.statementDate = statementDate;
        this.statementTime = statementTime;
        this.statementAmount = statementAmount;
        this.accountId = accountId;
        this.createDate = createDate;
        this.createTime = createTime;
        this.createUserId = createUserId;
        this.updateDate = updateDate;
        this.updateTime = updateTime;
        this.updateUserId = updateUserId;
        this.statusBank = statusBank;
        this.bankOrderId = bankOrderId;
        this.paymentId = paymentId;
        this.users = users;
    }

    @Override
    public String toString() {
        return "BankStatement{" +
                "id=" + id +
                ", bankId=" + bankId +
                ", bankName='" + bankName + '\'' +
                ", statementDate='" + statementDate + '\'' +
                ", statementTime='" + statementTime + '\'' +
                ", statementAmount=" + statementAmount +
                ", accountId=" + accountId +
                ", createDate='" + createDate + '\'' +
                ", createTime='" + createTime + '\'' +
                ", createUserId=" + createUserId +
                ", updateDate='" + updateDate + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", updateUserId=" + updateUserId +
                ", statusBank='" + statusBank + '\'' +
                ", bankOrderId=" + bankOrderId +
                ", paymentId='" + paymentId + '\'' +
                ", users=" + users +
                '}';
    }
}
