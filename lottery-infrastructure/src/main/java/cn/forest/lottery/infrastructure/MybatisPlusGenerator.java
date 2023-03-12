package cn.forest.lottery.infrastructure;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.TemplateType;
import com.baomidou.mybatisplus.generator.fill.Column;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @description:
 * @author：Forest
 * @date: 2023/3/12
 */
public class MybatisPlusGenerator {

    public static void main(String[] args) {
        DataSourceConfig.Builder ds = new DataSourceConfig.Builder("jdbc:mysql://127.0.0.1:3306/lottery?serverTimezone=GMT%2B8", "root", "root");
        FastAutoGenerator.create(ds)
                // 全局配置
                .globalConfig((scanner, builder) -> builder.author("Forest")
                        .outputDir("D:\\workspace\\lottery\\lottery-infrastructure\\src\\main\\java"))
                // 包配置
                .packageConfig((scanner, builder) -> builder.parent("cn.forest.lottery.infrastructure")
                        .entity("po")
                        .mapper("dao")
                        .service("repository")
                        .serviceImpl("repository.iml")
                        .xml("dao.xml"))
                .templateConfig((scanner, builder) -> builder
                        .disable(TemplateType.CONTROLLER))
                // 策略配置
                .strategyConfig((scanner, builder) -> builder.addInclude(getTables(scanner.apply("请输入表名，多个英文逗号分隔？所有输入 all")))
                        .controllerBuilder().enableRestStyle().enableHyphenStyle()
                        .entityBuilder().enableLombok().addTableFills(
                                new Column("create_time", FieldFill.INSERT)
                        )
                        .serviceBuilder().formatServiceFileName("%sRepository")
                            .formatServiceImplFileName("%sRepositoryImpl")
                        .mapperBuilder().formatMapperFileName("%sDao")
                        .formatXmlFileName("%sDao")
                        .build())
                /*
                    模板引擎配置，默认 Velocity 可选模板引擎 Beetl 或 Freemarker
                   .templateEngine(new BeetlTemplateEngine())
                   .templateEngine(new FreemarkerTemplateEngine())
                 */
                .execute();
    }


// 处理 all 情况
    protected static List<String> getTables(String tables) {
        return "all".equals(tables) ? Collections.emptyList() : Arrays.asList(tables.split(","));
    }
}
