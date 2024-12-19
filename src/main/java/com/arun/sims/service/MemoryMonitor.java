package com.arun.sims.service;

import com.sun.management.OperatingSystemMXBean;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.search.MeterNotFoundException;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.lang.management.ManagementFactory;

@Component
public class MemoryMonitor {


}
