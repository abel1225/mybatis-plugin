package me.abel.mybatis.plugin.lazyresult;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.util.Properties;

/**
 * @author Abel.li
 * @description
 * @contact abel0130@163.com
 * @date 2019-07-04
 */
@Intercepts(
        value={
                @Signature(type=Executor.class, method="update", args={MappedStatement.class, Object.class}),
                @Signature(type=Executor.class, method="query", args={MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class})
        }
)
public class LazyresultPlugin implements Interceptor {

    private int startIndex;

    public final int getStartIndex() {
        return startIndex;
    }

    public final void setStartIndex(int startIndex) {
        this.startIndex=startIndex;
    }

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
