package com.embedded.mot.util;

import com.embedded.mot.projectTask.ProjectTaskService;
import weka.classifiers.trees.M5P;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.experiment.InstanceQuery;

public final class ProjectTaskClassifier {

    private static final ProjectTaskClassifier INSTANCE = new ProjectTaskClassifier();
    private static InstanceQuery query;
    private static Instances datasetInstances;
    private ProjectTaskService projectTaskService;

    private ProjectTaskClassifier() {}

    public static ProjectTaskClassifier getInstance() {
        return INSTANCE;
    }

    /*private void connectQueryToDatabase() {
        try {
            query.setDatabaseURL("jdbc:postgresql://ec2-107-21-98-165.compute-1.amazonaws.com:5432/d1katppeupkpim?useSSL=false");
            query.setUsername("ixiveebjhhyywy");
            query.setPassword("c6765de78ae33b847635408c930454405115c384dad974f968f59e9dd6e7f19f");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/

    public double predictTaskPlannedHoursByTaskId(int taskId) {
        double plannedHours = 0;

        try {
            taskId = 22;
            DataSource datasource = new DataSource("src/main/java/com/embedded/mot/util/project_task.arff");
            Instances ins = datasource.getDataSet();
            ins.setClassIndex(6);

            // Delete complexity attribute
            ins.deleteAttributeAt(1);

            // Delete description attribute
            ins.deleteAttributeAt(1);

            // Delete id_project attribute
            ins.deleteAttributeAt(2);

            M5P classifier = new M5P();

            String[] options = {"-N", "-U", "-M", "4.0"};
            classifier.setOptions(options);
            classifier.buildClassifier(ins);

            Instance instance = new DenseInstance(6);
            instance.setDataset(ins);
            instance.setValue(3, taskId);

            plannedHours = classifier.classifyInstance(instance);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Predicted planned hours: " + plannedHours);
        return plannedHours;
    }
}
