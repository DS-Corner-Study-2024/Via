package com.springboot.api.controller;

import com.springboot.api.dto.MemberDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/get-api")
public class GetController {

    private final Logger LOGGER = LoggerFactory.getLogger(GetController.class);

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String getHello() {
        // 로그 출력
        LOGGER.info("getHello 메소드가 호출되었습니다.");
        return "Hello World";
    }

    @GetMapping(value = "/name")
    public String getName() {
        // 로그 출력
        LOGGER.info("getName 메소드가 호출되었습니다.");
        return "Flature";
    }

    @GetMapping(value = "/variable1/{variable}")
    public String getVariable1(@PathVariable String variable) {
        // 컨트롤러에 들어오는 값을 포함하여 로그 출력
        LOGGER.info("@PathVariable을 통해 들어온 값 : {}", variable);
        return variable;
    }


    //http://localhost:8080/api/v1/get-api/variable2/{String 값}
    @GetMapping(value = "/variable2/{variable}")
    public String getVariable2(@PathVariable("variable") String var) {
        return var;
    }

    //http://localhost:8080/api/v1/get-api/request1?name=value1&email=value2&organization=value3
    @Operation(summary  = "Get 메서드 예제", description  = "@RequestParam을 활용한 Get Method")
    @GetMapping(value = "/request1")
    public String getRequestParam1(
            @Parameter(description ="이름", required=true) @RequestParam String name,
            @Parameter(description ="이메일", required=true) @RequestParam String email,
            @Parameter(description ="회사", required=true) @RequestParam String organization
    ) {
        return name + " " + email + " " + organization;
    }
    //http://localhost:8080/api/v1/get-api/request2?key1=value1&key2=value2
    @GetMapping(value = "/request2")
    public String getRequestParam2(@RequestParam Map<String, String> param) {
        StringBuilder sb = new StringBuilder();

        param.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });

        return sb.toString();
    }

    //http://localhost:8080/api/v1/get-api/request3?name=value1&email=value2&organization=value3
    @GetMapping(value = "/request3")
    public String getRequestParam3(MemberDto memberDto) {
        return memberDto.toString();
    }

}

