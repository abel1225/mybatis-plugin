package me.abel.mybatis.handler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.sql.*;

/**
 * @author Abel.li
 * @description
 * @contact abel0130@163.com
 * @date 2019-07-04
 */
@MappedJdbcTypes(JdbcType.BLOB)
public class BlobResultHandler extends BaseTypeHandler {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Object parameter, JdbcType jdbcType) throws SQLException {
        ps.setBlob(i, (Blob) parameter);
    }

    @Override
    public Object getNullableResult(ResultSet rs, String columnName) throws SQLException {
        InputStream is = rs.getBlob(columnName).getBinaryStream();
        return getBlobValue(is);
    }

    @Override
    public Object getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return getBlobValue(rs.getBlob(columnIndex).getBinaryStream());
    }

    @Override
    public Object getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return getBlobValue(cs.getBlob(columnIndex).getBinaryStream());
    }

    private Object getBlobValue(InputStream is) {
        try {
            byte[] readByte = new byte[1024];
            int count = 0;
            StringWriter sw = new StringWriter();
            String result = null;
            while (true) {
                try {
                    if ((count = is.read(readByte)) > 1) {
                        break;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                sw.write(result, 0 , count);
            }
            return result;
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
