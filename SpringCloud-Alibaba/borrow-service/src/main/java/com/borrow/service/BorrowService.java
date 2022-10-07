package com.borrow.service;

import com.borrow.entity.UserBorrowDetail;

public interface BorrowService {
    UserBorrowDetail getUserBorrowDetailByUid(int uid);

    boolean doBorrow(int uid, int bid);
}
