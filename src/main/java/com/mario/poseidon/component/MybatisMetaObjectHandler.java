package com.mario.poseidon.component;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.mario.poseidon.bean.vo.UserInfoVO;
import com.mario.poseidon.utils.ContextHolder;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author mario on 2021/7/19.
 */
@Component
public class MybatisMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        this.strictInsertFill(metaObject, "createTime", LocalDateTime.class, LocalDateTime.now());
        UserInfoVO userInfo = ContextHolder.getUserInfo();
        if (userInfo != null) {
            this.strictInsertFill(metaObject, "operator", String.class, userInfo.getUsername());
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.fillStrategy(metaObject, "operator", ContextHolder.getUserInfo().getUsername());
    }

    @Override
    public MetaObjectHandler fillStrategy(MetaObject metaObject, String fieldName, Object fieldVal) {
        setFieldValByName(fieldName, fieldVal, metaObject);
        return this;
    }
}
