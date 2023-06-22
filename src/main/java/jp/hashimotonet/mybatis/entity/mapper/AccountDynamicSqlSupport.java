package jp.hashimotonet.mybatis.entity.mapper;

import java.sql.JDBCType;
import java.util.Date;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class AccountDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-06-22T14:25:50.612+09:00", comments="Source Table: account")
    public static final Account account = new Account();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-06-22T14:25:50.612+09:00", comments="Source field: account.id")
    public static final SqlColumn<Integer> id = account.id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-06-22T14:25:50.613+09:00", comments="Source field: account.identity")
    public static final SqlColumn<String> identity = account.identity;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-06-22T14:25:50.613+09:00", comments="Source field: account.authority")
    public static final SqlColumn<Integer> authority = account.authority;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-06-22T14:25:50.613+09:00", comments="Source field: account.created_at")
    public static final SqlColumn<Date> createdAt = account.createdAt;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-06-22T14:25:50.613+09:00", comments="Source field: account.updated_at")
    public static final SqlColumn<Date> updatedAt = account.updatedAt;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-06-22T14:25:50.613+09:00", comments="Source field: account.password")
    public static final SqlColumn<String> password = account.password;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-06-22T14:25:50.612+09:00", comments="Source Table: account")
    public static final class Account extends SqlTable {
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

        public final SqlColumn<String> identity = column("identity", JDBCType.VARCHAR);

        public final SqlColumn<Integer> authority = column("authority", JDBCType.INTEGER);

        public final SqlColumn<Date> createdAt = column("created_at", JDBCType.TIMESTAMP);

        public final SqlColumn<Date> updatedAt = column("updated_at", JDBCType.TIMESTAMP);

        public final SqlColumn<String> password = column("password", JDBCType.LONGVARCHAR);

        public Account() {
            super("account");
        }
    }
}