/**
 *    Copyright 2016 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package examples.generated.always;

import static org.mybatis.qbe.sql.SqlConditions.isEqualTo;
import static org.mybatis.qbe.sql.insert.InsertSupportBuilder.insert;
import static org.mybatis.qbe.sql.update.UpdateSupportBuilder.update;

import java.sql.JDBCType;
import java.util.Optional;

import org.mybatis.qbe.mybatis3.MyBatis3Column;
import org.mybatis.qbe.sql.SqlTable;
import org.mybatis.qbe.sql.insert.InsertSupport;
import org.mybatis.qbe.sql.update.UpdateSupport;
import org.mybatis.qbe.sql.update.UpdateSupportBuilder.UpdateSupportBuildStep1;

public interface GeneratedAlwaysFields {
    SqlTable generatedAlways = SqlTable.of("GeneratedAlways").withAlias("a");
    MyBatis3Column<Integer> id = MyBatis3Column.of("id", JDBCType.INTEGER).inTable(generatedAlways);
    MyBatis3Column<String> firstName = MyBatis3Column.of("first_name", JDBCType.VARCHAR).inTable(generatedAlways);
    MyBatis3Column<String> lastName = MyBatis3Column.of("last_name", JDBCType.VARCHAR).inTable(generatedAlways);
    MyBatis3Column<String> fullName = MyBatis3Column.of("full_name", JDBCType.VARCHAR).inTable(generatedAlways);
    
    static InsertSupport<GeneratedAlwaysRecord> buildInsertSupport(GeneratedAlwaysRecord record) {
        return insert(record)
                .into(generatedAlways)
                .withColumnMapping(id, "id", record::getId)
                .withColumnMapping(firstName, "firstName", record::getFirstName)
                .withColumnMapping(lastName, "lastName", record::getLastName)
                .buildFullInsert();
    }

    static InsertSupport<GeneratedAlwaysRecord> buildInsertSelectiveSupport(GeneratedAlwaysRecord record) {
        return insert(record)
                .into(generatedAlways)
                .withColumnMapping(id, "id", record::getId)
                .withColumnMapping(firstName, "firstName", record::getFirstName)
                .withColumnMapping(lastName, "lastName", record::getLastName)
                .buildSelectiveInsert();
    }
    
    static UpdateSupport buildUpdateByPrimaryKeySupport(GeneratedAlwaysRecord record) {
        return update(generatedAlways)
                .set(firstName, record.getFirstName())
                .set(lastName, record.getLastName())
                .where(id, isEqualTo(record.getId()))
                .build();
    }

    static UpdateSupport buildUpdateByPrimaryKeySelectiveSupport(GeneratedAlwaysRecord record) {
        return update(generatedAlways)
                .set(firstName, Optional.ofNullable(record.getFirstName()))
                .set(lastName, Optional.ofNullable(record.getLastName()))
                .where(id, isEqualTo(record.getId()))
                .build();
    }

    static UpdateSupportBuildStep1 updateByExample(GeneratedAlwaysRecord record) {
        return update(generatedAlways)
                .set(id, record.getId())
                .set(firstName, record.getFirstName())
                .set(lastName, record.getLastName());
    }

    static UpdateSupportBuildStep1 updateByExampleSelective(GeneratedAlwaysRecord record) {
        return update(generatedAlways)
                .set(id, Optional.ofNullable(record.getId()))
                .set(firstName, Optional.ofNullable(record.getFirstName()))
                .set(lastName, Optional.ofNullable(record.getLastName()));
    }
}