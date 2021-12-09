package cn.com.zhshzh.daily.generator;

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.Scanner;

/**
 * mybatis-plus代码生成器
 *
 * @author wangbt
 * @since 2022-01-01
 */
public class CodeGenerator {

    /**
     * 执行代码生成器
     *
     * @param args 启动参数
     */
    public static void main(String[] args) {
        new AutoGenerator(dataSourceConfig())
                .packageInfo(packageConfig())
                .strategy(strategyConfig())
                .global(globalConfig())
                .execute();
    }

    /**
     * 包相关配置项
     *
     * @return 包配置
     */
    private static PackageConfig packageConfig() {
        return new PackageConfig.Builder()
                .parent("cn.com.zhshzh.daily")
                .moduleName("repository")
                .controller("controller")
                .service("service")
                .serviceImpl("service.impl")
                .mapper("mapper")
                .entity("entity")
                .build();
    }

    /**
     * 数据源相关配置项
     *
     * @return 数据源配置
     */
    private static DataSourceConfig dataSourceConfig() {
        String url = "jdbc:mysql://127.0.0.1:3306/daily?useUnicode=true&useSSL=false&characterEncoding=utf8";
        String username = "root";
        String password = "6yhNMko)";
        return new DataSourceConfig.Builder(url, username, password).build();
    }

    /**
     * 策略相关配置项
     *
     * @return 策略配置
     */
    private static StrategyConfig strategyConfig() {
        StrategyConfig.Builder builder = new StrategyConfig.Builder();

        // controller层相关配置
        builder.controllerBuilder()
                .enableRestStyle()
                .enableHyphenStyle();

        builder.serviceBuilder()
                .formatServiceFileName("%sService");

        // 实体类相关配置
        builder.entityBuilder()
                .naming(NamingStrategy.underline_to_camel)
                .columnNaming(NamingStrategy.underline_to_camel)
                .superClass("cn.com.zhshzh.daily.repository.entity.BaseEntity")
                .addSuperEntityColumns("id", "create_user", "update_user", "create_time", "update_time")
                .enableLombok()
                .enableChainModel()
                .enableTableFieldAnnotation()
                .enableRemoveIsPrefix();

        builder.addInclude(scanner("请输入表名，多个表之间用英文逗号分割").split(","));

        return builder.build();
    }

    /**
     * 全局相关配置项
     *
     * @return 全局配置
     */
    private static GlobalConfig globalConfig() {
        return new GlobalConfig.Builder()
                .outputDir(System.getProperty("user.dir") + "/daily-repository/src/main/java")
                // 开发人员，取电脑当前登录的用户名
                .author(System.getProperty("user.name"))
                // 覆盖已有文件
                .fileOverride()
                .disableOpenDir()
                .build();
    }

    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(tip + "：");
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotBlank(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }
}
