package org.umeframework.quickstart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.umeframework.dora.bean.BeanConfigConst;
import org.umeframework.dora.service.user.UserAuthenticator;
import org.umeframework.uac.user.dto.UserAclDto;
import org.umeframework.uac.user.impl.DefaultAuthenticatorImpl;

/**
 * Spring Boot启动用的主类<br>
 * 只需在该类的头部用注解标注的形式，即可启动一个内嵌Web服务器的Java项目<br>
 * <br>
 * 框架提供基于注解自动配置和基于XML配置两种方案，分别采用如下说明的方法来选择配置方式：<br>
 * <li>基于注解自动配置 - 在主类的头部添加"@ImportAutoConfiguration"设置
 * <li>基于注解自动配置 - 在主类的头部添加"@ImportResource"设置
 * <li>对于要从自动配置中排除的模块，使用"@EnableAutoConfiguration(exclude=...)"设置 <br>
 * <li>基于XML配置的场合，使用：@ImportResource("classpath:applicationContext.xml")<br>
 * <br><br>
 * 当默认的自动配置类org.umeframework.dora.appconfig.AutoConfiguration被导入·启动时，<br>
 * 框架默认声明了以下名称的Bean，因此应用中需要避免再次声明相同名称的Bean，否则会发生命名冲突。<br>
 * <li>"doraBeanFactory" - org.umeframework.dora.bean.impl.BeanFactoryImpl
 * <li>"doraUserCacheManager" - org.umeframework.dora.cache.impl.TempMemoryCachedImpl 
 * <li>"doraRdbDao" - org.umeframework.dora.dao.impl.BatisDaoImpl 
 * <li>"doraBasicDataSource" - org.apache.commons.dbcp.BasicDataSource 
 * <li>"doraExceptionHandler" - org.umeframework.dora.exception.impl.ExceptionHandlerImpl 
 * <li>"doraHttpProxy" - org.umeframework.dora.http.impl.HttpProxyImpl 
 * <li>"doraHttpProxy[json]" - org.umeframework.dora.http.impl.HttpProxyImpl 
 * <li>"doraHttpProxy[xml]" - org.umeframework.dora.http.impl.HttpProxyImpl 
 * <li>"doraHttpProxy[x-www-form-urlencoded]" - org.umeframework.dora.http.impl.HttpProxyImpl 
 * <li>"doraRemoteServiceClient" - org.umeframework.dora.http.impl.RemoteServiceProxyImpl 
 * <li>"doraJdbcDataSourceManager" - org.umeframework.dora.connection.impl.JdbcDataSourceManagerImpl 
 * <li>"doraLogger" - org.umeframework.dora.log.Logger 
 * <li>"doraUserLoginService" - org.umeframework.dora.service.user.impl.UserLoginServiceImpl 
 * <li>"doraMessageProperties" - org.umeframework.dora.message.MessageProperties 
 * <li>"doraAjaxParser" - org.umeframework.dora.ajax.impl.JSONParserImpl 
 * <li>"doraAjaxRender" - org.umeframework.dora.ajax.impl.UnicodeJSONRenderImpl 
 * <li>"doraServiceMappingConfigProperties" - org.umeframework.dora.property.impl.ConfigPropertiesImpl 
 * <li>"doraServiceWhiteListConfigProperties" - org.umeframework.dora.property.impl.ConfigPropertiesImpl 
 * <li>"doraServiceMapping" - org.umeframework.dora.service.mapping.impl.ServiceMappingImpl 
 * <li>"doraServiceMappingDesc" - org.umeframework.dora.service.mapping.impl.ServiceMappingDescImpl 
 * <li>"doraSystemPropertyConfiguration" - org.umeframework.dora.appconfig.DefaultSystemPropertyConfiguration 
 * <li>"doraTransactionManager" - org.umeframework.dora.transaction.impl.TransactionManagerImpl 
 * <li>"doraServiceRunner" - org.umeframework.dora.service.runner.impl.TransactionalServiceRunnerImpl
 * <li>"sys" - org.umeframework.dora.service.runner.impl.AjaxServiceRunnerImpl 
 * <br><br>
 * @author Yue MA
 */
// 排除SpringBoot自带的数据源初始化设置，采用application.properties中使用ume.jdbc设置的数据源连接。
@SpringBootApplication
@EnableAutoConfiguration(exclude = {
        org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration.class,
        org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration.class })
// 导入项目的自动化配置。
@Import({
    // 启动UME框架的默认配置
	// 启用AutoConfiguration内建的默认配置项目
    // org.umeframework.dora.appconfig.AutoConfiguration.class,
	// 或根据需要选择自定义如下预置组件的配置项目
    org.umeframework.dora.appconfig.DefaultBeanFactoryConfiguration.class,
    org.umeframework.dora.appconfig.DefaultDaoConfiguration.class,
    org.umeframework.dora.appconfig.DefaultDataSourceConfiguration.class,
    org.umeframework.dora.appconfig.DefaultExceptionHandlerConfiguration.class,
    org.umeframework.dora.appconfig.DefaultHttpProxyConfiguration.class,
    org.umeframework.dora.appconfig.DefaultJdbcDataSourceManagerConfiguration.class,
    org.umeframework.dora.appconfig.DefaultLogConfiguration.class,
    org.umeframework.dora.appconfig.DefaultMessageConfiguration.class,
    org.umeframework.dora.appconfig.DefaultServiceAjaxConfiguration.class,
    org.umeframework.dora.appconfig.DefaultServiceMappingConfiguration.class,
    org.umeframework.dora.appconfig.DefaultServiceRunnerConfiguration.class,
    org.umeframework.dora.appconfig.DefaultSystemPropertyConfiguration.class,
    org.umeframework.dora.appconfig.DefaultTransactionManagerConfiguration.class,
    org.umeframework.dora.appconfig.DefaultUserCacheConfiguration.class,
    org.umeframework.dora.appconfig.DefaultUserLoginConfiguration.class,
    org.umeframework.dora.appconfig.DefaultWebControllerConfiguration.class })
// 该设置创建并导入示例用的数据库及数据脚本；如果应用(通过application.properties的ume.jdbc设置)已变更为其他的数据库，请删除此设置。
@ImportResource("classpath:config/ume-quickstart-boot-uac/initDataConfiguration.xml")
@ComponentScan(basePackages = "org.umeframework.quickstart")
public class Application {

	/**
	 * Start application.<br>
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			SpringApplication.run(Application.class, args);
		} catch (Throwable e) {
			if (!e.getClass().getName().startsWith("org.springframework.boot.devtools")) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * User authentication implementation class.<br>
	 * 
	 * @return
	 */
	@Bean(name = BeanConfigConst.DEFAULT_USER_AUTHENTICATOR)
	public UserAuthenticator<?> userAuthenticator() {
		UserAuthenticator<UserAclDto> instance = new DefaultAuthenticatorImpl();
		return instance;
	}

}