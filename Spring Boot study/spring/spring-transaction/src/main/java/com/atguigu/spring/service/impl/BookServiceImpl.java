package com.atguigu.spring.service.impl;
import com.atguigu.spring.dao.BookDao;
import com.atguigu.spring.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookServiceImpl implements BookService{
    @Autowired
    private BookDao bookDao;


//    事务属性：只读
//    @Transactional(readOnly = true)
//    对一个查询操作来说，如果我们把它设置成只读，
//    就能够明确告诉数据库，这个操作不涉及写操作。这样数据库就能够针对查询操作来进行优化。
//    只能在只有查询的method里使用
//    对增删改操作设置只读会抛出下面异常：
//    Caused by: java.sql.SQLException: Connection is read-only.
//    Queries leading to data modification are not allowed



//    事务属性：超时
//    @Transactional(timeout = -1) 默认值，一直等，跑完为止
//    @Transactional(timeout = 3) 三秒没跑完强制回滚并抛出异常

//    事务在执行过程中，有可能因为遇到某些问题，导致程序卡住，从而长时间
//    占用数据库资源。而长时间占用资源，大概率是因为程序运行出现了问题（可能是Java程序或MySQL数据库或网络连接等等）。
//    此时这个很可能出问题的程序应该被回滚，撤销它已做的操作，事务结束，把资源让出来，让其他正常程序可以执行。
//    概括来说就是一句话：超时回滚，释放资源。
//    org.springframework.transaction.TransactionTimedOutException: Transaction timed out:


//    事务属性：回滚策略
//
//    声明式事务默认只针对运行时异常回滚，编译时异常不回滚。
//    可以通过@Transactional中相关属性设置回滚策略
//    rollbackFor属性：需要设置一个Class类型的对象
//    rollbackForClassName属性：需要设置一个字符串类型的全类名
//    noRollbackFor属性：需要设置一个Class类型的对象
//    noRollbackFor{ArithmeticException.class}
//    rollbackFor属性：需要设置一个字符串类型的全类名




    @Override
    @Transactional
    public void buyBook(Integer userId, Integer bookId) {
        //查询图书的价格
        Integer price = bookDao.getPriceByBookId(bookId);
        //更新图书的库存
        bookDao.updateStock(bookId);
        //更新用户的余额
        bookDao.updateBalance(userId, price);
    }
}
