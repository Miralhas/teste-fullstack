
### module.xml
````
<?xml version="1.0" encoding="UTF-8"?>
<!--
  ~ Copyright The WildFly Authors
  ~ SPDX-License-Identifier: Apache-2.0
  -->
<module xmlns="urn:jboss:module:1.9" name="com.mysql">
    <resources>
        <resource-root path="mysql-connector-j-8.0.33.jar"/>
    </resources>
    <dependencies>
        <module name="javax.api"/>
        <module name="javax.transaction.api"/>
    </dependencies>
</module>
````

### datasources.xml
````
<datasources>
                <datasource jndi-name="java:jboss/datasources/ExampleDS" pool-name="ExampleDS" enabled="true" use-java-context="true" statistics-enabled="${wildfly.datasources.statistics-enabled:${wildfly.statistics-enabled:false}}">
                    <connection-url>jdbc:h2:mem:test;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE;MODE=${wildfly.h2.compatibility.mode:REGULAR}</connection-url>
                    <driver>h2</driver>
                    <security user-name="sa" password="sa"/>
                </datasource>
                <datasource jndi-name="java:/teste-fullstack" pool-name="teste-fullstack" enabled="true" use-java-context="true">
                    <connection-url>jdbc:mysql://localhost:3306/teste-fullstack?createDatabaseIfNotExist=true&amp;serverTimezone=UTC</connection-url>
                    <driver>mysql</driver>
                    <pool>
                        <min-pool-size>5</min-pool-size>
                        <max-pool-size>15</max-pool-size>
                    </pool>
                    <security user-name="root" password="admin"/>
                    <validation>
                        <valid-connection-checker class-name="org.jboss.jca.adapters.jdbc.extensions.mysql.MySQLValidConnectionChecker"/>
                        <validate-on-match>true</validate-on-match>
                        <exception-sorter class-name="org.jboss.jca.adapters.jdbc.extensions.mysql.MySQLExceptionSorter"/>
                    </validation>
                </datasource>
                <drivers>
                    <driver name="h2" module="com.h2database.h2">
                        <xa-datasource-class>org.h2.jdbcx.JdbcDataSource</xa-datasource-class>
                    </driver>
                    <driver name="mysql" module="com.mysql">
                        <driver-class>com.mysql.cj.jdbc.Driver</driver-class>
                    </driver>
                </drivers>
            </datasources>
````