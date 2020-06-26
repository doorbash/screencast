package io.github.doorbash.casthoneypot.util;

import android.os.Process;
import android.util.Log;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolHelper {

    private static ThreadPoolHelper instance;
    public static final String TAG = "ThreadPoolHelper";

    public static ThreadPoolHelper getInstance() {
        if (instance == null) {
            instance = new ThreadPoolHelper();
        }
        return instance;
    }

    private ThreadPoolHelper() {

    }

    private int NUMBER_OF_CORES = Runtime.getRuntime().availableProcessors();
    private int KEEP_ALIVE_TIME = 1;
    private TimeUnit KEEP_ALIVE_TIME_UNIT = TimeUnit.SECONDS;
    private BlockingQueue<Runnable> taskQueue = new LinkedBlockingQueue<Runnable>();
//    private List<Future> mRunningTaskList = new ArrayList<>();

    private ExecutorService executorService = new ThreadPoolExecutor(NUMBER_OF_CORES,
            NUMBER_OF_CORES * 2,
            KEEP_ALIVE_TIME,
            KEEP_ALIVE_TIME_UNIT,
            taskQueue,
            new BackgroundThreadFactory());

    private static class BackgroundThreadFactory implements ThreadFactory {
        private static int sTag = 1;

        @Override
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName("CustomThread" + sTag);
            thread.setPriority(Process.THREAD_PRIORITY_BACKGROUND);

            // A exception handler is created to log the exception from threads
            thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
                @Override
                public void uncaughtException(Thread thread, Throwable ex) {
                    Log.e(TAG, thread.getName() + " encountered an error: " + ex.getMessage());
                }
            });
            return thread;
        }
    }


    public void run(Runnable runnable) {
        executorService.submit(runnable);
    }

    public void shutdown() {
        executorService.shutdown(); // Disable new tasks from being submitted
        try {
            // Wait a while for existing tasks to terminate
            if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                executorService.shutdownNow(); // Cancel currently executing tasks
                // Wait a while for tasks to respond to being cancelled
                if (!executorService.awaitTermination(60, TimeUnit.SECONDS))
                    System.err.println("Pool did not terminate");
            }
        } catch (InterruptedException ie) {
            // (Re-)Cancel if current thread also interrupted
            executorService.shutdownNow();
            // Preserve interrupt status
            Thread.currentThread().interrupt();
        }
        instance = null;
    }
}
