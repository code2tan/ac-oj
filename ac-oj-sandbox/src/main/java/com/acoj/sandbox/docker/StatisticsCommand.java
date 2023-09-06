package com.acoj.sandbox.docker;

import com.github.dockerjava.api.async.ResultCallback;
import com.github.dockerjava.api.command.StatsCmd;
import com.github.dockerjava.api.model.Statistics;
import lombok.extern.slf4j.Slf4j;

import java.io.Closeable;
import java.io.IOException;
import java.util.Objects;

@Slf4j
public class StatisticsCommand implements ResultCallback<Statistics> {
    public long maxMemory = 0L;

    public StatisticsCommand(StatsCmd statsCmd) {
        statsCmd.exec(this);
    }

    @Override
    public void onStart(Closeable closeable) {

    }

    @Override
    public void onNext(Statistics statistics) {
        log.info("内存占用：" + statistics.getMemoryStats().getUsage());
        Long usageMemory = statistics.getMemoryStats().getUsage();
        usageMemory = Objects.isNull(usageMemory) ? 0L : usageMemory;
        this.maxMemory = Math.max(usageMemory, this.maxMemory);
    }

    @Override
    public void onError(Throwable throwable) {

    }

    @Override
    public void onComplete() {

    }

    @Override
    public void close() throws IOException {

    }
}