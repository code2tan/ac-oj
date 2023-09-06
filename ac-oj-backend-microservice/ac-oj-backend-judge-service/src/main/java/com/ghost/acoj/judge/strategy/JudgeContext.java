package com.ghost.acoj.judge.strategy;

import com.ghost.acoj.model.codesandbox.JudgeInfo;
import com.ghost.acoj.model.dto.question.JudgeCase;
import com.ghost.acoj.model.entity.Question;
import com.ghost.acoj.model.entity.QuestionSubmit;
import lombok.Data;

import java.util.List;

/**
 * 上下文（用于定义在策略中传递的参数）
 */
@Data
public class JudgeContext {

    private JudgeInfo judgeInfo;

    private List<String> inputList;

    private List<String> outputList;

    private List<JudgeCase> judgeCaseList;

    private Question question;

    private QuestionSubmit questionSubmit;

}
