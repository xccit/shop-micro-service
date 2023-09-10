package io.xccit.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.xccit.pojo.product.Product;
import org.springframework.stereotype.Repository;

/**
 * @author CH_ywx
 * @date 2023-09-10
 * @description
 */
@Repository
public interface IProductMapper extends BaseMapper<Product> {
}
