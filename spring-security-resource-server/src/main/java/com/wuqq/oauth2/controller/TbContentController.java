package com.wuqq.oauth2.controller;


import com.wuqq.oauth2.dto.ResponseResult;
import com.wuqq.oauth2.entity.TbContent;
import com.wuqq.oauth2.service.ITbContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wuqq
 * @since 2021-05-30
 */
@RestController
public class TbContentController {

    @Autowired
    private ITbContentService iTbContentService;

    /**
     *
     * @description: 获取全部资源
     * @return:
     * @author: niaonao
     * @date: 2021/5/30
     */
    @GetMapping("/")
    public ResponseResult<List<TbContent>> selectAll(){
        return new ResponseResult<>(HttpStatus.OK.value(),HttpStatus.OK.toString(),iTbContentService.list());
    }


    /**
     * 获取资源详情
     *
     * @param id
     * @return
     */
    @GetMapping("/view/{id}")
    public ResponseResult<TbContent> getById(@PathVariable Long id) {
        return new ResponseResult<>(Integer.valueOf(HttpStatus.OK.value()), HttpStatus.OK.toString(), iTbContentService.getById(id));
    }

    /**
     * 新增资源
     *
     * @param tbContent
     * @return
     */
    @PostMapping("/insert")
    public ResponseResult<Integer> insert(@RequestBody TbContent tbContent) {
        boolean count = iTbContentService.save(tbContent);

        if (count) {
            return new ResponseResult<>(Integer.valueOf(HttpStatus.OK.value()), HttpStatus.OK.toString(), 1);
        } else {
            return new ResponseResult<>(Integer.valueOf(HttpStatus.BAD_REQUEST.value()), HttpStatus.BAD_REQUEST.toString());
        }
    }

    /**
     * 更新资源
     *
     * @param tbContent
     * @return
     */
//    @PutMapping("/update")
//    public ResponseResult<Integer> update(@RequestBody TbContent tbContent) {
//        int count = iTbContentService.update(tbContent);
//
//        if (count > 0) {
//            return new ResponseResult<>(Integer.valueOf(HttpStatus.OK.value()), HttpStatus.OK.toString(), count);
//        } else {
//            return new ResponseResult<>(Integer.valueOf(HttpStatus.BAD_REQUEST.value()), HttpStatus.BAD_REQUEST.toString());
//        }
//    }

    /**
     * 删除资源
     *
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public ResponseResult<Integer> delete(@PathVariable Long id) {
        boolean count = iTbContentService.removeById(id);

        if (count) {
            return new ResponseResult<>(Integer.valueOf(HttpStatus.OK.value()), HttpStatus.OK.toString(), 1);
        } else {
            return new ResponseResult<>(Integer.valueOf(HttpStatus.BAD_REQUEST.value()), HttpStatus.BAD_REQUEST.toString());
        }
    }

}
