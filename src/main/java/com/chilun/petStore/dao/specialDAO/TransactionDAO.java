package com.chilun.petStore.dao.specialDAO;

import com.chilun.petStore.dao.BaseDAO;
import com.chilun.petStore.pojo.Transaction;

import java.util.List;

/**
 * @auther 齿轮
 * @create 2022-10-29-20:46
 */
public class TransactionDAO extends BaseDAO<Transaction> {

    //根据UserID查找交易信息
    public List<Transaction> getTransactions(long id) {
        return super.executeQuery("select UserId,specificInfo from transactions where UserId = ?", id);
    }

    //添加交易信息
    public void addTransaction(Transaction transaction) {
        super.executeUpdate("insert into transactions values (0,?,?)", transaction.getUserId(), transaction.getSpecificInfo());
    }
}
