package com.dvd.Dvd.security;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.core.io.Resource;
//import org.springframework.jdbc.datasource.init.DataSourceInitializer;
//import org.springframework.jdbc.datasource.init.DatabasePopulator;
//import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
//import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
//import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
//import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
//import org.springframework.security.oauth2.provider.token.TokenStore;
//import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
//
//import javax.sql.DataSource;
//
//@Configuration
//@EnableAuthorizationServer
//public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
//
//    @Autowired
//    @Qualifier("authenticationManagerBean")
//    private AuthenticationManager authenticationManager;
//
//    @Autowired
//    private DataSource dataSource;
//
//    @Override
//    public void configure(AuthorizationServerSecurityConfigurer oautchServer) throws Exception {
//        oautchServer
//                .tokenKeyAccess("permitALL()")
//                .checkTokenAccess("isAuthenticated()");
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return NoOpPasswordEncoder.getInstance();
//    }
//
//    @Override
//    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//        clients.jdbc(dataSource)
//                .withClient("sampleClientId")
//                .authorizedGrantTypes("implicit")
//                .scopes("read")
//                .autoApprove(true)
//                .and()
//                .withClient("clientIdPassword")
//                .secret("secret")
//                .authorizedGrantTypes(
//                        "password","authorization_code", "refresh_token")
//                .scopes("read");
//    }
//
//    @Override
//    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
//        endpoints
//                .tokenStore(tokenStore())
//                .authenticationManager(authenticationManager);
//    }
//
//    @Value("classpath:schema.sql")
//    private Resource schemaScript;
//
//    @Bean
//    public DataSourceInitializer dataSourceInitializer(DataSource dataSource) {
//        DataSourceInitializer initializer = new DataSourceInitializer();
//        initializer.setDataSource(dataSource);
//        initializer.setDatabasePopulator(databasePopulator());
//        return initializer;
//    }
//
//    private DatabasePopulator databasePopulator() {
//        ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
//        populator.addScript(schemaScript);
//        return populator;
//    }
//
//    @Bean
//    public TokenStore tokenStore() {
//        return new JdbcTokenStore(dataSource);
//    }
//
//    @Primary
//    @Bean
//    public RemoteTokenServices tokenService() {
//        RemoteTokenServices tokenService = new RemoteTokenServices();
//        tokenService.setCheckTokenEndpointUrl("http://localhost:8080/oauth/check_token");
//        tokenService.setClientId("clientIdPassword");
//        tokenService.setClientSecret("secret");
//        return tokenService;
//    }
//
//}
