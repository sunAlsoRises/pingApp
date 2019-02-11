## 技术选型:
    springboot
    mysql
    mybatis
    jpush 极光推送
    lombok 
    jdbc
    
    

## 项目架构
      push-parent :父pom工程
        push-common : 公共层(公共api及工具)
        push-manager : 服务层
           push-manager-dao : Mapper映射文件
           push-manager-interface : service的实现接口
           push-manager-pojo : 数据库表映射对象
           push-manager-service : service层api
        push-api : 调用层 (即controller层)
            com.config: 配置
            com.util : 工具
            com.controller : 调用者
                                

极光推送逻辑
1用户在新建报账的接口的同时就要将信息推送给相关区域的运维人员  也就是说极光推送的接口要在用户新建报账的接口里调用
2极光推送需要获取的信息
    1,该用户的所在区域 __
    2,通过该区域获取所有相关运维人员的唯一id 调用一次接口service :根据区域获取运维人员
    3,将获取到的运维人员别名id 和需要发送的信息打包交给极光推送处理
    
后续开发: 
      未完