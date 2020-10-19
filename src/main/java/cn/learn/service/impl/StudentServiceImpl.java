package cn.learn.service.impl;

import cn.learn.dao.StudentMapper;
import cn.learn.entity.Student;
import cn.learn.service.StudentService;
import cn.learn.utils.RedisUtil;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class StudentServiceImpl implements StudentService {
    @Resource
    private StudentMapper studentMapper;
    @Override
    public Student findBySno(int sno) {
        String studentJson = RedisUtil.getVal(String.valueOf(sno));
        if (studentJson != null && studentJson.length() > 0) {
            return JSONObject.parseObject(studentJson, Student.class);
        } else {
            Student student = studentMapper.findBySno(sno);
            RedisUtil.setVal(String.valueOf(sno), JSONObject.toJSONString(student));
            return student;
        }

    }
}
