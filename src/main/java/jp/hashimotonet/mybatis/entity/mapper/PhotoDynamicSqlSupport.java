package jp.hashimotonet.mybatis.entity.mapper;

import java.sql.JDBCType;
import java.util.Date;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class PhotoDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-06-22T14:25:50.634+09:00", comments="Source Table: photo")
    public static final Photo photo = new Photo();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-06-22T14:25:50.634+09:00", comments="Source field: photo.id")
    public static final SqlColumn<Integer> id = photo.id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-06-22T14:25:50.634+09:00", comments="Source field: photo.identity")
    public static final SqlColumn<String> identity = photo.identity;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-06-22T14:25:50.634+09:00", comments="Source field: photo.authority")
    public static final SqlColumn<Integer> authority = photo.authority;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-06-22T14:25:50.634+09:00", comments="Source field: photo.alt")
    public static final SqlColumn<String> alt = photo.alt;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-06-22T14:25:50.635+09:00", comments="Source field: photo.created_at")
    public static final SqlColumn<Date> createdAt = photo.createdAt;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-06-22T14:25:50.635+09:00", comments="Source field: photo.updated_at")
    public static final SqlColumn<Date> updatedAt = photo.updatedAt;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-06-22T14:25:50.635+09:00", comments="Source field: photo.data")
    public static final SqlColumn<byte[]> data = photo.data;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-06-22T14:25:50.635+09:00", comments="Source field: photo.thumbnail")
    public static final SqlColumn<byte[]> thumbnail = photo.thumbnail;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-06-22T14:25:50.634+09:00", comments="Source Table: photo")
    public static final class Photo extends SqlTable {
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

        public final SqlColumn<String> identity = column("identity", JDBCType.VARCHAR);

        public final SqlColumn<Integer> authority = column("authority", JDBCType.INTEGER);

        public final SqlColumn<String> alt = column("alt", JDBCType.VARCHAR);

        public final SqlColumn<Date> createdAt = column("created_at", JDBCType.TIMESTAMP);

        public final SqlColumn<Date> updatedAt = column("updated_at", JDBCType.TIMESTAMP);

        public final SqlColumn<byte[]> data = column("data", JDBCType.LONGVARBINARY);

        public final SqlColumn<byte[]> thumbnail = column("thumbnail", JDBCType.LONGVARBINARY);

        public Photo() {
            super("photo");
        }
    }
}