#  Lombok 注解使用
#-------------------------------------mysql
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <scope>runtime</scope>
</dependency>

application.properties:

##数据库地址
spring.datasource.url=jdbc:mysql://localhost:3306/数据库?characterEncoding=utf8&useSSL=false
##数据库用户名
spring.datasource.username=root
##数据库密码
spring.datasource.password=123456
##数据库驱动
spring.datasource.driver-class-name=com.mysql.jdbc.Driver

#-------------------------------------sql server
<dependency>
    <groupId>com.microsoft.sqlserver</groupId>
    <artifactId>mssql-jdbc</artifactId>
    <scope>runtime</scope>
</dependency>

application.properties:

##数据库地址
spring.datasource.url=jdbc:sqlserver://192.168.16.218:1433;databaseName=dev_btrpawn
##数据库用户名
spring.datasource.username=sa
##数据库密码
spring.datasource.password=p@ssw0rd
##数据库驱动
spring.datasource.driver-class-name=com.microsoft.sqlserver.jdbc.SQLServerDriver

#-------------------------------------------mongodb数据库：
pom文件：

<dependencies>
    <dependency> 
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-mongodb</artifactId>
    </dependency> 
</dependencies>

application.properties:
spring.data.mongodb.uri=mongodb://localhost:27017/test


#------------------------------------------------h2数据库：
pom文件：

<dependency>
    <groupId>com.h2database</groupId>
    <artifactId>h2</artifactId>
    <scope>runtime</scope>
</dependency>

application.properties:
spring.datasource.url=jdbc:h2:file:D:/roncoo_h2/roncoo_spring_boot;AUTO_SERVER=TRUE;DBCLOSE_ON_EXIT=FALSE
spring.datasource.username=sa
spring.datasource.password=
