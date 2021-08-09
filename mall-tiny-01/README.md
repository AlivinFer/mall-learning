# mybatis-generator 的使用

1. 导入依赖

   ```xml
   <!-- MyBatis 生成器 -->
   <dependency>
       <groupId>org.mybatis.generator</groupId>
       <artifactId>mybatis-generator-core</artifactId>
       <version>1.4.0</version>
   </dependency>
   ```

2. 配置 generatorConfig.xml 和  generator.properties

   ```properties
   jdbc.driverClass=com.mysql.cj.jdbc.Driver
   jdbc.connectionURL=jdbc:mysql://localhost:3306/mall?useUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai
   jdbc.userId=root
   jdbc.password=123456
   ```

   ```xml
   <?xml version="1.0" encoding="UTF-8"?>
   <!DOCTYPE generatorConfiguration
           PUBLIC "-//mybatis.org//DTD MyBatis Generator Configuration 1.0//EN"
           "http://mybatis.org/dtd/mybatis-generator-config_1_0.dtd">
   
   <generatorConfiguration>
       <properties resource="generator.properties"/>
       <context id="MySqlContext" targetRuntime="MyBatis3" defaultModelType="flat">
           <property name="beginningDelimiter" value="`"/>
           <property name="endingDelimiter" value="`"/>
           <property name="javaFileEncoding" value="UTF-8"/>
           <!-- 为模型生成序列化方法-->
           <plugin type="org.mybatis.generator.plugins.SerializablePlugin"/>
           <!-- 为生成的Java模型创建一个toString方法 -->
           <plugin type="org.mybatis.generator.plugins.ToStringPlugin"/>
           <!--可以自定义生成model的代码注释-->
           <commentGenerator type="com.alivin.mall.tiny.mbg.CommentGenerator">
               <!-- 是否去除自动生成的注释 true：是 ： false:否 -->
               <property name="suppressAllComments" value="true"/>
               <property name="suppressDate" value="true"/>
               <property name="addRemarkComments" value="true"/>
           </commentGenerator>
           <!--配置数据库连接-->
           <jdbcConnection driverClass="${jdbc.driverClass}"
                           connectionURL="${jdbc.connectionURL}"
                           userId="${jdbc.userId}"
                           password="${jdbc.password}">
               <!--解决mysql驱动升级到8.0后不生成指定数据库代码的问题-->
               <property name="nullCatalogMeansCurrent" value="true" />
           </jdbcConnection>
           <!--指定生成model的路径-->
           <javaModelGenerator targetPackage="com.alivin.mall.tiny.mbg.model" targetProject="mall-tiny-01\src\main\java"/>
           <!--指定生成mapper.xml的路径-->
           <sqlMapGenerator targetPackage="com.alivin.mall.tiny.mbg.mapper" targetProject="mall-tiny-01\src\main\resources"/>
           <!--指定生成mapper接口的的路径-->
           <javaClientGenerator type="XMLMAPPER" targetPackage="com.alivin.mall.tiny.mbg.mapper"
                                targetProject="mall-tiny-01\src\main\java"/>
           <!--生成全部表tableName设为%-->
           <table tableName="pms_brand">
               <generatedKey column="id" sqlStatement="MySql" identity="true"/>
           </table>
       </context>
   </generatorConfiguration>
   ```

3. 运行 Generator 的 main 函数生成代码

4. 编写 Mybatis 配置

5. 添加 service 接口和实现

6. 添加 controller

项目结构

![mbg](https://user-images.githubusercontent.com/39876872/128490407-d1e66f1b-7560-486f-ae04-f3e98dc8e501.png)


