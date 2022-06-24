package io.reactorbrains.demo.sec12.helper;

import io.reactorbrains.demo.courseutils.Util;
import reactor.core.publisher.Mono;
import reactor.util.context.Context;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class BookService {

    public static final Map<String, Integer> MAP = new HashMap<>();

    static {
        MAP.put("std", 2);
        MAP.put("prime", 3);
    }

    public static Mono<String> getBook() {
        return Mono.deferContextual(ctx -> {
            if(ctx.get("allow")) {
                return Mono.just(Util.faker().book().title());
            } else {
                return Mono.error(new RuntimeException("not allowed"));
            }
        }).contextWrite(rateLimiterContext());
    }

    private static Function<Context, Context> rateLimiterContext() {
        return ctx -> {
            if(ctx.hasKey("category")) {
                String category = ctx.get("category").toString();
                Integer attemps = MAP.get(category);
                if (attemps > 0) {
                    MAP.put(category, attemps - 1);
                    return ctx.put("allow", true);
                }
            }
            return ctx.put("allow", false);
        };
    }
}
