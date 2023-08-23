package com.colipu.huaweideployment.model.dto.DeploymentsAndImages;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeploymentsAndImagesDTO {

    private String deploymentName;

    private String imageName;

    private String imageRepoName;
}
