package edu.hw9.task2;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

class SearchFilesTask extends RecursiveTask<List<File>> {
    private final File directory;
    private final int sizeThreshold;
    private final String extension;

    SearchFilesTask(File directory, int sizeThreshold, String extension) {
        this.directory = directory;
        this.sizeThreshold = sizeThreshold;
        this.extension = extension;
    }

    @Override
    protected List<File> compute() {
        List<File> result = new ArrayList<>();

        if (directory.isFile()) {
            if (directory.length() > sizeThreshold && directory.getName().endsWith(extension)) {
                result.add(directory);
            }
        } else {
            File[] subFiles = directory.listFiles();
            if (subFiles != null) {
                List<SearchFilesTask> subTasks = new ArrayList<>();

                for (File subFile : subFiles) {
                    SearchFilesTask subTask = new SearchFilesTask(subFile, sizeThreshold, extension);
                    subTask.fork();
                    subTasks.add(subTask);
                }

                for (SearchFilesTask subTask : subTasks) {
                    result.addAll(subTask.join());
                }
            }
        }

        return result;
    }
}

