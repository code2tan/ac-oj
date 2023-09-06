package com.ghost.acoj.judge.codesandbox;

import com.ghost.acoj.model.codesandbox.ExecuteCodeRequest;
import com.ghost.acoj.model.codesandbox.ExecuteCodeResponse;

/**
 * 代码沙箱接口定义
 */
public interface CodeSandbox {

    /**
     * 执行代码
     *
     * @param executeCodeRequest
     * @return
     */
    ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest);
}
