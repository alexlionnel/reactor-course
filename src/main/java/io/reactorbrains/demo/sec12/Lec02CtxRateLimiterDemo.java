package io.reactorbrains.demo.sec12;

import io.reactorbrains.demo.courseutils.Util;
import io.reactorbrains.demo.sec12.helper.BookService;
import io.reactorbrains.demo.sec12.helper.UserService;
import reactor.util.context.Context;

public class Lec02CtxRateLimiterDemo {

    public static void main(String[] args) {
        BookService.getBook()
                .repeat(2)
                .contextWrite(UserService.userCategoryContext())
                .contextWrite(Context.of("user", "mike"))
                .subscribe(Util.subscriber());
    }
}
