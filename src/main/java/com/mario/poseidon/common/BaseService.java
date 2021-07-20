package com.mario.poseidon.common;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.ReflectUtil;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mario.poseidon.exception.BusinessException;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author mario on 2021/7/19.
 */
@AllArgsConstructor
public abstract class BaseService<M extends BaseMapper<T>, T extends BaseEntity, DTO extends BaseDTO> extends ServiceImpl<M, T> implements IBaseService<T, DTO> {

    private final Class<T> clazz;
    private final String resource;

    @Override
    public IPage<T> page(Page<T> page, BaseSearch<T> search) {
        return super.page(page, search.query());
    }

    @Override
    public List<T> list(BaseSearch<T> search) {
        return super.list(search.query());
    }

    @Override
    public T get(Integer id) {
        return Assert.notNull(super.getById(id), () -> new BusinessException(resource + "不存在"));
    }

    @Override
    @Transactional
    public void create(DTO dto) {
        T t = ReflectUtil.newInstance(clazz);
        checkExist(t, dto);
        BeanUtil.copyProperties(dto, t, false);
        ICreateExtend<T, DTO> extend = createExtend();
        extend.before(t, dto);
        super.save(t);
        extend.after(t, dto);
    }


    @Override
    @Transactional
    public void modify(Integer id, DTO dto) {
        T t = get(id);
        checkExist(t, dto);
        BeanUtil.copyProperties(dto, t, false);
        IModifyExtend<T, DTO> extend = modifyExtend();
        extend.before(t, dto);
        super.updateById(t);
        extend.after(t, dto);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        T t = get(id);
        IDeleteExtend<T> extend = deleteExtend();
        extend.before(t);
        super.removeById(id);
        extend.after(t);
    }

    protected void isExist(Integer id, String column, Object value) {
        Assert.isFalse(super.count(Wrappers
                        .<T>query()
                        .eq(column, value)
                        .ne(id != null, "id", id)) > 0,
                () -> new BusinessException(resource + "已存在"));
    }

    public ICreateExtend<T, DTO> createExtend() {
        return new ICreateExtend<>() {
        };
    }

    public IModifyExtend<T, DTO> modifyExtend() {
        return new IModifyExtend<>() {
        };
    }

    public IDeleteExtend<T> deleteExtend() {
        return new IDeleteExtend<>() {
        };
    }

    protected void checkExist(T t, DTO dto) {
    }

    /**
     * 扩展添加
     */
    public interface ICreateExtend<T, DTO> {
        default void before(T t, DTO dto) {
        }

        default void after(T t, DTO dto) {
        }
    }

    /**
     * 扩展修改
     */
    public interface IModifyExtend<T, DTO> {
        default void before(T t, DTO dto) {
        }

        default void after(T t, DTO dto) {
        }
    }

    /**
     * 扩展删除
     */
    public interface IDeleteExtend<T> {
        default void before(T t) {
        }

        default void after(T t) {
        }
    }

}
