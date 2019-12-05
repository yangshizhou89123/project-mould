package com.study.cache;

import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * mapper自动生成工具
 * 使用説明：
 * 只需要修改main方法里面的参数，并且执行main方法即可
 * 参考：https://mp.baomidou.com/guide/generator.html#使用教程
 */
public class MybatisPlusGenerator {
    private static final Logger logger = LoggerFactory.getLogger(MybatisPlusGenerator.class);
    /**
     * 作者名称
     */
    private String author;
    /**
     * 文件的输出绝对位置
     */
    private String outPutDir;
    /**
     * 数据库用户名
     */
    private String dbUserName;
    /**
     * 数据库密码
     */
    private String dbPassword;
    /**
     * 数据连接
     */
    private String dbUrl;
    /**
     * 输出包名
     */
    private String moduleName;
    /**
     * 基础包名
     */
    private String packege;

    private String[] includeTable;
    private String[] excludeTable;



    public void setIncludeTable(String[] includeTable) {
        this.includeTable = includeTable;
    }

    public void setExcludeTable(String[] excludeTable) {
        this.excludeTable = excludeTable;
    }

    /**
     * 引用用参数类
     * @param outPutDir 生成代码的位置
     * @param dbUserName 数据库用户名
     * @param dbPassword 数据库密码
     * @param dbUrl 数据库ＵＲＬ
     * @param moduleName　生成代码的所属包的名称
     * @param author 作者名称
     */
    public MybatisPlusGenerator(String outPutDir, String dbUserName, String dbPassword, String dbUrl, String packege, String moduleName , String author) {
        this.outPutDir = outPutDir;
        this.dbUserName = dbUserName;
        this.dbPassword = dbPassword;
        this.dbUrl = dbUrl;
        this.packege = packege;
        this.moduleName = moduleName;
        this.author = author;
    }

    /**
     * 配置全局参数
     * 这里主要设置文件的输出位置
     * 是否生成baseResultMapper,baseColumList
     * 是否开启缓存（不需要修改）
     * controller service mapper xml的名称（不需要修改）
     * @return
     */
    private GlobalConfig getGlobalConfig(){
        GlobalConfig gc = new GlobalConfig();

        //配置输出的位置
        gc.setOutputDir(this.outPutDir);

        //文件是否覆盖
        gc.setFileOverride(true);
        //领域模式
        gc.setActiveRecord(true);

        //禁用二级缓存
        gc.setEnableCache(false);

        //生成字段对应的resultMap
        gc.setBaseResultMap(true);

        //生成字段
        gc.setBaseColumnList(false);

        //设置作者名称
        gc.setAuthor("jack");

        //AUTO : AUTO(0, “数据库ID自增”)
        //INPUT : INPUT(1, “用户输入ID”)
        //ID_WORKER : ID_WORKER(2, “全局唯一ID”),生成的ID格式：ccba0a05fcbe46898304d5213d2b
        //UUID : UUID(3, “全局唯一ID”)
        //NONE : NONE(4, “该类型为未设置主键类型”)
        //ID_WORKER_STR : ID_WORKER_STR(5, “字符串全局唯一ID”)
        //gc.setIdType(IdType.INPUT);

        //是否生成kotlin代码
        //gc.setKotlin(false);

        //设置生成的controller名称
        gc.setControllerName("%sController");

        //设置生成的Service名称
        gc.setServiceName("%sService");

        //设置生成ServiceImpl名称
        gc.setServiceImplName("%sServiceImpl");

        //设置Mapper的名称
        gc.setMapperName("%sMapper");

        //设置xml名称
        gc.setXmlName("%sMapper");

        //生成后是否打开文件夹
        gc.setOpen(true);

        return gc;
    }

    /**
     * 配置数据库
     * @return 数据库
     */
    private DataSourceConfig getDataSourceConfig(){
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setTypeConvert(new MySqlTypeConvert() {
            public DbColumnType processTypeConvert(String fieldType) {
                return super.processTypeConvert(fieldType);
            }
        });
//         dsc.setDriverName("com.mysql.cj.jdbc.Driver");  //mysql 8.0以上版本 需要用这个驱动
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername(this.dbUserName);
        dsc.setPassword(this.dbPassword);
        dsc.setUrl(this.dbUrl);
        return dsc;
    }

    /**
     * 配置输出文件的包名
     * @return
     */
    public PackageConfig getPackageConfig(){
        PackageConfig pc = new PackageConfig();
        pc.setParent(this.packege);
        pc.setModuleName(this.moduleName);
        return pc;
    }

    /**
     * 生成策略
     * 这个方法可能需要修改里面的参数
     * @return
     */
    public StrategyConfig getStrategyConfig(){
        StrategyConfig strategy = new StrategyConfig();
        //配置表名的分割符
        strategy.setNaming(NamingStrategy.underline_to_camel);
        //配置字段名的分割符
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        //全局大写命名 ORACLE 注意
        //strategy.setCapitalMode(true);
        strategy.setInclude(this.includeTable);
        strategy.setExclude(this.excludeTable);

        // 自定义实体父类
        // strategy.setSuperEntityClass("com.baomidou.demo.TestEntity");
        // 自定义实体，公共字段
        // strategy.setSuperEntityColumns(new String[] { "test_id", "age" });
        // 自定义 mapper 父类
        // strategy.setSuperMapperClass("com.baomidou.demo.TestMapper");
        // 自定义 service 父类
        // strategy.setSuperServiceClass("com.baomidou.demo.TestService");
        // 自定义 service 实现类父类
        // strategy.setSuperServiceImplClass("com.baomidou.demo.TestServiceImpl");
        // 自定义 controller 父类
        // strategy.setSuperControllerClass("com.baomidou.demo.TestController");
        // 【实体】是否生成字段常量（默认 false）
        // strategy.setEntityColumnConstant(true);

        strategy.setEntityLombokModel(true);


        return strategy;
    }

    public void execute() {
        if (StringUtils.isEmpty(this.dbUserName)) {
            logger.error("数据库连接信息不能为空");
        } else {
            AutoGenerator mpg = new AutoGenerator();

            //配置全局参数
            GlobalConfig globalConfig = getGlobalConfig();
            mpg.setGlobalConfig(globalConfig);

            //配置数据源
            DataSourceConfig dataSourceConfig = getDataSourceConfig();
            mpg.setDataSource(dataSourceConfig);

            //配置策略
            StrategyConfig strategyConfig = getStrategyConfig();
            mpg.setStrategy(strategyConfig);

            //配置输出文件的包名
            PackageConfig packageConfig = getPackageConfig();
            mpg.setPackageInfo(packageConfig);

            //执行生成
            mpg.execute();
        }
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        MybatisPlusGenerator mh = new MybatisPlusGenerator("D:\\Project\\studycacahe\\src\\main\\java",
                "admin",
                "123456",
                "jdbc:mysql://192.168.31.10:3306/test",
                "com.study.cache",
                "product",
                "yangshizhou");
        mh.setIncludeTable(new String []{"product"});// 需要自动生成的table 列表
        mh.execute();
    }
}
