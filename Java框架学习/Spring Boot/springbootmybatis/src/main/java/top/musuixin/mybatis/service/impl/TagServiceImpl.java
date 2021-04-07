package top.musuixin.mybatis.service.impl;

import top.musuixin.mybatis.entity.Tag;
import top.musuixin.mybatis.mapper.TagMapper;
import top.musuixin.mybatis.service.ITagService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jobob
 * @since 2020-02-10
 */
@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements ITagService {

}
