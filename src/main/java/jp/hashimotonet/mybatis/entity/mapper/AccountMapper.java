package jp.hashimotonet.mybatis.entity.mapper;

import static jp.hashimotonet.mybatis.entity.mapper.AccountDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.annotation.Generated;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.delete.DeleteDSLCompleter;
import org.mybatis.dynamic.sql.delete.render.DeleteStatementProvider;
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider;
import org.mybatis.dynamic.sql.insert.render.MultiRowInsertStatementProvider;
import org.mybatis.dynamic.sql.select.CountDSLCompleter;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.UpdateDSL;
import org.mybatis.dynamic.sql.update.UpdateDSLCompleter;
import org.mybatis.dynamic.sql.update.UpdateModel;
import org.mybatis.dynamic.sql.update.render.UpdateStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;
import org.mybatis.dynamic.sql.util.mybatis3.MyBatis3Utils;

import jp.hashimotonet.mybatis.entity.Account;

@Mapper
public interface AccountMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-06-22T14:25:50.623+09:00", comments="Source Table: account")
    BasicColumn[] selectList = BasicColumn.columnList(id, identity, authority, createdAt, updatedAt, password);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-06-22T14:25:50.614+09:00", comments="Source Table: account")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-06-22T14:25:50.615+09:00", comments="Source Table: account")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-06-22T14:25:50.615+09:00", comments="Source Table: account")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<Account> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-06-22T14:25:50.616+09:00", comments="Source Table: account")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<Account> multipleInsertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-06-22T14:25:50.616+09:00", comments="Source Table: account")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("AccountResult")
    Optional<Account> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-06-22T14:25:50.616+09:00", comments="Source Table: account")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="AccountResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="identity", property="identity", jdbcType=JdbcType.VARCHAR),
        @Result(column="authority", property="authority", jdbcType=JdbcType.INTEGER),
        @Result(column="created_at", property="createdAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updated_at", property="updatedAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="password", property="password", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<Account> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-06-22T14:25:50.618+09:00", comments="Source Table: account")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-06-22T14:25:50.618+09:00", comments="Source Table: account")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, account, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-06-22T14:25:50.618+09:00", comments="Source Table: account")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, account, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-06-22T14:25:50.619+09:00", comments="Source Table: account")
    default int deleteByPrimaryKey(Integer id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-06-22T14:25:50.619+09:00", comments="Source Table: account")
    default int insert(Account record) {
        return MyBatis3Utils.insert(this::insert, record, account, c ->
            c.map(id).toProperty("id")
            .map(identity).toProperty("identity")
            .map(authority).toProperty("authority")
            .map(createdAt).toProperty("createdAt")
            .map(updatedAt).toProperty("updatedAt")
            .map(password).toProperty("password")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-06-22T14:25:50.621+09:00", comments="Source Table: account")
    default int insertMultiple(Collection<Account> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, account, c ->
            c.map(id).toProperty("id")
            .map(identity).toProperty("identity")
            .map(authority).toProperty("authority")
            .map(createdAt).toProperty("createdAt")
            .map(updatedAt).toProperty("updatedAt")
            .map(password).toProperty("password")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-06-22T14:25:50.621+09:00", comments="Source Table: account")
    default int insertSelective(Account record) {
        return MyBatis3Utils.insert(this::insert, record, account, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(identity).toPropertyWhenPresent("identity", record::getIdentity)
            .map(authority).toPropertyWhenPresent("authority", record::getAuthority)
            .map(createdAt).toPropertyWhenPresent("createdAt", record::getCreatedAt)
            .map(updatedAt).toPropertyWhenPresent("updatedAt", record::getUpdatedAt)
            .map(password).toPropertyWhenPresent("password", record::getPassword)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-06-22T14:25:50.625+09:00", comments="Source Table: account")
    default Optional<Account> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, account, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-06-22T14:25:50.626+09:00", comments="Source Table: account")
    default List<Account> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, account, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-06-22T14:25:50.626+09:00", comments="Source Table: account")
    default List<Account> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, account, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-06-22T14:25:50.627+09:00", comments="Source Table: account")
    default Optional<Account> selectByPrimaryKey(Integer id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-06-22T14:25:50.627+09:00", comments="Source Table: account")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, account, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-06-22T14:25:50.628+09:00", comments="Source Table: account")
    static UpdateDSL<UpdateModel> updateAllColumns(Account record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(identity).equalTo(record::getIdentity)
                .set(authority).equalTo(record::getAuthority)
                .set(createdAt).equalTo(record::getCreatedAt)
                .set(updatedAt).equalTo(record::getUpdatedAt)
                .set(password).equalTo(record::getPassword);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-06-22T14:25:50.628+09:00", comments="Source Table: account")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Account record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(identity).equalToWhenPresent(record::getIdentity)
                .set(authority).equalToWhenPresent(record::getAuthority)
                .set(createdAt).equalToWhenPresent(record::getCreatedAt)
                .set(updatedAt).equalToWhenPresent(record::getUpdatedAt)
                .set(password).equalToWhenPresent(record::getPassword);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-06-22T14:25:50.629+09:00", comments="Source Table: account")
    default int updateByPrimaryKey(Account record) {
        return update(c ->
            c.set(identity).equalTo(record::getIdentity)
            .set(authority).equalTo(record::getAuthority)
            .set(createdAt).equalTo(record::getCreatedAt)
            .set(updatedAt).equalTo(record::getUpdatedAt)
            .set(password).equalTo(record::getPassword)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-06-22T14:25:50.63+09:00", comments="Source Table: account")
    default int updateByPrimaryKeySelective(Account record) {
        return update(c ->
            c.set(identity).equalToWhenPresent(record::getIdentity)
            .set(authority).equalToWhenPresent(record::getAuthority)
            .set(createdAt).equalToWhenPresent(record::getCreatedAt)
            .set(updatedAt).equalToWhenPresent(record::getUpdatedAt)
            .set(password).equalToWhenPresent(record::getPassword)
            .where(id, isEqualTo(record::getId))
        );
    }
    
    /**
     * ユーザアカウント登録
     * @param account
     */
    void save(Account account);
}