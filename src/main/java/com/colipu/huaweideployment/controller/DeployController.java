package com.colipu.huaweideployment.controller;

import com.colipu.huaweideployment.model.dto.DeploymentsAndImages.DeploymentsAndImagesDTO;
import com.colipu.huaweideployment.model.dto.Result;
import com.colipu.huaweideployment.service.IKubernetesService;
import com.colipu.huaweideployment.service.impl.RepositoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/Deployment")
public class DeployController {
    @Resource
    RepositoryService repositoryService;
    @Resource
    IKubernetesService kubernetesService;

    @RequestMapping("/listRepository")
    public Result listRepository(@RequestParam(required = true, value = "imageRepoName") String repoName,
                                 @RequestParam(required = false, value = "instanceId", defaultValue = "cri-2xl36ikg0mg1eczp") String instanceId,
                                 @RequestParam(required = false, value = "repoNamespaceName", defaultValue = "clp-uat") String repoNamespaceName,
                                 @RequestParam(required = false, value = "repoStatus", defaultValue = "NORMAL") String repoStatus) {
        List<String> imageTags = repositoryService.listRepository(repoName, instanceId, repoNamespaceName,repoStatus);
        return Result.ok(imageTags, (long) imageTags.size());
    }

    @RequestMapping("/findDeploymentsAndImages")
    public Result findDeploymentsAndImages(){
        List<DeploymentsAndImagesDTO> deploymentsAndImagesDTOs = kubernetesService.findDeploymentsAndImages();
        if (deploymentsAndImagesDTOs == null){
            return Result.fail("查询Deployment名称和Image名称失败");
        }
        return Result.ok(deploymentsAndImagesDTOs, (long) deploymentsAndImagesDTOs.size());
    }
}
