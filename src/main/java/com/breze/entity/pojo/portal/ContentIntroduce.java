package com.breze.entity.pojo.portal;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.breze.entity.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author chenweixi
 * @create 2023-02-10 15:43
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@TableName("tb_content_introduce")
@ApiModel(value = "SimpleContent", description = "主体内容对象,tb_content_introduce主体内容表")
public class ContentIntroduce extends BaseEntity {

    private static final long serialVersionUID = 8822671337435221276L;

    @ApiModelProperty("oss表id")
    private Long ossId;

    @ApiModelProperty("内容模块主标题")
    private String mainTitle;

    @ApiModelProperty("内容模块副标题")
    private String subtitle;

    @ApiModelProperty("内容模块简介")
    private String titleInfo;

    @ApiModelProperty("序号")
    private Long orderNum;

    @ApiModelProperty("指定路由跳转")
    private String routerPath;

    @ApiModelProperty("父id")
    private Long parentId;

    @ApiModelProperty("图片")
    @TableField(exist = false)
    private String imgUrl;

    @ApiModelProperty("背景")
    private String backUrl;

    @TableField(exist = false)
    private List<String> titleInfoList;
}
