## 技术选型:
    springboot
    mysql
    mybatis
    jpush 极光推送
    lombok 
    jdbc
    
## 注: git上的 application.yml 相关数据库和 推送配置已删除 需要用压缩文件种的    

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
                 com.controller.admin.AllPageToController : 测试用
            com.controller.inf :   所有项目相关api
                com.controller.inf.BusinessTestController:  业务测试,连通性测试等相关
                com.controller.inf.LoginingController:  登陆相关
                com.controller.inf.OneClickDiagnosisController: 上传一键诊断终端显示信息  
                com.controller.inf.OtherSysController : 获取地区相关
                com.controller.inf.ReportErrorController: 保障相关
                com.controller.inf.UserController : 用户相关 :  用户与运维  
            com.controller.test :  测试类 无实际作用 可忽略    
            
            静态文件 resoureces  均为测试相关 与实际项目无相关作用              

极光推送逻辑
1用户在新建报账的接口的同时就要将信息推送给相关区域的运维人员  也就是说极光推送的接口要在用户新建报账的接口里调用
2极光推送需要获取的信息
    1,该用户的所在区域 __
    2,通过该区域获取所有相关运维人员的唯一id 调用一次接口service :根据区域获取运维人员
    3,将获取到的运维人员别名id 和需要发送的信息打包交给极光推送处理
    
后续开发: 
      未完