package com.reasonable.calendar.domain.photo;

import com.amazonaws.services.rekognition.model.DetectFacesResult;
import com.amazonaws.services.rekognition.model.FaceDetail;
import com.fasterxml.jackson.core.type.TypeReference;
import com.reasonable.calendar.util.JsonUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PhotoRefineService {
    private final PhotoService photoService;

    public void refine(String photoId) {
        Photo photo = photoService.findByPhotoId(photoId);
        List<FaceDetail> result = JsonUtil.read(photo.getAnalyzedRaw(), new TypeReference<>() {});
        this.refineAndSave(result);
    }

    public void refineAndSave(List<FaceDetail> details) {
        System.out.println("HEYHEYEHEYEHEY");
    }
}
