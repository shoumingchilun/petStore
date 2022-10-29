package testTransactions;

import com.chilun.petStore.dao.specialDAO.TransactionDAO;
import com.chilun.petStore.pojo.Transaction;
import org.junit.Test;

/**
 * @auther 齿轮
 * @create 2022-10-29-20:53
 */
public class testTransactionDAO {
    TransactionDAO dao = new TransactionDAO();

    @Test
    public void testGet() {
        dao.getTransactions(1).forEach(System.out::println);
    }

    @Test
    public void testAdd(){
        Transaction transaction = new Transaction(1,"123123qweqwe");
        dao.addTransaction(transaction);
    }
}
