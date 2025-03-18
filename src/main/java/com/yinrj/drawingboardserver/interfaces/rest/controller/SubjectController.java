package com.yinrj.drawingboardserver.interfaces.rest.controller;

import com.yinrj.drawingboardserver.app.dto.SubjectResultsDTO;
import com.yinrj.drawingboardserver.app.manager.ExamManager;
import com.yinrj.drawingboardserver.common.utils.JsonUtils;
import com.yinrj.drawingboardserver.common.vo.R;
import com.yinrj.drawingboardserver.interfaces.rest.vo.ExamGenVO;
import jakarta.annotation.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.Instant;
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
        // 将ISO格式的时间字符串转换为时间戳（毫秒）
        Long loginTime;
        try {
            loginTime = Instant.parse(loginTimeStr).toEpochMilli();
        } catch (Exception e) {
            // 如果解析失败，尝试直接将字符串转为Long
            try {
                loginTime = Long.parseLong(loginTimeStr);
            } catch (NumberFormatException ex) {
                // 如果都无法转换，使用当前时间作为默认值
                loginTime = Instant.now().toEpochMilli();
            }
        }
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
