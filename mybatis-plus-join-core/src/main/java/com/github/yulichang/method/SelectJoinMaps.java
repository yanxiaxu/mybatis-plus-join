package com.github.yulichang.method;

import com.baomidou.mybatisplus.core.metadata.TableInfo;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlSource;

import java.util.Map;

/**
 * copy {@link com.baomidou.mybatisplus.core.injector.methods.SelectMaps}
 *
 * @author yulichang
 */
public class SelectJoinMaps extends MPJAbstractMethod {

    @SuppressWarnings("deprecation")
    public SelectJoinMaps() {
        super();
    }

    @SuppressWarnings("unused")
    public SelectJoinMaps(String name) {
        super(name);
    }

    @Override
    public MappedStatement injectMappedStatement(Class<?> mapperClass, Class<?> modelClass, TableInfo tableInfo) {
        SqlMethod sqlMethod = SqlMethod.SELECT_JOIN_MAPS;
        String sql = String.format(sqlMethod.getSql(), sqlFirst(), sqlDistinct(), sqlSelectColumns(tableInfo, true),
                tableInfo.getTableName(), sqlAlias(), sqlFrom(), sqlWhereEntityWrapper(true, tableInfo), sqlComment());
        SqlSource sqlSource = languageDriver.createSqlSource(configuration, sql, modelClass);
        return this.addSelectMappedStatementForOther(mapperClass, sqlMethod.getMethod(), sqlSource, Map.class);
    }
}
