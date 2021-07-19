package com.mario.poseidon.common;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mario.poseidon.utils.R;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author mario on 2021/7/19.
 */
@AllArgsConstructor
public class BaseController<T extends BaseEntity,
        DTO extends BaseDTO,
        S extends IBaseService<T, DTO>,
        SEARCH extends BaseSearch<T>
        > {

    private final S service;

    @GetMapping()
    public R<IPage<T>> page(Page<T> page, SEARCH search) {
        return R.ok(service.page(page, search));
    }

    @GetMapping("list")
    public R<List<T>> list(SEARCH search) {
        return R.ok(service.list(search));
    }

    @GetMapping("{id}")
    public R<T> detail(@PathVariable Long id) {
        return R.ok(service.get(id));
    }

    @PostMapping()
    public R<?> create(@RequestBody @Validated DTO dto) {
        service.create(dto);
        return R.ok();
    }

    @PutMapping("{id}")
    public R<?> modify(@PathVariable Long id, @RequestBody @Validated DTO dto) {
        service.modify(id, dto);
        return R.ok();
    }

    @DeleteMapping("{id}")
    public R<?> delete(@PathVariable Long id) {
        service.delete(id);
        return R.ok();
    }
}
