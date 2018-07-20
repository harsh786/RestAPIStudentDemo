package com.harsh.student.RestAPIStudentDemo;

import java.sql.Types;

import org.hibernate.dialect.SQLServer2012Dialect;

public class ModifiedSQLServerDialect extends SQLServer2012Dialect {
    public ModifiedSQLServerDialect () {
        super();
        registerColumnType( Types.TIMESTAMP, "datetime" );
    }
}