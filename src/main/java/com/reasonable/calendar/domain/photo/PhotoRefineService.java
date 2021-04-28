package com.reasonable.calendar.domain.photo;

import com.amazonaws.services.rekognition.model.DetectFacesResult;
import com.amazonaws.services.rekognition.model.FaceDetail;
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
        DetectFacesResult result = JsonUtil.read(photo.getAnalyzedRaw(), DetectFacesResult.class);
        this.refineAndSave(result.getFaceDetails());
    }

    public void refineAndSave(List<FaceDetail> details) {
        System.out.println("HEYHEYEHEYEHEY");
    }
}
