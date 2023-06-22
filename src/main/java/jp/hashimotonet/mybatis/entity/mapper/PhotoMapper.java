package jp.hashimotonet.mybatis.entity.mapper;

import static jp.hashimotonet.mybatis.entity.mapper.PhotoDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import javax.annotation.Generated;
import jp.hashimotonet.mybatis.entity.Photo;
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

@Mapper
public interface PhotoMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-06-22T14:25:50.636+09:00", comments="Source Table: photo")
    BasicColumn[] selectList = BasicColumn.columnList(id, identity, authority, alt, createdAt, updatedAt, data, thumbnail);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-06-22T14:25:50.635+09:00", comments="Source Table: photo")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-06-22T14:25:50.635+09:00", comments="Source Table: photo")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-06-22T14:25:50.635+09:00", comments="Source Table: photo")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<Photo> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-06-22T14:25:50.635+09:00", comments="Source Table: photo")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<Photo> multipleInsertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-06-22T14:25:50.635+09:00", comments="Source Table: photo")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("PhotoResult")
    Optional<Photo> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-06-22T14:25:50.635+09:00", comments="Source Table: photo")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="PhotoResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="identity", property="identity", jdbcType=JdbcType.VARCHAR),
        @Result(column="authority", property="authority", jdbcType=JdbcType.INTEGER),
        @Result(column="alt", property="alt", jdbcType=JdbcType.VARCHAR),
        @Result(column="created_at", property="createdAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updated_at", property="updatedAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="data", property="data", jdbcType=JdbcType.LONGVARBINARY),
        @Result(column="thumbnail", property="thumbnail", jdbcType=JdbcType.LONGVARBINARY)
    })
    List<Photo> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-06-22T14:25:50.635+09:00", comments="Source Table: photo")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-06-22T14:25:50.635+09:00", comments="Source Table: photo")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, photo, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-06-22T14:25:50.636+09:00", comments="Source Table: photo")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, photo, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-06-22T14:25:50.636+09:00", comments="Source Table: photo")
    default int deleteByPrimaryKey(Integer id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-06-22T14:25:50.636+09:00", comments="Source Table: photo")
    default int insert(Photo record) {
        return MyBatis3Utils.insert(this::insert, record, photo, c ->
            c.map(id).toProperty("id")
            .map(identity).toProperty("identity")
            .map(authority).toProperty("authority")
            .map(alt).toProperty("alt")
            .map(createdAt).toProperty("createdAt")
            .map(updatedAt).toProperty("updatedAt")
            .map(data).toProperty("data")
            .map(thumbnail).toProperty("thumbnail")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-06-22T14:25:50.636+09:00", comments="Source Table: photo")
    default int insertMultiple(Collection<Photo> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, photo, c ->
            c.map(id).toProperty("id")
            .map(identity).toProperty("identity")
            .map(authority).toProperty("authority")
            .map(alt).toProperty("alt")
            .map(createdAt).toProperty("createdAt")
            .map(updatedAt).toProperty("updatedAt")
            .map(data).toProperty("data")
            .map(thumbnail).toProperty("thumbnail")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-06-22T14:25:50.636+09:00", comments="Source Table: photo")
    default int insertSelective(Photo record) {
        return MyBatis3Utils.insert(this::insert, record, photo, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(identity).toPropertyWhenPresent("identity", record::getIdentity)
            .map(authority).toPropertyWhenPresent("authority", record::getAuthority)
            .map(alt).toPropertyWhenPresent("alt", record::getAlt)
            .map(createdAt).toPropertyWhenPresent("createdAt", record::getCreatedAt)
            .map(updatedAt).toPropertyWhenPresent("updatedAt", record::getUpdatedAt)
            .map(data).toPropertyWhenPresent("data", record::getData)
            .map(thumbnail).toPropertyWhenPresent("thumbnail", record::getThumbnail)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-06-22T14:25:50.636+09:00", comments="Source Table: photo")
    default Optional<Photo> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, photo, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-06-22T14:25:50.636+09:00", comments="Source Table: photo")
    default List<Photo> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, photo, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-06-22T14:25:50.636+09:00", comments="Source Table: photo")
    default List<Photo> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, photo, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-06-22T14:25:50.636+09:00", comments="Source Table: photo")
    default Optional<Photo> selectByPrimaryKey(Integer id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-06-22T14:25:50.636+09:00", comments="Source Table: photo")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, photo, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-06-22T14:25:50.636+09:00", comments="Source Table: photo")
    static UpdateDSL<UpdateModel> updateAllColumns(Photo record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(identity).equalTo(record::getIdentity)
                .set(authority).equalTo(record::getAuthority)
                .set(alt).equalTo(record::getAlt)
                .set(createdAt).equalTo(record::getCreatedAt)
                .set(updatedAt).equalTo(record::getUpdatedAt)
                .set(data).equalTo(record::getData)
                .set(thumbnail).equalTo(record::getThumbnail);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-06-22T14:25:50.637+09:00", comments="Source Table: photo")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Photo record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(identity).equalToWhenPresent(record::getIdentity)
                .set(authority).equalToWhenPresent(record::getAuthority)
                .set(alt).equalToWhenPresent(record::getAlt)
                .set(createdAt).equalToWhenPresent(record::getCreatedAt)
                .set(updatedAt).equalToWhenPresent(record::getUpdatedAt)
                .set(data).equalToWhenPresent(record::getData)
                .set(thumbnail).equalToWhenPresent(record::getThumbnail);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-06-22T14:25:50.637+09:00", comments="Source Table: photo")
    default int updateByPrimaryKey(Photo record) {
        return update(c ->
            c.set(identity).equalTo(record::getIdentity)
            .set(authority).equalTo(record::getAuthority)
            .set(alt).equalTo(record::getAlt)
            .set(createdAt).equalTo(record::getCreatedAt)
            .set(updatedAt).equalTo(record::getUpdatedAt)
            .set(data).equalTo(record::getData)
            .set(thumbnail).equalTo(record::getThumbnail)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-06-22T14:25:50.637+09:00", comments="Source Table: photo")
    default int updateByPrimaryKeySelective(Photo record) {
        return update(c ->
            c.set(identity).equalToWhenPresent(record::getIdentity)
            .set(authority).equalToWhenPresent(record::getAuthority)
            .set(alt).equalToWhenPresent(record::getAlt)
            .set(createdAt).equalToWhenPresent(record::getCreatedAt)
            .set(updatedAt).equalToWhenPresent(record::getUpdatedAt)
            .set(data).equalToWhenPresent(record::getData)
            .set(thumbnail).equalToWhenPresent(record::getThumbnail)
            .where(id, isEqualTo(record::getId))
        );
    }
}