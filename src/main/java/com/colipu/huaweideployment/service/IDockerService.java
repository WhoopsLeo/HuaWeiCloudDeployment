package com.colipu.huaweideployment.service;

public interface IDockerService {

    boolean pullImage(String imagePath);

    boolean pushImage(String newImageName);

    boolean tagImage(String oldImageName, String newImageName);
}
