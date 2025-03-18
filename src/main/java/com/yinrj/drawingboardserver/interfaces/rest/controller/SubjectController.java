package com.yinrj.drawingboardserver.interfaces.rest.controller;

import com.yinrj.drawingboardserver.app.dto.SubjectResultsDTO;
import com.yinrj.drawingboardserver.app.manager.ExamManager;
import com.yinrj.drawingboardserver.common.utils.JsonUtils;
import com.yinrj.drawingboardserver.common.utils.TimeUtil;
import com.yinrj.drawingboardserver.common.vo.R;
import com.yinrj.drawingboardserver.interfaces.rest.vo.ExamGenVO;
import jakarta.annotation.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * Name: SubjectController
 * Author: yinrongjie
 * Date: 2025/1/23
 */
@RestController
@RequestMapping("/api/subject/v1")
public class SubjectController {

    @Resource
    private ExamManager examManager;

    @GetMapping("/generate_exam")
    public R<ExamGenVO> generateExam(@RequestParam("student_id") String studentId,
            @RequestParam("login_time") String loginTimeStr,
            @RequestParam("ip_address") String ipAddress,
            @RequestParam("device_info") String deviceInfo) {
        // 使用TimeUtil工具类将时间字符串转换为时间戳
        Long loginTime = TimeUtil.parseTimeString(loginTimeStr);
        return R.success(examManager.generateExam(studentId, loginTime, ipAddress, deviceInfo));
    }

    @PostMapping(value = "/upload_subject", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public R<Void> uploadSubject(@RequestPart("file") MultipartFile file,
            @RequestParam Map<String, String> params) {
        var subjectResultsDTO = JsonUtils.parseObject(params, SubjectResultsDTO.class);
        examManager.saveSubjectsResult(file, subjectResultsDTO);
        return R.success();
    }

}
