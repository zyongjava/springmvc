package cn.springmvc.job;

import cn.springmvc.biz.service.intf.UserService;
import cn.springmvc.dal.mysql.object.UserDO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dangdang.ddframe.job.api.JobExecutionMultipleShardingContext;
import com.dangdang.ddframe.job.plugin.job.type.simple.AbstractSimpleElasticJob;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Random;

/**
 * 团伙欺诈报告处理定时器。<br/>
 * Created by maojianting on 16/9/16.
 */
@Component
public class ElasticJob extends AbstractSimpleElasticJob {

    private static final Logger logger = LoggerFactory.getLogger(ElasticJob.class);

    @Autowired
    private UserService         userService;

    @Override
    public void process(JobExecutionMultipleShardingContext context) {
        try {
            UserDO userDO = new UserDO();
            userDO.setName("哈哈");
            userDO.setAge(20);
            userDO.setGmtCreate(new Timestamp(new Date().getTime()));
            userService.insert(userDO);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }
}
