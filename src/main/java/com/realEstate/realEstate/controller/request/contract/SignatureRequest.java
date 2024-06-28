package com.realEstate.realEstate.controller.request.contract;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SignatureRequest {
    private List<MultipartFile> images;
}
