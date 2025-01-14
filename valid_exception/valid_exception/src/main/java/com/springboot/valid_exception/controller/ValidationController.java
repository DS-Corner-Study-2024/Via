package com.springboot.valid_exception.controller;

@Restcontroller
@RequestMapping("/validation")
public class ValidationController {
    private final Logger LOGGER=LoggerFactory.getLogger(ValidatonController.class);

    @PostMapping("/valid")
    public ResponseEntity<String> checkValidationByValid(
            @Valid @RequestBody ValidRequestDto validRequestDto){
        LOGGER.info(validRequestDto.toString());
        return ResponseEntity.status(HttpStatus.OK).body(validRequestDto.toString());
    }
}
