package cn.alan;

import org.junit.Test;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

public class GeneratorDemo {
    @Test
    public void testGenerator() {

        // 1. 全局配置
        GlobalConfig config = new GlobalConfig();
        config.setActiveRecord(true) // 是否支持AR模式
            .setAuthor("alan") // 作者
            .setOutputDir("F:\\MyProject\\JavaProject\\mp-test\\src\\main\\java2") // 生成路径
            .setFileOverride(true) // 文件覆盖
            .setIdType(IdType.AUTO) // 主键策略
            .setServiceName("I%sService") // 设置生成的service接口的名字的首字母是否为I

            //
            .setBaseResultMap(true).setBaseColumnList(true);

        // 2. 数据源配置
        DataSourceConfig dsConfig = new DataSourceConfig();
        dsConfig.setDbType(DbType.MYSQL) // 设置数据库类型
            .setDriverName("com.mysql.jdbc.Driver")
            .setUrl(
                "jdbc:mysql://localhost:3306/mp?useUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai")
            .setUsername("root").setPassword("123456");

        // 3. 策略配置
        StrategyConfig stConfig = new StrategyConfig();
        stConfig.setCapitalMode(true) // 全局大写命名
            .setColumnNaming(NamingStrategy.underline_to_camel) // 指定表名 字段名是否使用下划线
            .setNaming(NamingStrategy.underline_to_camel) // 数据库表映射到实体的命名策略
            .setTablePrefix("tbl_");
        // .setInclude("tbl_employee"); // 生成的表

        // 4. 包名策略配置
        PackageConfig pkConfig = new PackageConfig();
        pkConfig.setParent("com.alan").setMapper("mapper").setService("service").setController("controller")
            .setEntity("beans").setXml("mapper");

        // 5. 整合配置
        AutoGenerator ag = new AutoGenerator();

        ag.setGlobalConfig(config).setDataSource(dsConfig).setStrategy(stConfig).setPackageInfo(pkConfig);

        // 6. 执行
        ag.execute();
    }
}
