package com.acoj.sandbox.docker;

import com.github.dockerjava.api.async.ResultCallback;
import com.github.dockerjava.api.model.Frame;
import com.github.dockerjava.api.model.StreamType;
import com.github.dockerjava.core.command.ExecStartResultCallback;
import lombok.extern.slf4j.Slf4j;

import java.io.Closeable;
import java.io.IOException;

@Slf4j
public class ExecCodeCommand extends ExecStartResultCallback implements ResultCallback<Frame> {
    public boolean timeout = true;
    public String message = "";
    public String errorMessage = "";

    @Override
    public void onStart(Closeable closeable) {

    }

    /**
     * Called when an async result event occurs
     *
     * @param frame Frame
     */
    @Override
    public void onNext(Frame frame) {

        StreamType streamType = frame.getStreamType();
        if (StreamType.STDERR.equals(streamType)) {
            errorMessage = new String(frame.getPayload());
            log.info("输出错误结果：" + errorMessage);
        } else {
            message = new String(frame.getPayload());
            log.info("输出结果：" + message);
        }
    }

    @Override
    public void onError(Throwable throwable) {

    }

    @Override
    public void onComplete() {
        // 如果执行完成，则表示没超时
        timeout = false;
        try {
            this.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void close() throws IOException {

    }
}