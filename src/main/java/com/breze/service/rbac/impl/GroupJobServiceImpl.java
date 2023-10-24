package com.breze.service.rbac.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.breze.entity.pojo.rbac.Group;
import com.breze.entity.pojo.rbac.GroupJob;
import com.breze.entity.pojo.rbac.Job;
import com.breze.mapper.rbac.GroupJobMapper;
import com.breze.mapper.rbac.GroupMapper;
import com.breze.mapper.rbac.JobMapper;
import com.breze.service.rbac.GroupJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author LUCIFER-LGX
 * @Date 2022/9/10 10:25
 * @Description 岗位组服务实现类
 * @Copyright(c) 2022 , 青枫网络工作室
 */
@Service
public class GroupJobServiceImpl extends ServiceImpl<GroupJobMapper, GroupJob> implements GroupJobService {

    @Autowired
    private JobMapper jobMapper;

    @Autowired
    private GroupMapper groupMapper;

    @Autowired
    private GroupJobMapper groupJobMapper;

    @Override
    public List<Job> findJobsByGroupId(Long id) {
        List<GroupJob> gjs = groupJobMapper.selectList(new QueryWrapper<GroupJob>().eq("group_id", id));
        List<Job> jobs = new ArrayList<>();
        for (GroupJob gj : gjs) {
            Job j = jobMapper.selectById(gj.getJobId());
            jobs.add(j);
        }
        return jobs;
    }

    @Override
    public Boolean insert(GroupJob groupJob) {
        Group group = groupMapper.selectById(groupJob.getGroupId());
        Job job = jobMapper.selectById(groupJob.getJobId());
        if (group == null || job == null) {
            return false;
        }
        QueryWrapper<GroupJob> qw = new QueryWrapper<>();
        qw.lambda().eq(GroupJob::getGroupId, groupJob.getGroupId()).and(wrapper -> wrapper.eq(GroupJob::getJobId, groupJob.getJobId()));
        List<GroupJob> gjs = groupJobMapper.selectList(qw);
        if (gjs.size() != 0) {
            return false;
        } else {
            return groupJobMapper.insert(groupJob) > 0;
        }
    }

    @Override
    public Boolean update(GroupJob groupJob) {
        return groupJobMapper.updateById(groupJob) > 0;
    }

    @Override
    public Boolean delete(GroupJob groupJob) {
        QueryWrapper<GroupJob> qw = new QueryWrapper<>();
        qw.lambda().eq(GroupJob::getGroupId, groupJob.getGroupId()).and(wrapper -> wrapper.eq(GroupJob::getJobId, groupJob.getJobId()));
        return groupJobMapper.delete(qw) > 0;
    }
}
