ProcessEngine这个类，在Activiti中最核心的类，其他的类都是由他而来，例如：
RuntimeService :是activiti的流程执行服务类，可以从这个服务类中获取很多关于流程执行的相关的信息。
TaskService是activiti的任务服务类。可以从这个类中获取任务的相关信息，如当前正在执行的个人待办和用户组待办任务。
HistoryService是activiti的查询历史信息的类，在一个流程执行完成后，这个对象为我们提供查询历史信息，可以跟踪流程实例对应所有待办节点的运行情况。
ProcessDefinition流程定义类，可以从这里获得资源文件等。
ProcessInstance代表流程定义的执行实例，当一个部署的流程图启动后，该流程只有一条流程实例数据，但是它的流程任务可以有多个，每个任务对应流程图中相应的流程节点。

ACT_RE_*: 'RE'表示repository。 这个前缀的表包含了流程定义和流程静态资源 （图片，规则，等等）。
ACT_RU_*: 'RU'表示runtime。 这些运行时的表，包含流程实例，任务，变量，异步任务，等运行中的数据。 Activiti只在流程实例执行过程中保存这些数据， 在流程结束时就会删除这些记录。 这样运行时表可以一直很小速度很快。
ACT_ID_*: 'ID'表示identity。 这些表包含身份信息，比如用户，组等等。
ACT_HI_*: 'HI'表示history。 这些表包含历史数据，比如历史流程实例， 变量，任务等等。
ACT_GE_*: 通用数据， 用于不同场景下，如存放资源文件。

资源库流程规则表
1 act_re_deployment 部署信息表
2 act_re_model  流程设计模型部署表
3 act_re_procdef  流程定义数据表

运行时数据库表
1 act_ru_execution运行时流程执行实例表
2 act_ru_identitylink运行时流程人员表，主要存储任务节点与参与者的相关信息
3 act_ru_task运行时任务节点表
4 act_ru_variable运行时流程变量数据表

历史数据库表
1 act_hi_actinst 历史节点表
2 act_hi_attachment历史附件表
3 act_hi_comment历史意见表
4 act_hi_identitylink历史流程人员表
5 act_hi_detail历史详情表，提供历史变量的查询
6 act_hi_procinst历史流程实例表
7 act_hi_taskinst历史任务实例表
8 act_hi_varinst历史变量表

组织机构表
1 act_id_group用户组信息表
2 act_id_info用户扩展信息表
3 act_id_membership用户与用户组对应信息表
4 act_id_user用户信息表
这四张表很常见，基本的组织机构管理，关于用户认证方面建议还是自己开发一套，组件自带的功能太简单，使用中有很多需求难以满足

通用数据表
1 act_ge_bytearray二进制数据表
2 act_ge_property属性数据表存储整个流程引擎级别的数据,初始化表结构时，会默认插入三条记录，