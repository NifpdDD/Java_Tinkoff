package edu.hw9.task2;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

class CountFilesTask extends RecursiveTask<Integer> {
    public static final int FILES_COUNT = 2;
    private final File directory;

    CountFilesTask(File directory) {
        this.directory = directory;
    }

    @Override
    protected Integer compute() {
        if (directory.isFile()) {
            return 0;
        }

        File[] subFiles = directory.listFiles();
        if (subFiles == null) {
            return 0;
        }

        List<CountFilesTask> subTasks = new ArrayList<>();

        for (File subFile : subFiles) {
            CountFilesTask subTask = new CountFilesTask(subFile);
            subTask.fork();
            subTasks.add(subTask);
        }

        int count = 0;
        for (CountFilesTask subTask : subTasks) {
            count += subTask.join();
        }

        if (subFiles.length > FILES_COUNT) {
            count++;
        }

        return count;
    }
}
