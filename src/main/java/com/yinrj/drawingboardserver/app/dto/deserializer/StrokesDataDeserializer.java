package com.yinrj.drawingboardserver.app.dto.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yinrj.drawingboardserver.app.dto.StrokeDetailDTO;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class StrokesDataDeserializer extends JsonDeserializer<List<StrokeDetailDTO>> {
  @Override
  public List<StrokeDetailDTO> deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
    String value = jp.getValueAsString();
    if (value == null || value.isEmpty()) {
      return Collections.emptyList();
    }

    // 如果是字符串形式的JSON数组，尝试解析它
    ObjectMapper mapper = (ObjectMapper) jp.getCodec();
    try {
      return mapper.readValue(value, new TypeReference<List<StrokeDetailDTO>>() {
      });
    } catch (Exception e) {
      // 解析失败，记录错误并返回空列表
      return Collections.emptyList();
    }
  }
}