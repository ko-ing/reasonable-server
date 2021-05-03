package com.reasonable.calendar.domain.photo;

import com.amazonaws.services.rekognition.model.BoundingBox;
import com.amazonaws.services.rekognition.model.FaceDetail;
import com.fasterxml.jackson.core.type.TypeReference;
import com.reasonable.calendar.domain.emotion.EmotionRepository;
import com.reasonable.calendar.domain.emotion.EmotionService;
import com.reasonable.calendar.util.JsonUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PhotoRefineService {
    private final PhotoService photoService;
    private final EmotionService emotionService;

    public void refine(String photoId) {
        Photo photo = photoService.findByPhotoId(photoId);
        List<FaceDetail> faceDetails = JsonUtil.read(photo.getAnalyzedRaw(), new TypeReference<>() {});
        this.refineAndSave(faceDetails, photo.getPhotoId());
    }

    public void refineAndSave(List<FaceDetail> details, UUID photoId) {
        details.forEach(d -> this.save(d, photoId));
    }

    public void save(FaceDetail detail, UUID photoId) {
        Map<String, Float> fields = new HashMap<>();
        BoundingBox box = detail.getBoundingBox();

        detail.getEmotions().forEach(e -> fields.put(RekognitionEmotionField.valueOf(e.getType()).getColumn(), e.getConfidence()));

        fields.put(RekognitionEmotionField.BOX_LEFT.getColumn(), box.getLeft());
        fields.put(RekognitionEmotionField.BOX_TOP.getColumn(), box.getTop());
        fields.put(RekognitionEmotionField.BOX_WIDTH.getColumn(), box.getWidth());
        fields.put(RekognitionEmotionField.BOX_HEIGHT.getColumn(), box.getHeight());

        emotionService.save(fields, photoId);
    }
}
