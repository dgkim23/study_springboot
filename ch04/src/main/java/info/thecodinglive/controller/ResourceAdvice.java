package info.thecodinglive.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.resource.ResourceUrlProvider;

/**
 * versionResourceResolver를 통해
 * 웹 리소스 파일을 호출하려면 ResourceUrlProvider를
 * 이용해서 로드하는 것이 좋다.
 * ResourceUrlProvider는 정적 자원들을 우리가 설정한
 * 리졸버에 맞춰서 로드할 수 있게 해준다.
 */
@ControllerAdvice
public class ResourceAdvice {
    @Autowired
    private ResourceUrlProvider resourceUrlProvider;

    @ModelAttribute("versionResourceResolver")
    public ResourceUrlProvider versionResourceResolver(){
        return this.resourceUrlProvider;
    }
}
